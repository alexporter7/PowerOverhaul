package com.alexporter7.poweroverhaul.blocks.engine;

import com.alexporter7.poweroverhaul.api.material.Component;
import com.alexporter7.poweroverhaul.api.material.MaterialUtil;
import com.alexporter7.poweroverhaul.api.material.PowerOverhaulMaterial;
import com.alexporter7.poweroverhaul.api.model.RenderedBlockModel;
import com.alexporter7.poweroverhaul.blocks.meta.MetaEngineComponentTE;
import com.alexporter7.poweroverhaul.render.PowerOverhaulModelBase;
import com.alexporter7.poweroverhaul.util.ModelManager;

public class EngineHeadTileEntity extends MetaEngineComponentTE {

    public EngineHeadTileEntity(PowerOverhaulMaterial material, Component component, int cylinders) {
        super(material, component, cylinders);
    }

    @Override
    public RenderedBlockModel<PowerOverhaulModelBase> getRenderedBlockModel() {
        return switch (CYLINDERS) {
            case 6 -> ModelManager.EngineHead6;
            case 8 -> ModelManager.EngineHead8;
            default -> ModelManager.EngineHead4;
        };
    }
}
