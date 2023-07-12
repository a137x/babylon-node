/*
 * Babylon Core API - RCnet V2
 *
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node.  It is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Very heavy load may impact the node's function.  This API exposes queries against the node's current state (see `/lts/state/` or `/state/`), and streams of transaction history (under `/lts/stream/` or `/stream`).  If you require queries against snapshots of historical ledger state, you may also wish to consider using the [Gateway API](https://docs-babylon.radixdlt.com/).  ## Integration and forward compatibility guarantees  This version of the Core API belongs to the second release candidate of the Radix Babylon network (\"RCnet v2\").  Integrators (such as exchanges) are recommended to use the `/lts/` endpoints - they have been designed to be clear and simple for integrators wishing to create and monitor transactions involving fungible transfers to/from accounts.  All endpoints under `/lts/` are guaranteed to be forward compatible to Babylon mainnet launch (and beyond). We may add new fields, but existing fields will not be changed. Assuming the integrating code uses a permissive JSON parser which ignores unknown fields, any additions will not affect existing code.  We give no guarantees that other endpoints will not change before Babylon mainnet launch, although changes are expected to be minimal. 
 *
 * The version of the OpenAPI document: 0.4.0
 * 
 * Generated by: https://openapi-generator.tech
 */

/// LtsStreamAccountTransactionOutcomesRequest : A request to retrieve a sublist of committed transactions from the ledger. 



#[derive(Clone, Debug, PartialEq, Default, serde::Serialize, serde::Deserialize)]
pub struct LtsStreamAccountTransactionOutcomesRequest {
    /// The logical name of the network
    #[serde(rename = "network")]
    pub network: String,
    /// The Bech32m-encoded human readable version of the account's address
    #[serde(rename = "account_address")]
    pub account_address: String,
    #[serde(rename = "from_state_version")]
    pub from_state_version: i64,
    /// The maximum number of transactions that will be returned.
    #[serde(rename = "limit")]
    pub limit: i32,
}

impl LtsStreamAccountTransactionOutcomesRequest {
    /// A request to retrieve a sublist of committed transactions from the ledger. 
    pub fn new(network: String, account_address: String, from_state_version: i64, limit: i32) -> LtsStreamAccountTransactionOutcomesRequest {
        LtsStreamAccountTransactionOutcomesRequest {
            network,
            account_address,
            from_state_version,
            limit,
        }
    }
}


