package com.alexporter7.poweroverhaul.items.engines;

import net.minecraft.item.Item;

public class BasicEngineItem extends Item {

    private EngineProperties engineProperties;

    public BasicEngineItem(EngineProperties engineProperties) {
        this.setUnlocalizedName("basic_engine");
        this.setTextureName("");
        this.engineProperties = engineProperties;
    }

}
