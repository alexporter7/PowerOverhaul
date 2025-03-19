package com.alexporter7.poweroverhaul.items.components;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class EngineComponentItem extends Item {

    public enum ComponentType {
        PISTON,
        BLOCK,
        HEAD
    }

    private final ComponentMaterial componentMaterial;
    private final ComponentType componentType;

    public EngineComponentItem(ComponentType componentType, ComponentMaterial componentMaterial,
        String unlocalizedName) {
        this.setUnlocalizedName(unlocalizedName + "_" + componentMaterial.getUnlocalizedMaterialName());
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

    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer entityPlayer, List<String> tooltip,
        boolean p_77624_4_) {
        super.addInformation(itemStack, entityPlayer, tooltip, p_77624_4_);
        tooltip.add("Material: " + this.componentMaterial.getMaterialName());
        tooltip.add("Durability Factor: " + this.componentMaterial.getDurabilityFactor());
    }
}
