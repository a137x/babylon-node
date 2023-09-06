/*
 * Babylon Core API - RCnet v3.1
 *
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node.  It is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Very heavy load may impact the node's function.  This API exposes queries against the node's current state (see `/lts/state/` or `/state/`), and streams of transaction history (under `/lts/stream/` or `/stream`).  If you require queries against snapshots of historical ledger state, you may also wish to consider using the [Gateway API](https://docs-babylon.radixdlt.com/).  ## Integration and forward compatibility guarantees  This version of the Core API belongs to the fourth release candidate of the Radix Babylon network (\"RCnet v3.1\").  Integrators (such as exchanges) are recommended to use the `/lts/` endpoints - they have been designed to be clear and simple for integrators wishing to create and monitor transactions involving fungible transfers to/from accounts.  All endpoints under `/lts/` are guaranteed to be forward compatible to Babylon mainnet launch (and beyond). We may add new fields, but existing fields will not be changed. Assuming the integrating code uses a permissive JSON parser which ignores unknown fields, any additions will not affect existing code. 
 *
 * The version of the OpenAPI document: 0.5.1
 * 
 * Generated by: https://openapi-generator.tech
 */

/// ScopedTypeId : An identifier for a type in the context of a schema.  The location of the schema store to locate the schema is not included, and is known from context. Currently the schema store will be in the schema partition under a node (typically a package).  Note - this type provides scoping to a schema even for well-known types where the schema is irrelevant. 



#[derive(Clone, Debug, PartialEq, Default, serde::Serialize, serde::Deserialize)]
pub struct ScopedTypeId {
    /// The hex-encoded schema hash, capturing the identity of an SBOR schema.
    #[serde(rename = "schema_hash")]
    pub schema_hash: String,
    #[serde(rename = "local_type_id")]
    pub local_type_id: Box<crate::core_api::generated::models::LocalTypeId>,
}

impl ScopedTypeId {
    /// An identifier for a type in the context of a schema.  The location of the schema store to locate the schema is not included, and is known from context. Currently the schema store will be in the schema partition under a node (typically a package).  Note - this type provides scoping to a schema even for well-known types where the schema is irrelevant. 
    pub fn new(schema_hash: String, local_type_id: crate::core_api::generated::models::LocalTypeId) -> ScopedTypeId {
        ScopedTypeId {
            schema_hash,
            local_type_id: Box::new(local_type_id),
        }
    }
}


