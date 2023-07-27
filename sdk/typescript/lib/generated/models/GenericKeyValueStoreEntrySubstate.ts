/* tslint:disable */
/* eslint-disable */
/**
 * Babylon Core API - RCnet v3
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node.  It is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Very heavy load may impact the node\'s function.  This API exposes queries against the node\'s current state (see `/lts/state/` or `/state/`), and streams of transaction history (under `/lts/stream/` or `/stream`).  If you require queries against snapshots of historical ledger state, you may also wish to consider using the [Gateway API](https://docs-babylon.radixdlt.com/).  ## Integration and forward compatibility guarantees  This version of the Core API belongs to the second release candidate of the Radix Babylon network (\"RCnet v3\").  Integrators (such as exchanges) are recommended to use the `/lts/` endpoints - they have been designed to be clear and simple for integrators wishing to create and monitor transactions involving fungible transfers to/from accounts.  All endpoints under `/lts/` are guaranteed to be forward compatible to Babylon mainnet launch (and beyond). We may add new fields, but existing fields will not be changed. Assuming the integrating code uses a permissive JSON parser which ignores unknown fields, any additions will not affect existing code. 
 *
 * The version of the OpenAPI document: 0.5.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

import { exists, mapValues } from '../runtime';
import type { GenericKey } from './GenericKey';
import {
    GenericKeyFromJSON,
    GenericKeyFromJSONTyped,
    GenericKeyToJSON,
} from './GenericKey';
import type { GenericKeyValueStoreEntryValue } from './GenericKeyValueStoreEntryValue';
import {
    GenericKeyValueStoreEntryValueFromJSON,
    GenericKeyValueStoreEntryValueFromJSONTyped,
    GenericKeyValueStoreEntryValueToJSON,
} from './GenericKeyValueStoreEntryValue';

/**
 * 
 * @export
 * @interface GenericKeyValueStoreEntrySubstate
 */
export interface GenericKeyValueStoreEntrySubstate {
    /**
     * 
     * @type {string}
     * @memberof GenericKeyValueStoreEntrySubstate
     */
    substate_type: GenericKeyValueStoreEntrySubstateSubstateTypeEnum;
    /**
     * 
     * @type {boolean}
     * @memberof GenericKeyValueStoreEntrySubstate
     */
    is_locked: boolean;
    /**
     * 
     * @type {GenericKey}
     * @memberof GenericKeyValueStoreEntrySubstate
     */
    key: GenericKey;
    /**
     * 
     * @type {GenericKeyValueStoreEntryValue}
     * @memberof GenericKeyValueStoreEntrySubstate
     */
    value?: GenericKeyValueStoreEntryValue;
}


/**
 * @export
 */
export const GenericKeyValueStoreEntrySubstateSubstateTypeEnum = {
    GenericKeyValueStoreEntry: 'GenericKeyValueStoreEntry'
} as const;
export type GenericKeyValueStoreEntrySubstateSubstateTypeEnum = typeof GenericKeyValueStoreEntrySubstateSubstateTypeEnum[keyof typeof GenericKeyValueStoreEntrySubstateSubstateTypeEnum];


/**
 * Check if a given object implements the GenericKeyValueStoreEntrySubstate interface.
 */
export function instanceOfGenericKeyValueStoreEntrySubstate(value: object): boolean {
    let isInstance = true;
    isInstance = isInstance && "substate_type" in value;
    isInstance = isInstance && "is_locked" in value;
    isInstance = isInstance && "key" in value;

    return isInstance;
}

export function GenericKeyValueStoreEntrySubstateFromJSON(json: any): GenericKeyValueStoreEntrySubstate {
    return GenericKeyValueStoreEntrySubstateFromJSONTyped(json, false);
}

export function GenericKeyValueStoreEntrySubstateFromJSONTyped(json: any, ignoreDiscriminator: boolean): GenericKeyValueStoreEntrySubstate {
    if ((json === undefined) || (json === null)) {
        return json;
    }
    return {
        
        'substate_type': json['substate_type'],
        'is_locked': json['is_locked'],
        'key': GenericKeyFromJSON(json['key']),
        'value': !exists(json, 'value') ? undefined : GenericKeyValueStoreEntryValueFromJSON(json['value']),
    };
}

export function GenericKeyValueStoreEntrySubstateToJSON(value?: GenericKeyValueStoreEntrySubstate | null): any {
    if (value === undefined) {
        return undefined;
    }
    if (value === null) {
        return null;
    }
    return {
        
        'substate_type': value.substate_type,
        'is_locked': value.is_locked,
        'key': GenericKeyToJSON(value.key),
        'value': GenericKeyValueStoreEntryValueToJSON(value.value),
    };
}

