package com.alexporter7.poweroverhaul.render;

import com.alexporter7.poweroverhaul.PowerOverhaul;
import com.alexporter7.poweroverhaul.blocks.PowerOverhaulBlocks;
import com.alexporter7.poweroverhaul.blocks.models.DieselGeneratorModel;
import com.alexporter7.poweroverhaul.blocks.generators.DieselGeneratorTileEntity;
import com.alexporter7.poweroverhaul.render.renderers.PowerOverhaulBlockRenderer;
import com.alexporter7.poweroverhaul.render.renderers.PowerOverhaulItemRenderer;
import com.alexporter7.poweroverhaul.util.ModelManager;
import cpw.mods.fml.client.registry.ClientRegistry;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.client.MinecraftForgeClient;

public class PowerOverhaulRender {

    public static void registerBlockRenderers() {

        registerBlockRenderer(
            new PowerOverhaulBlockRenderer(new DieselGeneratorModel(), ModelManager.Texture.DIESEL_GENERATOR),
            DieselGeneratorTileEntity.class, new DieselGeneratorTileEntity(), "diesel_generator");

    }

    public static void registerBlockRenderer(TileEntitySpecialRenderer renderer,
                                             Class<? extends TileEntity> tileEntityClass,
                                             TileEntity tileEntity, String blockName) {
        PowerOverhaul.LOG.info("Registering block renderer for: " + blockName);
        ClientRegistry.bindTileEntitySpecialRenderer(tileEntityClass, renderer);
        MinecraftForgeClient.registerItemRenderer(
            Item.getItemFromBlock(PowerOverhaulBlocks.blocks.get(blockName)),
            new PowerOverhaulItemRenderer(renderer, tileEntity)
        );
    }

}
