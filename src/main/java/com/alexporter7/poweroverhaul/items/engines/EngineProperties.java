package com.alexporter7.poweroverhaul.items.engines;

import java.util.Arrays;
import java.util.List;

import com.alexporter7.poweroverhaul.items.components.ComponentMaterial;
import com.alexporter7.poweroverhaul.items.components.EngineComponentItem;

public class EngineProperties {

    private int torque;
    private int maxRpm;
    private int horsepower;
    private List<ComponentMaterial> components;

    public EngineProperties(ComponentMaterial piston, ComponentMaterial engineBlock, ComponentMaterial engineHead) {
        this.components.addAll(Arrays.asList(piston, engineBlock, engineHead));
    }

    public ComponentMaterial getComponentMaterial(EngineComponentItem.ComponentType componentType) {
        return switch (componentType) {
            case PISTON -> this.components.get(0);
            case BLOCK -> this.components.get(1);
            case HEAD -> this.components.get(2);
        };
    }
}
