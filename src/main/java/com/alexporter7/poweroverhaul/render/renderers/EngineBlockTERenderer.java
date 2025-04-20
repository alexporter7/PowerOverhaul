package com.alexporter7.poweroverhaul.render.renderers;

import com.alexporter7.poweroverhaul.blocks.engine.EngineBlockTileEntity;
import com.alexporter7.poweroverhaul.blocks.models.engine.EngineBlock4Model;
import com.alexporter7.poweroverhaul.blocks.models.engine.EngineBlock6Model;
import com.alexporter7.poweroverhaul.blocks.models.engine.EngineBlock8Model;
import com.alexporter7.poweroverhaul.render.PowerOverhaulModelBase;
import com.alexporter7.poweroverhaul.util.ModelManager;
import com.alexporter7.poweroverhaul.util.RenderUtil;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

import java.awt.*;

public class EngineBlockTERenderer extends TileEntitySpecialRenderer {

    private final EngineBlock4Model engineBlock4Model = new EngineBlock4Model();
    private final EngineBlock6Model engineBlock6Model = new EngineBlock6Model();
    private final EngineBlock8Model engineBlock8Model = new EngineBlock8Model();

    @Override
    public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float f) {
        EngineBlockTileEntity engineBlockTileEntity = (EngineBlockTileEntity) tileEntity;
        Color tintColor = new Color(engineBlockTileEntity.getPowerOverhaulMaterial().getColor());

        float[] coordinates = RenderUtil.getCorrectedTranslateFloats(x, y, z);

        GL11.glPushMatrix();
        GL11.glTranslatef(coordinates[0], coordinates[1], coordinates[2]);
        GL11.glRotatef(180, 0f, 0f, 1f);

        this.bindTexture(getTexture(engineBlockTileEntity));
        GL11.glColor4f(RenderUtil.getFloatColorFromInt(tintColor.getRed()),
            RenderUtil.getFloatColorFromInt(tintColor.getGreen()),
            RenderUtil.getFloatColorFromInt(tintColor.getBlue()),
            0.25f);
        GL11.glPushMatrix();
        this.getModel(engineBlockTileEntity).renderModel(0.0625f);
        GL11.glPopMatrix();

        GL11.glPopMatrix();
    }

    public ResourceLocation getTexture(EngineBlockTileEntity tileEntity) {
        return switch (tileEntity.getCylinders()) {
            case 6 -> ModelManager.Texture.ENGINE_BLOCK_6.getResourceLocation();
            case 8 -> ModelManager.Texture.ENGINE_BLOCK_8.getResourceLocation();
            default -> ModelManager.Texture.ENGINE_BLOCK_4.getResourceLocation();
        };
    }

    public PowerOverhaulModelBase getModel(EngineBlockTileEntity tileEntity) {
        return switch (tileEntity.getCylinders()) {
            case 6 -> engineBlock6Model;
            case 8 -> engineBlock8Model;
            default -> engineBlock4Model;
        };
    }
}
