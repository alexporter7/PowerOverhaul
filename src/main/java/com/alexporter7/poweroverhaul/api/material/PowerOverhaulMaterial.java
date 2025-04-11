package com.alexporter7.poweroverhaul.api.material;

import java.util.HashSet;

import cpw.mods.fml.common.registry.LanguageRegistry;

public class PowerOverhaulMaterial {

    private final String name;

    /* Material Properties */
    private final int weight;
    private final int hardness;
    private final int meltingPoint;
    private final int color;

    private final HashSet<MaterialUtil.Component> COMPONENTS;

    private final LanguageRegistry languageRegistry = LanguageRegistry.instance();

    public PowerOverhaulMaterial(MaterialBuilder builder) {
        name = builder.name;
        weight = builder.weight;
        hardness = builder.hardness;
        meltingPoint = builder.meltingPoint;
        color = builder.color;

        COMPONENTS = builder.components;
    }

    public void register(MaterialUtil.Component component) {
        MaterialUtil.getRegister(this, component)
            .accept(component);
    }

    // // TODO: make this return MaterialItem
    // public void registerItem(MaterialItem item) {
    // GameRegistry.registerItem(item, name + "_ingot");
    // }
    //
    // // TODO: make this return MaterialBlock
    // public void registerBlock(MaterialBlock block) {
    // GameRegistry.registerBlock(block, name + "_block");
    // }
    //
    // // TODO: make this return MaterialFluid
    // public void registerFluid(PowerOverhaulFluid fluid) {
    //
    // }
    //
    // public void registerOreBlock(MaterialOreBlock oreBlock) {
    // GameRegistry.registerBlock(oreBlock, name + "_ore_block");
    // }
    //
    // public void registerComponent(MaterialComponent component) {
    //
    // }

    public void register() {
        COMPONENTS.forEach(this::register);
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
