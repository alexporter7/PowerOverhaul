package com.alexporter7.poweroverhaul.render.renderers;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

public class PowerOverhaulItemRenderer implements IItemRenderer {

    private final TileEntitySpecialRenderer renderer;
    private final TileEntity tileEntity;

    public PowerOverhaulItemRenderer(TileEntitySpecialRenderer render, TileEntity tileEntity) {
        this.renderer = render;
        this.tileEntity = tileEntity;
    }

    @Override
    public boolean handleRenderType(ItemStack item, ItemRenderType type) {
        return true;
    }

    @Override
    public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
        return true;
    }

    @Override
    public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
        if (type == ItemRenderType.ENTITY) GL11.glTranslatef(-0.5f, 0.0f, -0.5f);
        this.renderer.renderTileEntityAt(this.tileEntity, 0.0, 0.0, 0.0, 0.0f);
    }
}
