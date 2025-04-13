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
    public void render(Entity p_78088_1_, float p_78088_2_, float p_78088_3_, float p_78088_4_, float p_78088_5_,
        float p_78088_6_, float p_78088_7_) {
        super.render(p_78088_1_, p_78088_2_, p_78088_3_, p_78088_4_, p_78088_5_, p_78088_6_, p_78088_7_);
    }

    @Override
    public void setRotationAngles(float f1, float f2, float f3, float f4,
        float f5, float f6, Entity entity) {
        super.setRotationAngles(f1, f2, f3, f4, f5, f6, entity);
    }
}
