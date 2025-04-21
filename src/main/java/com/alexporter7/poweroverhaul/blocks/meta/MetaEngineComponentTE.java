package com.alexporter7.poweroverhaul.blocks.meta;

import com.alexporter7.poweroverhaul.api.material.MaterialUtil;
import com.alexporter7.poweroverhaul.api.material.PowerOverhaulMaterial;

public class MetaEngineComponentTE extends MetaPowerOverhaulTEBase {

    protected final PowerOverhaulMaterial MATERIAL;
    protected final MaterialUtil.Component COMPONENT;
    protected final int CYLINDERS;

    public MetaEngineComponentTE(PowerOverhaulMaterial material, MaterialUtil.Component component, int cylinders) {
        MATERIAL = material;
        COMPONENT = component;
        CYLINDERS = cylinders;
    }

    public int getCylinders() {
        return CYLINDERS;
    }

    public MaterialUtil.Component getComponent() {
        return COMPONENT;
    }

    public PowerOverhaulMaterial getPowerOverhaulMaterial() {
        return MATERIAL;
    }
}
