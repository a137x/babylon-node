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
import type { SystemTransaction } from './SystemTransaction';
import {
    SystemTransactionFromJSON,
    SystemTransactionFromJSONTyped,
    SystemTransactionToJSON,
} from './SystemTransaction';

/**
 * 
 * @export
 * @interface GenesisLedgerTransaction
 */
export interface GenesisLedgerTransaction {
    /**
     * 
     * @type {string}
     * @memberof GenesisLedgerTransaction
     */
    type: GenesisLedgerTransactionTypeEnum;
    /**
     * The hex-encoded full ledger transaction payload. Only returned if enabled in TransactionFormatOptions on your request.
     * @type {string}
     * @memberof GenesisLedgerTransaction
     */
    payload_hex?: string;
    /**
     * The first genesis "transaction" flashes state into the database to prepare for the bootstrap transaction.
     * Such a transaction does not have an associated `system_transaction`
     * @type {boolean}
     * @memberof GenesisLedgerTransaction
     */
    is_flash: boolean;
    /**
     * 
     * @type {SystemTransaction}
     * @memberof GenesisLedgerTransaction
     */
    system_transaction?: SystemTransaction;
}


/**
 * @export
 */
export const GenesisLedgerTransactionTypeEnum = {
    Genesis: 'Genesis'
} as const;
export type GenesisLedgerTransactionTypeEnum = typeof GenesisLedgerTransactionTypeEnum[keyof typeof GenesisLedgerTransactionTypeEnum];


/**
 * Check if a given object implements the GenesisLedgerTransaction interface.
 */
export function instanceOfGenesisLedgerTransaction(value: object): boolean {
    let isInstance = true;
    isInstance = isInstance && "type" in value;
    isInstance = isInstance && "is_flash" in value;

    return isInstance;
}

export function GenesisLedgerTransactionFromJSON(json: any): GenesisLedgerTransaction {
    return GenesisLedgerTransactionFromJSONTyped(json, false);
}

export function GenesisLedgerTransactionFromJSONTyped(json: any, ignoreDiscriminator: boolean): GenesisLedgerTransaction {
    if ((json === undefined) || (json === null)) {
        return json;
    }
    return {
        
        'type': json['type'],
        'payload_hex': !exists(json, 'payload_hex') ? undefined : json['payload_hex'],
        'is_flash': json['is_flash'],
        'system_transaction': !exists(json, 'system_transaction') ? undefined : SystemTransactionFromJSON(json['system_transaction']),
    };
}

export function GenesisLedgerTransactionToJSON(value?: GenesisLedgerTransaction | null): any {
    if (value === undefined) {
        return undefined;
    }
    if (value === null) {
        return null;
    }
    return {
        
        'type': value.type,
        'payload_hex': value.payload_hex,
        'is_flash': value.is_flash,
        'system_transaction': SystemTransactionToJSON(value.system_transaction),
    };
}

