package com.alexporter7.poweroverhaul.fluid;

import com.alexporter7.poweroverhaul.PowerOverhaul;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;

public class PowerOverhaulFluid extends Fluid {

    private static final String FLUID_TEXTURE_PATH = PowerOverhaul.MODID + ":fluids/";

    private final ResourceLocation iconStill;
    private final ResourceLocation iconFlowing;

    @SideOnly(Side.CLIENT)
    private IIcon still;
    private IIcon flowing;

    public PowerOverhaulFluid(String name) {
        super(name);
        this.iconStill = new ResourceLocation(FLUID_TEXTURE_PATH + name + "_still");
        this.iconFlowing = new ResourceLocation(FLUID_TEXTURE_PATH + name + "_flowing");
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

    public void setFluidIcons(IIcon still, IIcon flowing) {
        this.still = still;
        this.flowing = flowing;
    }




}
