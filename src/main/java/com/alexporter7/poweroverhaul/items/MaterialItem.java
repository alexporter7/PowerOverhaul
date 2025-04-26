package com.alexporter7.poweroverhaul.items;

import java.util.List;

import com.alexporter7.poweroverhaul.api.material.Component;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.alexporter7.poweroverhaul.PowerOverhaul;
import com.alexporter7.poweroverhaul.api.material.MaterialUtil;
import com.alexporter7.poweroverhaul.api.material.PowerOverhaulMaterial;
import com.alexporter7.poweroverhaul.util.TooltipUtil;

public class MaterialItem extends Item {

    /* Static Properties */
    private final int weight;
    private final int hardness;
    private final int meltingPoint;
    private final int color;

    /* Dynamic Properties */
    private int temperature = 75;

    //private final MaterialUtil.Component component;
    private final Component component;
    private final PowerOverhaulMaterial material;

    public MaterialItem(PowerOverhaulMaterial material, Component component) {
        this.material = material;
        this.component = component;
        this.weight = material.getWeight();
        this.hardness = material.getHardness();
        this.meltingPoint = material.getMeltingPoint();
        this.color = material.getColor();
        this.setUnlocalizedName(MaterialUtil.getRegistryName(material, component));
        this.setTextureName(getTexture());
    }

    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer player, List<String> tooltip, boolean bool) {
        super.addInformation(itemStack, player, tooltip, bool);
        tooltip.add(TooltipUtil.createLabelValueTooltip(TooltipUtil.Color.AQUA, "Temperature", temperature));
        tooltip.add(TooltipUtil.createLabelValueTooltip(TooltipUtil.Color.AQUA, "Weight", weight));
        tooltip.add(TooltipUtil.createLabelValueTooltip(TooltipUtil.Color.AQUA, "Hardness", hardness));
        tooltip.add(TooltipUtil.createLabelValueTooltip(TooltipUtil.Color.AQUA, "Melting Point", meltingPoint));
    }

    private String getTexture() {
        return PowerOverhaul.MODID + ":"
            + component.getRegistryName();
    }

    public int getWeight() {
        return weight;
    }

    public int getHardness() {
        return hardness;
    }

    public int getMeltingPoint() {
        return meltingPoint;
    }

    public void incrementTemperature() {
        incrementTemperature(1);
    }

    public void incrementTemperature(int amount) {
        temperature += amount;
    }

    public void decrementTemperature() {
        decrementTemperature(1);
    }

    public void decrementTemperature(int amount) {
        temperature -= amount;
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer player) {
        this.incrementTemperature();
        return super.onItemRightClick(itemStackIn, worldIn, player);
    }

    @Override
    public int getColorFromItemStack(ItemStack itemStack, int renderPass) {
        return color;
    }

    public int getMaterialColor() {
        return color;
    }

}
