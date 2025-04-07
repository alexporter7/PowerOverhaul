package com.alexporter7.poweroverhaul.api.material;

import com.alexporter7.poweroverhaul.items.MaterialItem;

public class PowerOverhaulMaterial {

    private final int weight;
    private final int hardness;
    private final int meltingPoint;

    private final boolean hasBlock;
    private final boolean hasIngot;
    private final boolean hasMolten;

    public PowerOverhaulMaterial(MaterialBuilder builder) {
        weight = builder.weight;
        hardness = builder.hardness;
        meltingPoint = builder.meltingPoint;
        hasBlock = builder.hasBlock;
        hasIngot = builder.hasIngot;
        hasMolten = builder.hasMolten;
    }

    //TODO: make this return MaterialItem
    public void registerIngot() {
        //maybe hook into materialItem hashset in item class and add entry there after def
    }

    //TODO: make this return MaterialBlock
    public void registerBlock() {

    }

    //TODO: make this return MaterialFluid
    public void registerMolten() {

    }

    public void register() {
        //register everything here based on config
    }
}
