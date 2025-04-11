package com.alexporter7.poweroverhaul.api.material;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.function.Consumer;

import com.alexporter7.poweroverhaul.blocks.MaterialBlock;
import com.alexporter7.poweroverhaul.blocks.MaterialOreBlock;
import com.alexporter7.poweroverhaul.items.MaterialItem;
import com.alexporter7.poweroverhaul.items.components.EngineComponentItem;

import cpw.mods.fml.common.registry.GameRegistry;

public class MaterialUtil {

    public enum Type {
        BLOCK,
        ORE,
        FLUID,
        ITEM,
        ENGINE_COMPONENT
    }

    public enum Component {

        /* Blocks */
        BLOCK(Type.BLOCK),

        /* Ores */
        ORE(Type.ORE),

        /* Fluids */
        //MOLTEN(Type.FLUID),

        /* Items */
        INGOT(Type.ITEM),
        DUST(Type.ITEM),

        /* Engine Component */
        ENGINE_HEAD(Type.ENGINE_COMPONENT),
        ENGINE_BLOCK(Type.ENGINE_COMPONENT),
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

    // TODO: fix fluid then do @NotNull
    public static Consumer<Component> getRegister(PowerOverhaulMaterial material, Component component) {
        return switch (component.TYPE) {
            case BLOCK -> (_component -> {
                GameRegistry.registerBlock(new MaterialBlock(material), getRegistryName(material, _component));
            });
            case ORE -> (_component -> {
                GameRegistry.registerBlock(new MaterialOreBlock(material), getRegistryName(material, _component));
            });
            case FLUID -> null;
            case ITEM -> (_component) -> {
                String regName = getRegistryName(material, component);
                GameRegistry.registerItem(new MaterialItem(material, component), regName);
            };
            case ENGINE_COMPONENT -> (_component) -> {
                String regName = getRegistryName(material, component);
                GameRegistry.registerItem(new EngineComponentItem(material, component), regName);
            };
        };
    }

    public static HashSet<Component> getAllComponents() {
        return new HashSet<>(Arrays.asList(Component.values()));
    }

    public static HashSet<Component> getAllComponentsNoEngine() {
        return new HashSet<>(Arrays.asList(Component.BLOCK, Component.ORE, //Component.MOLTEN,
            Component.INGOT, Component.DUST));
    }

}
