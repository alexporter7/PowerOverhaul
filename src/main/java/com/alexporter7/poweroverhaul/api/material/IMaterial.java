package com.alexporter7.poweroverhaul.api.material;

public interface IMaterial {

    /**
     * Get the PowerOverhaulMaterial associated with this class
     *
     * @return PowerOverhaulMaterial
     */
    PowerOverhaulMaterial getPowerOverhaulMaterial();

    Component getComponent();

    ComponentType getComponentType();

    String getMaterialName();

    int getWeight();

    int getHardness();

    int getMeltingPoint();

    int getColor();
}
