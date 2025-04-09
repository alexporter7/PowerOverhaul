package com.alexporter7.poweroverhaul.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.world.IBlockAccess;

import com.alexporter7.poweroverhaul.PowerOverhaul;
import com.alexporter7.poweroverhaul.api.material.PowerOverhaulMaterial;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class MaterialBlock extends Block {

    protected final int color;
    protected final PowerOverhaulMaterial material;

    public MaterialBlock(PowerOverhaulMaterial material) {
        super(Material.iron);
        this.material = material;
        this.color = material.getColor();
        this.setBlockName(this.getBlockName());
    }

    public String getBlockName() {
        return this.material.getName() + "_block";
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getRenderColor(int meta) {
        return this.color;
    }

    @Override
    public int colorMultiplier(IBlockAccess worldIn, int x, int y, int z) {
        return this.color;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        this.blockIcon = iconRegister.registerIcon(PowerOverhaul.MODID + ":material_block_1");
    }
}
