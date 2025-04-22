package com.alexporter7.poweroverhaul.blocks;

import com.alexporter7.poweroverhaul.api.material.IMaterial;
import com.alexporter7.poweroverhaul.api.material.MaterialUtil;
import com.alexporter7.poweroverhaul.api.material.PowerOverhaulMaterial;
import com.alexporter7.poweroverhaul.api.model.ICustomModel;
import com.alexporter7.poweroverhaul.blocks.meta.MetaPowerOverhaulTEBase;
import com.alexporter7.poweroverhaul.render.PowerOverhaulModelBase;
import net.minecraft.util.ResourceLocation;

public class MaterialRenderedTileEntity extends MetaPowerOverhaulTEBase implements IMaterial, ICustomModel {

    protected final PowerOverhaulMaterial MATERIAL;
    protected final MaterialUtil.Component COMPONENT;

    public MaterialRenderedTileEntity(PowerOverhaulMaterial material, MaterialUtil.Component component) {
        MATERIAL = material;
        COMPONENT = component;
    }

    @Override
    public PowerOverhaulMaterial getPowerOverhaulMaterial() {
        return MATERIAL;
    }

    @Override
    public MaterialUtil.Component getComponent() {
        return COMPONENT;
    }

    @Override
    public MaterialUtil.Type getComponentType() {
        return COMPONENT.TYPE;
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
    public PowerOverhaulModelBase getModel() {
        return null;
    }

    @Override
    public ResourceLocation getTexture() {
        return null;
    }
}
