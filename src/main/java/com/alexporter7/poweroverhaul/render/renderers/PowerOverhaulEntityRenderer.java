package com.alexporter7.poweroverhaul.render.renderers;

import com.alexporter7.poweroverhaul.render.PowerOverhaulModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

public class PowerOverhaulEntityRenderer<T extends EntityLiving> extends RenderLiving {

    private final PowerOverhaulModelBase MODEL;
    private final ResourceLocation ENTITY_TEXTURE;

    public PowerOverhaulEntityRenderer(PowerOverhaulModelBase model, ResourceLocation entityTexture, float f1) {
        super(model, f1);
        MODEL = model;
        ENTITY_TEXTURE = entityTexture;
    }

    public void renderEntityModel(T entity, double x, double y, double z, float u, float v) {
        super.doRender(entity, x, y, z, u, v);
    }

    public void doRenderLiving(EntityLiving entityLiving, double x, double y, double z, float u, float v) {
        renderEntityModel((T) entityLiving, x, y, z, u, v);
    }

    @Override
    public void doRender(Entity entity, double x, double y, double z, float u, float v) {
        renderEntityModel((T) entity, x, y, z, u, v);
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity p_110775_1_) {
        return ENTITY_TEXTURE;
    }
}
