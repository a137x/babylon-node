/*
 * (C) Copyright 2020 Radix DLT Ltd
 *
 * Radix DLT Ltd licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except in
 * compliance with the License.  You may obtain a copy of the
 * License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied.  See the License for the specific
 * language governing permissions and limitations under the License.
 */

package com.radixdlt.middleware2.store;

import com.google.inject.Inject;
import com.radixdlt.identifiers.AID;
import com.radixdlt.atommodel.Atom;
import com.radixdlt.identifiers.EUID;
import com.radixdlt.constraintmachine.Particle;
import com.radixdlt.constraintmachine.Spin;
import com.radixdlt.middleware.RadixEngineUtils;
import com.radixdlt.middleware.RadixEngineUtils.CMAtomConversionException;
import com.radixdlt.middleware.SimpleRadixEngineAtom;
import com.radixdlt.serialization.Serialization;
import com.radixdlt.store.SearchCursor;
import com.radixdlt.store.StoreIndex;
import com.radixdlt.store.LedgerSearchMode;
import com.radixdlt.middleware2.converters.AtomToBinaryConverter;
import com.radixdlt.store.EngineStore;
import com.radixdlt.store.LedgerEntry;
import com.radixdlt.store.LedgerEntryStore;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;

public class LedgerEngineStore implements EngineStore<SimpleRadixEngineAtom> {
    private static final Logger log = LogManager.getLogger("middleware2.store");

    private final Serialization serialization;
    private final LedgerEntryStore store;
    private AtomToBinaryConverter atomToBinaryConverter;

    @Inject
    public LedgerEngineStore(LedgerEntryStore store,
                             AtomToBinaryConverter atomToBinaryConverter,
                             Serialization serialization) {
        this.serialization = serialization;
        this.store = store;
        this.atomToBinaryConverter = atomToBinaryConverter;
    }

    @Override
    public void getAtomContaining(Particle particle, boolean isInput, Consumer<SimpleRadixEngineAtom> callback) {
        Optional<Atom> atomOptional = getAtomByParticle(particle, isInput);
        if (atomOptional.isPresent()) {
            try {
                SimpleRadixEngineAtom reAtom = RadixEngineUtils.toCMAtom(atomOptional.get());
                callback.accept(reAtom);
            } catch (CMAtomConversionException e) {
                throw new IllegalStateException("Could not construct atom", e);
            }
        }
    }

    private Optional<Atom> getAtomByParticle(Particle particle, boolean isInput) {
        final byte[] indexableBytes = EngineAtomIndices.toByteArray(
        	isInput ? EngineAtomIndices.IndexType.PARTICLE_DOWN : EngineAtomIndices.IndexType.PARTICLE_UP,
        	particle.euid()
        );
        SearchCursor cursor = store.search(StoreIndex.LedgerIndexType.UNIQUE, new StoreIndex(indexableBytes), LedgerSearchMode.EXACT);
        if (cursor != null) {
            return store.get(cursor.get()).flatMap(ledgerEntry ->  Optional.of(atomToBinaryConverter.toAtom(ledgerEntry.getContent())));
        } else {
            log.debug("getAtomByParticle returned empty result");
            return Optional.empty();
        }
    }

    @Override
    public void storeAtom(SimpleRadixEngineAtom reAtom) {
        byte[] binaryAtom = atomToBinaryConverter.toLedgerEntryContent(reAtom.getAtom());
        LedgerEntry ledgerEntry = new LedgerEntry(binaryAtom, reAtom.getAID());
        EngineAtomIndices engineAtomIndices = EngineAtomIndices.from(reAtom, serialization);
        store.store(ledgerEntry, engineAtomIndices.getUniqueIndices(), engineAtomIndices.getDuplicateIndices());
    }

    @Override
    public void deleteAtom(AID atomId) {
        throw new UnsupportedOperationException("Delete operation is not supported by Ledger interface");
    }

    @Override
    public boolean supports(Set<EUID> destinations) {
        // TODO Sharding support is removed for now, meaning that every node supports all destinations.
        return true;
    }

    @Override
    public Spin getSpin(Particle particle) {
        if (getAtomByParticle(particle, true).isPresent()) {
            return Spin.DOWN;
        } else if (getAtomByParticle(particle, false).isPresent()) {
            return Spin.UP;
        }
        return Spin.NEUTRAL;
    }
}
