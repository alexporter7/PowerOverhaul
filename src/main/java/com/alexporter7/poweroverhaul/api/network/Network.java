package com.alexporter7.poweroverhaul.api.network;

import java.util.UUID;

public class Network {

    private final UUID ID;

    public Network(UUID networkKey) {
        ID = networkKey;
    }

    public UUID getID() {
        return ID;
    }
}
