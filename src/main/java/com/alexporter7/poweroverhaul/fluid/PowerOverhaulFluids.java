package com.alexporter7.poweroverhaul.fluid;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBucket;
import net.minecraftforge.fluids.*;

import java.util.HashSet;
import java.util.Set;

public class PowerOverhaulFluids {

    public static Set<Fluid> fluids = new HashSet<>();
    public static Set<IFluidBlock> fluidBlocks = new HashSet<>();

    public static void registerFluids() {

        PowerOverhaulFluidBlock coolantBlock = new PowerOverhaulFluidBlock(
            new PowerOverhaulFluid("coolant"));
        coolantBlock.setBlockName("coolant");
        GameRegistry.registerBlock(coolantBlock, "coolant");
        FluidRegistry.registerFluid(coolantBlock.getFluid());

        //registerFluid(new PowerOverhaulFluid("coolant"));
//        Fluid coolant = createFluid("coolant", PowerOverhaul.MODID + ":fluids/coolant",
//            75, 0, 800, 100,
//            fluid -> new PowerOverhaulFluidBlock(fluid));

    }

    public static void registerFluid(PowerOverhaulFluid fluid) {
        FluidRegistry.registerFluid(fluid);

        PowerOverhaulFluidBlock fluidBlock = registerFluidBlock(fluid);
        FluidStack bucketFluid = new FluidStack(fluid, FluidContainerRegistry.BUCKET_VOLUME);
        GameRegistry.registerItem(
            new ItemBucket(fluidBlock),
            fluid.getUnlocalizedName() + "_bucket"
        );
    }

    public static PowerOverhaulFluidBlock registerFluidBlock(PowerOverhaulFluid fluid) {
        PowerOverhaulFluidBlock fluidBlock = new PowerOverhaulFluidBlock(fluid);
        GameRegistry.registerBlock(
            new PowerOverhaulFluidBlock(fluid).setBlockName(fluid.getUnlocalizedName()),
            fluid.getUnlocalizedName()
        );
        return fluidBlock;
    }


}
