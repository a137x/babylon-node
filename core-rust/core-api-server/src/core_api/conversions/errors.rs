use radix_engine::types::NonFungibleIdType;
use radix_engine_common::{address::AddressBech32EncodeError, types::PartitionNumber};
use radix_engine_interface::data::scrypto::model::ParseNonFungibleLocalIdError;
use sbor::{DecodeError, EncodeError};
use state_manager::StateVersion;
use tracing::warn;
use transaction::errors::TransactionValidationError;
use transaction::model::TransactionHashBech32EncodeError;

use crate::core_api::*;

/// Should be used when there's an error mapping to an API response
#[derive(Debug, Clone)]
pub enum MappingError {
    PartitionNumber {
        entity_address: String,
        partition_number: PartitionNumber,
        message: String,
    },
    SubstateKey {
        entity_address: String,
        partition_number: PartitionNumber,
        substate_key: Box<models::SubstateKey>, // only for the variant's size reasons
        message: String,
    },
    SubstateValue {
        bytes: Vec<u8>,
        message: String,
    },
    ObsoleteSubstateVersion,
    UnexpectedPersistedData {
        message: String,
    },
    EntityTypeError,
    ScryptoValueDecode {
        decode_error: DecodeError,
        bytes: Vec<u8>,
    },
    InvalidSbor {
        decode_error: String,
        bytes: Vec<u8>,
    },
    SborEncodeError {
        encode_error: EncodeError,
        message: String,
    },
    InvalidManifest {
        message: String,
    },
    InvalidEntityAddress {
        encode_error: AddressBech32EncodeError,
    },
    InvalidTransactionHash {
        encode_error: TransactionHashBech32EncodeError,
    },
    MismatchedSubstateId {
        message: String,
    },
    MismatchedSubstateKeyType {
        expected_match: String,
        actual: String,
    },
    MismatchedTransactionIdentifiers {
        message: String,
    },
    IntegerError {
        message: String,
    },
    CouldNotDecodeTransaction {
        state_version: StateVersion,
        error: DecodeError,
    },
    KeyValueStoreEntryUnexpectedlyAbsent,
    UnexpectedGenesis {
        message: String,
    },
    /// An error occurring when the contents of some Node-maintained index table do not match the
    /// Engine-owned data (most likely due to a bug on either side).
    InternalIndexDataMismatch {
        message: String,
    },
    MissingSystemStructure {
        message: String,
    },
    CouldNotResolveRemoteGenericSubstitution {
        message: String,
    },
}

impl<E: ErrorDetails> From<MappingError> for ResponseError<E> {
    fn from(mapping_error: MappingError) -> Self {
        warn!(?mapping_error, "Error mapping response on Core API");
        server_error("Server error mapping response")
    }
}

/// Should be used when extracting values from a client request
#[derive(Debug, Clone)]
#[allow(clippy::enum_variant_names)]
pub enum ExtractionError {
    InvalidInteger {
        message: String,
    },
    InvalidHex,
    InvalidSignature,
    InvalidPublicKey,
    InvalidHash,
    InvalidTransaction(TransactionValidationError),
    InvalidAddress,
    InvalidNonFungibleId(ParseNonFungibleLocalIdError),
    WrongNonFungibleIdType {
        expected: NonFungibleIdType,
        actual: NonFungibleIdType,
    },
}

impl ExtractionError {
    pub(crate) fn into_response_error<E: ErrorDetails>(self, field_name: &str) -> ResponseError<E> {
        client_error(format!(
            "Error extracting {field_name} from request: {self:?}"
        ))
    }
}

impl From<TransactionValidationError> for ExtractionError {
    fn from(err: TransactionValidationError) -> Self {
        ExtractionError::InvalidTransaction(err)
    }
}

impl From<ParseNonFungibleLocalIdError> for ExtractionError {
    fn from(err: ParseNonFungibleLocalIdError) -> Self {
        ExtractionError::InvalidNonFungibleId(err)
    }
}
