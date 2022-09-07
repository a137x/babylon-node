/*
 * Babylon Core API
 *
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * The version of the OpenAPI document: 0.1.0
 * 
 * Generated by: https://openapi-generator.tech
 */

/// EmptySubstate : A not yet implemented substate model



#[derive(Clone, Debug, PartialEq, Default, serde::Serialize, serde::Deserialize)]
pub struct EmptySubstate {
    #[serde(rename = "dummy", skip_serializing_if = "Option::is_none")]
    pub dummy: Option<String>,
}

impl EmptySubstate {
    /// A not yet implemented substate model
    pub fn new() -> EmptySubstate {
        EmptySubstate {
            dummy: None,
        }
    }
}


