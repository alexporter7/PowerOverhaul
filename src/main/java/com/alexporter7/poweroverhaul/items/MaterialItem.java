package com.alexporter7.poweroverhaul.items;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.alexporter7.poweroverhaul.PowerOverhaul;
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

    public MaterialItem(PowerOverhaulMaterial material) {
        this.setUnlocalizedName(material.getName() + "_ingot");
        this.weight = material.getWeight();
        this.hardness = material.getHardness();
        this.meltingPoint = material.getMeltingPoint();
        this.color = material.getColor();
        this.setTextureName(PowerOverhaul.MODID + ":ingot");
    }

    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer player, List<String> tooltip, boolean bool) {
        super.addInformation(itemStack, player, tooltip, bool);
        tooltip.add(TooltipUtil.createLabelValueTooltip(TooltipUtil.Color.AQUA, "Temperature", temperature));
        tooltip.add(TooltipUtil.createLabelValueTooltip(TooltipUtil.Color.AQUA, "Weight", weight));
        tooltip.add(TooltipUtil.createLabelValueTooltip(TooltipUtil.Color.AQUA, "Hardness", hardness));
        tooltip.add(TooltipUtil.createLabelValueTooltip(TooltipUtil.Color.AQUA, "Melting Point", meltingPoint));
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

    // @Override
    // public boolean onItemUse(ItemStack itemStack, EntityPlayer entityPlayer, World world, int x, int y, int z,
    // int noIdea, float f1, float f2, float f3) {
    // this.incrementTemperature();
    // return super.onItemUse(itemStack, entityPlayer, world, x, y, z, noIdea, f1, f2, f3);
    // }

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
