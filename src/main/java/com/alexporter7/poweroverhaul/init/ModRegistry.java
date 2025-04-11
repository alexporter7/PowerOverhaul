package com.alexporter7.poweroverhaul.init;

import java.util.HashMap;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;

import com.alexporter7.poweroverhaul.blocks.generators.DieselGeneratorBlock;
import com.alexporter7.poweroverhaul.blocks.generators.DieselGeneratorTileEntity;

import cpw.mods.fml.common.registry.GameRegistry;

public class ModRegistry {

    public static final HashMap<String, Block> BLOCKS = new HashMap<>();
    public static final HashMap<String, Item> ITEMS = new HashMap<>();
    public static final HashMap<String, Class<? extends TileEntity>> TILE_ENTITIES = new HashMap<>();

    public static void registerBlocks() {
        BLOCKS.put("diesel_generator", new DieselGeneratorBlock());

        BLOCKS.forEach((key, block) -> {
            block.setBlockName(key);
            GameRegistry.registerBlock(block, key);
        });
    }

    public static void registerTileEntities() {
        TILE_ENTITIES.put("diesel_generator_te", DieselGeneratorTileEntity.class);

        TILE_ENTITIES.forEach((key, tileEntity) -> { GameRegistry.registerTileEntity(tileEntity, key); });
    }

    public static void registerItems() {
        MaterialDef.registerMaterials();
    }

    public static void registerBlockRenderers() {

    }

    private static void registerBlockRenderer() {

    }

}
