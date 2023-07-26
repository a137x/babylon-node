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
import type { NotarizedTransaction } from './NotarizedTransaction';
import {
    NotarizedTransactionFromJSON,
    NotarizedTransactionFromJSONTyped,
    NotarizedTransactionToJSON,
} from './NotarizedTransaction';

/**
 * 
 * @export
 * @interface UserLedgerTransaction
 */
export interface UserLedgerTransaction {
    /**
     * 
     * @type {string}
     * @memberof UserLedgerTransaction
     */
    type: UserLedgerTransactionTypeEnum;
    /**
     * The hex-encoded full ledger transaction payload. Only returned if enabled in TransactionFormatOptions on your request.
     * @type {string}
     * @memberof UserLedgerTransaction
     */
    payload_hex?: string;
    /**
     * 
     * @type {NotarizedTransaction}
     * @memberof UserLedgerTransaction
     */
    notarized_transaction: NotarizedTransaction;
}


/**
 * @export
 */
export const UserLedgerTransactionTypeEnum = {
    User: 'User'
} as const;
export type UserLedgerTransactionTypeEnum = typeof UserLedgerTransactionTypeEnum[keyof typeof UserLedgerTransactionTypeEnum];


/**
 * Check if a given object implements the UserLedgerTransaction interface.
 */
export function instanceOfUserLedgerTransaction(value: object): boolean {
    let isInstance = true;
    isInstance = isInstance && "type" in value;
    isInstance = isInstance && "notarized_transaction" in value;

    return isInstance;
}

export function UserLedgerTransactionFromJSON(json: any): UserLedgerTransaction {
    return UserLedgerTransactionFromJSONTyped(json, false);
}

export function UserLedgerTransactionFromJSONTyped(json: any, ignoreDiscriminator: boolean): UserLedgerTransaction {
    if ((json === undefined) || (json === null)) {
        return json;
    }
    return {
        
        'type': json['type'],
        'payload_hex': !exists(json, 'payload_hex') ? undefined : json['payload_hex'],
        'notarized_transaction': NotarizedTransactionFromJSON(json['notarized_transaction']),
    };
}

export function UserLedgerTransactionToJSON(value?: UserLedgerTransaction | null): any {
    if (value === undefined) {
        return undefined;
    }
    if (value === null) {
        return null;
    }
    return {
        
        'type': value.type,
        'payload_hex': value.payload_hex,
        'notarized_transaction': NotarizedTransactionToJSON(value.notarized_transaction),
    };
}

