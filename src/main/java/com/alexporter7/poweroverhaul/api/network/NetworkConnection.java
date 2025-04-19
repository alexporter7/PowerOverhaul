package com.alexporter7.poweroverhaul.api.network;

import java.util.function.Supplier;

public class NetworkConnection<T> {

    private final T CONNECTION;
    private final Supplier<NetworkPacket> packetSupplier;

    public NetworkConnection(T connection, Supplier<NetworkPacket> packetSupplier) {
        this.CONNECTION = connection;
        this.packetSupplier = packetSupplier;
    }

    public T getConnection() {
        return CONNECTION;
    }

    public NetworkPacket getNetworkPacket() {
        return packetSupplier.get();
    }
}
