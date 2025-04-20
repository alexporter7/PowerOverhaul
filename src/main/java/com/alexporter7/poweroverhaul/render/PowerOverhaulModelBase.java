package com.alexporter7.poweroverhaul.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class PowerOverhaulModelBase extends ModelBase {

    public PowerOverhaulModelBase() {
        this.textureWidth = 128;
        this.textureHeight = 128;
    }

    public void renderModel(float f5) {

    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z, Entity entity) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }

    @Override
    public void render(Entity entity, float f1, float f2, float f3, float f4, float f5, float f6) {
        super.render(entity, f1, f2, f3, f4, f5, f6);
    }

    @Override
    public void setRotationAngles(float f1, float f2, float f3, float f4, float f5, float f6, Entity entity) {
        super.setRotationAngles(f1, f2, f3, f4, f5, f6, entity);
    }
}
