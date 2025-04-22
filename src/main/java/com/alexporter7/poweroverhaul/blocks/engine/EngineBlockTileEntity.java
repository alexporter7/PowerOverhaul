package com.alexporter7.poweroverhaul.blocks.engine;

import com.alexporter7.poweroverhaul.api.material.MaterialUtil;
import com.alexporter7.poweroverhaul.api.material.PowerOverhaulMaterial;
import com.alexporter7.poweroverhaul.blocks.meta.MetaEngineComponentTE;
import com.alexporter7.poweroverhaul.blocks.meta.MetaPowerOverhaulTEBase;
import com.alexporter7.poweroverhaul.blocks.models.engine.block.EngineBlock4Model;
import com.alexporter7.poweroverhaul.blocks.models.engine.block.EngineBlock6Model;
import com.alexporter7.poweroverhaul.blocks.models.engine.block.EngineBlock8Model;
import com.alexporter7.poweroverhaul.render.PowerOverhaulModelBase;

public class EngineBlockTileEntity extends MetaEngineComponentTE {

    public EngineBlockTileEntity(PowerOverhaulMaterial material, MaterialUtil.Component component, int cylinders) {
        super(material, component, cylinders);
    }

    @Override
    public PowerOverhaulModelBase getModel() {
        return switch (CYLINDERS) {
            case 6 -> new EngineBlock4Model();
            case 8 -> new EngineBlock6Model();
            default -> new EngineBlock8Model();
        };
    }
}
