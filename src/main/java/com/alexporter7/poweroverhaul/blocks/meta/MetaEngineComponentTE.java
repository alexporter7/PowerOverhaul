package com.alexporter7.poweroverhaul.blocks.meta;

import com.alexporter7.poweroverhaul.api.material.Component;
import com.alexporter7.poweroverhaul.api.material.PowerOverhaulMaterial;
import com.alexporter7.poweroverhaul.blocks.MaterialRenderedTileEntity;

public class MetaEngineComponentTE extends MaterialRenderedTileEntity {

    protected final int CYLINDERS;

    public MetaEngineComponentTE(PowerOverhaulMaterial material, Component component, int cylinders) {
        super(material, component);
        CYLINDERS = cylinders;
    }

    public int getCylinders() {
        return CYLINDERS;
    }

}
