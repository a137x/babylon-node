/*
 * Babylon Core API
 *
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node. It is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Heavy load may impact the node's function.  If you require queries against historical ledger state, you may also wish to consider using the [Gateway API](https://betanet-gateway.redoc.ly/). 
 *
 * The version of the OpenAPI document: 0.2.0
 * 
 * Generated by: https://openapi-generator.tech
 */


/// 
#[derive(Clone, Copy, Debug, Eq, PartialEq, Ord, PartialOrd, Hash, serde::Serialize, serde::Deserialize)]
pub enum EntityType {
    #[serde(rename = "EpochManager")]
    EpochManager,
    #[serde(rename = "ResourceManager")]
    ResourceManager,
    #[serde(rename = "Component")]
    Component,
    #[serde(rename = "Package")]
    Package,
    #[serde(rename = "Vault")]
    Vault,
    #[serde(rename = "KeyValueStore")]
    KeyValueStore,
    #[serde(rename = "Global")]
    Global,
    #[serde(rename = "NonFungibleStore")]
    NonFungibleStore,
    #[serde(rename = "Clock")]
    Clock,
    #[serde(rename = "Validator")]
    Validator,

}

impl ToString for EntityType {
    fn to_string(&self) -> String {
        match self {
            Self::EpochManager => String::from("EpochManager"),
            Self::ResourceManager => String::from("ResourceManager"),
            Self::Component => String::from("Component"),
            Self::Package => String::from("Package"),
            Self::Vault => String::from("Vault"),
            Self::KeyValueStore => String::from("KeyValueStore"),
            Self::Global => String::from("Global"),
            Self::NonFungibleStore => String::from("NonFungibleStore"),
            Self::Clock => String::from("Clock"),
            Self::Validator => String::from("Validator"),
        }
    }
}

impl Default for EntityType {
    fn default() -> EntityType {
        Self::EpochManager
    }
}




