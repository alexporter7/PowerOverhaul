package com.alexporter7.poweroverhaul.items.subcomponents;

import java.util.List;

import com.alexporter7.poweroverhaul.api.material.MaterialUtil;
import com.alexporter7.poweroverhaul.items.components.ComponentMaterial;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

import com.alexporter7.poweroverhaul.api.material.PowerOverhaulMaterial;
import com.alexporter7.poweroverhaul.items.MaterialItem;

public class EngineSubComponent extends MaterialItem {

    public EngineSubComponent(PowerOverhaulMaterial material, MaterialUtil.Component component) {
        super(material, component);
    }

    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer player, List<String> tooltip, boolean bool) {
        super.addInformation(itemStack, player, tooltip, bool);
    }
}
