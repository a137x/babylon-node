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
import type { EncryptedMessageCurveDecryptorSet } from './EncryptedMessageCurveDecryptorSet';
import {
    EncryptedMessageCurveDecryptorSetFromJSON,
    EncryptedMessageCurveDecryptorSetFromJSONTyped,
    EncryptedMessageCurveDecryptorSetToJSON,
} from './EncryptedMessageCurveDecryptorSet';

/**
 * A `PlaintextTransactionMessage` encrypted with "Multi-party ECIES" for a number of decryptors (public keys).
 * @export
 * @interface EncryptedTransactionMessageAllOf
 */
export interface EncryptedTransactionMessageAllOf {
    /**
     * The hex-encoded (128-bit) AES-GCM encrypted bytes of an SBOR-encoded `PlaintextTransactionMessage`.
     * The bytes are serialized as the concatenation `Nonce/IV (12 bytes) || Cipher (variable length) || Tag/MAC (16 bytes)`:
     * @type {string}
     * @memberof EncryptedTransactionMessageAllOf
     */
    encrypted_hex: string;
    /**
     * 
     * @type {Array<EncryptedMessageCurveDecryptorSet>}
     * @memberof EncryptedTransactionMessageAllOf
     */
    curve_decryptor_sets: Array<EncryptedMessageCurveDecryptorSet>;
    /**
     * 
     * @type {string}
     * @memberof EncryptedTransactionMessageAllOf
     */
    type?: EncryptedTransactionMessageAllOfTypeEnum;
}


/**
 * @export
 */
export const EncryptedTransactionMessageAllOfTypeEnum = {
    Encrypted: 'Encrypted'
} as const;
export type EncryptedTransactionMessageAllOfTypeEnum = typeof EncryptedTransactionMessageAllOfTypeEnum[keyof typeof EncryptedTransactionMessageAllOfTypeEnum];


/**
 * Check if a given object implements the EncryptedTransactionMessageAllOf interface.
 */
export function instanceOfEncryptedTransactionMessageAllOf(value: object): boolean {
    let isInstance = true;
    isInstance = isInstance && "encrypted_hex" in value;
    isInstance = isInstance && "curve_decryptor_sets" in value;

    return isInstance;
}

export function EncryptedTransactionMessageAllOfFromJSON(json: any): EncryptedTransactionMessageAllOf {
    return EncryptedTransactionMessageAllOfFromJSONTyped(json, false);
}

export function EncryptedTransactionMessageAllOfFromJSONTyped(json: any, ignoreDiscriminator: boolean): EncryptedTransactionMessageAllOf {
    if ((json === undefined) || (json === null)) {
        return json;
    }
    return {
        
        'encrypted_hex': json['encrypted_hex'],
        'curve_decryptor_sets': ((json['curve_decryptor_sets'] as Array<any>).map(EncryptedMessageCurveDecryptorSetFromJSON)),
        'type': !exists(json, 'type') ? undefined : json['type'],
    };
}

export function EncryptedTransactionMessageAllOfToJSON(value?: EncryptedTransactionMessageAllOf | null): any {
    if (value === undefined) {
        return undefined;
    }
    if (value === null) {
        return null;
    }
    return {
        
        'encrypted_hex': value.encrypted_hex,
        'curve_decryptor_sets': ((value.curve_decryptor_sets as Array<any>).map(EncryptedMessageCurveDecryptorSetToJSON)),
        'type': value.type,
    };
}

