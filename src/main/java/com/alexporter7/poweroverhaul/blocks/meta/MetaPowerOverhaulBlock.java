package com.alexporter7.poweroverhaul.blocks.meta;

import java.util.Random;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import com.alexporter7.poweroverhaul.PowerOverhaul;
import com.alexporter7.poweroverhaul.blocks.PowerOverhaulBlocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class MetaPowerOverhaulBlock extends BlockContainer implements ITileEntityProvider {

    public MetaPowerOverhaulBlock(Material material) {
        super(material);
        this.setCreativeTab(PowerOverhaul.powerOverhaulTab);
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return null;
    }

    @Override
    public int getRenderType() {
        return super.getRenderType();
    }

    @Override
    public Item getItemDropped(int meta, Random random, int fortune) {
        return Item.getItemFromBlock(PowerOverhaulBlocks.blocks.get(this.getUnlocalizedName()));
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int metadata) {
        return this.blockIcon;
    }

    @Override
    public void onBlockAdded(World world, int x, int y, int z) {
        super.onBlockAdded(world, x, y, z);
        this.setDefaultDirection(world, x, y, z);
    }

    public void setDefaultDirection(World world, int x, int y, int z) {
        if (!world.isRemote) {
            byte b0 = 3;
            world.setBlockMetadataWithNotify(x, y, z, b0, 2);
        }
    }
}
