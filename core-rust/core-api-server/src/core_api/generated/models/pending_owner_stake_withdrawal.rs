/*
 * Babylon Core API - RCnet v3
 *
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node.  It is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Very heavy load may impact the node's function.  This API exposes queries against the node's current state (see `/lts/state/` or `/state/`), and streams of transaction history (under `/lts/stream/` or `/stream`).  If you require queries against snapshots of historical ledger state, you may also wish to consider using the [Gateway API](https://docs-babylon.radixdlt.com/).  ## Integration and forward compatibility guarantees  This version of the Core API belongs to the second release candidate of the Radix Babylon network (\"RCnet v3\").  Integrators (such as exchanges) are recommended to use the `/lts/` endpoints - they have been designed to be clear and simple for integrators wishing to create and monitor transactions involving fungible transfers to/from accounts.  All endpoints under `/lts/` are guaranteed to be forward compatible to Babylon mainnet launch (and beyond). We may add new fields, but existing fields will not be changed. Assuming the integrating code uses a permissive JSON parser which ignores unknown fields, any additions will not affect existing code. 
 *
 * The version of the OpenAPI document: 0.5.0
 * 
 * Generated by: https://openapi-generator.tech
 */




#[derive(Clone, Debug, PartialEq, Default, serde::Serialize, serde::Deserialize)]
pub struct PendingOwnerStakeWithdrawal {
    /// An integer between `0` and `10^10`, marking the epoch when the stake units are unlocked for withdrawal. 
    #[serde(rename = "epoch_unlocked")]
    pub epoch_unlocked: i64,
    /// A string-encoded fixed-precision decimal to 18 decimal places. A decimal is formed of some signed integer `m` of attos (`10^(-18)`) units, where `-2^(256 - 1) <= m < 2^(256 - 1)`. 
    #[serde(rename = "stake_unit_amount")]
    pub stake_unit_amount: String,
}

impl PendingOwnerStakeWithdrawal {
    pub fn new(epoch_unlocked: i64, stake_unit_amount: String) -> PendingOwnerStakeWithdrawal {
        PendingOwnerStakeWithdrawal {
            epoch_unlocked,
            stake_unit_amount,
        }
    }
}


