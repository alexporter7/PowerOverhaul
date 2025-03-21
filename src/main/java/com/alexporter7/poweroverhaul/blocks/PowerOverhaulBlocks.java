package com.alexporter7.poweroverhaul.blocks;

import java.util.HashMap;

import net.minecraft.block.Block;

import com.alexporter7.poweroverhaul.blocks.generators.DieselGeneratorBlock;
import com.alexporter7.poweroverhaul.blocks.generators.DieselGeneratorTileEntity;

import cpw.mods.fml.common.registry.GameRegistry;

public class PowerOverhaulBlocks {

    // public static List<Block> blocks = new ArrayList<Block>();

    public static HashMap<String, Block> blocks = new HashMap<>();

    public static void registerBlocks() {

        /* Generators */
        blocks.put("diesel_generator", new DieselGeneratorBlock());

        for (String key : blocks.keySet()) GameRegistry.registerBlock(blocks.get(key), key);

    }

    public static void registerTileEntities() {
        GameRegistry.registerTileEntity(DieselGeneratorTileEntity.class, "diesel_generator_te");
    }

}
