package com.alexporter7.poweroverhaul.api.material;

import java.util.HashSet;

public class PowerOverhaulMaterial {

    private final String name;

    /* Material Properties */
    private final int weight;
    private final int hardness;
    private final int meltingPoint;
    private final int color;

    private final HashSet<Component> COMPONENTS;

    public PowerOverhaulMaterial(MaterialBuilder builder) {
        name = builder.name;
        weight = builder.weight;
        hardness = builder.hardness;
        meltingPoint = builder.meltingPoint;
        color = builder.color;

        COMPONENTS = builder.components;
    }

    public void register(Component component) {
        component.registerComponent(this);
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
