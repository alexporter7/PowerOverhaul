package com.alexporter7.poweroverhaul.api.material;

import java.util.function.BiConsumer;

public class ComponentType {

    private final BiConsumer<PowerOverhaulMaterial, Component> registerComponent;
    private final Enum<?> type;

    public ComponentType(Enum<?> type, BiConsumer<PowerOverhaulMaterial, Component> registration) {
        registerComponent = registration;
        this.type = type;
    }

    public void registerComponent(PowerOverhaulMaterial material, Component component) {
        registerComponent.accept(material, component);
    }

    public Enum<?> getType() {
        return type;
    }

}
