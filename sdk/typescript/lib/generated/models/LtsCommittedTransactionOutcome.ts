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
import type { LtsCommittedTransactionStatus } from './LtsCommittedTransactionStatus';
import {
    LtsCommittedTransactionStatusFromJSON,
    LtsCommittedTransactionStatusFromJSONTyped,
    LtsCommittedTransactionStatusToJSON,
} from './LtsCommittedTransactionStatus';
import type { LtsEntityFungibleBalanceChanges } from './LtsEntityFungibleBalanceChanges';
import {
    LtsEntityFungibleBalanceChangesFromJSON,
    LtsEntityFungibleBalanceChangesFromJSONTyped,
    LtsEntityFungibleBalanceChangesToJSON,
} from './LtsEntityFungibleBalanceChanges';
import type { LtsResultantAccountFungibleBalances } from './LtsResultantAccountFungibleBalances';
import {
    LtsResultantAccountFungibleBalancesFromJSON,
    LtsResultantAccountFungibleBalancesFromJSONTyped,
    LtsResultantAccountFungibleBalancesToJSON,
} from './LtsResultantAccountFungibleBalances';
import type { TransactionIdentifiers } from './TransactionIdentifiers';
import {
    TransactionIdentifiersFromJSON,
    TransactionIdentifiersFromJSONTyped,
    TransactionIdentifiersToJSON,
} from './TransactionIdentifiers';

/**
 * For the given transaction, contains the status, total fee summary and individual entity resource balance changes.
 * The balance changes accounts for the fee payments as well.
 * Current implementation does not take into account recalls, but this will change in a future update.
 * For failed transactions, current implementation does not return any balance changes (not even the fee payments).
 * This will also change in a future update.
 * @export
 * @interface LtsCommittedTransactionOutcome
 */
export interface LtsCommittedTransactionOutcome {
    /**
     * 
     * @type {number}
     * @memberof LtsCommittedTransactionOutcome
     */
    state_version: number;
    /**
     * The hex-encoded transaction accumulator hash. This hash captures the order of all transactions on ledger.
     * This hash is `ACC_{N+1} = combine(ACC_N, LEDGER_HASH_{N}))` (where `combine()` is an arbitrary deterministic function we use).
     * @type {string}
     * @memberof LtsCommittedTransactionOutcome
     */
    accumulator_hash: string;
    /**
     * 
     * @type {TransactionIdentifiers}
     * @memberof LtsCommittedTransactionOutcome
     */
    user_transaction_identifiers?: TransactionIdentifiers;
    /**
     * 
     * @type {LtsCommittedTransactionStatus}
     * @memberof LtsCommittedTransactionOutcome
     */
    status: LtsCommittedTransactionStatus;
    /**
     * THE FEE ASSIGNMENT IS NOT CURRENTLY FULLY ACCURATE FOR SOME TRANSACTIONS. THIS WILL BE FIXED AT RCNET-V2.
     * A list of all fungible balance updates which occurred in this transaction, aggregated by the global entity (such as account)
     * which owns the vaults which were updated.
     * @type {Array<LtsEntityFungibleBalanceChanges>}
     * @memberof LtsCommittedTransactionOutcome
     */
    fungible_entity_balance_changes: Array<LtsEntityFungibleBalanceChanges>;
    /**
     * THIS CURRENTLY RETURNS AN EMPTY LIST. THIS FEATURE WILL BE COMING AT RCNET-V2.
     * A list of the resultant balances of any account balances changed in this transaction.
     * Only balances for accounts are returned, not any other kind of entity.
     * @type {Array<LtsResultantAccountFungibleBalances>}
     * @memberof LtsCommittedTransactionOutcome
     */
    resultant_account_fungible_balances: Array<LtsResultantAccountFungibleBalances>;
    /**
     * The string-encoded decimal representing the total amount of XRD payed as fee (execution, validator tip and royalties).
     * A decimal is formed of some signed integer `m` of attos (`10^(-18)`) units, where `-2^(256 - 1) <= m < 2^(256 - 1)`.
     * @type {string}
     * @memberof LtsCommittedTransactionOutcome
     */
    total_fee: string;
}

/**
 * Check if a given object implements the LtsCommittedTransactionOutcome interface.
 */
export function instanceOfLtsCommittedTransactionOutcome(value: object): boolean {
    let isInstance = true;
    isInstance = isInstance && "state_version" in value;
    isInstance = isInstance && "accumulator_hash" in value;
    isInstance = isInstance && "status" in value;
    isInstance = isInstance && "fungible_entity_balance_changes" in value;
    isInstance = isInstance && "resultant_account_fungible_balances" in value;
    isInstance = isInstance && "total_fee" in value;

    return isInstance;
}

export function LtsCommittedTransactionOutcomeFromJSON(json: any): LtsCommittedTransactionOutcome {
    return LtsCommittedTransactionOutcomeFromJSONTyped(json, false);
}

export function LtsCommittedTransactionOutcomeFromJSONTyped(json: any, ignoreDiscriminator: boolean): LtsCommittedTransactionOutcome {
    if ((json === undefined) || (json === null)) {
        return json;
    }
    return {
        
        'state_version': json['state_version'],
        'accumulator_hash': json['accumulator_hash'],
        'user_transaction_identifiers': !exists(json, 'user_transaction_identifiers') ? undefined : TransactionIdentifiersFromJSON(json['user_transaction_identifiers']),
        'status': LtsCommittedTransactionStatusFromJSON(json['status']),
        'fungible_entity_balance_changes': ((json['fungible_entity_balance_changes'] as Array<any>).map(LtsEntityFungibleBalanceChangesFromJSON)),
        'resultant_account_fungible_balances': ((json['resultant_account_fungible_balances'] as Array<any>).map(LtsResultantAccountFungibleBalancesFromJSON)),
        'total_fee': json['total_fee'],
    };
}

export function LtsCommittedTransactionOutcomeToJSON(value?: LtsCommittedTransactionOutcome | null): any {
    if (value === undefined) {
        return undefined;
    }
    if (value === null) {
        return null;
    }
    return {
        
        'state_version': value.state_version,
        'accumulator_hash': value.accumulator_hash,
        'user_transaction_identifiers': TransactionIdentifiersToJSON(value.user_transaction_identifiers),
        'status': LtsCommittedTransactionStatusToJSON(value.status),
        'fungible_entity_balance_changes': ((value.fungible_entity_balance_changes as Array<any>).map(LtsEntityFungibleBalanceChangesToJSON)),
        'resultant_account_fungible_balances': ((value.resultant_account_fungible_balances as Array<any>).map(LtsResultantAccountFungibleBalancesToJSON)),
        'total_fee': value.total_fee,
    };
}

