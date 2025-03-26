package com.alexporter7.poweroverhaul.blocks.generators;

import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.alexporter7.poweroverhaul.blocks.meta.MetaCustomRenderBlock;
import com.cleanroommc.modularui.factory.GuiFactories;

public class DieselGeneratorBlock extends MetaCustomRenderBlock {

    public DieselGeneratorBlock() {
        super(Material.iron);
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new DieselGeneratorTileEntity();
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float subX,
        float subY, float subZ) {
        if (!world.isRemote) {
            GuiFactories.tileEntity()
                .open(player, x, y, z);
        }
        return true;
    }

}
