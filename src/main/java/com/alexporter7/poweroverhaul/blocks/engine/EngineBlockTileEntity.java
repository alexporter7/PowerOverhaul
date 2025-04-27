package com.alexporter7.poweroverhaul.blocks.engine;

import com.alexporter7.poweroverhaul.api.material.Component;
import com.alexporter7.poweroverhaul.api.material.MaterialUtil;
import com.alexporter7.poweroverhaul.api.material.PowerOverhaulMaterial;
import com.alexporter7.poweroverhaul.api.model.RenderedBlockModel;
import com.alexporter7.poweroverhaul.blocks.meta.MetaEngineComponentTE;
import com.alexporter7.poweroverhaul.util.ModelManager;

public class EngineBlockTileEntity extends MetaEngineComponentTE {

    public EngineBlockTileEntity(PowerOverhaulMaterial material, Component component, int cylinders) {
        super(material, component, cylinders);
    }

    @Override
    public RenderedBlockModel<?> getRenderedBlockModel() {
        return switch (CYLINDERS) {
            case 6 -> ModelManager.EngineBlock6;
            case 8 -> ModelManager.EngineBlock8;
            default -> ModelManager.EngineBlock4;
        };
    }
}
