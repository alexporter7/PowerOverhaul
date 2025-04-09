package com.alexporter7.poweroverhaul.blocks;

import com.alexporter7.poweroverhaul.PowerOverhaul;
import com.alexporter7.poweroverhaul.api.material.PowerOverhaulMaterial;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.world.IBlockAccess;

public class MaterialOreBlock extends MaterialBlock {

    public MaterialOreBlock(PowerOverhaulMaterial material) {
        super(material);
    }

    @Override
    public String getBlockName() {
        return this.material.getName() + "_ore_block";
    }

    @Override
    public int getRenderColor(int meta) {
        return 0xFFFFFF;
    }

    @Override
    public int colorMultiplier(IBlockAccess worldIn, int x, int y, int z) {
        return 0xFFFFFF;
    }

    //TODO: add in material builder if you want shiny or dull ore
    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        this.blockIcon = iconRegister
            .registerIcon(PowerOverhaul.MODID + ":ores/" + this.material.getName() + "_ore_block");

    }

}
