#!/bin/sh

set -e

SCRIPT_DIR="$( cd -- "$( dirname -- "${BASH_SOURCE[0]}" )" &> /dev/null && pwd )"
cd "$SCRIPT_DIR"

source ./node-variables.sh

docker run --rm -v $SCRIPT_DIR/node/:/keygen/key radixdlt/keygen:1.0.0 --keystore=/keygen/key/keystore.ks --password="$RADIXDLT_NODE_KEY_PASSWORD" --keypair-name=node