package com.alexporter7.poweroverhaul.items;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import net.minecraft.item.Item;

import com.alexporter7.poweroverhaul.init.MaterialDef;

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

    }

    public static void registerEngines() {

    }

    public static void registerMaterials() {
        MaterialDef.registerMaterials();
    }
}
