package com.alexporter7.poweroverhaul.util;

import com.alexporter7.poweroverhaul.PowerOverhaul;
import com.alexporter7.poweroverhaul.api.enums.Components;
import com.alexporter7.poweroverhaul.api.material.Component;
import com.alexporter7.poweroverhaul.api.material.MaterialUtil;
import com.alexporter7.poweroverhaul.blocks.engine.*;
import com.alexporter7.poweroverhaul.init.ModRegistry;
import com.alexporter7.poweroverhaul.render.renderers.EngineComponentTERenderer;
import com.alexporter7.poweroverhaul.render.renderers.PowerOverhaulTEItemRenderer;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.client.MinecraftForgeClient;

public class RegistryUtil {

    public static void registerEntity(String key, Class<? extends Entity> entityClass) {
        int entityId = EntityRegistry.findGlobalUniqueEntityId();
        long x = key.hashCode();
        int mainColor = 0x000000;
        int subColor = 0xFFFFFF;
        EntityRegistry.registerGlobalEntityID(entityClass, key, entityId);
        EntityRegistry.registerModEntity(entityClass, key, entityId, PowerOverhaul.instance, 64, 1, true);
        EntityList.entityEggs.put(entityId, new EntityList.EntityEggInfo(entityId, mainColor, subColor));
    }


    @SideOnly(Side.CLIENT)
    public static void registerBlockRenderer(TileEntitySpecialRenderer renderer,
                                             Class<? extends TileEntity> tileEntityClass, TileEntity tileEntity, String blockName) {

        PowerOverhaul.LOG.info("Registering block renderer for: " + blockName);
        ClientRegistry.bindTileEntitySpecialRenderer(tileEntityClass, renderer);
        MinecraftForgeClient.registerItemRenderer(
            Item.getItemFromBlock(ModRegistry.BLOCKS.get(blockName)),
            new PowerOverhaulTEItemRenderer(renderer, tileEntity));
    }

    @SideOnly(Side.CLIENT)
    public static void registerEngineRendererFromComponent(EngineComponentBlock engineComponentBlock,
                                                           Component component) {
        switch ((Components.Component)component.getComponentKey()) {
            case ENGINE_BLOCK -> {
                EngineBlock block = (EngineBlock) engineComponentBlock;
                registerEngineComponentRenderer(
                    EngineBlockTileEntity.class,
                    new EngineBlockTileEntity(engineComponentBlock.getPowerOverhaulMaterial(), component, block.getCylinders()),
                    new EngineComponentTERenderer(),
                    block.getBlockName());
            }
            case ENGINE_HEAD -> {
                EngineHead block = (EngineHead) engineComponentBlock;
                registerEngineComponentRenderer(
                    EngineHeadTileEntity.class,
                    new EngineHeadTileEntity(engineComponentBlock.getPowerOverhaulMaterial(), component, block.getCylinders()),
                    new EngineComponentTERenderer(),
                    block.getBlockName());
            }
        }
    }

    @SideOnly(Side.CLIENT)
    public static void registerEngineComponentRenderer(Class<? extends TileEntity> tileEntityClass,
                                                       TileEntity tileEntity, TileEntitySpecialRenderer renderer, String blockName) {
        ClientRegistry.bindTileEntitySpecialRenderer(tileEntityClass, renderer);
        MinecraftForgeClient.registerItemRenderer(
            Item.getItemFromBlock(ModRegistry.BLOCKS.get(blockName)),
            new PowerOverhaulTEItemRenderer(renderer, tileEntity));
    }
}
