package com.alexporter7.poweroverhaul.items.engines;

import com.alexporter7.poweroverhaul.api.material.MaterialUtil;
import com.alexporter7.poweroverhaul.items.components.ComponentMaterial;

public class EngineProperties {

    private int torque;
    private int maxRpm;
    private int horsepower;
    private ComponentMaterial piston;
    private ComponentMaterial engineBlock;
    private ComponentMaterial engineHead;

    public EngineProperties(ComponentMaterial piston, ComponentMaterial engineBlock, ComponentMaterial engineHead,
        int torque, int maxRpm, int horsepower) {
        this.piston = piston;
        this.engineBlock = engineBlock;
        this.engineHead = engineHead;
        this.torque = torque;
        this.maxRpm = maxRpm;
        this.horsepower = horsepower;
    }

    public ComponentMaterial getComponentMaterial(MaterialUtil.Component componentType) {
        return switch (componentType) {
            case ENGINE_PISTON -> this.piston;
            case ENGINE_BLOCK -> this.engineBlock;
            case ENGINE_HEAD -> this.engineHead;
            default -> throw new IllegalStateException("Unexpected value: " + componentType);
        };
    }

    public int getTorque() {
        return torque;
    }

    public int getMaxRpm() {
        return maxRpm;
    }

    public int getHorsepower() {
        return horsepower;
    }
}
