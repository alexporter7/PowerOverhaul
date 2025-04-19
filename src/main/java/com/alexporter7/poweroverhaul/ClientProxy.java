package com.alexporter7.poweroverhaul;

import com.alexporter7.poweroverhaul.init.ModRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import com.alexporter7.poweroverhaul.blocks.PowerOverhaulBlocks;
import com.alexporter7.poweroverhaul.render.PowerOverhaulRender;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;

public class ClientProxy extends CommonProxy {

    // Override CommonProxy methods here, if you want a different behaviour on the client (e.g. registering renders).
    // Don't forget to call the super methods as well.

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        super.preInit(event);

        PowerOverhaul.LOG.info("Registering Block Renderers");
        ModRegistry.registerBlockRenderers();

        PowerOverhaul.LOG.info("Registering Item Renderers");
        ModRegistry.registerItemRenderers();

        PowerOverhaul.LOG.info("Registering Creative Tab(s)");
        PowerOverhaul.powerOverhaulTab = new CreativeTabs(PowerOverhaul.MOD_LABEL) {

            @Override
            public Item getTabIconItem() {
                return Item.getItemFromBlock(PowerOverhaulBlocks.blocks.get("diesel_generator"));
            }
        };
    }

    @Override
    public void init(FMLInitializationEvent event) {
        super.init(event);
    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {
        super.postInit(event);
    }

    @Override
    public void serverStarting(FMLServerStartingEvent event) {
        super.serverStarting(event);
    }
}
