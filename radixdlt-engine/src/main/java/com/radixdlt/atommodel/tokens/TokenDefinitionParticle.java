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

package com.radixdlt.atommodel.tokens;

import com.radixdlt.atomos.RriId;
import com.radixdlt.constraintmachine.Particle;
import com.radixdlt.identifiers.RRI;
import com.radixdlt.utils.UInt256;

import java.util.Objects;
import java.util.Optional;

/**
 * Particle representing a fixed supply token definition
 */
public final class TokenDefinitionParticle implements Particle {
	private final RRI rri;
	private final UInt256 supply;
	private final String name;
	private final String description;
	private final String iconUrl;
	private final String url;

	public TokenDefinitionParticle(
		RRI rri,
		String name,
		String description,
		String iconUrl,
		String url,
		UInt256 supply
	) {
		this.rri = Objects.requireNonNull(rri);
		this.name = Objects.requireNonNull(name);
		this.description = Objects.requireNonNull(description);
		this.supply = supply;
		this.iconUrl = Objects.requireNonNull(iconUrl);
		this.url = Objects.requireNonNull(url);
	}

	public boolean isMutable() {
		return this.supply == null;
	}

	public RRI getRri() {
		return rri;
	}

	public RriId getRriId() {
		return RriId.fromRri(rri);
	}

	public String getName() {
		return this.name;
	}

	public String getDescription() {
		return this.description;
	}

	public Optional<UInt256> getSupply() {
		return Optional.ofNullable(this.supply);
	}

	public String getIconUrl() {
		return this.iconUrl;
	}

	public String getUrl() {
		return url;
	}

	@Override
	public String toString() {
		return String.format("%s[(%s:%s:%s), (%s)]", getClass().getSimpleName(),
			this.rri, name, supply, description);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof TokenDefinitionParticle)) {
			return false;
		}
		TokenDefinitionParticle that = (TokenDefinitionParticle) o;
		return Objects.equals(rri, that.rri)
				&& Objects.equals(name, that.name)
				&& Objects.equals(description, that.description)
				&& Objects.equals(supply, that.supply)
				&& Objects.equals(iconUrl, that.iconUrl)
				&& Objects.equals(url, that.url);
	}

	@Override
	public int hashCode() {
		return Objects.hash(rri, name, description, supply, iconUrl, url);
	}
}
