/*
 * Babylon Core API
 *
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node. It is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Heavy load may impact the node's function.  If you require queries against historical ledger state, you may also wish to consider using the [Gateway API](https://betanet-gateway.redoc.ly/). 
 *
 * The version of the OpenAPI document: 0.2.0
 * 
 * Generated by: https://openapi-generator.tech
 */




#[derive(Clone, Debug, PartialEq, Default, serde::Serialize, serde::Deserialize)]
pub struct RoyaltyPayment {
    #[serde(rename = "royalty_receiver")]
    pub royalty_receiver: Box<crate::core_api::generated::models::GlobalEntityReference>,
    /// An integer between `0` and `2^32 - 1`, representing the amount of cost units of royalty paid to this receiver.
    #[serde(rename = "cost_unit_amount")]
    pub cost_unit_amount: i64,
}

impl RoyaltyPayment {
    pub fn new(royalty_receiver: crate::core_api::generated::models::GlobalEntityReference, cost_unit_amount: i64) -> RoyaltyPayment {
        RoyaltyPayment {
            royalty_receiver: Box::new(royalty_receiver),
            cost_unit_amount,
        }
    }
}


