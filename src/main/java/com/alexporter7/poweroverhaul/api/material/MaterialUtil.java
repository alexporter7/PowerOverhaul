package com.alexporter7.poweroverhaul.api.material;

import com.alexporter7.poweroverhaul.api.enums.Components;
import com.alexporter7.poweroverhaul.blocks.engine.EngineBlock;
import com.alexporter7.poweroverhaul.blocks.engine.EngineComponentBlock;
import com.alexporter7.poweroverhaul.blocks.engine.EngineHead;

import java.util.Arrays;
import java.util.HashSet;


public class MaterialUtil {

    public enum Type {
        BLOCK,
        ORE,
        FLUID,
        ITEM,
        ENGINE_COMPONENT,
        ENGINE_COMPONENT_RENDER
    }

    public enum Component {

        /* Blocks */
        BLOCK(Type.BLOCK),

        /* Ores */
        ORE_BLOCK(Type.ORE),

        /* Fluids */
        // MOLTEN(Type.FLUID),

        /* Items */
        INGOT(Type.ITEM),
        DUST(Type.ITEM),

        /* Engine Component */
        ENGINE_HEAD(Type.ENGINE_COMPONENT_RENDER),
        ENGINE_BLOCK(Type.ENGINE_COMPONENT_RENDER),
        ENGINE_PISTON(Type.ENGINE_COMPONENT);

        public final Type TYPE;

        Component(Type type) {
            this.TYPE = type;
        }
    }

    public static String getRegistryName(PowerOverhaulMaterial material, Component materialType) {
        return material.getName() + "_"
            + materialType.toString()
                .toLowerCase();
    }

    public static String getRegistryName(PowerOverhaulMaterial material, com.alexporter7.poweroverhaul.api.material.Component component) {
        return material.getName() + "_" + component.getComponentType().getType().toString().toLowerCase();
    }

    public static String getLangName(PowerOverhaulMaterial material, Component component) {
        return switch (component.TYPE) {
            case BLOCK, ORE -> "tile." + material.getName()
                + "_"
                + component.toString()
                    .toLowerCase()
                + ".name=";
            case ITEM, ENGINE_COMPONENT -> "item." + material.getName()
                + "_"
                + component.toString()
                    .toLowerCase()
                + ".name=";
            default -> null;
        };
    }

    public static String getEnglishTranslation(PowerOverhaulMaterial material, Component component) {
        String name = material.getName()
            .substring(0, 1)
            .toUpperCase()
            + material.getName()
                .substring(1)
                .toLowerCase();
        for (String word : component.toString()
            .split("_"))
            name = name + " "
                + word.substring(0, 1)
                    .toUpperCase()
                + word.substring(1)
                    .toLowerCase();
        return name;
    }

    // TODO: fix fluid then do @NotNull
//    public static Consumer<Component> getRegister(PowerOverhaulMaterial material, Component component) {
//        return switch (component.TYPE) {
//            case BLOCK -> (_component -> {
//                Block block = new MaterialBlock(material);
//                ModRegistry.BLOCKS.put(getRegistryName(material, component), block);
//                GameRegistry.registerBlock(block, getRegistryName(material, component));
//            });
//            case ORE -> (_component -> {
//                Block block = new MaterialOreBlock(material);
//                ModRegistry.BLOCKS.put(getRegistryName(material, component), block);
//                GameRegistry.registerBlock(block, getRegistryName(material, component));
//            });
//            case FLUID -> null;
//            case ITEM -> (_component) -> {
//                String regName = getRegistryName(material, component);
//                Item item = new MaterialItem(material, component);
//                ModRegistry.ITEMS.put(regName, item);
//                GameRegistry.registerItem(item, regName);
//            };
//            case ENGINE_COMPONENT -> (_component) -> {
//                String regName = getRegistryName(material, component);
//                Item item = new EngineComponentItem(material, component);
//                ModRegistry.ITEMS.put(regName, item);
//                GameRegistry.registerItem(item, regName);
//            };
//            case ENGINE_COMPONENT_RENDER -> (_component) -> {
//                HashSet<EngineComponentBlock> blocks = getEngineComponentClass(material, component);
//                blocks.forEach((block -> {
//                    ModRegistry.BLOCKS.put(block.getBlockName(), block);
//                    GameRegistry.registerBlock(block, block.getBlockName());
//                    RegistryUtil.registerEngineRendererFromComponent(block, component);
//                }));
//            };
//        };
//    }

    public static HashSet<EngineComponentBlock> getEngineComponentClass(PowerOverhaulMaterial material,
        Component component) {
        switch (component) {
            case ENGINE_BLOCK -> {
                return new HashSet<>(
                    Arrays.asList(
                        new EngineBlock(material, 4),
                        new EngineBlock(material, 6),
                        new EngineBlock(material, 8)));
            }
            case ENGINE_HEAD -> {
                return new HashSet<>(
                    Arrays.asList(
                        new EngineHead(material, 4),
                        new EngineHead(material, 6),
                        new EngineHead(material, 8)));
            }
        }
        return null;
    }

    public static HashSet<EngineComponentBlock> getEngineComponentClass(PowerOverhaulMaterial material,
                                                                        com.alexporter7.poweroverhaul.api.material.Component component) {
        switch ((Components.Component)component.getComponentKey()) {
            case ENGINE_BLOCK -> {
                return new HashSet<>(
                    Arrays.asList(
                        new EngineBlock(material, 4),
                        new EngineBlock(material, 6),
                        new EngineBlock(material, 8)));
            }
            case ENGINE_HEAD -> {
                return new HashSet<>(
                    Arrays.asList(
                        new EngineHead(material, 4),
                        new EngineHead(material, 6),
                        new EngineHead(material, 8)));
            }
        }
        return null;
    }

    public static HashSet<Component> getAllComponents() {
        return new HashSet<>(Arrays.asList(Component.values()));
    }

    public static HashSet<Component> getAllComponentsNoEngine() {
        return new HashSet<>(
            Arrays.asList(
                Component.BLOCK,
                Component.ORE_BLOCK, // Component.MOLTEN,
                Component.INGOT,
                Component.DUST));
    }

}
