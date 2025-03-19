package com.alexporter7.poweroverhaul.items.components;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.alexporter7.poweroverhaul.PowerOverhaul;

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
        this.setTextureName(this.getDefaultTexture(componentType));
        this.componentType = componentType;
        this.componentMaterial = componentMaterial;
    }

    public ComponentType getComponentType() {
        return componentType;
    }

    public ComponentMaterial getComponentMaterial() {
        return componentMaterial;
    }

    public String getDefaultTexture(ComponentType componentType) {
        return switch (componentType) {
            case PISTON -> PowerOverhaul.MODID + ":piston_default";
            case BLOCK -> PowerOverhaul.MODID + ":engine_block_default";
            case HEAD -> PowerOverhaul.MODID + ":engine_head_default";
        };
    }

    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer entityPlayer, List<String> tooltip,
        boolean p_77624_4_) {
        super.addInformation(itemStack, entityPlayer, tooltip, p_77624_4_);
        tooltip.add("Material: " + this.componentMaterial.getMaterialName());
        tooltip.add("Durability Factor: " + this.componentMaterial.getDurabilityFactor());
    }
}
