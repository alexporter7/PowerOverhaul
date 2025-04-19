package com.alexporter7.poweroverhaul.api.network;

import java.util.HashMap;

public class NetworkPacket {

    private final HashMap<Enum<?>, String> PACKET_DATA = new HashMap<>();

    public NetworkPacket() {

    }

    public String getPacketFromKey(Enum<?> key) {
        return PACKET_DATA.get(key);
    }

    public NetworkPacket addPacketData(Enum<?> key, String value) {
        PACKET_DATA.put(key, value);
        return this;
    }

}
