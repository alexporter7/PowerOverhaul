package com.alexporter7.poweroverhaul.blocks.engine;

import com.alexporter7.poweroverhaul.api.material.MaterialUtil;
import com.alexporter7.poweroverhaul.api.material.PowerOverhaulMaterial;
import com.alexporter7.poweroverhaul.blocks.meta.MetaEngineComponentTE;

public class EngineHeadTileEntity extends MetaEngineComponentTE {

    public EngineHeadTileEntity(PowerOverhaulMaterial material, MaterialUtil.Component component, int cylinders) {
        super(material, component, cylinders);
    }
}
