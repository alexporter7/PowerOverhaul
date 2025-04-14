package com.alexporter7.poweroverhaul.init;

import java.util.HashMap;

import com.alexporter7.poweroverhaul.PowerOverhaul;
import com.alexporter7.poweroverhaul.blocks.PowerOverhaulBlocks;
import com.alexporter7.poweroverhaul.blocks.machines.AlloySmelterBlock;
import com.alexporter7.poweroverhaul.blocks.machines.AlloySmelterTileEntity;
import com.alexporter7.poweroverhaul.blocks.misc.MusicPlayerBlock;
import com.alexporter7.poweroverhaul.blocks.misc.MusicPlayerTileEntity;
import com.alexporter7.poweroverhaul.blocks.models.AlloySmelterModel;
import com.alexporter7.poweroverhaul.blocks.models.DieselGeneratorModel;
import com.alexporter7.poweroverhaul.blocks.models.MusicPlayerModel;
import com.alexporter7.poweroverhaul.render.renderers.PowerOverhaulBlockRenderer;
import com.alexporter7.poweroverhaul.render.renderers.PowerOverhaulItemRenderer;
import com.alexporter7.poweroverhaul.util.ModelManager;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;

import com.alexporter7.poweroverhaul.blocks.generators.DieselGeneratorBlock;
import com.alexporter7.poweroverhaul.blocks.generators.DieselGeneratorTileEntity;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraftforge.client.MinecraftForgeClient;

public class ModRegistry {

    public static final HashMap<String, Block> BLOCKS = new HashMap<>();
    public static final HashMap<String, Item> ITEMS = new HashMap<>();
    public static final HashMap<String, Class<? extends TileEntity>> TILE_ENTITIES = new HashMap<>();

    public static void preInit() {
        initBlocks();
        initItems();
    }

    public static void init() {
        initTileEntities();
    }

    public static HashMap<String, Block> initBlocks() {
        BLOCKS.put("diesel_generator", new DieselGeneratorBlock());
        BLOCKS.put("music_player", new MusicPlayerBlock());
        BLOCKS.put("alloy_smelter", new AlloySmelterBlock());

        return BLOCKS;
    }

    public static void initTileEntities() {
        TILE_ENTITIES.put("diesel_generator_te", DieselGeneratorTileEntity.class);
        TILE_ENTITIES.put("music_player_te", MusicPlayerTileEntity.class);
        TILE_ENTITIES.put("alloy_smelter_te", AlloySmelterTileEntity.class);
    }

    public static void initItems() {

    }

    @SideOnly(Side.CLIENT)
    public static void registerBlockRenderers() {
        registerBlockRenderer(
            new PowerOverhaulBlockRenderer(new DieselGeneratorModel(), ModelManager.Texture.DIESEL_GENERATOR),
            DieselGeneratorTileEntity.class,
            new DieselGeneratorTileEntity(),
            "diesel_generator");
        registerBlockRenderer(
            new PowerOverhaulBlockRenderer(new MusicPlayerModel(), ModelManager.Texture.MUSIC_PLAYER),
            MusicPlayerTileEntity.class,
            new MusicPlayerTileEntity(),
            "music_player"
        );
        registerBlockRenderer(
            new PowerOverhaulBlockRenderer(new AlloySmelterModel(), ModelManager.Texture.ALLOY_SMELTER),
            AlloySmelterTileEntity.class,
            new AlloySmelterTileEntity(),
            "alloy_smelter"
        );
    }

    @SideOnly(Side.CLIENT)
    private static void registerBlockRenderer(TileEntitySpecialRenderer renderer,
                                              Class<? extends TileEntity> tileEntityClass,
                                              TileEntity tileEntity, String blockName) {

        PowerOverhaul.LOG.info("Registering block renderer for: " + blockName);
        ClientRegistry.bindTileEntitySpecialRenderer(tileEntityClass, renderer);
        MinecraftForgeClient.registerItemRenderer(
            Item.getItemFromBlock(BLOCKS.get(blockName)),
            new PowerOverhaulItemRenderer(renderer, tileEntity));
    }

    public static void registerPreInit() {
        BLOCKS.forEach((key, block) -> {
            block.setBlockName(key);
            GameRegistry.registerBlock(block, key);
        });
        MaterialDef.registerMaterials();
    }

    public static void registerInit() {
        TILE_ENTITIES.forEach((key, tileEntity) -> {
            GameRegistry.registerTileEntity(tileEntity, key);
        });
    }

}
