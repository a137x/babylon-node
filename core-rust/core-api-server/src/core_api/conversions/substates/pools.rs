use super::super::*;
use super::*;
use crate::core_api::models;
use radix_engine::blueprints::pool::multi_resource_pool::MultiResourcePoolStateFieldSubstate;
use radix_engine::blueprints::pool::one_resource_pool::OneResourcePoolStateFieldSubstate;
use radix_engine::blueprints::pool::two_resource_pool::TwoResourcePoolStateFieldSubstate;

use radix_engine::types::*;
use radix_engine_queries::typed_substate_layout::*;

pub fn to_api_one_resource_pool_substate(
    context: &MappingContext,
    substate: &OneResourcePoolStateFieldSubstate,
) -> Result<models::Substate, MappingError> {
    Ok(field_substate_versioned!(
        substate,
        OneResourcePoolFieldState,
        one_resource_pool::OneResourcePoolSubstate {
            vault,
            pool_unit_resource_manager,
        },
        Value {
            vault: Box::new(to_api_entity_reference(context, vault.0.as_node_id())?),
            pool_unit_resource_address: to_api_resource_address(
                context,
                &pool_unit_resource_manager.0,
            )?,
        }
    ))
}

pub fn to_api_two_resource_pool_substate(
    context: &MappingContext,
    substate: &TwoResourcePoolStateFieldSubstate,
) -> Result<models::Substate, MappingError> {
    Ok(field_substate_versioned!(
        substate,
        TwoResourcePoolFieldState,
        two_resource_pool::TwoResourcePoolSubstate {
            vaults,
            pool_unit_resource_manager,
        },
        Value {
            vaults: vaults
                .iter()
                .map(|(resource_address, vault)| to_api_pool_vault(
                    context,
                    resource_address,
                    vault
                ))
                .collect::<Result<Vec<_>, _>>()?,
            pool_unit_resource_address: to_api_resource_address(
                context,
                &pool_unit_resource_manager.0,
            )?,
        }
    ))
}

pub fn to_api_multi_resource_pool_substate(
    context: &MappingContext,
    substate: &MultiResourcePoolStateFieldSubstate,
) -> Result<models::Substate, MappingError> {
    Ok(field_substate_versioned!(
        substate,
        MultiResourcePoolFieldState,
        multi_resource_pool::MultiResourcePoolSubstate {
            vaults,
            pool_unit_resource_manager,
        },
        Value {
            vaults: vaults
                .iter()
                .map(|(resource_address, vault)| to_api_pool_vault(
                    context,
                    resource_address,
                    vault
                ))
                .collect::<Result<Vec<_>, _>>()?,
            pool_unit_resource_address: to_api_resource_address(
                context,
                &pool_unit_resource_manager.0,
            )?,
        }
    ))
}

pub fn to_api_pool_vault(
    context: &MappingContext,
    resource_address: &ResourceAddress,
    vault: &Vault,
) -> Result<models::PoolVault, MappingError> {
    Ok(models::PoolVault {
        vault: Box::new(to_api_entity_reference(context, vault.0.as_node_id())?),
        resource_address: to_api_resource_address(context, resource_address)?,
    })
}
