/* tslint:disable */
/* eslint-disable */
/**
 * Radix Core API - Babylon
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node.  The default configuration is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Very heavy load may impact the node\'s function. The node exposes a configuration flag which allows disabling certain endpoints which may be problematic, but monitoring is advised. This configuration parameter is `api.core.flags.enable_unbounded_endpoints` / `RADIXDLT_CORE_API_FLAGS_ENABLE_UNBOUNDED_ENDPOINTS`.  This API exposes queries against the node\'s current state (see `/lts/state/` or `/state/`), and streams of transaction history (under `/lts/stream/` or `/stream`).  If you require queries against snapshots of historical ledger state, you may also wish to consider using the [Gateway API](https://docs-babylon.radixdlt.com/).  ## Integration and forward compatibility guarantees  Integrators (such as exchanges) are recommended to use the `/lts/` endpoints - they have been designed to be clear and simple for integrators wishing to create and monitor transactions involving fungible transfers to/from accounts.  All endpoints under `/lts/` have high guarantees of forward compatibility in future node versions. We may add new fields, but existing fields will not be changed. Assuming the integrating code uses a permissive JSON parser which ignores unknown fields, any additions will not affect existing code.  Other endpoints may be changed with new node versions carrying protocol-updates, although any breaking changes will be flagged clearly in the corresponding release notes.  All responses may have additional fields added, so clients are advised to use JSON parsers which ignore unknown fields on JSON objects. 
 *
 * The version of the OpenAPI document: v1.0.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


import * as runtime from '../runtime';
import type {
  BasicErrorResponse,
  TransactionCallPreviewRequest,
  TransactionCallPreviewResponse,
  TransactionParseRequest,
  TransactionParseResponse,
  TransactionPreviewRequest,
  TransactionPreviewResponse,
  TransactionReceiptRequest,
  TransactionReceiptResponse,
  TransactionStatusRequest,
  TransactionStatusResponse,
  TransactionSubmitErrorResponse,
  TransactionSubmitRequest,
  TransactionSubmitResponse,
} from '../models';
import {
    BasicErrorResponseFromJSON,
    BasicErrorResponseToJSON,
    TransactionCallPreviewRequestFromJSON,
    TransactionCallPreviewRequestToJSON,
    TransactionCallPreviewResponseFromJSON,
    TransactionCallPreviewResponseToJSON,
    TransactionParseRequestFromJSON,
    TransactionParseRequestToJSON,
    TransactionParseResponseFromJSON,
    TransactionParseResponseToJSON,
    TransactionPreviewRequestFromJSON,
    TransactionPreviewRequestToJSON,
    TransactionPreviewResponseFromJSON,
    TransactionPreviewResponseToJSON,
    TransactionReceiptRequestFromJSON,
    TransactionReceiptRequestToJSON,
    TransactionReceiptResponseFromJSON,
    TransactionReceiptResponseToJSON,
    TransactionStatusRequestFromJSON,
    TransactionStatusRequestToJSON,
    TransactionStatusResponseFromJSON,
    TransactionStatusResponseToJSON,
    TransactionSubmitErrorResponseFromJSON,
    TransactionSubmitErrorResponseToJSON,
    TransactionSubmitRequestFromJSON,
    TransactionSubmitRequestToJSON,
    TransactionSubmitResponseFromJSON,
    TransactionSubmitResponseToJSON,
} from '../models';

export interface TransactionCallPreviewPostRequest {
    transactionCallPreviewRequest: TransactionCallPreviewRequest;
}

export interface TransactionParsePostRequest {
    transactionParseRequest: TransactionParseRequest;
}

export interface TransactionPreviewPostRequest {
    transactionPreviewRequest: TransactionPreviewRequest;
}

export interface TransactionReceiptPostRequest {
    transactionReceiptRequest: TransactionReceiptRequest;
}

export interface TransactionStatusPostRequest {
    transactionStatusRequest: TransactionStatusRequest;
}

export interface TransactionSubmitPostRequest {
    transactionSubmitRequest: TransactionSubmitRequest;
}

/**
 * 
 */
export class TransactionApi extends runtime.BaseAPI {

    /**
     * Preview a scrypto function or method call against the latest network state. Returns the result of the scrypto function or method call. 
     * Scrypto Call Preview
     */
    async transactionCallPreviewPostRaw(requestParameters: TransactionCallPreviewPostRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<runtime.ApiResponse<TransactionCallPreviewResponse>> {
        if (requestParameters.transactionCallPreviewRequest === null || requestParameters.transactionCallPreviewRequest === undefined) {
            throw new runtime.RequiredError('transactionCallPreviewRequest','Required parameter requestParameters.transactionCallPreviewRequest was null or undefined when calling transactionCallPreviewPost.');
        }

        const queryParameters: any = {};

        const headerParameters: runtime.HTTPHeaders = {};

        headerParameters['Content-Type'] = 'application/json';

        const response = await this.request({
            path: `/transaction/call-preview`,
            method: 'POST',
            headers: headerParameters,
            query: queryParameters,
            body: TransactionCallPreviewRequestToJSON(requestParameters.transactionCallPreviewRequest),
        }, initOverrides);

        return new runtime.JSONApiResponse(response, (jsonValue) => TransactionCallPreviewResponseFromJSON(jsonValue));
    }

    /**
     * Preview a scrypto function or method call against the latest network state. Returns the result of the scrypto function or method call. 
     * Scrypto Call Preview
     */
    async transactionCallPreviewPost(requestParameters: TransactionCallPreviewPostRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<TransactionCallPreviewResponse> {
        const response = await this.transactionCallPreviewPostRaw(requestParameters, initOverrides);
        return await response.value();
    }

    /**
     * Extracts the contents and hashes of various types of transaction payloads, or sub-payloads.
     * Parse Transaction Payload
     */
    async transactionParsePostRaw(requestParameters: TransactionParsePostRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<runtime.ApiResponse<TransactionParseResponse>> {
        if (requestParameters.transactionParseRequest === null || requestParameters.transactionParseRequest === undefined) {
            throw new runtime.RequiredError('transactionParseRequest','Required parameter requestParameters.transactionParseRequest was null or undefined when calling transactionParsePost.');
        }

        const queryParameters: any = {};

        const headerParameters: runtime.HTTPHeaders = {};

        headerParameters['Content-Type'] = 'application/json';

        const response = await this.request({
            path: `/transaction/parse`,
            method: 'POST',
            headers: headerParameters,
            query: queryParameters,
            body: TransactionParseRequestToJSON(requestParameters.transactionParseRequest),
        }, initOverrides);

        return new runtime.JSONApiResponse(response, (jsonValue) => TransactionParseResponseFromJSON(jsonValue));
    }

    /**
     * Extracts the contents and hashes of various types of transaction payloads, or sub-payloads.
     * Parse Transaction Payload
     */
    async transactionParsePost(requestParameters: TransactionParsePostRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<TransactionParseResponse> {
        const response = await this.transactionParsePostRaw(requestParameters, initOverrides);
        return await response.value();
    }

    /**
     * Preview a transaction against the latest network state, and returns the preview receipt. 
     * Transaction Preview
     */
    async transactionPreviewPostRaw(requestParameters: TransactionPreviewPostRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<runtime.ApiResponse<TransactionPreviewResponse>> {
        if (requestParameters.transactionPreviewRequest === null || requestParameters.transactionPreviewRequest === undefined) {
            throw new runtime.RequiredError('transactionPreviewRequest','Required parameter requestParameters.transactionPreviewRequest was null or undefined when calling transactionPreviewPost.');
        }

        const queryParameters: any = {};

        const headerParameters: runtime.HTTPHeaders = {};

        headerParameters['Content-Type'] = 'application/json';

        const response = await this.request({
            path: `/transaction/preview`,
            method: 'POST',
            headers: headerParameters,
            query: queryParameters,
            body: TransactionPreviewRequestToJSON(requestParameters.transactionPreviewRequest),
        }, initOverrides);

        return new runtime.JSONApiResponse(response, (jsonValue) => TransactionPreviewResponseFromJSON(jsonValue));
    }

    /**
     * Preview a transaction against the latest network state, and returns the preview receipt. 
     * Transaction Preview
     */
    async transactionPreviewPost(requestParameters: TransactionPreviewPostRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<TransactionPreviewResponse> {
        const response = await this.transactionPreviewPostRaw(requestParameters, initOverrides);
        return await response.value();
    }

    /**
     * Gets the transaction receipt for a committed transaction. 
     * Get Transaction Receipt
     */
    async transactionReceiptPostRaw(requestParameters: TransactionReceiptPostRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<runtime.ApiResponse<TransactionReceiptResponse>> {
        if (requestParameters.transactionReceiptRequest === null || requestParameters.transactionReceiptRequest === undefined) {
            throw new runtime.RequiredError('transactionReceiptRequest','Required parameter requestParameters.transactionReceiptRequest was null or undefined when calling transactionReceiptPost.');
        }

        const queryParameters: any = {};

        const headerParameters: runtime.HTTPHeaders = {};

        headerParameters['Content-Type'] = 'application/json';

        const response = await this.request({
            path: `/transaction/receipt`,
            method: 'POST',
            headers: headerParameters,
            query: queryParameters,
            body: TransactionReceiptRequestToJSON(requestParameters.transactionReceiptRequest),
        }, initOverrides);

        return new runtime.JSONApiResponse(response, (jsonValue) => TransactionReceiptResponseFromJSON(jsonValue));
    }

    /**
     * Gets the transaction receipt for a committed transaction. 
     * Get Transaction Receipt
     */
    async transactionReceiptPost(requestParameters: TransactionReceiptPostRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<TransactionReceiptResponse> {
        const response = await this.transactionReceiptPostRaw(requestParameters, initOverrides);
        return await response.value();
    }

    /**
     * Shares the node\'s knowledge of any payloads associated with the given intent hash. Generally there will be a single payload for a given intent, but it\'s theoretically possible there may be multiple. This knowledge is summarised into a status for the intent. This summarised status in the response is likely sufficient for most clients. 
     * Get Transaction Status
     */
    async transactionStatusPostRaw(requestParameters: TransactionStatusPostRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<runtime.ApiResponse<TransactionStatusResponse>> {
        if (requestParameters.transactionStatusRequest === null || requestParameters.transactionStatusRequest === undefined) {
            throw new runtime.RequiredError('transactionStatusRequest','Required parameter requestParameters.transactionStatusRequest was null or undefined when calling transactionStatusPost.');
        }

        const queryParameters: any = {};

        const headerParameters: runtime.HTTPHeaders = {};

        headerParameters['Content-Type'] = 'application/json';

        const response = await this.request({
            path: `/transaction/status`,
            method: 'POST',
            headers: headerParameters,
            query: queryParameters,
            body: TransactionStatusRequestToJSON(requestParameters.transactionStatusRequest),
        }, initOverrides);

        return new runtime.JSONApiResponse(response, (jsonValue) => TransactionStatusResponseFromJSON(jsonValue));
    }

    /**
     * Shares the node\'s knowledge of any payloads associated with the given intent hash. Generally there will be a single payload for a given intent, but it\'s theoretically possible there may be multiple. This knowledge is summarised into a status for the intent. This summarised status in the response is likely sufficient for most clients. 
     * Get Transaction Status
     */
    async transactionStatusPost(requestParameters: TransactionStatusPostRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<TransactionStatusResponse> {
        const response = await this.transactionStatusPostRaw(requestParameters, initOverrides);
        return await response.value();
    }

    /**
     * Submits a notarized transaction to the network. Returns whether the transaction submission was already included in the node\'s mempool. 
     * Transaction Submit
     */
    async transactionSubmitPostRaw(requestParameters: TransactionSubmitPostRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<runtime.ApiResponse<TransactionSubmitResponse>> {
        if (requestParameters.transactionSubmitRequest === null || requestParameters.transactionSubmitRequest === undefined) {
            throw new runtime.RequiredError('transactionSubmitRequest','Required parameter requestParameters.transactionSubmitRequest was null or undefined when calling transactionSubmitPost.');
        }

        const queryParameters: any = {};

        const headerParameters: runtime.HTTPHeaders = {};

        headerParameters['Content-Type'] = 'application/json';

        const response = await this.request({
            path: `/transaction/submit`,
            method: 'POST',
            headers: headerParameters,
            query: queryParameters,
            body: TransactionSubmitRequestToJSON(requestParameters.transactionSubmitRequest),
        }, initOverrides);

        return new runtime.JSONApiResponse(response, (jsonValue) => TransactionSubmitResponseFromJSON(jsonValue));
    }

    /**
     * Submits a notarized transaction to the network. Returns whether the transaction submission was already included in the node\'s mempool. 
     * Transaction Submit
     */
    async transactionSubmitPost(requestParameters: TransactionSubmitPostRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<TransactionSubmitResponse> {
        const response = await this.transactionSubmitPostRaw(requestParameters, initOverrides);
        return await response.value();
    }

}
