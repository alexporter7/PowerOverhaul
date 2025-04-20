package com.alexporter7.poweroverhaul.blocks.engine;

import com.alexporter7.poweroverhaul.api.material.MaterialUtil;
import com.alexporter7.poweroverhaul.api.material.PowerOverhaulMaterial;
import com.alexporter7.poweroverhaul.blocks.meta.MetaCustomRenderBlock;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class EngineBlock extends EngineComponentBlock {

    private final int CYLINDERS;

    public EngineBlock(PowerOverhaulMaterial material, int cylinders) {
        super(material,
            MaterialUtil.Component.ENGINE_BLOCK,
            material.getName() + "_engine_block_" + cylinders);
        CYLINDERS = cylinders;
        this.setBlockName(material.getName() + "_engine_block_" + cylinders);
    }

    public int getCylinders() {
        return CYLINDERS;
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
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new EngineBlockTileEntity(this.getPowerOverhaulMaterial(), CYLINDERS);
    }
}
