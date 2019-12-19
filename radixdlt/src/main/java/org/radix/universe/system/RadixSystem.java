package org.radix.universe.system;

import java.util.Map;
import java.util.stream.Stream;

import com.radixdlt.common.EUID;
import org.radix.containers.BasicContainer;
import com.radixdlt.crypto.ECPublicKey;
import com.radixdlt.crypto.CryptoException;
import org.radix.modules.Modules;
import org.radix.network2.transport.TransportInfo;

import com.radixdlt.serialization.DsonOutput;
import com.radixdlt.serialization.DsonOutput.Output;
import com.radixdlt.serialization.SerializationException;
import com.radixdlt.serialization.SerializerId2;
import org.radix.shards.ShardSpace;
import com.radixdlt.universe.Universe;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableList;

import static com.radixdlt.serialization.MapHelper.mapOf;

@SerializerId2("api.system")
public class RadixSystem extends BasicContainer
{
	@Override
	public short VERSION() { return 100; }

	private int  			agentVersion;
	private int  			protocolVersion;

	@JsonProperty("planck")
	@DsonOutput(Output.ALL)
	private int				planck;

	private String 			agent;

	@JsonProperty("timestamp")
	@DsonOutput(Output.ALL)
	private long			timestamp;

	@JsonProperty("transports")
	@DsonOutput(Output.ALL)
	private ImmutableList<TransportInfo> transports;

	private ECPublicKey		key;

	public RadixSystem()
	{
		super();

		this.agent = "unknown";
		this.agentVersion = 0;
		this.planck = 0;
		this.protocolVersion = 0;
		this.timestamp = 0;
		this.transports = ImmutableList.of();
		this.key = null;
	}

	public RadixSystem(RadixSystem system)
	{
		super();

 		this.agent = system.getAgent();
 		this.agentVersion = system.getAgentVersion();
		this.planck = system.getPlanck();
		this.protocolVersion = system.getProtocolVersion();
		this.timestamp = system.getTimestamp();
		this.transports = system.transports;
		this.key = system.getKey();
	}

	public RadixSystem(ECPublicKey key, String agent, int agentVersion, int protocolVersion, ImmutableList<TransportInfo> transports)
	{
		this();

		this.key = key;
		this.agent = agent;
		this.agentVersion = agentVersion;
		this.protocolVersion = protocolVersion;
		this.transports = transports;
	}

	public String getAgent()
	{
		return this.agent;
	}

	public int getAgentVersion()
	{
		return this.agentVersion;
	}

	public int getProtocolVersion()
	{
		return this.protocolVersion;
	}

	public int getPlanck()
	{
		return this.planck;
	}

	void setPlanck(int planck)
	{
		this.planck = planck;
	}

	public long getTimestamp()
	{
		return this.timestamp;
	}

	public void setTimestamp(long timestamp)
	{
		this.timestamp = timestamp;
	}

	public Stream<TransportInfo> supportedTransports() {
		return transports.stream();
	}

	public ECPublicKey getKey()
	{
		return key;
	}

	void setKey(ECPublicKey key)
	{
		this.key = key;
	}

	public EUID getNID()
	{
		return this.key == null ? EUID.ZERO : this.key.getUID();
	}

	// Property "agent" - 1 getter, 1 setter
	// FIXME: Should be included in a serializable class
	@JsonProperty("agent")
	@DsonOutput(Output.ALL)
	Map<String, Object> getJsonAgent() {
		return mapOf(
				"name", this.agent,
				"version", this.agentVersion,
				"protocol", this.protocolVersion);
	}

	@JsonProperty("agent")
	void setJsonAgent(Map<String, Object> props) {
		this.agent = (String) props.get("name");
		this.agentVersion = ((Number) props.get("version")).intValue();
		this.protocolVersion = ((Number) props.get("protocol")).intValue();
	}

	// Property "key" - 1 getter, 1 setter
	// FIXME: Should serialize ECKeyPair directly
	@JsonProperty("key")
	@DsonOutput(Output.ALL)
	byte[] getJsonKey() {
		return (key == null) ? null : key.getBytes();
	}

	@JsonProperty("key")
	void setJsonKey(byte[] newKey) throws SerializationException {
		try {
			key = new ECPublicKey(newKey);
		} catch (CryptoException cex) {
			throw new SerializationException("Invalid key", cex);
		}
	}

	// Property "nid" - 1 getter
	@JsonProperty("nid")
	@DsonOutput(Output.ALL)
	EUID getJsonNid() {
		return this.key == null ? null : this.key.getUID();
	}
}
