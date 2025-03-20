package com.alexporter7.poweroverhaul.blocks.generators;

import java.util.Random;

import com.cleanroommc.modularui.factory.GuiFactories;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import com.alexporter7.poweroverhaul.PowerOverhaul;
import com.alexporter7.poweroverhaul.blocks.PowerOverhaulBlocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class DieselGeneratorBlock extends BlockContainer implements ITileEntityProvider {

    private final String unlocalizedName;

    @SideOnly(Side.CLIENT)
    private IIcon iconFront;

    public DieselGeneratorBlock() {
        super(Material.iron);
        this.unlocalizedName = "diesel_generator";
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new DieselGeneratorTileEntity();
    }

    @Override
    public Item getItemDropped(int meta, Random random, int fortune) {
        return Item.getItemFromBlock(PowerOverhaulBlocks.blocks.get(this.unlocalizedName));
    }

    @Override
    public void onBlockAdded(World world, int x, int y, int z) {
        super.onBlockAdded(world, x, y, z);
        this.setDefaultDirection(world, x, y, z);
    }

    private void setDefaultDirection(World world, int x, int y, int z) {
        if (!world.isRemote) {
            byte b0 = 3;
            world.setBlockMetadataWithNotify(x, y, z, b0, 2);
        }
    }

    // TODO: onBlockActivated
    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float subX,
        float subY, float subZ) {
        // return super.onBlockActivated(world, x, y, z, player, side, subX, subY, subZ);
        if (!world.isRemote) {
            GuiFactories.tileEntity().open(player, x, y, z);
        }
        return true;
    }

    // TODO: Random display tick

    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase placer, ItemStack itemStack) {
        // super.onBlockPlacedBy(world, x, y, z, placer, itemIn);

    }

    @Override
    public String getUnlocalizedName() {
        return this.unlocalizedName;
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        this.blockIcon = iconRegister.registerIcon(PowerOverhaul.MODID + ":diesel_generator_side");
        this.iconFront = iconRegister.registerIcon(PowerOverhaul.MODID + ":diesel_generator_front");
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int metadata) {
        return (side == 3) ? this.iconFront : this.blockIcon;
    }

}
