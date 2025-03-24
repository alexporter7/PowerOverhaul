package com.alexporter7.poweroverhaul.render.blocks;

import com.alexporter7.poweroverhaul.blocks.models.DieselGeneratorModel;
import com.alexporter7.poweroverhaul.util.ModelManager;
import com.alexporter7.poweroverhaul.util.RenderUtil;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class DieselGeneratorRenderer extends TileEntitySpecialRenderer {

    private static final ResourceLocation texture = ModelManager.Texture.DIESEL_GENERATOR.getResourceLocation();
    private DieselGeneratorModel dieselGeneratorModel;

    public DieselGeneratorRenderer() {
        this.dieselGeneratorModel = new DieselGeneratorModel();
    }

    @Override
    public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float f) {
        float[] coordinates = RenderUtil.getCorrectedTranslateFloats(x, y, z);

        GL11.glPushMatrix();
        GL11.glTranslatef(coordinates[0], coordinates[1], coordinates[2]);
        GL11.glRotatef(180, 0f, 0f, 1f);

        this.bindTexture(texture);

        GL11.glPushMatrix();
        this.dieselGeneratorModel.renderModel(0.0625f);
        GL11.glPopMatrix();

        GL11.glPopMatrix();
    }
}
