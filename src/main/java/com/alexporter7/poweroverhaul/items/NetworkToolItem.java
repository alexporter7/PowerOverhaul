package com.alexporter7.poweroverhaul.items;

import com.alexporter7.poweroverhaul.PowerOverhaul;

import java.util.UUID;

public class NetworkToolItem extends PowerOverhaulItem {

    private UUID network;

    public NetworkToolItem() {
        this.maxStackSize = 1;
        this.setTextureName(PowerOverhaul.MODID + ":network_tool");
    }

}
