package com.alexporter7.poweroverhaul.api.network;

public interface INetworkProvider {

    /**
     * Called from Network when an update is needed
     * 
     * @return NetworkPacket
     */
    NetworkPacket getNetworkPacket();
}
