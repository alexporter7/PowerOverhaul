package com.alexporter7.poweroverhaul.blocks;

import com.alexporter7.poweroverhaul.render.blocks.DieselGeneratorRenderer;
import com.alexporter7.poweroverhaul.blocks.generators.DieselGeneratorTileEntity;
import com.alexporter7.poweroverhaul.render.items.DieselGeneratorItemRenderer;
import cpw.mods.fml.client.registry.ClientRegistry;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;

public class PowerOverhaulRender {

    public static void registerBlockRenderers() {
        TileEntitySpecialRenderer dieselGeneratorRenderer = new DieselGeneratorRenderer();
        ClientRegistry.bindTileEntitySpecialRenderer(DieselGeneratorTileEntity.class, dieselGeneratorRenderer);
        MinecraftForgeClient
            .registerItemRenderer(
                Item.getItemFromBlock(PowerOverhaulBlocks.blocks.get("diesel_generator")),
                new DieselGeneratorItemRenderer(dieselGeneratorRenderer, new DieselGeneratorTileEntity()));
    }

    public static void registerTileEntityRenderers() {

    }

}
