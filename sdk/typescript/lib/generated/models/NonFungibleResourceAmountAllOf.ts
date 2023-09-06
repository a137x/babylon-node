/* tslint:disable */
/* eslint-disable */
/**
 * Babylon Core API - RCnet v3.1
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node.  It is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Very heavy load may impact the node\'s function.  This API exposes queries against the node\'s current state (see `/lts/state/` or `/state/`), and streams of transaction history (under `/lts/stream/` or `/stream`).  If you require queries against snapshots of historical ledger state, you may also wish to consider using the [Gateway API](https://docs-babylon.radixdlt.com/).  ## Integration and forward compatibility guarantees  This version of the Core API belongs to the fourth release candidate of the Radix Babylon network (\"RCnet v3.1\").  Integrators (such as exchanges) are recommended to use the `/lts/` endpoints - they have been designed to be clear and simple for integrators wishing to create and monitor transactions involving fungible transfers to/from accounts.  All endpoints under `/lts/` are guaranteed to be forward compatible to Babylon mainnet launch (and beyond). We may add new fields, but existing fields will not be changed. Assuming the integrating code uses a permissive JSON parser which ignores unknown fields, any additions will not affect existing code. 
 *
 * The version of the OpenAPI document: 0.5.1
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

import { exists, mapValues } from '../runtime';
import type { NonFungibleLocalId } from './NonFungibleLocalId';
import {
    NonFungibleLocalIdFromJSON,
    NonFungibleLocalIdFromJSONTyped,
    NonFungibleLocalIdToJSON,
} from './NonFungibleLocalId';

/**
 * 
 * @export
 * @interface NonFungibleResourceAmountAllOf
 */
export interface NonFungibleResourceAmountAllOf {
    /**
     * The string-encoded decimal representing the amount of this resource (some decimal for fungible resources, a whole integer for non-fungible resources).
     * A decimal is formed of some signed integer `m` of attos (`10^(-18)`) units, where `-2^(192 - 1) <= m < 2^(192 - 1)`.
     * @type {string}
     * @memberof NonFungibleResourceAmountAllOf
     */
    amount: string;
    /**
     * 
     * @type {Array<NonFungibleLocalId>}
     * @memberof NonFungibleResourceAmountAllOf
     */
    non_fungible_ids: Array<NonFungibleLocalId>;
    /**
     * 
     * @type {string}
     * @memberof NonFungibleResourceAmountAllOf
     */
    resource_type?: NonFungibleResourceAmountAllOfResourceTypeEnum;
}


/**
 * @export
 */
export const NonFungibleResourceAmountAllOfResourceTypeEnum = {
    NonFungible: 'NonFungible'
} as const;
export type NonFungibleResourceAmountAllOfResourceTypeEnum = typeof NonFungibleResourceAmountAllOfResourceTypeEnum[keyof typeof NonFungibleResourceAmountAllOfResourceTypeEnum];


/**
 * Check if a given object implements the NonFungibleResourceAmountAllOf interface.
 */
export function instanceOfNonFungibleResourceAmountAllOf(value: object): boolean {
    let isInstance = true;
    isInstance = isInstance && "amount" in value;
    isInstance = isInstance && "non_fungible_ids" in value;

    return isInstance;
}

export function NonFungibleResourceAmountAllOfFromJSON(json: any): NonFungibleResourceAmountAllOf {
    return NonFungibleResourceAmountAllOfFromJSONTyped(json, false);
}

export function NonFungibleResourceAmountAllOfFromJSONTyped(json: any, ignoreDiscriminator: boolean): NonFungibleResourceAmountAllOf {
    if ((json === undefined) || (json === null)) {
        return json;
    }
    return {
        
        'amount': json['amount'],
        'non_fungible_ids': ((json['non_fungible_ids'] as Array<any>).map(NonFungibleLocalIdFromJSON)),
        'resource_type': !exists(json, 'resource_type') ? undefined : json['resource_type'],
    };
}

export function NonFungibleResourceAmountAllOfToJSON(value?: NonFungibleResourceAmountAllOf | null): any {
    if (value === undefined) {
        return undefined;
    }
    if (value === null) {
        return null;
    }
    return {
        
        'amount': value.amount,
        'non_fungible_ids': ((value.non_fungible_ids as Array<any>).map(NonFungibleLocalIdToJSON)),
        'resource_type': value.resource_type,
    };
}

