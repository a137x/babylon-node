/*
 * Babylon Core API - RCnet V2
 *
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node.  It is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Very heavy load may impact the node's function.  This API exposes queries against the node's current state (see `/lts/state/` or `/state/`), and streams of transaction history (under `/lts/stream/` or `/stream`).  If you require queries against snapshots of historical ledger state, you may also wish to consider using the [Gateway API](https://docs-babylon.radixdlt.com/).  ## Integration and forward compatibility guarantees  This version of the Core API belongs to the first release candidate of the Radix Babylon network (\"RCnet-V1\").  Integrators (such as exchanges) are recommended to use the `/lts/` endpoints - they have been designed to be clear and simple for integrators wishing to create and monitor transactions involving fungible transfers to/from accounts.  All endpoints under `/lts/` are guaranteed to be forward compatible to Babylon mainnet launch (and beyond). We may add new fields, but existing fields will not be changed. Assuming the integrating code uses a permissive JSON parser which ignores unknown fields, any additions will not affect existing code.  We give no guarantees that other endpoints will not change before Babylon mainnet launch, although changes are expected to be minimal. 
 *
 * The version of the OpenAPI document: 0.4.0
 * 
 * Generated by: https://openapi-generator.tech
 */


/// 
#[derive(Clone, Copy, Debug, Eq, PartialEq, Ord, PartialOrd, Hash, serde::Serialize, serde::Deserialize)]
pub enum EntityType {
    #[serde(rename = "GlobalPackage")]
    GlobalPackage,
    #[serde(rename = "GlobalConsensusManager")]
    GlobalConsensusManager,
    #[serde(rename = "GlobalValidator")]
    GlobalValidator,
    #[serde(rename = "GlobalGenericComponent")]
    GlobalGenericComponent,
    #[serde(rename = "GlobalAccount")]
    GlobalAccount,
    #[serde(rename = "GlobalIdentity")]
    GlobalIdentity,
    #[serde(rename = "GlobalAccessController")]
    GlobalAccessController,
    #[serde(rename = "GlobalVirtualSecp256k1Account")]
    GlobalVirtualSecp256k1Account,
    #[serde(rename = "GlobalVirtualSecp256k1Identity")]
    GlobalVirtualSecp256k1Identity,
    #[serde(rename = "GlobalVirtualEd25519Account")]
    GlobalVirtualEd25519Account,
    #[serde(rename = "GlobalVirtualEd25519Identity")]
    GlobalVirtualEd25519Identity,
    #[serde(rename = "GlobalFungibleResource")]
    GlobalFungibleResource,
    #[serde(rename = "InternalFungibleVault")]
    InternalFungibleVault,
    #[serde(rename = "GlobalNonFungibleResource")]
    GlobalNonFungibleResource,
    #[serde(rename = "InternalNonFungibleVault")]
    InternalNonFungibleVault,
    #[serde(rename = "InternalGenericComponent")]
    InternalGenericComponent,
    #[serde(rename = "InternalAccount")]
    InternalAccount,
    #[serde(rename = "InternalKeyValueStore")]
    InternalKeyValueStore,

}

impl ToString for EntityType {
    fn to_string(&self) -> String {
        match self {
            Self::GlobalPackage => String::from("GlobalPackage"),
            Self::GlobalConsensusManager => String::from("GlobalConsensusManager"),
            Self::GlobalValidator => String::from("GlobalValidator"),
            Self::GlobalGenericComponent => String::from("GlobalGenericComponent"),
            Self::GlobalAccount => String::from("GlobalAccount"),
            Self::GlobalIdentity => String::from("GlobalIdentity"),
            Self::GlobalAccessController => String::from("GlobalAccessController"),
            Self::GlobalVirtualSecp256k1Account => String::from("GlobalVirtualSecp256k1Account"),
            Self::GlobalVirtualSecp256k1Identity => String::from("GlobalVirtualSecp256k1Identity"),
            Self::GlobalVirtualEd25519Account => String::from("GlobalVirtualEd25519Account"),
            Self::GlobalVirtualEd25519Identity => String::from("GlobalVirtualEd25519Identity"),
            Self::GlobalFungibleResource => String::from("GlobalFungibleResource"),
            Self::InternalFungibleVault => String::from("InternalFungibleVault"),
            Self::GlobalNonFungibleResource => String::from("GlobalNonFungibleResource"),
            Self::InternalNonFungibleVault => String::from("InternalNonFungibleVault"),
            Self::InternalGenericComponent => String::from("InternalGenericComponent"),
            Self::InternalAccount => String::from("InternalAccount"),
            Self::InternalKeyValueStore => String::from("InternalKeyValueStore"),
        }
    }
}

impl Default for EntityType {
    fn default() -> EntityType {
        Self::GlobalPackage
    }
}




