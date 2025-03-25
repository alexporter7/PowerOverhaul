package com.alexporter7.poweroverhaul;

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
        PowerOverhaulRender.registerBlockRenderers();
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
