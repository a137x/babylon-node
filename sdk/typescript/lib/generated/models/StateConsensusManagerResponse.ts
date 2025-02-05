/* tslint:disable */
/* eslint-disable */
/**
 * Radix Core API - Babylon
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node.  The default configuration is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Very heavy load may impact the node\'s function. The node exposes a configuration flag which allows disabling certain endpoints which may be problematic, but monitoring is advised. This configuration parameter is `api.core.flags.enable_unbounded_endpoints` / `RADIXDLT_CORE_API_FLAGS_ENABLE_UNBOUNDED_ENDPOINTS`.  This API exposes queries against the node\'s current state (see `/lts/state/` or `/state/`), and streams of transaction history (under `/lts/stream/` or `/stream`).  If you require queries against snapshots of historical ledger state, you may also wish to consider using the [Gateway API](https://docs-babylon.radixdlt.com/).  ## Integration and forward compatibility guarantees  Integrators (such as exchanges) are recommended to use the `/lts/` endpoints - they have been designed to be clear and simple for integrators wishing to create and monitor transactions involving fungible transfers to/from accounts.  All endpoints under `/lts/` have high guarantees of forward compatibility in future node versions. We may add new fields, but existing fields will not be changed. Assuming the integrating code uses a permissive JSON parser which ignores unknown fields, any additions will not affect existing code.  Other endpoints may be changed with new node versions carrying protocol-updates, although any breaking changes will be flagged clearly in the corresponding release notes.  All responses may have additional fields added, so clients are advised to use JSON parsers which ignore unknown fields on JSON objects. 
 *
 * The version of the OpenAPI document: v1.0.4
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

import { exists, mapValues } from '../runtime';
import type { LedgerStateSummary } from './LedgerStateSummary';
import {
    LedgerStateSummaryFromJSON,
    LedgerStateSummaryFromJSONTyped,
    LedgerStateSummaryToJSON,
} from './LedgerStateSummary';
import type { Substate } from './Substate';
import {
    SubstateFromJSON,
    SubstateFromJSONTyped,
    SubstateToJSON,
} from './Substate';

/**
 * 
 * @export
 * @interface StateConsensusManagerResponse
 */
export interface StateConsensusManagerResponse {
    /**
     * 
     * @type {LedgerStateSummary}
     * @memberof StateConsensusManagerResponse
     */
    at_ledger_state: LedgerStateSummary;
    /**
     * 
     * @type {Substate}
     * @memberof StateConsensusManagerResponse
     */
    config: Substate;
    /**
     * 
     * @type {Substate}
     * @memberof StateConsensusManagerResponse
     */
    state: Substate;
    /**
     * 
     * @type {Substate}
     * @memberof StateConsensusManagerResponse
     */
    current_proposal_statistic: Substate;
    /**
     * 
     * @type {Substate}
     * @memberof StateConsensusManagerResponse
     */
    current_validator_set: Substate;
    /**
     * 
     * @type {Substate}
     * @memberof StateConsensusManagerResponse
     */
    current_time: Substate;
    /**
     * 
     * @type {Substate}
     * @memberof StateConsensusManagerResponse
     */
    current_time_rounded_to_minutes: Substate;
}

/**
 * Check if a given object implements the StateConsensusManagerResponse interface.
 */
export function instanceOfStateConsensusManagerResponse(value: object): boolean {
    let isInstance = true;
    isInstance = isInstance && "at_ledger_state" in value;
    isInstance = isInstance && "config" in value;
    isInstance = isInstance && "state" in value;
    isInstance = isInstance && "current_proposal_statistic" in value;
    isInstance = isInstance && "current_validator_set" in value;
    isInstance = isInstance && "current_time" in value;
    isInstance = isInstance && "current_time_rounded_to_minutes" in value;

    return isInstance;
}

export function StateConsensusManagerResponseFromJSON(json: any): StateConsensusManagerResponse {
    return StateConsensusManagerResponseFromJSONTyped(json, false);
}

export function StateConsensusManagerResponseFromJSONTyped(json: any, ignoreDiscriminator: boolean): StateConsensusManagerResponse {
    if ((json === undefined) || (json === null)) {
        return json;
    }
    return {
        
        'at_ledger_state': LedgerStateSummaryFromJSON(json['at_ledger_state']),
        'config': SubstateFromJSON(json['config']),
        'state': SubstateFromJSON(json['state']),
        'current_proposal_statistic': SubstateFromJSON(json['current_proposal_statistic']),
        'current_validator_set': SubstateFromJSON(json['current_validator_set']),
        'current_time': SubstateFromJSON(json['current_time']),
        'current_time_rounded_to_minutes': SubstateFromJSON(json['current_time_rounded_to_minutes']),
    };
}

export function StateConsensusManagerResponseToJSON(value?: StateConsensusManagerResponse | null): any {
    if (value === undefined) {
        return undefined;
    }
    if (value === null) {
        return null;
    }
    return {
        
        'at_ledger_state': LedgerStateSummaryToJSON(value.at_ledger_state),
        'config': SubstateToJSON(value.config),
        'state': SubstateToJSON(value.state),
        'current_proposal_statistic': SubstateToJSON(value.current_proposal_statistic),
        'current_validator_set': SubstateToJSON(value.current_validator_set),
        'current_time': SubstateToJSON(value.current_time),
        'current_time_rounded_to_minutes': SubstateToJSON(value.current_time_rounded_to_minutes),
    };
}

