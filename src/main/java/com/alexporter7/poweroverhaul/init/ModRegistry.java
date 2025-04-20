package com.alexporter7.poweroverhaul.init;

import java.util.HashMap;

import com.alexporter7.poweroverhaul.PowerOverhaul;
import com.alexporter7.poweroverhaul.api.material.MaterialUtil;
import com.alexporter7.poweroverhaul.blocks.engine.EngineBlock;
import com.alexporter7.poweroverhaul.blocks.engine.EngineBlockTileEntity;
import com.alexporter7.poweroverhaul.blocks.engine.EngineComponentBlock;
import com.alexporter7.poweroverhaul.blocks.machines.AlloySmelterBlock;
import com.alexporter7.poweroverhaul.blocks.machines.AlloySmelterTileEntity;
import com.alexporter7.poweroverhaul.blocks.misc.MusicPlayerBlock;
import com.alexporter7.poweroverhaul.blocks.misc.MusicPlayerTileEntity;
import com.alexporter7.poweroverhaul.blocks.models.machine.AlloySmelterModel;
import com.alexporter7.poweroverhaul.blocks.models.generator.DieselGeneratorModel;
import com.alexporter7.poweroverhaul.blocks.models.MusicPlayerModel;
import com.alexporter7.poweroverhaul.items.NetworkToolItem;
import com.alexporter7.poweroverhaul.items.models.NetworkToolModel;
import com.alexporter7.poweroverhaul.render.renderers.EngineBlockTERenderer;
import com.alexporter7.poweroverhaul.render.renderers.PowerOverhaulTEBlockRenderer;
import com.alexporter7.poweroverhaul.render.renderers.PowerOverhaulItemRenderer;
import com.alexporter7.poweroverhaul.render.renderers.PowerOverhaulTEItemRenderer;
import com.alexporter7.poweroverhaul.util.ModelManager;
import com.alexporter7.poweroverhaul.util.TestGuiBlock;
import com.alexporter7.poweroverhaul.util.TestTileGui;
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
        /* For GUI Testing */
        BLOCKS.put("test_gui", new TestGuiBlock());

        BLOCKS.put("diesel_generator", new DieselGeneratorBlock());
        BLOCKS.put("music_player", new MusicPlayerBlock());
        BLOCKS.put("alloy_smelter", new AlloySmelterBlock());

//        BLOCKS.put("engine_block_4", new EngineBlock(4));
//        BLOCKS.put("engine_block_6", new EngineBlock(6));
//        BLOCKS.put("engine_block_8", new EngineBlock(8));

        return BLOCKS;
    }

    public static void initTileEntities() {
        /* For GUI Testing */
        TILE_ENTITIES.put("test_gui_te", TestTileGui.class);

        TILE_ENTITIES.put("diesel_generator_te", DieselGeneratorTileEntity.class);
        TILE_ENTITIES.put("music_player_te", MusicPlayerTileEntity.class);
        TILE_ENTITIES.put("alloy_smelter_te", AlloySmelterTileEntity.class);

        TILE_ENTITIES.put("engine_block_te", EngineBlockTileEntity.class);
    }

    public static void initItems() {
        ITEMS.put("network_tool", new NetworkToolItem());
    }

    @SideOnly(Side.CLIENT)
    public static void registerBlockRenderers() {
        registerBlockRenderer(
            new PowerOverhaulTEBlockRenderer(new DieselGeneratorModel(), ModelManager.Texture.DIESEL_GENERATOR),
            DieselGeneratorTileEntity.class,
            new DieselGeneratorTileEntity(),
            "diesel_generator");
        registerBlockRenderer(
            new PowerOverhaulTEBlockRenderer(new MusicPlayerModel(), ModelManager.Texture.MUSIC_PLAYER),
            MusicPlayerTileEntity.class,
            new MusicPlayerTileEntity(),
            "music_player"
        );
        registerBlockRenderer(
            new PowerOverhaulTEBlockRenderer(new AlloySmelterModel(), ModelManager.Texture.ALLOY_SMELTER),
            AlloySmelterTileEntity.class,
            new AlloySmelterTileEntity(),
            "alloy_smelter"
        );

//        /* Engine Blocks */
//        registerBlockRenderer(
//            new EngineBlockTERenderer(),
//            EngineBlockTileEntity.class,
//            new EngineBlockTileEntity(4),
//            "engine_block_4");
//        registerBlockRenderer(
//            new EngineBlockTERenderer(),
//            EngineBlockTileEntity.class,
//            new EngineBlockTileEntity(6),
//            "engine_block_6");
//        registerBlockRenderer(
//            new EngineBlockTERenderer(),
//            EngineBlockTileEntity.class,
//            new EngineBlockTileEntity(8),
//            "engine_block_8");
    }

    @SideOnly(Side.CLIENT)
    private static void registerBlockRenderer(TileEntitySpecialRenderer renderer,
                                              Class<? extends TileEntity> tileEntityClass,
                                              TileEntity tileEntity, String blockName) {

        PowerOverhaul.LOG.info("Registering block renderer for: " + blockName);
        ClientRegistry.bindTileEntitySpecialRenderer(tileEntityClass, renderer);
        MinecraftForgeClient.registerItemRenderer(
            Item.getItemFromBlock(BLOCKS.get(blockName)),
            new PowerOverhaulTEItemRenderer(renderer, tileEntity));
    }

    @SideOnly(Side.CLIENT)
    public static void registerItemRenderers() {

        MinecraftForgeClient.registerItemRenderer(ITEMS.get("network_tool"),
            new PowerOverhaulItemRenderer(new NetworkToolModel()));

    }

    @SideOnly(Side.CLIENT)
    public static void registerEngineRendererFromComponent(EngineComponentBlock engineComponentBlock,
                                                           MaterialUtil.Component component) {
        switch (component) {
            case ENGINE_BLOCK -> {
                EngineBlock block = (EngineBlock) engineComponentBlock;
                registerEngineComponentRenderer(EngineBlockTileEntity.class,
                new EngineBlockTileEntity(engineComponentBlock.getPowerOverhaulMaterial(), block.getCylinders()),
                    new EngineBlockTERenderer(), block.getBlockName());
            }
            case ENGINE_HEAD -> {

            }
        }
    }

    @SideOnly(Side.CLIENT)
    private static void registerEngineComponentRenderer(Class<? extends TileEntity> tileEntityClass, TileEntity tileEntity,
                                                        TileEntitySpecialRenderer renderer,
                                                        String blockName) {
        ClientRegistry.bindTileEntitySpecialRenderer(tileEntityClass, renderer);
        MinecraftForgeClient.registerItemRenderer(
            Item.getItemFromBlock(BLOCKS.get(blockName)),
            new PowerOverhaulTEItemRenderer(renderer, tileEntity));
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
    }

    public static void registerInit() {
        TILE_ENTITIES.forEach((key, tileEntity) -> {
            GameRegistry.registerTileEntity(tileEntity, key);
        });
    }

}
