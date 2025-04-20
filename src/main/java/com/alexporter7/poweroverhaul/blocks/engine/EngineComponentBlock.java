package com.alexporter7.poweroverhaul.blocks.engine;

import com.alexporter7.poweroverhaul.PowerOverhaul;
import com.alexporter7.poweroverhaul.api.material.IMaterial;
import com.alexporter7.poweroverhaul.api.material.MaterialUtil;
import com.alexporter7.poweroverhaul.api.material.PowerOverhaulMaterial;
import com.alexporter7.poweroverhaul.blocks.meta.MetaCustomRenderBlock;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.world.IBlockAccess;

public class EngineComponentBlock extends MetaCustomRenderBlock implements IMaterial {

    public final String INTERNAL_BLOCK_NAME;
    private final PowerOverhaulMaterial MATERIAL;
    private final MaterialUtil.Component COMPONENT;

    public EngineComponentBlock(PowerOverhaulMaterial material, MaterialUtil.Component component, String internalBlockName) {
        super(Material.iron);
        MATERIAL = material;
        COMPONENT = component;
        INTERNAL_BLOCK_NAME = internalBlockName;
    }

    public String getBlockName() {
        return INTERNAL_BLOCK_NAME;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getRenderColor(int meta) {
        return this.getColor();
    }

    @Override
    public int colorMultiplier(IBlockAccess worldIn, int x, int y, int z) {
        return this.getColor();
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
