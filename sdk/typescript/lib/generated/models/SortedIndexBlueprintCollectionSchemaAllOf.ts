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
import type { BlueprintPayloadDef } from './BlueprintPayloadDef';
import {
    BlueprintPayloadDefFromJSON,
    BlueprintPayloadDefFromJSONTyped,
    BlueprintPayloadDefToJSON,
} from './BlueprintPayloadDef';

/**
 * 
 * @export
 * @interface SortedIndexBlueprintCollectionSchemaAllOf
 */
export interface SortedIndexBlueprintCollectionSchemaAllOf {
    /**
     * 
     * @type {BlueprintPayloadDef}
     * @memberof SortedIndexBlueprintCollectionSchemaAllOf
     */
    key_type_ref: BlueprintPayloadDef;
    /**
     * 
     * @type {BlueprintPayloadDef}
     * @memberof SortedIndexBlueprintCollectionSchemaAllOf
     */
    value_type_ref: BlueprintPayloadDef;
    /**
     * Whether the entries of the sorted index partition are allowed to own child nodes.
     * @type {boolean}
     * @memberof SortedIndexBlueprintCollectionSchemaAllOf
     */
    allow_ownership: boolean;
    /**
     * 
     * @type {string}
     * @memberof SortedIndexBlueprintCollectionSchemaAllOf
     */
    type?: SortedIndexBlueprintCollectionSchemaAllOfTypeEnum;
}


/**
 * @export
 */
export const SortedIndexBlueprintCollectionSchemaAllOfTypeEnum = {
    SortedIndex: 'SortedIndex'
} as const;
export type SortedIndexBlueprintCollectionSchemaAllOfTypeEnum = typeof SortedIndexBlueprintCollectionSchemaAllOfTypeEnum[keyof typeof SortedIndexBlueprintCollectionSchemaAllOfTypeEnum];


/**
 * Check if a given object implements the SortedIndexBlueprintCollectionSchemaAllOf interface.
 */
export function instanceOfSortedIndexBlueprintCollectionSchemaAllOf(value: object): boolean {
    let isInstance = true;
    isInstance = isInstance && "key_type_ref" in value;
    isInstance = isInstance && "value_type_ref" in value;
    isInstance = isInstance && "allow_ownership" in value;

    return isInstance;
}

export function SortedIndexBlueprintCollectionSchemaAllOfFromJSON(json: any): SortedIndexBlueprintCollectionSchemaAllOf {
    return SortedIndexBlueprintCollectionSchemaAllOfFromJSONTyped(json, false);
}

export function SortedIndexBlueprintCollectionSchemaAllOfFromJSONTyped(json: any, ignoreDiscriminator: boolean): SortedIndexBlueprintCollectionSchemaAllOf {
    if ((json === undefined) || (json === null)) {
        return json;
    }
    return {
        
        'key_type_ref': BlueprintPayloadDefFromJSON(json['key_type_ref']),
        'value_type_ref': BlueprintPayloadDefFromJSON(json['value_type_ref']),
        'allow_ownership': json['allow_ownership'],
        'type': !exists(json, 'type') ? undefined : json['type'],
    };
}

export function SortedIndexBlueprintCollectionSchemaAllOfToJSON(value?: SortedIndexBlueprintCollectionSchemaAllOf | null): any {
    if (value === undefined) {
        return undefined;
    }
    if (value === null) {
        return null;
    }
    return {
        
        'key_type_ref': BlueprintPayloadDefToJSON(value.key_type_ref),
        'value_type_ref': BlueprintPayloadDefToJSON(value.value_type_ref),
        'allow_ownership': value.allow_ownership,
        'type': value.type,
    };
}

