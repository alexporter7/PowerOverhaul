package com.alexporter7.poweroverhaul.fluid;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Items;
import net.minecraft.item.ItemBucket;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import com.alexporter7.poweroverhaul.PowerOverhaul;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class PowerOverhaulBucket extends ItemBucket {

    private IIcon bucketBase;
    private IIcon fluidOverlay;

    private int color;

    public PowerOverhaulBucket(Block block, int color) {
        super(block);
        this.setContainerItem(Items.bucket);
        this.maxStackSize = 1;
        this.color = color;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean requiresMultipleRenderPasses() {
        return true;
    }

    @Override
    public int getRenderPasses(int metadata) {
        return 2;
    }

    @Override
    public int getColorFromItemStack(ItemStack itemStack, int renderPass) {
        return switch (renderPass) {
            case 1 -> this.color;
            default -> 0x00FFFFFF;
        };
    }

    @Override
    public IIcon getIconFromDamageForRenderPass(int damage, int renderPass) {
        return (renderPass == 0) ? this.bucketBase : this.fluidOverlay;
    }

    @Override
    public void registerIcons(IIconRegister register) {
        this.bucketBase = register.registerIcon(PowerOverhaul.MODID + ":bucket_base");
        this.fluidOverlay = register.registerIcon(PowerOverhaul.MODID + ":bucket_fluid_textured");
    }
}
