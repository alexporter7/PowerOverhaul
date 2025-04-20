package com.alexporter7.poweroverhaul.util;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import com.alexporter7.poweroverhaul.PowerOverhaul;
import com.alexporter7.poweroverhaul.blocks.meta.MetaPowerOverhaulBlock;
import com.cleanroommc.modularui.factory.GuiFactories;

public class TestGuiBlock extends MetaPowerOverhaulBlock {

    public TestGuiBlock() {
        super(Material.iron);
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TestTileGui();
    }

    @Override
    public boolean onBlockActivated(World worldIn, int x, int y, int z, EntityPlayer player, int side, float subX,
        float subY, float subZ) {
        if (!worldIn.isRemote) {
            GuiFactories.tileEntity()
                .open(player, x, y, z);
        }
        return true;
    }

    @Override
    public void registerBlockIcons(IIconRegister reg) {
        this.blockIcon = reg.registerIcon(PowerOverhaul.MODID + ":test_gui");
    }

    @Override
    public IIcon getIcon(int side, int metadata) {
        return this.blockIcon;
    }
}
