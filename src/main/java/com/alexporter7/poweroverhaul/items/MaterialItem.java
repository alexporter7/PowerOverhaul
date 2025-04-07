package com.alexporter7.poweroverhaul.items;

import com.alexporter7.poweroverhaul.api.material.MaterialBuilder;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.List;

public class MaterialItem extends Item {

    /* Static Properties */
    private final int weight;
    private final int hardness;
    private final int meltingPoint;

    /* Dynamic Properties */
    private int temperature;

    public MaterialItem(MaterialBuilder builder) {
        super();
        this.weight = builder.weight;
        this.hardness = builder.hardness;
        this.meltingPoint = builder.meltingPoint;
    }

    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer player, List<String> tooltip, boolean bool) {
        super.addInformation(itemStack, player, tooltip, bool);
    }

    public int getWeight() {
        return this.weight;
    }

    public int getHardness() {
        return this.hardness;
    }

    public int getMeltingPoint() {
        return meltingPoint;
    }

    public void incrementTemperature() {
        this.incrementTemperature(1);
    }

    public void incrementTemperature(int amount) {
        this.temperature += amount;
    }

    public void decrementTemperature() {
        this.decrementTemperature(1);
    }

    public void decrementTemperature(int amount) {
        this.temperature -= amount;
    }

}
