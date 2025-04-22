package com.alexporter7.poweroverhaul.blocks;

import com.alexporter7.poweroverhaul.api.material.IMaterial;
import com.alexporter7.poweroverhaul.api.material.MaterialUtil;
import com.alexporter7.poweroverhaul.api.material.PowerOverhaulMaterial;
import com.alexporter7.poweroverhaul.blocks.meta.MetaCustomRenderBlock;
import net.minecraft.block.material.Material;

public class MaterialCustomRenderBlock extends MetaCustomRenderBlock implements IMaterial {

    private final PowerOverhaulMaterial MATERIAL;
    private final MaterialUtil.Component COMPONENT;
    public final String INTERNAL_BLOCK_NAME;

    public MaterialCustomRenderBlock(PowerOverhaulMaterial material, MaterialUtil.Component component,
                                     String internalBlockName) {
        super(Material.iron);
        MATERIAL = material;
        COMPONENT = component;
        INTERNAL_BLOCK_NAME = internalBlockName;
    }

    public String getBlockName() {
        return INTERNAL_BLOCK_NAME;
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
}
