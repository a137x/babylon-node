/* tslint:disable */
/* eslint-disable */
/**
 * Radix Core API - Babylon
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node.  The default configuration is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Very heavy load may impact the node\'s function. The node exposes a configuration flag which allows disabling certain endpoints which may be problematic, but monitoring is advised. This configuration parameter is `api.core.flags.enable_unbounded_endpoints` / `RADIXDLT_CORE_API_FLAGS_ENABLE_UNBOUNDED_ENDPOINTS`.  This API exposes queries against the node\'s current state (see `/lts/state/` or `/state/`), and streams of transaction history (under `/lts/stream/` or `/stream`).  If you require queries against snapshots of historical ledger state, you may also wish to consider using the [Gateway API](https://docs-babylon.radixdlt.com/).  ## Integration and forward compatibility guarantees  Integrators (such as exchanges) are recommended to use the `/lts/` endpoints - they have been designed to be clear and simple for integrators wishing to create and monitor transactions involving fungible transfers to/from accounts.  All endpoints under `/lts/` have high guarantees of forward compatibility in future node versions. We may add new fields, but existing fields will not be changed. Assuming the integrating code uses a permissive JSON parser which ignores unknown fields, any additions will not affect existing code.  Other endpoints may be changed with new node versions carrying protocol-updates, although any breaking changes will be flagged clearly in the corresponding release notes.  All responses may have additional fields added, so clients are advised to use JSON parsers which ignore unknown fields on JSON objects. 
 *
 * The version of the OpenAPI document: v1.0.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

import { exists, mapValues } from '../runtime';
import type { Substate } from './Substate';
import {
    SubstateFromJSON,
    SubstateFromJSONTyped,
    SubstateToJSON,
} from './Substate';

/**
 * 
 * @export
 * @interface SubstateValue
 */
export interface SubstateValue {
    /**
     * The hex-encoded, SBOR-encoded substate data bytes. Only returned if enabled in SubstateFormatOptions on your request (default false).
     * @type {string}
     * @memberof SubstateValue
     */
    substate_hex?: string;
    /**
     * The hex-encoded Blake2b-256 hash of the substate data bytes. Only returned if enabled in SubstateFormatOptions on your request (default false).
     * @type {string}
     * @memberof SubstateValue
     */
    substate_data_hash?: string;
    /**
     * 
     * @type {Substate}
     * @memberof SubstateValue
     */
    substate_data?: Substate;
}

/**
 * Check if a given object implements the SubstateValue interface.
 */
export function instanceOfSubstateValue(value: object): boolean {
    let isInstance = true;

    return isInstance;
}

export function SubstateValueFromJSON(json: any): SubstateValue {
    return SubstateValueFromJSONTyped(json, false);
}

export function SubstateValueFromJSONTyped(json: any, ignoreDiscriminator: boolean): SubstateValue {
    if ((json === undefined) || (json === null)) {
        return json;
    }
    return {
        
        'substate_hex': !exists(json, 'substate_hex') ? undefined : json['substate_hex'],
        'substate_data_hash': !exists(json, 'substate_data_hash') ? undefined : json['substate_data_hash'],
        'substate_data': !exists(json, 'substate_data') ? undefined : SubstateFromJSON(json['substate_data']),
    };
}

export function SubstateValueToJSON(value?: SubstateValue | null): any {
    if (value === undefined) {
        return undefined;
    }
    if (value === null) {
        return null;
    }
    return {
        
        'substate_hex': value.substate_hex,
        'substate_data_hash': value.substate_data_hash,
        'substate_data': SubstateToJSON(value.substate_data),
    };
}

