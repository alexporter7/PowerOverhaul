package com.alexporter7.poweroverhaul.items.components;

import net.minecraft.item.Item;

public class EngineComponentItem extends Item {

    public enum ComponentType {
        PISTON,
        BLOCK,
        HEAD
    }

    private ComponentMaterial componentMaterial;
    private ComponentType componentType;

    public EngineComponentItem() {
        this.setUnlocalizedName("basic_engine");
        this.setTextureName("");
    }

    public EngineComponentItem(ComponentType componentType, ComponentMaterial componentMaterial) {
        this.setUnlocalizedName("basic_engine");
        this.setTextureName("");
        this.componentType = componentType;
        this.componentMaterial = componentMaterial;
    }

    public ComponentType getComponentType() {
        return componentType;
    }

    public ComponentMaterial getComponentMaterial() {
        return componentMaterial;
    }
}
