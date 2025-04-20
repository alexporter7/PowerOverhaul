package com.alexporter7.poweroverhaul.api.material;

import java.util.HashSet;

public class PowerOverhaulMaterial {

    private final String name;

    /* Material Properties */
    private final int weight;
    private final int hardness;
    private final int meltingPoint;
    private final int color;

    private final HashSet<MaterialUtil.Component> COMPONENTS;

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
