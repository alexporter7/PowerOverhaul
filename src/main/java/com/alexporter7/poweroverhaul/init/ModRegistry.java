package com.alexporter7.poweroverhaul.init;

import com.alexporter7.poweroverhaul.PowerOverhaul;
import com.alexporter7.poweroverhaul.blocks.meta.MetaPowerOverhaulTEBase;
import com.alexporter7.poweroverhaul.items.MaterialItem;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.block.Block;

import java.util.HashMap;

public class ModRegistry {

    public static final HashMap<String, ? extends Block> BLOCKS = new HashMap<>();
    public static final HashMap<String, ? extends MaterialItem> ITEMS = new HashMap<>();
    public static final HashMap<String, ? extends MetaPowerOverhaulTEBase> TILE_ENTITIES = new HashMap<>();

    public static void registerBlocks() {

    }

    public static void registerTileEntities() {

    }

    public static void registerItems() {

    }

    public static void registerBlockRenderers() {

    }

    private static void registerBlockRenderer() {

    }
}
