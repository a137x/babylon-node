/* Copyright 2021 Radix Publishing Ltd incorporated in Jersey (Channel Islands).
 *
 * Licensed under the Radix License, Version 1.0 (the "License"); you may not use this
 * file except in compliance with the License. You may obtain a copy of the License at:
 *
 * radixfoundation.org/licenses/LICENSE-v1
 *
 * The Licensor hereby grants permission for the Canonical version of the Work to be
 * published, distributed and used under or by reference to the Licensor’s trademark
 * Radix ® and use of any unregistered trade names, logos or get-up.
 *
 * The Licensor provides the Work (and each Contributor provides its Contributions) on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied,
 * including, without limitation, any warranties or conditions of TITLE, NON-INFRINGEMENT,
 * MERCHANTABILITY, or FITNESS FOR A PARTICULAR PURPOSE.
 *
 * Whilst the Work is capable of being deployed, used and adopted (instantiated) to create
 * a distributed ledger it is your responsibility to test and validate the code, together
 * with all logic and performance of that code under all foreseeable scenarios.
 *
 * The Licensor does not make or purport to make and hereby excludes liability for all
 * and any representation, warranty or undertaking in any form whatsoever, whether express
 * or implied, to any entity or person, including any representation, warranty or
 * undertaking, as to the functionality security use, value or other characteristics of
 * any distributed ledger nor in respect the functioning or value of any tokens which may
 * be created stored or transferred using the Work. The Licensor does not warrant that the
 * Work or any use of the Work complies with any law or regulation in any territory where
 * it may be implemented or used or that it will be appropriate for any specific purpose.
 *
 * Neither the licensor nor any current or former employees, officers, directors, partners,
 * trustees, representatives, agents, advisors, contractors, or volunteers of the Licensor
 * shall be liable for any direct or indirect, special, incidental, consequential or other
 * losses of any kind, in tort, contract or otherwise (including but not limited to loss
 * of revenue, income or profits, or loss of use or data, or loss of reputation, or loss
 * of any economic or other opportunity of whatsoever nature or howsoever arising), arising
 * out of or in connection with (without limitation of any use, misuse, of any ledger system
 * or use made or its functionality or any performance or operation of any code or protocol
 * caused by bugs or programming or logic errors or otherwise);
 *
 * A. any offer, purchase, holding, use, sale, exchange or transmission of any
 * cryptographic keys, tokens or assets created, exchanged, stored or arising from any
 * interaction with the Work;
 *
 * B. any failure in a transmission or loss of any token or assets keys or other digital
 * artefacts due to errors in transmission;
 *
 * C. bugs, hacks, logic errors or faults in the Work or any communication;
 *
 * D. system software or apparatus including but not limited to losses caused by errors
 * in holding or transmitting tokens by any third-party;
 *
 * E. breaches or failure of security including hacker attacks, loss or disclosure of
 * password, loss of private key, unauthorised use or misuse of such passwords or keys;
 *
 * F. any losses including loss of anticipated savings or other benefits resulting from
 * use of the Work or any changes to the Work (however implemented).
 *
 * You are solely responsible for; testing, validating and evaluation of all operation
 * logic, functionality, security and appropriateness of using the Work for any commercial
 * or non-commercial purpose and for any reproduction or redistribution by You of the
 * Work. You assume all risks associated with Your use of the Work and the exercise of
 * permissions under this License.
 */

use std::ops::Deref;
use std::sync::Arc;
use std::time::Duration;

use node_common::scheduler::{Metrics, Scheduler, Spawner, Tracker};
use node_common::{
    config::{limits::VertexLimitsConfig, MempoolConfig},
    locks::*,
};
use prometheus::Registry;

use radix_engine_common::prelude::*;

use crate::jni::LedgerSyncLimitsConfig;
use crate::store::jmt_gc::StateHashTreeGcConfig;
use crate::store::proofs_gc::{LedgerProofsGc, LedgerProofsGcConfig};
use crate::transaction::ExecutionConfigurator;
use crate::{
    compute_initial_protocol_state,
    mempool_manager::MempoolManager,
    mempool_relay_dispatcher::MempoolRelayDispatcher,
    priority_mempool::PriorityMempool,
    store::{
        jmt_gc::StateHashTreeGc, DatabaseBackendConfig, DatabaseFlags, RawDbMetricsCollector,
        StateManagerDatabase,
    },
    transaction::{CachedCommittabilityValidator, CommittabilityValidator, TransactionPreviewer},
    LoggingConfig, PendingTransactionResultCache, ProtocolConfig, ProtocolUpdaterFactory,
    StateComputer,
};

/// An interval between time-intensive measurement of raw DB metrics.
/// Some of our raw DB metrics take ~a few milliseconds to collect. We cannot afford the overhead of
/// updating them every time they change (i.e. on every DB commit) and we also should not perform
/// this considerable I/O within the Prometheus' exposition servlet thread - hence, a periodic task
/// (which in practice still runs more often than Prometheus' scraping).
const RAW_DB_MEASUREMENT_INTERVAL: Duration = Duration::from_secs(10);

#[derive(Clone, Debug, ScryptoCategorize, ScryptoEncode, ScryptoDecode)]
pub struct StateManagerConfig {
    pub network_definition: NetworkDefinition,
    pub mempool_config: Option<MempoolConfig>,
    pub vertex_limits_config: Option<VertexLimitsConfig>,
    pub database_backend_config: DatabaseBackendConfig,
    pub database_flags: DatabaseFlags,
    pub logging_config: LoggingConfig,
    pub state_hash_tree_gc_config: StateHashTreeGcConfig,
    pub ledger_proofs_gc_config: LedgerProofsGcConfig,
    pub ledger_sync_limits_config: LedgerSyncLimitsConfig,
    pub protocol_config: ProtocolConfig,
    pub no_fees: bool,
}

impl StateManagerConfig {
    pub fn new_for_testing(rocks_db_path: impl Into<String>) -> Self {
        StateManagerConfig {
            network_definition: NetworkDefinition::simulator(),
            mempool_config: Some(MempoolConfig::new_for_testing()),
            vertex_limits_config: None,
            database_backend_config: DatabaseBackendConfig {
                rocks_db_path: rocks_db_path.into(),
            },
            database_flags: DatabaseFlags::default(),
            logging_config: LoggingConfig::default(),
            state_hash_tree_gc_config: StateHashTreeGcConfig::default(),
            ledger_proofs_gc_config: LedgerProofsGcConfig::default(),
            ledger_sync_limits_config: LedgerSyncLimitsConfig::default(),
            protocol_config: ProtocolConfig::testing_default(),
            no_fees: false,
        }
    }
}

#[derive(Clone)]
pub struct StateManager {
    config: StateManagerConfig,
    pub state_computer: Arc<StateComputer<StateManagerDatabase>>,
    pub database: Arc<StateLock<StateManagerDatabase>>,
    pub pending_transaction_result_cache: Arc<RwLock<PendingTransactionResultCache>>,
    pub mempool: Arc<RwLock<PriorityMempool>>,
    pub mempool_manager: Arc<MempoolManager>,
    pub execution_configurator: Arc<RwLock<ExecutionConfigurator>>,
    pub committability_validator: Arc<RwLock<CommittabilityValidator<StateManagerDatabase>>>,
    pub transaction_previewer: Arc<RwLock<TransactionPreviewer<StateManagerDatabase>>>,
    pub protocol_updater_factory: Arc<dyn ProtocolUpdaterFactory + Sync + Send>,
}

impl StateManager {
    pub fn test(&self, metrics_registry: &Registry) {
        let mut write_mempool = self.mempool.write();
        *write_mempool = PriorityMempool::new(MempoolConfig::default(), metrics_registry);
        drop(write_mempool);
    }

    pub fn new(
        config: StateManagerConfig,
        mempool_relay_dispatcher: Option<MempoolRelayDispatcher>,
        lock_factory: &LockFactory,
        protocol_updater_factory: Box<dyn ProtocolUpdaterFactory + Sync + Send>,
        metrics_registry: &Registry,
        scheduler: &Scheduler<impl Spawner, impl Tracker, impl Metrics>,
    ) -> Self {
        let mempool_config = match config.mempool_config.clone() {
            Some(mempool_config) => mempool_config,
            None =>
            // in general, missing mempool config should mean that mempool isn't needed
            // but for now just using a default
            {
                MempoolConfig::default()
            }
        };
        let network = config.network_definition.clone();
        let logging_config = config.logging_config.clone();

        let raw_db = StateManagerDatabase::from_config(
            config.database_backend_config.clone(),
            config.database_flags.clone(),
        );

        let database = Arc::new(lock_factory.named("database").new_state_lock(raw_db));

        if let Err(err) = config
            .protocol_config
            .sanity_check(&protocol_updater_factory)
        {
            panic!("Protocol misconfiguration: {}", err);
        };

        let read_db = database.read_current();
        let initial_protocol_state =
            compute_initial_protocol_state(read_db.deref(), &config.protocol_config);
        drop(read_db);

        let initial_protocol_updater = protocol_updater_factory.updater_for(
            &initial_protocol_state.current_protocol_version,
            database.clone(),
        );
        let initial_protocol_configurator = initial_protocol_updater.state_computer_configurator();

        let execution_configurator = Arc::new(
            lock_factory
                .named("execution_configurator")
                .new_rwlock(initial_protocol_configurator.execution_configurator(config.no_fees)),
        );

        let pending_transaction_result_cache = Arc::new(
            lock_factory
                .named("pending_cache")
                .new_rwlock(PendingTransactionResultCache::new(10000, 10000)),
        );
        let committability_validator =
            Arc::new(lock_factory.named("committability_validator").new_rwlock(
                CommittabilityValidator::new(
                    database.clone(),
                    execution_configurator.clone(),
                    initial_protocol_configurator.user_transaction_validator(),
                ),
            ));
        let cached_committability_validator = CachedCommittabilityValidator::new(
            database.clone(),
            committability_validator.clone(),
            pending_transaction_result_cache.clone(),
        );

        let mempool = Arc::new(
            lock_factory
                .named("mempool")
                .new_rwlock(PriorityMempool::new(mempool_config, metrics_registry)),
        );

        let mempool_manager = Arc::new(match mempool_relay_dispatcher {
            None => MempoolManager::new_for_testing(
                mempool.clone(),
                cached_committability_validator,
                metrics_registry,
            ),
            Some(mempool_relay_dispatcher) => MempoolManager::new(
                mempool.clone(),
                mempool_relay_dispatcher,
                cached_committability_validator,
                metrics_registry,
            ),
        });

        let transaction_previewer =
            Arc::new(lock_factory.named("transaction_previewer").new_rwlock(
                TransactionPreviewer::new(
                    database.clone(),
                    execution_configurator.clone(),
                    initial_protocol_configurator.validation_config(),
                ),
            ));

        let vertex_limits_config = match config.vertex_limits_config {
            Some(java_vertex_limits_config) => java_vertex_limits_config,
            None => VertexLimitsConfig::default(),
        };

        // Build the state computer:
        let state_computer = Arc::new(StateComputer::new(
            &network,
            vertex_limits_config,
            database.clone(),
            mempool_manager.clone(),
            execution_configurator.clone(),
            pending_transaction_result_cache.clone(),
            logging_config,
            metrics_registry,
            lock_factory.named("state_computer"),
            initial_protocol_updater,
            initial_protocol_state,
        ));

        // Register the periodic background task for collecting the costly raw DB metrics...
        let raw_db_metrics_collector =
            RawDbMetricsCollector::new(database.clone(), metrics_registry);
        scheduler
            .named("raw_db_measurement")
            .start_periodic(RAW_DB_MEASUREMENT_INTERVAL, move || {
                raw_db_metrics_collector.run()
            });

        // ... and for deleting the stale state hash tree nodes (a.k.a. "JMT GC")...
        let state_hash_tree_gc =
            StateHashTreeGc::new(database.clone(), config.state_hash_tree_gc_config.clone());
        scheduler
            .named("state_hash_tree_gc")
            .start_periodic(state_hash_tree_gc.interval(), move || {
                state_hash_tree_gc.run()
            });

        // ... and for deleting the old, non-critical ledger proofs (a.k.a. "Proofs GC"):
        let ledger_proofs_gc = LedgerProofsGc::new(
            database.clone(),
            config.ledger_proofs_gc_config.clone(),
            config.ledger_sync_limits_config.clone(),
        );
        scheduler
            .named("ledger_proofs_gc")
            .start_periodic(ledger_proofs_gc.interval(), move || ledger_proofs_gc.run());

        Self {
            config,
            state_computer,
            database,
            pending_transaction_result_cache,
            mempool,
            mempool_manager,
            execution_configurator,
            committability_validator,
            transaction_previewer,
            protocol_updater_factory: protocol_updater_factory.into(),
        }
    }

    pub fn apply_protocol_update(&self, protocol_version_name: &str) {
        let protocol_updater = self
            .protocol_updater_factory
            .updater_for(protocol_version_name, self.database.clone());
        let state_computer_configurator = protocol_updater.state_computer_configurator();

        let new_execution_configurator =
            state_computer_configurator.execution_configurator(self.config.no_fees);

        let mut locked_execution_configurator = self.execution_configurator.write();
        *locked_execution_configurator = new_execution_configurator;
        drop(locked_execution_configurator);

        let mut locked_committability_validator = self.committability_validator.write();
        *locked_committability_validator = CommittabilityValidator::new(
            self.database.clone(),
            self.execution_configurator.clone(),
            state_computer_configurator.user_transaction_validator(),
        );
        drop(locked_committability_validator);

        let mut locked_transaction_previewer = self.transaction_previewer.write();
        *locked_transaction_previewer = TransactionPreviewer::new(
            self.database.clone(),
            self.execution_configurator.clone(),
            state_computer_configurator.validation_config(),
        );
        drop(locked_transaction_previewer);

        self.state_computer
            .apply_protocol_update(protocol_updater.deref());

        // TODO: recalculate mempool/txn result cache
    }
}
