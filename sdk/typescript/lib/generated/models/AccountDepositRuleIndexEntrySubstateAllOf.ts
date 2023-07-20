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
import type { AccountDepositRuleIndexEntryValue } from './AccountDepositRuleIndexEntryValue';
import {
    AccountDepositRuleIndexEntryValueFromJSON,
    AccountDepositRuleIndexEntryValueFromJSONTyped,
    AccountDepositRuleIndexEntryValueToJSON,
} from './AccountDepositRuleIndexEntryValue';
import type { ResourceKey } from './ResourceKey';
import {
    ResourceKeyFromJSON,
    ResourceKeyFromJSONTyped,
    ResourceKeyToJSON,
} from './ResourceKey';

/**
 * 
 * @export
 * @interface AccountDepositRuleIndexEntrySubstateAllOf
 */
export interface AccountDepositRuleIndexEntrySubstateAllOf {
    /**
     * 
     * @type {ResourceKey}
     * @memberof AccountDepositRuleIndexEntrySubstateAllOf
     */
    key: ResourceKey;
    /**
     * 
     * @type {AccountDepositRuleIndexEntryValue}
     * @memberof AccountDepositRuleIndexEntrySubstateAllOf
     */
    value?: AccountDepositRuleIndexEntryValue;
    /**
     * 
     * @type {string}
     * @memberof AccountDepositRuleIndexEntrySubstateAllOf
     */
    substate_type?: AccountDepositRuleIndexEntrySubstateAllOfSubstateTypeEnum;
}


/**
 * @export
 */
export const AccountDepositRuleIndexEntrySubstateAllOfSubstateTypeEnum = {
    AccountDepositRuleIndexEntry: 'AccountDepositRuleIndexEntry'
} as const;
export type AccountDepositRuleIndexEntrySubstateAllOfSubstateTypeEnum = typeof AccountDepositRuleIndexEntrySubstateAllOfSubstateTypeEnum[keyof typeof AccountDepositRuleIndexEntrySubstateAllOfSubstateTypeEnum];


/**
 * Check if a given object implements the AccountDepositRuleIndexEntrySubstateAllOf interface.
 */
export function instanceOfAccountDepositRuleIndexEntrySubstateAllOf(value: object): boolean {
    let isInstance = true;
    isInstance = isInstance && "key" in value;

    return isInstance;
}

export function AccountDepositRuleIndexEntrySubstateAllOfFromJSON(json: any): AccountDepositRuleIndexEntrySubstateAllOf {
    return AccountDepositRuleIndexEntrySubstateAllOfFromJSONTyped(json, false);
}

export function AccountDepositRuleIndexEntrySubstateAllOfFromJSONTyped(json: any, ignoreDiscriminator: boolean): AccountDepositRuleIndexEntrySubstateAllOf {
    if ((json === undefined) || (json === null)) {
        return json;
    }
    return {
        
        'key': ResourceKeyFromJSON(json['key']),
        'value': !exists(json, 'value') ? undefined : AccountDepositRuleIndexEntryValueFromJSON(json['value']),
        'substate_type': !exists(json, 'substate_type') ? undefined : json['substate_type'],
    };
}

export function AccountDepositRuleIndexEntrySubstateAllOfToJSON(value?: AccountDepositRuleIndexEntrySubstateAllOf | null): any {
    if (value === undefined) {
        return undefined;
    }
    if (value === null) {
        return null;
    }
    return {
        
        'key': ResourceKeyToJSON(value.key),
        'value': AccountDepositRuleIndexEntryValueToJSON(value.value),
        'substate_type': value.substate_type,
    };
}

