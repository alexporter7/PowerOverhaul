package com.alexporter7.poweroverhaul.render.renderers;

import java.awt.*;

import com.alexporter7.poweroverhaul.blocks.meta.MetaEngineComponentTE;
import com.alexporter7.poweroverhaul.blocks.models.engine.head.EngineHead4Model;
import com.alexporter7.poweroverhaul.blocks.models.engine.head.EngineHead6Model;
import com.alexporter7.poweroverhaul.blocks.models.engine.head.EngineHead8Model;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.alexporter7.poweroverhaul.blocks.engine.EngineBlockTileEntity;
import com.alexporter7.poweroverhaul.blocks.models.engine.block.EngineBlock4Model;
import com.alexporter7.poweroverhaul.blocks.models.engine.block.EngineBlock6Model;
import com.alexporter7.poweroverhaul.blocks.models.engine.block.EngineBlock8Model;
import com.alexporter7.poweroverhaul.render.PowerOverhaulModelBase;
import com.alexporter7.poweroverhaul.util.ModelManager;
import com.alexporter7.poweroverhaul.util.RenderUtil;

public class EngineComponentTERenderer extends TileEntitySpecialRenderer {

    private final EngineBlock4Model engineBlock4Model = new EngineBlock4Model();
    private final EngineBlock6Model engineBlock6Model = new EngineBlock6Model();
    private final EngineBlock8Model engineBlock8Model = new EngineBlock8Model();

    private final EngineHead4Model engineHead4Model = new EngineHead4Model();
    private final EngineHead6Model engineHead6Model = new EngineHead6Model();
    private final EngineHead8Model engineHead8Model = new EngineHead8Model();

    @Override
    public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float f) {
        MetaEngineComponentTE engineComponentTileEntity = (MetaEngineComponentTE) tileEntity;
        Color tintColor = new Color(
            engineComponentTileEntity.getPowerOverhaulMaterial()
                .getColor());

        float[] coordinates = RenderUtil.getCorrectedTranslateFloats(x, y, z);

        GL11.glPushMatrix();
        GL11.glTranslatef(coordinates[0], coordinates[1], coordinates[2]);
        GL11.glRotatef(180, 0f, 0f, 1f);

        this.bindTexture(getTexture(engineComponentTileEntity));
        GL11.glColor4f(
            RenderUtil.getFloatColorFromInt(tintColor.getRed()),
            RenderUtil.getFloatColorFromInt(tintColor.getGreen()),
            RenderUtil.getFloatColorFromInt(tintColor.getBlue()),
            0.25f);
        GL11.glPushMatrix();
        this.getModel(engineComponentTileEntity)
            .renderModel(0.0625f);
        GL11.glPopMatrix();

        GL11.glPopMatrix();
    }

    public ResourceLocation getTexture(MetaEngineComponentTE tileEntity) {
        return switch (tileEntity.getComponent()) {
            case ENGINE_BLOCK -> switch (tileEntity.getCylinders()) {
                case 6 -> ModelManager.Texture.ENGINE_BLOCK_6.getResourceLocation();
                case 8 -> ModelManager.Texture.ENGINE_BLOCK_8.getResourceLocation();
                default -> ModelManager.Texture.ENGINE_BLOCK_4.getResourceLocation();
            };
            case ENGINE_HEAD -> switch (tileEntity.getCylinders()) {
                case 6 -> ModelManager.Texture.ENGINE_HEAD_6.getResourceLocation();
                case 8 -> ModelManager.Texture.ENGINE_HEAD_8.getResourceLocation();
                default -> ModelManager.Texture.ENGINE_HEAD_4.getResourceLocation();
            };
            default -> null;
        };
    }

    public PowerOverhaulModelBase getModel(MetaEngineComponentTE tileEntity) {
        return switch (tileEntity.getComponent()) {
            case ENGINE_BLOCK -> switch (tileEntity.getCylinders()) {
                case 6 -> engineBlock6Model;
                case 8 -> engineBlock8Model;
                default -> engineBlock4Model;
            };
            case ENGINE_HEAD -> switch (tileEntity.getCylinders()) {
                case 6 -> engineHead6Model;
                case 8 -> engineHead8Model;
                default -> engineHead4Model;
            };
            default -> null;
        };
    }
}
