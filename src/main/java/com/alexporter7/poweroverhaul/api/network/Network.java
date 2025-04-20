package com.alexporter7.poweroverhaul.api.network;

import java.util.HashSet;
import java.util.UUID;

import net.minecraft.tileentity.TileEntity;

public class Network {

    private final UUID ID;
    private String networkName;
    private Enum<?> networkType;
    private final HashSet<TileEntity> CONNECTIONS = new HashSet<>();

    public Network(UUID networkKey) {
        ID = networkKey;
    }

    public UUID getID() {
        return ID;
    }

    public String getNetworkName() {
        return networkName;
    }

    public Enum<?> getNetworkType() {
        return networkType;
    }

    public HashSet<TileEntity> getCONNECTIONS() {
        return CONNECTIONS;
    }
}
