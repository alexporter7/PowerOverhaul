package com.alexporter7.poweroverhaul.fluid;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.ItemBucket;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.*;

import java.util.HashSet;
import java.util.Set;

public class PowerOverhaulFluids {

    public static Set<Fluid> fluids = new HashSet<>();
    public static Set<IFluidBlock> fluidBlocks = new HashSet<>();

    public static void registerFluids() {

        registerFluid("coolant");
        registerFluid("oil");
        registerFluid("diesel");
//        Fluid coolant = createFluid("coolant", PowerOverhaul.MODID + ":fluids/coolant",
//            75, 0, 800, 100,
//            fluid -> new PowerOverhaulFluidBlock(fluid));

    }

    public static void registerFluid(String fluidName) {

        PowerOverhaulFluid fluid = new PowerOverhaulFluid(fluidName);
        FluidRegistry.registerFluid(fluid);

        PowerOverhaulFluidBlock fluidBlock = registerFluidBlock(fluid);

        PowerOverhaulBucket fluidBucket = new PowerOverhaulBucket(fluidBlock);
        fluidBucket.setUnlocalizedName(fluidName + "_bucket");

        GameRegistry.registerItem(
                fluidBucket,
            fluid.getUnlocalizedName() + "_bucket"
        );

        registerFluidContainer(fluid, new ItemStack(fluidBucket));
    }

    public static PowerOverhaulFluidBlock registerFluidBlock(PowerOverhaulFluid fluid) {
        PowerOverhaulFluidBlock fluidBlock = new PowerOverhaulFluidBlock(fluid);
        GameRegistry.registerBlock(
            new PowerOverhaulFluidBlock(fluid).setBlockName(fluid.getName()),
            fluid.getName()
        );
        return fluidBlock;
    }

    public static void registerFluidContainer(PowerOverhaulFluid fluid, ItemStack fluidBucket) {
        FluidContainerRegistry.registerFluidContainer(fluid, fluidBucket, new ItemStack(Items.bucket));
    }


}
