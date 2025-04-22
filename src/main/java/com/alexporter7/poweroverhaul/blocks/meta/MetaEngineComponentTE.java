package com.alexporter7.poweroverhaul.blocks.meta;

import com.alexporter7.poweroverhaul.api.material.MaterialUtil;
import com.alexporter7.poweroverhaul.api.material.PowerOverhaulMaterial;
import com.alexporter7.poweroverhaul.api.model.ICustomModel;
import com.alexporter7.poweroverhaul.blocks.MaterialRenderedTileEntity;
import com.alexporter7.poweroverhaul.render.PowerOverhaulModelBase;

public class MetaEngineComponentTE extends MaterialRenderedTileEntity{

    protected final int CYLINDERS;

    public MetaEngineComponentTE(PowerOverhaulMaterial material, MaterialUtil.Component component, int cylinders) {
        super(material, component);
        CYLINDERS = cylinders;
    }

    public int getCylinders() {
        return CYLINDERS;
    }

}
