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
import type { LedgerHeader } from './LedgerHeader';
import {
    LedgerHeaderFromJSON,
    LedgerHeaderFromJSONTyped,
    LedgerHeaderToJSON,
} from './LedgerHeader';
import type { TimestampedValidatorSignature } from './TimestampedValidatorSignature';
import {
    TimestampedValidatorSignatureFromJSON,
    TimestampedValidatorSignatureFromJSONTyped,
    TimestampedValidatorSignatureToJSON,
} from './TimestampedValidatorSignature';

/**
 * 
 * @export
 * @interface LedgerProof
 */
export interface LedgerProof {
    /**
     * A hex-encoded 32-byte vertex VoteData hash on the consensus side, opaque to ledger.
     * @type {string}
     * @memberof LedgerProof
     */
    opaque_hash: string;
    /**
     * 
     * @type {LedgerHeader}
     * @memberof LedgerProof
     */
    ledger_header: LedgerHeader;
    /**
     * 
     * @type {Array<TimestampedValidatorSignature>}
     * @memberof LedgerProof
     */
    timestamped_signatures: Array<TimestampedValidatorSignature>;
}

/**
 * Check if a given object implements the LedgerProof interface.
 */
export function instanceOfLedgerProof(value: object): boolean {
    let isInstance = true;
    isInstance = isInstance && "opaque_hash" in value;
    isInstance = isInstance && "ledger_header" in value;
    isInstance = isInstance && "timestamped_signatures" in value;

    return isInstance;
}

export function LedgerProofFromJSON(json: any): LedgerProof {
    return LedgerProofFromJSONTyped(json, false);
}

export function LedgerProofFromJSONTyped(json: any, ignoreDiscriminator: boolean): LedgerProof {
    if ((json === undefined) || (json === null)) {
        return json;
    }
    return {
        
        'opaque_hash': json['opaque_hash'],
        'ledger_header': LedgerHeaderFromJSON(json['ledger_header']),
        'timestamped_signatures': ((json['timestamped_signatures'] as Array<any>).map(TimestampedValidatorSignatureFromJSON)),
    };
}

export function LedgerProofToJSON(value?: LedgerProof | null): any {
    if (value === undefined) {
        return undefined;
    }
    if (value === null) {
        return null;
    }
    return {
        
        'opaque_hash': value.opaque_hash,
        'ledger_header': LedgerHeaderToJSON(value.ledger_header),
        'timestamped_signatures': ((value.timestamped_signatures as Array<any>).map(TimestampedValidatorSignatureToJSON)),
    };
}

