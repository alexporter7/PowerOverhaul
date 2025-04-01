package com.alexporter7.poweroverhaul.fluid;

import com.alexporter7.poweroverhaul.PowerOverhaul;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.BlockFluidFinite;
import net.minecraftforge.fluids.Fluid;

public class PowerOverhaulFluidBlock extends BlockFluidClassic {

    @SideOnly(Side.CLIENT)
    private IIcon still;
    @SideOnly(Side.CLIENT)
    private IIcon flowing;

    private final PowerOverhaulFluid fluid;

    public PowerOverhaulFluidBlock(PowerOverhaulFluid fluid) {
        super(fluid, Material.water);
        this.fluid = fluid;
    }

    @Override
    public IIcon getIcon(int side, int meta) {
        return (side == 0 || side == 1)
            ? this.still
            : this.flowing;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister register) {

        this.still = register.registerIcon(this.fluid.getIconStill().toString());
        this.flowing = register.registerIcon(this.fluid.getIconFlowing().toString());
        this.fluid.setFluidIcons(this.still, this.flowing);

    }
}
