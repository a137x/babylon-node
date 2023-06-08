use parking_lot::RwLock;
use std::ops::Deref;
use std::sync::Arc;
use std::time::{Duration, SystemTime};
use transaction::errors::TransactionValidationError;

use radix_engine::transaction::{AbortReason, TransactionReceipt, TransactionResult};

use radix_engine_common::network::NetworkDefinition;

use crate::query::StateManagerSubstateQueries;
use crate::staging::ReadableStore;
use crate::store::traits::{QueryableProofStore, TransactionIndex};
use crate::transaction::{ConfigType, ExecutionConfigurator, TransactionLogic};
use crate::{
    AtState, PendingTransactionRecord, PendingTransactionResultCache, RejectionReason,
    TransactionAttempt,
};

use transaction::prelude::*;
use transaction::validation::*;

use super::{
    LedgerTransaction, PreparedLedgerTransaction, PreparedLedgerTransactionInner,
    RawLedgerTransaction, ValidatedLedgerTransaction, ValidatedLedgerTransactionInner,
};

pub struct LedgerTransactionValidator {
    pub validation_config: ValidationConfig,
    pub ledger_payload_limit: usize,
    pub user_transaction_validator: NotarizedTransactionValidator,
}

impl LedgerTransactionValidator {
    pub fn new(network: &NetworkDefinition) -> Self {
        let validation_config = ValidationConfig::default(network.id);
        Self {
            validation_config,
            // Add a few extra bytes for the enum discriminator at the start(!)
            ledger_payload_limit: validation_config.max_notarized_payload_size + 10,
            user_transaction_validator: NotarizedTransactionValidator::new(validation_config),
        }
    }

    pub fn prepare_from_model(
        &self,
        transaction: &LedgerTransaction,
    ) -> Result<PreparedLedgerTransaction, TransactionValidationError> {
        self.prepare_from_raw(&transaction.to_raw()?)
    }

    pub fn prepare_from_raw(
        &self,
        raw: &RawLedgerTransaction,
    ) -> Result<PreparedLedgerTransaction, TransactionValidationError> {
        self.prepare_from_payload_bytes(raw.as_slice())
    }

    fn prepare_from_payload_bytes(
        &self,
        raw_payload_bytes: &[u8],
    ) -> Result<PreparedLedgerTransaction, TransactionValidationError> {
        if raw_payload_bytes.len() > self.ledger_payload_limit {
            return Err(TransactionValidationError::TransactionTooLarge);
        }

        Ok(PreparedLedgerTransaction::prepare_from_payload(
            raw_payload_bytes,
        )?)
    }

    pub fn validate_user_or_round_update_from_model(
        &self,
        transaction: &LedgerTransaction,
    ) -> Result<ValidatedLedgerTransaction, LedgerTransactionValidationError> {
        self.validate_user_or_round_update(transaction.prepare()?)
    }

    pub fn validate_user_or_round_update_from_raw(
        &self,
        raw: &RawLedgerTransaction,
    ) -> Result<ValidatedLedgerTransaction, LedgerTransactionValidationError> {
        self.validate_user_or_round_update_from_payload_bytes(raw.as_slice())
    }

    pub fn validate_user_or_round_update_from_payload_bytes(
        &self,
        payload_bytes: &[u8],
    ) -> Result<ValidatedLedgerTransaction, LedgerTransactionValidationError> {
        let prepared = self.prepare_from_payload_bytes(payload_bytes)?;
        self.validate_user_or_round_update(prepared)
    }

    pub fn validate_user_or_round_update(
        &self,
        prepared: PreparedLedgerTransaction,
    ) -> Result<ValidatedLedgerTransaction, LedgerTransactionValidationError> {
        let validated_inner = match prepared.inner {
            PreparedLedgerTransactionInner::Genesis(_) => {
                return Err(LedgerTransactionValidationError::GenesisTransactionProvided);
            }
            PreparedLedgerTransactionInner::UserV1(prepared) => {
                let validated = self.user_transaction_validator.validate(*prepared)?;
                ValidatedLedgerTransactionInner::UserV1(Box::new(validated))
            }
            PreparedLedgerTransactionInner::RoundUpdateV1(prepared) => {
                ValidatedLedgerTransactionInner::RoundUpdateV1(prepared)
            }
        };
        Ok(ValidatedLedgerTransaction {
            inner: validated_inner,
            summary: prepared.summary,
        })
    }

    pub fn validate_genesis(
        &self,
        prepared: PreparedLedgerTransaction,
    ) -> ValidatedLedgerTransaction {
        let PreparedLedgerTransactionInner::Genesis(t) = prepared.inner else {
            panic!("Genesis transaction was not a system transaction")
        };
        ValidatedLedgerTransaction {
            inner: ValidatedLedgerTransactionInner::Genesis(t),
            summary: prepared.summary,
        }
    }
}

#[derive(Debug, Clone)]
pub enum LedgerTransactionValidationError {
    ValidationError(TransactionValidationError),
    GenesisTransactionProvided,
}

impl LedgerTransactionValidationError {
    // Should only be called on errors from validating user transactions
    pub fn into_user_validation_error(self) -> TransactionValidationError {
        match self {
            LedgerTransactionValidationError::ValidationError(x) => x,
            LedgerTransactionValidationError::GenesisTransactionProvided => {
                panic!("into_user_validation_error called on a genesis transaction payload")
            }
        }
    }
}

impl From<TransactionValidationError> for LedgerTransactionValidationError {
    fn from(value: TransactionValidationError) -> Self {
        Self::ValidationError(value)
    }
}

impl From<PrepareError> for LedgerTransactionValidationError {
    fn from(value: PrepareError) -> Self {
        Self::ValidationError(TransactionValidationError::PrepareError(value))
    }
}

const UP_TO_FEE_LOAN_RUNTIME_WARN_THRESHOLD: Duration = Duration::from_millis(100);

/// A validator for `NotarizedTransaction`, deciding whether they would be rejected or not-rejected
/// (i.e. "commitable") at a specific state of the `store`.
pub struct CommitabilityValidator<S> {
    store: Arc<RwLock<S>>,
    execution_configurator: Arc<ExecutionConfigurator>,
    user_transaction_validator: NotarizedTransactionValidator,
}

impl<S> CommitabilityValidator<S> {
    pub fn new(
        network: &NetworkDefinition,
        store: Arc<RwLock<S>>,
        execution_configurator: Arc<ExecutionConfigurator>,
    ) -> Self {
        Self {
            store,
            execution_configurator,
            user_transaction_validator: NotarizedTransactionValidator::new(
                ValidationConfig::default(network.id),
            ),
        }
    }

    pub fn prepare_from_raw(
        &self,
        transaction: &RawNotarizedTransaction,
    ) -> Result<PreparedNotarizedTransactionV1, TransactionValidationError> {
        self.user_transaction_validator
            .prepare_from_raw(transaction)
    }

    pub fn validate(
        &self,
        transaction: PreparedNotarizedTransactionV1,
    ) -> Result<ValidatedNotarizedTransactionV1, TransactionValidationError> {
        self.user_transaction_validator.validate(transaction)
    }
}

impl<S> CommitabilityValidator<S>
where
    S: ReadableStore + QueryableProofStore,
    S: for<'a> TransactionIndex<&'a IntentHash>,
{
    /// Determine whether it would be rejected given the current state of the substate store.
    pub fn check_for_rejection(
        &self,
        transaction: &ValidatedNotarizedTransactionV1,
        timestamp: SystemTime,
    ) -> TransactionAttempt {
        let read_store = self.store.read();
        let executed_at_state_version = read_store.max_state_version();

        let existing =
            read_store.get_txn_state_version_by_identifier(&transaction.prepared.intent_hash());
        if existing.is_some() {
            return TransactionAttempt {
                rejection: Some(RejectionReason::IntentHashCommitted),
                against_state: AtState::Committed {
                    state_version: executed_at_state_version,
                },
                timestamp,
            };
        }

        let receipt =
            match self.test_execute_transaction_up_to_fee_loan(read_store.deref(), transaction) {
                Ok(receipt) => receipt,
                Err(rejection_reason) => {
                    return TransactionAttempt {
                        rejection: Some(rejection_reason),
                        against_state: AtState::Committed {
                            state_version: executed_at_state_version,
                        },
                        timestamp,
                    };
                }
            };

        let result = match receipt.result {
            TransactionResult::Reject(reject_result) => Err(RejectionReason::FromExecution(
                Box::new(reject_result.error),
            )),
            TransactionResult::Commit(..) => Ok(()),
            TransactionResult::Abort(abort_result) => {
                // The transaction aborted after the fee loan was repaid - meaning the transaction result would get committed
                match abort_result.reason {
                    AbortReason::ConfiguredAbortTriggeredOnFeeLoanRepayment => Ok(()),
                }
            }
        };

        TransactionAttempt {
            rejection: result.err(),
            against_state: AtState::Committed {
                state_version: executed_at_state_version,
            },
            timestamp,
        }
    }

    fn test_execute_transaction_up_to_fee_loan(
        &self,
        root_store: &S,
        transaction: &ValidatedNotarizedTransactionV1,
    ) -> Result<TransactionReceipt, RejectionReason> {
        let transaction_logic = self
            .execution_configurator
            .wrap(transaction.get_executable(), ConfigType::Pending)
            .warn_after(
                UP_TO_FEE_LOAN_RUNTIME_WARN_THRESHOLD,
                format!(
                    "pending intent hash {}, up to fee loan",
                    transaction.prepared.intent_hash()
                ),
            );
        Ok(transaction_logic.execute_on(root_store))
    }
}

/// A caching wrapper for a `CommitabilityValidator`.
pub struct CachedCommitabilityValidator<S> {
    store: Arc<RwLock<S>>,
    commitability_validator: Arc<CommitabilityValidator<S>>,
    pending_transaction_result_cache: Arc<RwLock<PendingTransactionResultCache>>,
}

impl<S> CachedCommitabilityValidator<S> {
    pub fn new(
        store: Arc<RwLock<S>>,
        commitability_validator: Arc<CommitabilityValidator<S>>,
        pending_transaction_result_cache: Arc<RwLock<PendingTransactionResultCache>>,
    ) -> Self {
        Self {
            store,
            commitability_validator,
            pending_transaction_result_cache,
        }
    }

    pub fn prepare_from_raw(
        &self,
        transaction: &RawNotarizedTransaction,
    ) -> Result<PreparedNotarizedTransactionV1, TransactionValidationError> {
        self.commitability_validator.prepare_from_raw(transaction)
    }

    fn read_record(
        &self,
        prepared: &PreparedNotarizedTransactionV1,
    ) -> Option<PendingTransactionRecord> {
        // Even though we only want to read the cache here, the LRU structs require a write lock
        self.pending_transaction_result_cache
            .write()
            .get_pending_transaction_record(
                &prepared.intent_hash(),
                &prepared.notarized_transaction_hash(),
            )
    }

    fn write_attempt(
        &self,
        metadata: TransactionMetadata,
        attempt: TransactionAttempt,
    ) -> PendingTransactionRecord {
        self.pending_transaction_result_cache
            .write()
            .track_transaction_result(
                metadata.intent_hash,
                metadata.notarized_transaction_hash,
                Some(metadata.invalid_from_epoch),
                attempt,
            )
    }
}

struct TransactionMetadata {
    intent_hash: IntentHash,
    notarized_transaction_hash: NotarizedTransactionHash,
    invalid_from_epoch: Epoch,
}

impl TransactionMetadata {
    pub fn read_from(prepared: &PreparedNotarizedTransactionV1) -> Self {
        Self {
            intent_hash: prepared.intent_hash(),
            notarized_transaction_hash: prepared.notarized_transaction_hash(),
            invalid_from_epoch: prepared
                .signed_intent
                .intent
                .header
                .inner
                .end_epoch_exclusive,
        }
    }
}

enum ShouldRecalculate {
    Yes,
    No(PendingTransactionRecord),
}

pub enum CheckMetadata {
    Cached,
    Fresh(StaticValidation),
}

#[derive(Debug, Copy, Clone, Eq, PartialEq)]
pub enum PrevalidatedCheckMetadata {
    Cached,
    Fresh,
}

impl CheckMetadata {
    pub fn was_cached(&self) -> bool {
        match self {
            Self::Cached => true,
            Self::Fresh(_) => false,
        }
    }
}

pub enum StaticValidation {
    Valid(Box<ValidatedNotarizedTransactionV1>),
    Invalid,
}

#[derive(Debug, Copy, Clone, Eq, PartialEq)]
pub enum ForceRecalculation {
    Yes,
    IfCachedAsValid,
    No,
}

impl<S> CachedCommitabilityValidator<S>
where
    S: ReadableStore + QueryableProofStore,
    S: for<'a> TransactionIndex<&'a IntentHash>,
{
    /// Reads the transaction rejection status from the cache, else calculates it fresh, using
    /// `CommitabilityValidator`.
    ///
    /// The result is stored in the cache.
    /// If the transaction is freshly rejected, the caller should perform additional cleanup,
    /// e.g. removing the transaction from the mempool.
    ///
    /// Its pending transaction record is returned, along with a boolean about whether the last
    /// attempt was cached, and the validated notarized transaction (if it's new)
    pub fn check_for_rejection_cached(
        &self,
        prepared: PreparedNotarizedTransactionV1,
        force_recalculate: ForceRecalculation,
    ) -> (PendingTransactionRecord, CheckMetadata) {
        let current_time = SystemTime::now();

        if let ShouldRecalculate::No(record) =
            self.should_recalculate(&prepared, current_time, force_recalculate)
        {
            return (record, CheckMetadata::Cached);
        }

        let metadata = TransactionMetadata::read_from(&prepared);

        match self.commitability_validator.validate(prepared) {
            Ok(validated) => {
                // Transaction was valid - let's also attempt to execute it
                let attempt = self
                    .commitability_validator
                    .check_for_rejection(&validated, current_time);
                (
                    self.write_attempt(metadata, attempt),
                    CheckMetadata::Fresh(StaticValidation::Valid(Box::new(validated))),
                )
            }
            Err(validation_error) => {
                // The transaction is statically invalid
                let attempt = TransactionAttempt {
                    rejection: Some(RejectionReason::ValidationError(validation_error)),
                    against_state: AtState::Static,
                    timestamp: current_time,
                };
                (
                    self.write_attempt(metadata, attempt),
                    CheckMetadata::Fresh(StaticValidation::Invalid),
                )
            }
        }
    }

    /// Reads the transaction rejection status from the cache, else calculates it fresh, using
    /// `CommitabilityValidator`.
    ///
    /// The result is stored in the cache.
    /// If the transaction is freshly rejected, the caller should perform additional cleanup,
    /// e.g. removing the transaction from the mempool.
    ///
    /// Its pending transaction record is returned, along with a boolean about whether the last
    /// attempt was cached.
    pub fn check_for_rejection_cached_prevalidated(
        &self,
        validated: &ValidatedNotarizedTransactionV1,
        force_recalculate: ForceRecalculation,
    ) -> (PendingTransactionRecord, PrevalidatedCheckMetadata) {
        let current_time = SystemTime::now();

        if let ShouldRecalculate::No(record) =
            self.should_recalculate(&validated.prepared, current_time, force_recalculate)
        {
            return (record, PrevalidatedCheckMetadata::Cached);
        }

        let metadata = TransactionMetadata::read_from(&validated.prepared);

        let attempt = self
            .commitability_validator
            .check_for_rejection(validated, current_time);
        (
            self.write_attempt(metadata, attempt),
            PrevalidatedCheckMetadata::Fresh,
        )
    }

    fn should_recalculate(
        &self,
        prepared: &PreparedNotarizedTransactionV1,
        current_time: SystemTime,
        force_recalculate: ForceRecalculation,
    ) -> ShouldRecalculate {
        if force_recalculate == ForceRecalculation::Yes {
            return ShouldRecalculate::Yes;
        }

        let current_epoch = self.store.read().get_epoch();
        let record_option = self.read_record(prepared);

        if let Some(record) = record_option {
            if !record.should_recalculate(current_epoch, current_time) {
                if force_recalculate == ForceRecalculation::IfCachedAsValid
                    && record.latest_attempt.rejection.is_none()
                {
                    return ShouldRecalculate::Yes;
                }
                return ShouldRecalculate::No(record);
            }
        }
        ShouldRecalculate::Yes
    }
}
