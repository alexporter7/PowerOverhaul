package com.alexporter7.poweroverhaul.items.components;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

import com.alexporter7.poweroverhaul.PowerOverhaul;
import com.alexporter7.poweroverhaul.api.material.PowerOverhaulMaterial;
import com.alexporter7.poweroverhaul.items.MaterialItem;

public class EngineComponentItem extends MaterialItem {

    public enum ComponentType {
        PISTON,
        BLOCK,
        HEAD
    }

    private final ComponentType componentType;

    public EngineComponentItem(ComponentType componentType, PowerOverhaulMaterial material) {
        super(material);
        this.setUnlocalizedName(
            material.getName() + "_engine_"
                + componentType.toString()
                    .toLowerCase());
        this.setTextureName(this.getDefaultTexture(componentType));
        this.componentType = componentType;
    }

    public ComponentType getComponentType() {
        return componentType;
    }

    public String getDefaultTexture(ComponentType componentType) {
        return switch (componentType) {
            case PISTON -> PowerOverhaul.MODID + ":piston_default";
            case BLOCK -> PowerOverhaul.MODID + ":engine_block_default";
            case HEAD -> PowerOverhaul.MODID + ":engine_head_default";
        };
    }

    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer entityPlayer, List<String> tooltip, boolean bool) {
        super.addInformation(itemStack, entityPlayer, tooltip, bool);

    }

    @Override
    public int getColorFromItemStack(ItemStack itemStack, int renderPass) {
        return getMaterialColor();
    }
}
