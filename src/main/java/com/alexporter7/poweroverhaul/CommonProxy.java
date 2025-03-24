package com.alexporter7.poweroverhaul;

import com.alexporter7.poweroverhaul.blocks.PowerOverhaulBlocks;
import com.alexporter7.poweroverhaul.items.PowerOverhaulItems;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;

public class CommonProxy {

    // preInit "Run before anything else. Read your config, create blocks, items, etc, and register them with the
    // GameRegistry." (Remove if not needed)
    public void preInit(FMLPreInitializationEvent event) {
        Config.synchronizeConfiguration(event.getSuggestedConfigurationFile());


        PowerOverhaul.LOG.info("PowerOverhaul version: " + Tags.VERSION);

        PowerOverhaul.LOG.info("Registering PowerOverhaul Items");
        PowerOverhaulItems.init();

        PowerOverhaul.LOG.info("Registering PowerOverhaul Blocks");
        PowerOverhaulBlocks.registerBlocks();
    }

    // load "Do your mod setup. Build whatever data structures you care about. Register recipes." (Remove if not needed)
    public void init(FMLInitializationEvent event) {

        PowerOverhaul.LOG.info("Registering PowerOverhaul Tile Entities");
        PowerOverhaulBlocks.registerTileEntities();
    }

    // postInit "Handle interaction with other mods, complete your setup based on this." (Remove if not needed)
    public void postInit(FMLPostInitializationEvent event) {}

    // register server commands in this event handler (Remove if not needed)
    public void serverStarting(FMLServerStartingEvent event) {}
}
