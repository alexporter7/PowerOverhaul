package com.alexporter7.poweroverhaul.items;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import com.alexporter7.poweroverhaul.init.MaterialDef;
import net.minecraft.item.Item;

import com.alexporter7.poweroverhaul.items.components.ComponentMaterial;
import com.alexporter7.poweroverhaul.items.components.EngineComponentItem;

import cpw.mods.fml.common.registry.GameRegistry;

public class PowerOverhaulItems {

    public static List<Item> items = new ArrayList<Item>();
    public static HashSet<MaterialItem> materialItems = new HashSet<>();

    public static final void init() {
        registerEngineComponents();
        registerMaterials();

        for (Item item : items) GameRegistry.registerItem(item, item.getUnlocalizedName());
    }

    public static void registerEngineComponents() {

//        /* Pistons */
//        items.add(new EngineComponentItem(EngineComponentItem.ComponentType.PISTON, ComponentMaterial.IRON, "piston"));
//        items.add(new EngineComponentItem(EngineComponentItem.ComponentType.PISTON, ComponentMaterial.STEEL, "piston"));
//        items.add(
//            new EngineComponentItem(EngineComponentItem.ComponentType.PISTON, ComponentMaterial.ALUMINIUM, "piston"));
//        items.add(
//            new EngineComponentItem(EngineComponentItem.ComponentType.PISTON, ComponentMaterial.DARK_STEEL, "piston"));
//
//        /* Engine Blocks */
//        items.add(
//            new EngineComponentItem(EngineComponentItem.ComponentType.BLOCK, ComponentMaterial.IRON, "engine_block"));
//        items.add(
//            new EngineComponentItem(EngineComponentItem.ComponentType.BLOCK, ComponentMaterial.STEEL, "engine_block"));
//
//        /* Engine Head */
//        items.add(
//            new EngineComponentItem(EngineComponentItem.ComponentType.HEAD, ComponentMaterial.IRON, "engine_head"));
//        items.add(
//            new EngineComponentItem(EngineComponentItem.ComponentType.HEAD, ComponentMaterial.STEEL, "engine_head"));

    }

    public static void registerEngines() {

    }

    public static void registerMaterials() {
        MaterialDef.createMaterials();
    }
}
