package com.alexporter7.poweroverhaul.items.components;

import static com.alexporter7.poweroverhaul.api.material.MaterialUtil.Component.*;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

import com.alexporter7.poweroverhaul.PowerOverhaul;
import com.alexporter7.poweroverhaul.api.material.MaterialUtil.Component;
import com.alexporter7.poweroverhaul.api.material.PowerOverhaulMaterial;
import com.alexporter7.poweroverhaul.items.MaterialItem;

public class EngineComponentItem extends MaterialItem {

    private final Component componentType;

    public EngineComponentItem(PowerOverhaulMaterial material, Component component) {
        super(material, component);
        this.componentType = component;
        this.setTextureName(this.getDefaultTexture(component));
    }

    public Component getComponentType() {
        return componentType;
    }

    public String getDefaultTexture(Component componentType) {
        return switch (componentType) {
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
