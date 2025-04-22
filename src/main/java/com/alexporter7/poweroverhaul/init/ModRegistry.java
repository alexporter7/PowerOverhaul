package com.alexporter7.poweroverhaul.init;

import java.util.HashMap;

import com.alexporter7.poweroverhaul.blocks.engine.*;
import com.alexporter7.poweroverhaul.entity.AppaEntity;
import com.alexporter7.poweroverhaul.entity.models.AppaEntityModel;
import com.alexporter7.poweroverhaul.render.renderers.*;
import com.alexporter7.poweroverhaul.util.RegistryUtil;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.client.MinecraftForgeClient;

import com.alexporter7.poweroverhaul.PowerOverhaul;
import com.alexporter7.poweroverhaul.blocks.generators.DieselGeneratorBlock;
import com.alexporter7.poweroverhaul.blocks.generators.DieselGeneratorTileEntity;
import com.alexporter7.poweroverhaul.blocks.machines.AlloySmelterBlock;
import com.alexporter7.poweroverhaul.blocks.machines.AlloySmelterTileEntity;
import com.alexporter7.poweroverhaul.blocks.misc.MusicPlayerBlock;
import com.alexporter7.poweroverhaul.blocks.misc.MusicPlayerTileEntity;
import com.alexporter7.poweroverhaul.blocks.models.MusicPlayerModel;
import com.alexporter7.poweroverhaul.blocks.models.generator.DieselGeneratorModel;
import com.alexporter7.poweroverhaul.blocks.models.machine.AlloySmelterModel;
import com.alexporter7.poweroverhaul.items.NetworkToolItem;
import com.alexporter7.poweroverhaul.items.models.NetworkToolModel;
import com.alexporter7.poweroverhaul.util.ModelManager;
import com.alexporter7.poweroverhaul.util.TestGuiBlock;
import com.alexporter7.poweroverhaul.util.TestTileGui;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ModRegistry {

    public static final HashMap<String, Block> BLOCKS = new HashMap<>();
    public static final HashMap<String, Item> ITEMS = new HashMap<>();
    public static final HashMap<String, Class<? extends TileEntity>> TILE_ENTITIES = new HashMap<>();
    public static final HashMap<String, Class<? extends Entity>> ENTITIES = new HashMap<>();

    public static void preInit() {
        initBlocks();
        initItems();
        initEntities();
    }

    public static void init() {
        initTileEntities();
    }

    public static HashMap<String, Block> initBlocks() {
        /* For GUI Testing */
        BLOCKS.put("test_gui", new TestGuiBlock());

        BLOCKS.put("diesel_generator", new DieselGeneratorBlock());
        BLOCKS.put("music_player", new MusicPlayerBlock());
        BLOCKS.put("alloy_smelter", new AlloySmelterBlock());

        return BLOCKS;
    }


    public static void initItems() {
        ITEMS.put("network_tool", new NetworkToolItem());
    }

    public static void initTileEntities() {
        /* For GUI Testing */
        TILE_ENTITIES.put("test_gui_te", TestTileGui.class);

        TILE_ENTITIES.put("diesel_generator_te", DieselGeneratorTileEntity.class);
        TILE_ENTITIES.put("music_player_te", MusicPlayerTileEntity.class);
        TILE_ENTITIES.put("alloy_smelter_te", AlloySmelterTileEntity.class);

        TILE_ENTITIES.put("engine_block_te", EngineBlockTileEntity.class);
        TILE_ENTITIES.put("engine_head_te", EngineHeadTileEntity.class);
    }

    public static void initEntities() {
        ENTITIES.put("appa", AppaEntity.class);
    }

    @SideOnly(Side.CLIENT)
    public static void registerBlockRenderers() {
        RegistryUtil.registerBlockRenderer(
            new PowerOverhaulTEBlockRenderer(new DieselGeneratorModel(), ModelManager.Texture.DIESEL_GENERATOR),
            DieselGeneratorTileEntity.class,
            new DieselGeneratorTileEntity(),
            "diesel_generator");
        RegistryUtil.registerBlockRenderer(
            new PowerOverhaulTEBlockRenderer(new MusicPlayerModel(), ModelManager.Texture.MUSIC_PLAYER),
            MusicPlayerTileEntity.class,
            new MusicPlayerTileEntity(),
            "music_player");
        RegistryUtil.registerBlockRenderer(
            new PowerOverhaulTEBlockRenderer(new AlloySmelterModel(), ModelManager.Texture.ALLOY_SMELTER),
            AlloySmelterTileEntity.class,
            new AlloySmelterTileEntity(),
            "alloy_smelter");

    }

    @SideOnly(Side.CLIENT)
    public static void registerItemRenderers() {

        MinecraftForgeClient
            .registerItemRenderer(ITEMS.get("network_tool"), new PowerOverhaulItemRenderer(new NetworkToolModel()));

    }

    @SideOnly(Side.CLIENT)
    public static void registerEntityRenderers() {
        RenderingRegistry.registerEntityRenderingHandler(
            AppaEntity.class, new PowerOverhaulEntityRenderer<AppaEntity>(
                new AppaEntityModel(), ModelManager.Texture.APPA_ENTITY.getResourceLocation(), 0.3f));
    }

    public static void registerPreInit() {
        PowerOverhaul.LOG.info("Registering Blocks");
        BLOCKS.forEach((key, block) -> {
            block.setBlockName(key);
            GameRegistry.registerBlock(block, key);
        });

        PowerOverhaul.LOG.info("Registering Items");
        ITEMS.forEach((key, item) -> {
            item.setUnlocalizedName(key);
            GameRegistry.registerItem(item, key);
        });

        PowerOverhaul.LOG.info("Registering Materials");
        MaterialDef.registerMaterials();

        PowerOverhaul.LOG.info("Registering Entities");
        ENTITIES.forEach(RegistryUtil::registerEntity);
    }

    public static void registerInit() {
        TILE_ENTITIES.forEach((key, tileEntity) -> { GameRegistry.registerTileEntity(tileEntity, key); });
    }

}
