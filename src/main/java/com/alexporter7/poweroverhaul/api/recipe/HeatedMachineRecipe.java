package com.alexporter7.poweroverhaul.api.recipe;

import com.alexporter7.poweroverhaul.items.MaterialItem;

import java.util.HashSet;

public class HeatedMachineRecipe {

    private final HashSet<MaterialItem> inputs = new HashSet<>();
    private final MaterialItem output;
    private final int requiredTemperature;
    private final int duration;

    //TODO: probably use a wrapper for energy
    private final int powerPerTick;

    public HeatedMachineRecipe(HashSet<MaterialItem> inputs, MaterialItem output,
                               int requiredTemperature, int duration, int powerPerTick) {
        this.inputs.addAll(inputs);
        this.output = output;
        this.requiredTemperature = requiredTemperature;
        this.duration = duration;
        this.powerPerTick = powerPerTick;
    }

    public HeatedMachineRecipe(Builder builder) {
        this.inputs.addAll(builder.inputs);
        this.output = builder.output;
        this.requiredTemperature = builder.requiredTemperature;
        this.duration = builder.duration;
        this.powerPerTick = builder.powerPerTick;
    }

    public HashSet<MaterialItem> getInputs() {
        return inputs;
    }

    public MaterialItem getOutput() {
        return output;
    }

    public int getRequiredTemperature() {
        return requiredTemperature;
    }

    public int getDuration() {
        return duration;
    }

    public int getPowerPerTick() {
        return powerPerTick;
    }

    public static class Builder {

        public HashSet<MaterialItem> inputs = new HashSet<>();
        public MaterialItem output;
        public int requiredTemperature;
        public int duration;
        public int powerPerTick;

        public Builder addInput(MaterialItem input) {
            this.inputs.add(input);
            return this;
        }

        public Builder setOutput(MaterialItem output) {
            this.output = output;
            return this;
        }

        public Builder setRequiredTemperature(int requiredTemperature) {
            this.requiredTemperature = requiredTemperature;
            return this;
        }

        public Builder setDuration(int duration) {
            this.duration = duration;
            return this;
        }

        public Builder setPowerPerTick(int powerPerTick) {
            this.powerPerTick = powerPerTick;
            return this;
        }
    }
}
