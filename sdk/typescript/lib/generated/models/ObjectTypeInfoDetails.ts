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
import type { BlueprintInfo } from './BlueprintInfo';
import {
    BlueprintInfoFromJSON,
    BlueprintInfoFromJSONTyped,
    BlueprintInfoToJSON,
} from './BlueprintInfo';
import type { ModuleVersion } from './ModuleVersion';
import {
    ModuleVersionFromJSON,
    ModuleVersionFromJSONTyped,
    ModuleVersionToJSON,
} from './ModuleVersion';

/**
 * 
 * @export
 * @interface ObjectTypeInfoDetails
 */
export interface ObjectTypeInfoDetails {
    /**
     * 
     * @type {string}
     * @memberof ObjectTypeInfoDetails
     */
    type: ObjectTypeInfoDetailsTypeEnum;
    /**
     * 
     * @type {Array<ModuleVersion>}
     * @memberof ObjectTypeInfoDetails
     */
    module_versions: Array<ModuleVersion>;
    /**
     * 
     * @type {BlueprintInfo}
     * @memberof ObjectTypeInfoDetails
     */
    blueprint_info: BlueprintInfo;
    /**
     * 
     * @type {boolean}
     * @memberof ObjectTypeInfoDetails
     */
    global: boolean;
}


/**
 * @export
 */
export const ObjectTypeInfoDetailsTypeEnum = {
    Object: 'Object'
} as const;
export type ObjectTypeInfoDetailsTypeEnum = typeof ObjectTypeInfoDetailsTypeEnum[keyof typeof ObjectTypeInfoDetailsTypeEnum];


/**
 * Check if a given object implements the ObjectTypeInfoDetails interface.
 */
export function instanceOfObjectTypeInfoDetails(value: object): boolean {
    let isInstance = true;
    isInstance = isInstance && "type" in value;
    isInstance = isInstance && "module_versions" in value;
    isInstance = isInstance && "blueprint_info" in value;
    isInstance = isInstance && "global" in value;

    return isInstance;
}

export function ObjectTypeInfoDetailsFromJSON(json: any): ObjectTypeInfoDetails {
    return ObjectTypeInfoDetailsFromJSONTyped(json, false);
}

export function ObjectTypeInfoDetailsFromJSONTyped(json: any, ignoreDiscriminator: boolean): ObjectTypeInfoDetails {
    if ((json === undefined) || (json === null)) {
        return json;
    }
    return {
        
        'type': json['type'],
        'module_versions': ((json['module_versions'] as Array<any>).map(ModuleVersionFromJSON)),
        'blueprint_info': BlueprintInfoFromJSON(json['blueprint_info']),
        'global': json['global'],
    };
}

export function ObjectTypeInfoDetailsToJSON(value?: ObjectTypeInfoDetails | null): any {
    if (value === undefined) {
        return undefined;
    }
    if (value === null) {
        return null;
    }
    return {
        
        'type': value.type,
        'module_versions': ((value.module_versions as Array<any>).map(ModuleVersionToJSON)),
        'blueprint_info': BlueprintInfoToJSON(value.blueprint_info),
        'global': value.global,
    };
}

