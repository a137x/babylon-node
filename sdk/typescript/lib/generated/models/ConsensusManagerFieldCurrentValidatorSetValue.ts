/* tslint:disable */
/* eslint-disable */
/**
 * Babylon Core API - RCnet V2
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node.  It is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Very heavy load may impact the node\'s function.  This API exposes queries against the node\'s current state (see `/lts/state/` or `/state/`), and streams of transaction history (under `/lts/stream/` or `/stream`).  If you require queries against snapshots of historical ledger state, you may also wish to consider using the [Gateway API](https://docs-babylon.radixdlt.com/).  ## Integration and forward compatibility guarantees  This version of the Core API belongs to the second release candidate of the Radix Babylon network (\"RCnet v2\").  Integrators (such as exchanges) are recommended to use the `/lts/` endpoints - they have been designed to be clear and simple for integrators wishing to create and monitor transactions involving fungible transfers to/from accounts.  All endpoints under `/lts/` are guaranteed to be forward compatible to Babylon mainnet launch (and beyond). We may add new fields, but existing fields will not be changed. Assuming the integrating code uses a permissive JSON parser which ignores unknown fields, any additions will not affect existing code.  We give no guarantees that other endpoints will not change before Babylon mainnet launch, although changes are expected to be minimal. 
 *
 * The version of the OpenAPI document: 0.4.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

import { exists, mapValues } from '../runtime';
import type { ActiveValidator } from './ActiveValidator';
import {
    ActiveValidatorFromJSON,
    ActiveValidatorFromJSONTyped,
    ActiveValidatorToJSON,
} from './ActiveValidator';

/**
 * 
 * @export
 * @interface ConsensusManagerFieldCurrentValidatorSetValue
 */
export interface ConsensusManagerFieldCurrentValidatorSetValue {
    /**
     * 
     * @type {Array<ActiveValidator>}
     * @memberof ConsensusManagerFieldCurrentValidatorSetValue
     */
    validator_set: Array<ActiveValidator>;
}

/**
 * Check if a given object implements the ConsensusManagerFieldCurrentValidatorSetValue interface.
 */
export function instanceOfConsensusManagerFieldCurrentValidatorSetValue(value: object): boolean {
    let isInstance = true;
    isInstance = isInstance && "validator_set" in value;

    return isInstance;
}

export function ConsensusManagerFieldCurrentValidatorSetValueFromJSON(json: any): ConsensusManagerFieldCurrentValidatorSetValue {
    return ConsensusManagerFieldCurrentValidatorSetValueFromJSONTyped(json, false);
}

export function ConsensusManagerFieldCurrentValidatorSetValueFromJSONTyped(json: any, ignoreDiscriminator: boolean): ConsensusManagerFieldCurrentValidatorSetValue {
    if ((json === undefined) || (json === null)) {
        return json;
    }
    return {
        
        'validator_set': ((json['validator_set'] as Array<any>).map(ActiveValidatorFromJSON)),
    };
}

export function ConsensusManagerFieldCurrentValidatorSetValueToJSON(value?: ConsensusManagerFieldCurrentValidatorSetValue | null): any {
    if (value === undefined) {
        return undefined;
    }
    if (value === null) {
        return null;
    }
    return {
        
        'validator_set': ((value.validator_set as Array<any>).map(ActiveValidatorToJSON)),
    };
}

