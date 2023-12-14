package com.radixdlt.statecomputer;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.radixdlt.lang.Option;
import com.radixdlt.lang.Tuple;
import com.radixdlt.protocol.ProtocolConfig;
import com.radixdlt.protocol.ProtocolUpdate;
import com.radixdlt.protocol.ProtocolUpdateEnactmentCondition;
import com.radixdlt.protocol.ProtocolUpdateSupportType;
import com.radixdlt.sbor.codec.CodecMap;
import com.radixdlt.sbor.codec.EnumCodec;
import com.radixdlt.sbor.codec.StructCodec;
import com.radixdlt.utils.UInt64;

public record ProtocolState(
    Option<UInt64> currentEpoch,
    String currentProtocolVersion,
    ImmutableMap<UInt64, String> enactedProtocolUpdates,
    ImmutableList<UnenactedProtocolUpdate> unenactedProtocolUpdates) {

    public static void registerCodec(CodecMap codecMap) {
        codecMap.register(
            ProtocolState.class,
            codecs -> StructCodec.fromRecordComponents(ProtocolState.class, codecs));

        codecMap.register(
            UnenactedProtocolUpdate.class,
            codecs -> StructCodec.fromRecordComponents(UnenactedProtocolUpdate.class, codecs));

        codecMap.register(
            UnenactedProtocolUpdateState.class,
            codecs ->
                EnumCodec.fromPermittedRecordSubclasses(
                    UnenactedProtocolUpdateState.class, codecs));

        codecMap.register(
            UnenactedProtocolUpdateState.SignalledReadinessThresholdState.class,
            codecs -> StructCodec.fromRecordComponents(UnenactedProtocolUpdateState.SignalledReadinessThresholdState.class, codecs));
    }

    public record UnenactedProtocolUpdate(
        ProtocolUpdate protocolUpdate,
        UnenactedProtocolUpdateState state
    ) {}

    public sealed interface UnenactedProtocolUpdateState {
        record ForSignalledReadinessSupportCondition(
            ImmutableList<Tuple.Tuple2<
                    ProtocolUpdateSupportType.SignalledReadiness.SignalledReadinessThreshold,
                    SignalledReadinessThresholdState
            >> thresholdsState
        ) implements UnenactedProtocolUpdateState {}

        record Empty() implements UnenactedProtocolUpdateState {}

        record SignalledReadinessThresholdState(UInt64 consecutiveStartedEpochsOfSupport) {}
    }
}
