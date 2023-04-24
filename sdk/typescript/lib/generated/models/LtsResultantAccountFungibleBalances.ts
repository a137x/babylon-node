/* tslint:disable */
/* eslint-disable */
/**
 * Babylon Core API - RCnet V1
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node.  It is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Very heavy load may impact the node\'s function.  This API exposes queries against the node\'s current state (see `/lts/state/` or `/state/`), and streams of transaction history (under `/lts/stream/` or `/stream`).  If you require queries against snapshots of historical ledger state, you may also wish to consider using the [Gateway API](https://docs-babylon.radixdlt.com/).  ## Integration and forward compatibility guarantees  This version of the Core API belongs to the first release candidate of the Radix Babylon network (\"RCnet-V1\").  Integrators (such as exchanges) are recommended to use the `/lts/` endpoints - they have been designed to be clear and simple for integrators wishing to create and monitor transactions involving fungible transfers to/from accounts.  All endpoints under `/lts/` are guaranteed to be forward compatible to Babylon mainnet launch (and beyond). We may add new fields, but existing fields will not be changed. Assuming the integrating code uses a permissive JSON parser which ignores unknown fields, any additions will not affect existing code.  We give no guarantees that other endpoints will not change before Babylon mainnet launch, although changes are expected to be minimal. 
 *
 * The version of the OpenAPI document: 0.3.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

import { exists, mapValues } from '../runtime';
import type { LtsResultantFungibleBalance } from './LtsResultantFungibleBalance';
import {
    LtsResultantFungibleBalanceFromJSON,
    LtsResultantFungibleBalanceFromJSONTyped,
    LtsResultantFungibleBalanceToJSON,
} from './LtsResultantFungibleBalance';

/**
 * 
 * @export
 * @interface LtsResultantAccountFungibleBalances
 */
export interface LtsResultantAccountFungibleBalances {
    /**
     * The Bech32m-encoded human readable version of the account's address
     * @type {string}
     * @memberof LtsResultantAccountFungibleBalances
     */
    account_address: string;
    /**
     * 
     * @type {Array<LtsResultantFungibleBalance>}
     * @memberof LtsResultantAccountFungibleBalances
     */
    resultant_balances: Array<LtsResultantFungibleBalance>;
}

/**
 * Check if a given object implements the LtsResultantAccountFungibleBalances interface.
 */
export function instanceOfLtsResultantAccountFungibleBalances(value: object): boolean {
    let isInstance = true;
    isInstance = isInstance && "account_address" in value;
    isInstance = isInstance && "resultant_balances" in value;

    return isInstance;
}

export function LtsResultantAccountFungibleBalancesFromJSON(json: any): LtsResultantAccountFungibleBalances {
    return LtsResultantAccountFungibleBalancesFromJSONTyped(json, false);
}

export function LtsResultantAccountFungibleBalancesFromJSONTyped(json: any, ignoreDiscriminator: boolean): LtsResultantAccountFungibleBalances {
    if ((json === undefined) || (json === null)) {
        return json;
    }
    return {
        
        'account_address': json['account_address'],
        'resultant_balances': ((json['resultant_balances'] as Array<any>).map(LtsResultantFungibleBalanceFromJSON)),
    };
}

export function LtsResultantAccountFungibleBalancesToJSON(value?: LtsResultantAccountFungibleBalances | null): any {
    if (value === undefined) {
        return undefined;
    }
    if (value === null) {
        return null;
    }
    return {
        
        'account_address': value.account_address,
        'resultant_balances': ((value.resultant_balances as Array<any>).map(LtsResultantFungibleBalanceToJSON)),
    };
}

