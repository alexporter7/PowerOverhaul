package com.alexporter7.poweroverhaul.blocks.engine;

import com.alexporter7.poweroverhaul.api.material.PowerOverhaulMaterial;
import com.alexporter7.poweroverhaul.init.ComponentDef;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class EngineBlock extends EngineComponentBlock {

    private final int CYLINDERS;

    public EngineBlock(PowerOverhaulMaterial material, int cylinders) {
        super(material, ComponentDef.ENGINE_BLOCK, material.getName() + "_engine_block_" + cylinders);
        CYLINDERS = cylinders;
        this.setBlockName(material.getName() + "_engine_block_" + cylinders);
    }

    public int getCylinders() {
        return CYLINDERS;
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new EngineBlockTileEntity(this.getPowerOverhaulMaterial(), this.getComponent(), CYLINDERS);
    }


}
