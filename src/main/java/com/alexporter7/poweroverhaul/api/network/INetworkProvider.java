package com.alexporter7.poweroverhaul.api.network;

public interface INetworkProvider {

    NetworkPacket sendNetworkUpdate();
    Network getNetworkGrid();

}
