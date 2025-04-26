package com.alexporter7.poweroverhaul.items.components;

import java.util.List;

import com.alexporter7.poweroverhaul.api.material.Component;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

import com.alexporter7.poweroverhaul.PowerOverhaul;
import com.alexporter7.poweroverhaul.api.material.PowerOverhaulMaterial;
import com.alexporter7.poweroverhaul.items.MaterialItem;
import com.alexporter7.poweroverhaul.api.enums.Components;

public class EngineComponentItem extends MaterialItem {

    private final Component component;

    public EngineComponentItem(PowerOverhaulMaterial material, Component component) {
        super(material, component);
        this.component = component;
        this.setTextureName(this.getDefaultTexture(component));
    }

    public Component getComponent() {
        return component;
    }

    public String getDefaultTexture(Component componentType) {
        return switch ((Components.Component)component.getComponentKey()) {
            case ENGINE_PISTON -> PowerOverhaul.MODID + ":piston_default";
            case ENGINE_BLOCK -> PowerOverhaul.MODID + ":engine_block_default";
            case ENGINE_HEAD -> PowerOverhaul.MODID + ":engine_head_default";
            default -> "";
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
