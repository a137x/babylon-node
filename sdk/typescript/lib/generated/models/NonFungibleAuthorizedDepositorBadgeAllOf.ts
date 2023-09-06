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
import type { NonFungibleGlobalId } from './NonFungibleGlobalId';
import {
    NonFungibleGlobalIdFromJSON,
    NonFungibleGlobalIdFromJSONTyped,
    NonFungibleGlobalIdToJSON,
} from './NonFungibleGlobalId';

/**
 * 
 * @export
 * @interface NonFungibleAuthorizedDepositorBadgeAllOf
 */
export interface NonFungibleAuthorizedDepositorBadgeAllOf {
    /**
     * 
     * @type {NonFungibleGlobalId}
     * @memberof NonFungibleAuthorizedDepositorBadgeAllOf
     */
    non_fungible_global_id: NonFungibleGlobalId;
    /**
     * 
     * @type {string}
     * @memberof NonFungibleAuthorizedDepositorBadgeAllOf
     */
    type?: NonFungibleAuthorizedDepositorBadgeAllOfTypeEnum;
}


/**
 * @export
 */
export const NonFungibleAuthorizedDepositorBadgeAllOfTypeEnum = {
    NonFungible: 'NonFungible'
} as const;
export type NonFungibleAuthorizedDepositorBadgeAllOfTypeEnum = typeof NonFungibleAuthorizedDepositorBadgeAllOfTypeEnum[keyof typeof NonFungibleAuthorizedDepositorBadgeAllOfTypeEnum];


/**
 * Check if a given object implements the NonFungibleAuthorizedDepositorBadgeAllOf interface.
 */
export function instanceOfNonFungibleAuthorizedDepositorBadgeAllOf(value: object): boolean {
    let isInstance = true;
    isInstance = isInstance && "non_fungible_global_id" in value;

    return isInstance;
}

export function NonFungibleAuthorizedDepositorBadgeAllOfFromJSON(json: any): NonFungibleAuthorizedDepositorBadgeAllOf {
    return NonFungibleAuthorizedDepositorBadgeAllOfFromJSONTyped(json, false);
}

export function NonFungibleAuthorizedDepositorBadgeAllOfFromJSONTyped(json: any, ignoreDiscriminator: boolean): NonFungibleAuthorizedDepositorBadgeAllOf {
    if ((json === undefined) || (json === null)) {
        return json;
    }
    return {
        
        'non_fungible_global_id': NonFungibleGlobalIdFromJSON(json['non_fungible_global_id']),
        'type': !exists(json, 'type') ? undefined : json['type'],
    };
}

export function NonFungibleAuthorizedDepositorBadgeAllOfToJSON(value?: NonFungibleAuthorizedDepositorBadgeAllOf | null): any {
    if (value === undefined) {
        return undefined;
    }
    if (value === null) {
        return null;
    }
    return {
        
        'non_fungible_global_id': NonFungibleGlobalIdToJSON(value.non_fungible_global_id),
        'type': value.type,
    };
}

