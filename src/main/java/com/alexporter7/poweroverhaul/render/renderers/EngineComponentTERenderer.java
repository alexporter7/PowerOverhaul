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

        this.bindTexture(engineComponentTileEntity.getRenderedBlockModel().getTexture());
        GL11.glColor4f(
            RenderUtil.getFloatColorFromInt(tintColor.getRed()),
            RenderUtil.getFloatColorFromInt(tintColor.getGreen()),
            RenderUtil.getFloatColorFromInt(tintColor.getBlue()),
            0.25f);

        GL11.glPushMatrix();
        engineComponentTileEntity.getRenderedBlockModel().getModel().renderModel(0.0625f);
        GL11.glPopMatrix();

        GL11.glPopMatrix();
    }

}
