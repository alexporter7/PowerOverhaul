package com.alexporter7.poweroverhaul.blocks.machines;

import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.alexporter7.poweroverhaul.blocks.meta.MetaCustomRenderBlock;

public class AlloySmelterBlock extends MetaCustomRenderBlock {

    public AlloySmelterBlock() {
        super(Material.iron);
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new AlloySmelterTileEntity();
    }

}
