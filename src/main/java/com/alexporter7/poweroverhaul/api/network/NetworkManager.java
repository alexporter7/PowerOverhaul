package com.alexporter7.poweroverhaul.api.network;

import java.util.HashMap;
import java.util.UUID;

public class NetworkManager {

    public static final NetworkManager INSTANCE = new NetworkManager();
    private final HashMap<UUID, Network> NETWORKS = new HashMap<>();

    public NetworkManager() {

    }

    public Network getNetwork(UUID id) {
        return NETWORKS.get(id);
    }

    public void addNetwork(Network network) {
        NETWORKS.put(network.getID(), network);
    }

    //TODO: writeToNBT

    //TODO: readFromNBT

    //TODO: onWorldStop
}
