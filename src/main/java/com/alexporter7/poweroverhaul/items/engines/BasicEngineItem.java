package com.alexporter7.poweroverhaul.items.engines;

import net.minecraft.item.Item;

import com.alexporter7.poweroverhaul.items.components.ComponentMaterial;

public class BasicEngineItem extends Item {

    private ComponentMaterial piston;
    private ComponentMaterial engineBlock;
    private ComponentMaterial engineHead;

    public BasicEngineItem() {
        this.setUnlocalizedName("basic_engine");
        this.setTextureName("");
    }

}
