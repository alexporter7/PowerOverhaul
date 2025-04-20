package com.alexporter7.poweroverhaul.fluid;

import static com.alexporter7.poweroverhaul.api.enums.FluidEnum.*;

import java.util.HashSet;
import java.util.Set;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.IFluidBlock;

import com.alexporter7.poweroverhaul.api.enums.FluidEnum;

import cpw.mods.fml.common.registry.GameRegistry;

public class PowerOverhaulFluids {

    public static Set<Fluid> fluids = new HashSet<>();
    public static Set<IFluidBlock> fluidBlocks = new HashSet<>();

    public static void registerFluids() {

        registerFluid(COOLANT, 0x10CF00);
        registerFluid(OIL, 0x070707);
        registerFluid(DIESEL, 0xF6EC46);

    }

    public static void registerFluid(FluidEnum fluidDef, int color) {
        String fluidName = fluidDef.toString()
            .toLowerCase();
        PowerOverhaulFluid fluid = new PowerOverhaulFluid(fluidName);
        FluidRegistry.registerFluid(fluid);

        PowerOverhaulFluidBlock fluidBlock = registerFluidBlock(fluid);

        PowerOverhaulBucket fluidBucket = new PowerOverhaulBucket(fluidBlock, color);
        fluidBucket.setUnlocalizedName(fluidName + "_bucket");

        GameRegistry.registerItem(fluidBucket, fluid.getUnlocalizedName() + "_bucket");

        registerFluidContainer(fluid, new ItemStack(fluidBucket));
    }

    public static PowerOverhaulFluidBlock registerFluidBlock(PowerOverhaulFluid fluid) {
        PowerOverhaulFluidBlock fluidBlock = new PowerOverhaulFluidBlock(fluid);
        GameRegistry.registerBlock(new PowerOverhaulFluidBlock(fluid).setBlockName(fluid.getName()), fluid.getName());
        return fluidBlock;
    }

    public static void registerFluidContainer(PowerOverhaulFluid fluid, ItemStack fluidBucket) {
        FluidContainerRegistry.registerFluidContainer(fluid, fluidBucket, new ItemStack(Items.bucket));
    }

}
