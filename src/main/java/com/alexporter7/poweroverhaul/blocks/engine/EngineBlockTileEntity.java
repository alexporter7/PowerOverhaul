package com.alexporter7.poweroverhaul.blocks.engine;

import com.alexporter7.poweroverhaul.api.material.PowerOverhaulMaterial;
import com.alexporter7.poweroverhaul.blocks.meta.MetaCustomRenderBlock;
import com.alexporter7.poweroverhaul.blocks.meta.MetaPowerOverhaulTEBase;

public class EngineBlockTileEntity extends MetaPowerOverhaulTEBase {

    private final PowerOverhaulMaterial MATERIAL;
    private final int CYLINDERS;

    public EngineBlockTileEntity(PowerOverhaulMaterial material, int cylinders) {
        MATERIAL = material;
        CYLINDERS = cylinders;
    }

    public int getCylinders() {
        return CYLINDERS;
    }

    public PowerOverhaulMaterial getPowerOverhaulMaterial() {
        return MATERIAL;
    }


}
