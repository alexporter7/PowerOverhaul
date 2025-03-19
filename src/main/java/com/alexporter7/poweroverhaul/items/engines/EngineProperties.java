package com.alexporter7.poweroverhaul.items.engines;

import com.alexporter7.poweroverhaul.items.components.ComponentMaterial;
import com.alexporter7.poweroverhaul.items.components.EngineComponentItem;

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

    public ComponentMaterial getComponentMaterial(EngineComponentItem.ComponentType componentType) {
        return switch (componentType) {
            case PISTON -> this.piston;
            case BLOCK -> this.engineBlock;
            case HEAD -> this.engineHead;
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
