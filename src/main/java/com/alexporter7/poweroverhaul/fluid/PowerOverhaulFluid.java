package com.alexporter7.poweroverhaul.fluid;

import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;

import com.alexporter7.poweroverhaul.PowerOverhaul;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class PowerOverhaulFluid extends Fluid {

    private static final String FLUID_TEXTURE_PATH = PowerOverhaul.MODID + ":fluids/";

    private final ResourceLocation iconStill;
    private final ResourceLocation iconFlowing;

    @SideOnly(Side.CLIENT)
    private IIcon still;
    @SideOnly(Side.CLIENT)
    private IIcon flowing;

    private int quality;

    public PowerOverhaulFluid(String name) {
        super(name);
        this.iconStill = new ResourceLocation(FLUID_TEXTURE_PATH + name);
        this.iconFlowing = new ResourceLocation(FLUID_TEXTURE_PATH + name);
        this.quality = 100;
    }

    public PowerOverhaulFluid(String name, boolean flowingTexture) {
        super(name);
        this.iconStill = new ResourceLocation(FLUID_TEXTURE_PATH + name + "_still");
        this.iconFlowing = new ResourceLocation(FLUID_TEXTURE_PATH + name + "_flowing");
        this.quality = 100;
    }

    public ResourceLocation getIconStill() {
        return this.iconStill;
    }

    public ResourceLocation getIconFlowing() {
        return this.iconFlowing;
    }

    @Override
    public IIcon getStillIcon() {
        return this.still;
    }

    @Override
    public IIcon getFlowingIcon() {
        return this.flowing;
    }

    @Override
    public IIcon getIcon() {
        return this.still;
    }

    @Override
    public IIcon getIcon(FluidStack stack) {
        return this.still;
    }

    public void setFluidIcons(IIcon still, IIcon flowing) {
        this.still = still;
        this.flowing = flowing;
    }

    public int getQuality() {
        return this.quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public void decrementQuality() {
        this.quality--;
    }

    public void incrementQuality() {
        if (this.quality < 100) this.quality++;
    }
}
