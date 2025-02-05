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
import type { NonFungibleIdType } from './NonFungibleIdType';
import {
    NonFungibleIdTypeFromJSON,
    NonFungibleIdTypeFromJSONTyped,
    NonFungibleIdTypeToJSON,
} from './NonFungibleIdType';

/**
 * 
 * @export
 * @interface NonFungibleLocalId
 */
export interface NonFungibleLocalId {
    /**
     * The simple string representation of the non-fungible id.
     * * For string ids, this is `<the-string-id>`
     * * For integer ids, this is `#the-integer-id#`
     * * For bytes ids, this is `[the-lower-case-hex-representation]`
     * * For RUID ids, this is `{...-...-...-...}` where `...` are each 16 hex characters.
     * A given non-fungible resource has a fixed `NonFungibleIdType`, so this representation uniquely identifies this non-fungible
     * under the given resource address.
     * @type {string}
     * @memberof NonFungibleLocalId
     */
    simple_rep: string;
    /**
     * 
     * @type {NonFungibleIdType}
     * @memberof NonFungibleLocalId
     */
    id_type: NonFungibleIdType;
    /**
     * The hex-encoded SBOR-encoded bytes of its non-fungible id
     * @type {string}
     * @memberof NonFungibleLocalId
     */
    sbor_hex: string;
}

/**
 * Check if a given object implements the NonFungibleLocalId interface.
 */
export function instanceOfNonFungibleLocalId(value: object): boolean {
    let isInstance = true;
    isInstance = isInstance && "simple_rep" in value;
    isInstance = isInstance && "id_type" in value;
    isInstance = isInstance && "sbor_hex" in value;

    return isInstance;
}

export function NonFungibleLocalIdFromJSON(json: any): NonFungibleLocalId {
    return NonFungibleLocalIdFromJSONTyped(json, false);
}

export function NonFungibleLocalIdFromJSONTyped(json: any, ignoreDiscriminator: boolean): NonFungibleLocalId {
    if ((json === undefined) || (json === null)) {
        return json;
    }
    return {
        
        'simple_rep': json['simple_rep'],
        'id_type': NonFungibleIdTypeFromJSON(json['id_type']),
        'sbor_hex': json['sbor_hex'],
    };
}

export function NonFungibleLocalIdToJSON(value?: NonFungibleLocalId | null): any {
    if (value === undefined) {
        return undefined;
    }
    if (value === null) {
        return null;
    }
    return {
        
        'simple_rep': value.simple_rep,
        'id_type': NonFungibleIdTypeToJSON(value.id_type),
        'sbor_hex': value.sbor_hex,
    };
}

