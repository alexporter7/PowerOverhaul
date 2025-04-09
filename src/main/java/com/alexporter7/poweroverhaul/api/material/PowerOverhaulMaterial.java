package com.alexporter7.poweroverhaul.api.material;

import com.alexporter7.poweroverhaul.blocks.MaterialBlock;
import com.alexporter7.poweroverhaul.blocks.MaterialOreBlock;
import com.alexporter7.poweroverhaul.items.MaterialItem;
import com.alexporter7.poweroverhaul.items.components.EngineComponentItem;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class PowerOverhaulMaterial {

    private final String name;

    private final int weight;
    private final int hardness;
    private final int meltingPoint;
    private final int color;

    private final boolean hasBlock;
    private final boolean hasIngot;
    private final boolean hasMolten;
    private final boolean hasOreBlock;

    private final boolean hasEngineHead;
    private final boolean hasEngineBlock;
    private final boolean hasPiston;

    private MaterialItem ingot;
    private MaterialBlock block;
    private MaterialOreBlock oreBlock;

    private MaterialItem engineHead;
    private MaterialItem engineBlock;
    private MaterialItem piston;

    private final LanguageRegistry languageRegistry = LanguageRegistry.instance();

    public PowerOverhaulMaterial(MaterialBuilder builder) {
        name = builder.name;
        weight = builder.weight;
        hardness = builder.hardness;
        meltingPoint = builder.meltingPoint;
        color = builder.color;
        hasBlock = builder.hasBlock;
        hasIngot = builder.hasIngot;
        hasMolten = builder.hasMolten;
        hasEngineHead = builder.hasEngineHead;
        hasEngineBlock = builder.hasEngineBlock;
        hasPiston = builder.hasPiston;
        hasOreBlock = builder.hasOreBlock;
    }

    // TODO: make this return MaterialItem
    public void registerIngot() {
        ingot = new MaterialItem(this);
        GameRegistry.registerItem(ingot, name + "_ingot");
    }

    // TODO: make this return MaterialBlock
    public void registerBlock() {
        block = new MaterialBlock(this);
        GameRegistry.registerBlock(block, name + "_block");
    }

    // TODO: make this return MaterialFluid
    public void registerMolten() {

    }

    public void registerOreBlock() {
        oreBlock = new MaterialOreBlock(this);
        GameRegistry.registerBlock(oreBlock, name + "_ore_block");
    }

    public void registerEngineComponent(EngineComponentItem.ComponentType componentType) {
        MaterialItem component = new EngineComponentItem(componentType, this);
        GameRegistry.registerItem(
            component,
            name + "_engine_"
                + componentType.toString()
                    .toLowerCase());
        switch (componentType) {
            case BLOCK -> engineBlock = component;
            case PISTON -> piston = component;
            case HEAD -> engineHead = component;
        }
    }

    public MaterialItem getIngot() {
        return ingot;
    }

    public void register() {
        if (hasIngot) registerIngot();
        if (hasBlock) registerBlock();
        if (hasMolten) registerMolten();
        if (hasOreBlock) registerOreBlock();
        if (hasEngineBlock) registerEngineComponent(EngineComponentItem.ComponentType.BLOCK);
        if (hasEngineHead) registerEngineComponent(EngineComponentItem.ComponentType.HEAD);
        if (hasPiston) registerEngineComponent(EngineComponentItem.ComponentType.PISTON);
    }

    public int getWeight() {
        return weight;
    }

    public int getHardness() {
        return hardness;
    }

    public int getMeltingPoint() {
        return meltingPoint;
    }

    public String getName() {
        return name;
    }

    public int getColor() {
        return color;
    }
}
