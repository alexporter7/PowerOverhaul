package com.alexporter7.poweroverhaul.api.material;

public class MaterialBuilder {

    /* Static Properties */
    public String name;

    public int weight;
    public int hardness;
    public int meltingPoint;
    public int color;

    public boolean hasBlock = true;
    public boolean hasIngot = true;
    public boolean hasMolten = true;

    public MaterialBuilder() {

    }

    public MaterialBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public MaterialBuilder setWeight(int weight) {
        this.weight = weight;
        return this;
    }

    public MaterialBuilder setHardness(int hardness) {
        this.hardness = hardness;
        return this;
    }

    public MaterialBuilder setMeltingPoint(int meltingPoint) {
        this.meltingPoint = meltingPoint;
        return this;
    }

    public MaterialBuilder setColor(int color) {
        this.color = color;
        return this;
    }

    public MaterialBuilder noBlock() {
        this.hasBlock = false;
        return this;
    }

    public MaterialBuilder noIngot() {
        this.hasIngot = false;
        return this;
    }

    public MaterialBuilder noMolten() {
        this.hasMolten = false;
        return this;
    }

}
