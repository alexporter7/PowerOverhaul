package com.alexporter7.poweroverhaul.render.renderers;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.alexporter7.poweroverhaul.render.PowerOverhaulModelBase;
import com.alexporter7.poweroverhaul.util.ModelManager;
import com.alexporter7.poweroverhaul.util.RenderUtil;

public class PowerOverhaulTEBlockRenderer extends TileEntitySpecialRenderer {

    private final PowerOverhaulModelBase model;
    private final ResourceLocation texture;

    public PowerOverhaulTEBlockRenderer(PowerOverhaulModelBase model, ModelManager.Texture texture) {
        this.model = model;
        this.texture = texture.getResourceLocation();
    }

    @Override
    public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float f) {
        float[] coordinates = RenderUtil.getCorrectedTranslateFloats(x, y, z);

        GL11.glPushMatrix();
        GL11.glTranslatef(coordinates[0], coordinates[1], coordinates[2]);
        GL11.glRotatef(180, 0f, 0f, 1f);

        this.bindTexture(texture);

        GL11.glPushMatrix();
        this.model.renderModel(0.0625f);
        GL11.glPopMatrix();

        GL11.glPopMatrix();
    }
}
