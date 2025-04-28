package com.alexporter7.poweroverhaul.blocks;

import com.alexporter7.poweroverhaul.api.material.*;
import com.alexporter7.poweroverhaul.api.model.ICustomModel;
import com.alexporter7.poweroverhaul.api.model.RenderedBlockModel;
import com.alexporter7.poweroverhaul.blocks.meta.MetaPowerOverhaulTEBase;
import com.alexporter7.poweroverhaul.render.PowerOverhaulModelBase;

public class MaterialRenderedTileEntity extends MetaPowerOverhaulTEBase implements IMaterial, ICustomModel {

    protected final PowerOverhaulMaterial MATERIAL;
    protected final Component COMPONENT;

    public MaterialRenderedTileEntity(PowerOverhaulMaterial material, Component component) {
        MATERIAL = material;
        COMPONENT = component;
    }

    @Override
    public PowerOverhaulMaterial getPowerOverhaulMaterial() {
        return MATERIAL;
    }

    @Override
    public Component getComponent() {
        return COMPONENT;
    }

    @Override
    public ComponentType getComponentType() {
        return COMPONENT.getComponentType();
    }

    @Override
    public String getMaterialName() {
        return MATERIAL.getName();
    }

    @Override
    public int getWeight() {
        return MATERIAL.getWeight();
    }

    @Override
    public int getHardness() {
        return MATERIAL.getHardness();
    }

    @Override
    public int getMeltingPoint() {
        return MATERIAL.getMeltingPoint();
    }

    @Override
    public int getColor() {
        return MATERIAL.getColor();
    }

    @Override
    public RenderedBlockModel<PowerOverhaulModelBase> getRenderedBlockModel() {
        return null;
    }
}
