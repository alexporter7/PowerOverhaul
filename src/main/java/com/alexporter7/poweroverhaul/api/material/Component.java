package com.alexporter7.poweroverhaul.api.material;

import com.alexporter7.poweroverhaul.util.PowerOverhaulUtil;

import java.util.function.Supplier;

public class Component {

    private final Enum<?> componentKey;
    private final ComponentType componentType;
    private Supplier<String> registryName;

    public Component(Enum<?> key, ComponentType componentType) {
        this.componentKey = key;
        this.componentType = componentType;
    }

    public Enum<?> getComponentKey() {
        return this.componentKey;
    }

    public Component addRegistryName(Supplier<String> registryName) {
        this.registryName = registryName;
        return this;
    }

    public void registerComponent(PowerOverhaulMaterial material) {
        componentType.registerComponent(material, this);
    }

    public String getRegistryName() {
        if(registryName != null)
            return registryName.get();
        return PowerOverhaulUtil.formatEnum(componentKey) + "_" + componentType.toString().toLowerCase();
    }

    public ComponentType getComponentType() {
        return componentType;
    }

}
