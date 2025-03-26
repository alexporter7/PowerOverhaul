package com.alexporter7.poweroverhaul.blocks.models;
// Made with Blockbench 4.12.3
// Exported for Minecraft version 1.7 - 1.12
// Paste this class into your mod and generate all required imports

import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

import com.alexporter7.poweroverhaul.render.PowerOverhaulModelBase;

public class DieselGeneratorModel extends PowerOverhaulModelBase {

    private final ModelRenderer exhaust;
    private final ModelRenderer controlPanel;
    private final ModelRenderer base;
    private final ModelRenderer decorative;
    private final ModelRenderer plug1;
    private final ModelRenderer plug2;
    private final ModelRenderer fluids;
    private final ModelRenderer bone;

    public DieselGeneratorModel() {
        textureWidth = 128;
        textureHeight = 128;

        exhaust = new ModelRenderer(this);
        exhaust.setRotationPoint(8.0F, 24.0F, -8.0F);
        exhaust.cubeList.add(new ModelBox(exhaust, 0, 24, -15.0F, -13.0F, 1.0F, 14, 2, 8, 0.0F));
        exhaust.cubeList.add(new ModelBox(exhaust, 44, 24, -15.0F, -13.0F, 15.0F, 14, 2, 1, 0.0F));
        exhaust.cubeList.add(new ModelBox(exhaust, 58, 51, -4.0F, -12.0F, 9.0F, 1, 1, 6, 0.0F));
        exhaust.cubeList.add(new ModelBox(exhaust, 58, 58, -6.0F, -12.0F, 9.0F, 1, 1, 6, 0.0F));
        exhaust.cubeList.add(new ModelBox(exhaust, 0, 51, -9.0F, -12.0F, 9.0F, 2, 1, 6, 0.0F));
        exhaust.cubeList.add(new ModelBox(exhaust, 14, 59, -11.0F, -12.0F, 9.0F, 1, 1, 6, 0.0F));
        exhaust.cubeList.add(new ModelBox(exhaust, 28, 59, -13.0F, -12.0F, 9.0F, 1, 1, 6, 0.0F));
        exhaust.cubeList.add(new ModelBox(exhaust, 50, 6, -3.0F, -13.0F, 9.0F, 2, 2, 6, 0.0F));
        exhaust.cubeList.add(new ModelBox(exhaust, 16, 51, -5.0F, -13.0F, 9.0F, 1, 2, 6, 0.0F));
        exhaust.cubeList.add(new ModelBox(exhaust, 30, 51, -7.0F, -13.0F, 9.0F, 1, 2, 6, 0.0F));
        exhaust.cubeList.add(new ModelBox(exhaust, 44, 51, -10.0F, -13.0F, 9.0F, 1, 2, 6, 0.0F));
        exhaust.cubeList.add(new ModelBox(exhaust, 0, 58, -12.0F, -13.0F, 9.0F, 1, 2, 6, 0.0F));
        exhaust.cubeList.add(new ModelBox(exhaust, 50, 14, -15.0F, -13.0F, 9.0F, 2, 2, 6, 0.0F));

        controlPanel = new ModelRenderer(this);
        controlPanel.setRotationPoint(5.0F, 19.0F, -8.0F);
        controlPanel.cubeList.add(new ModelBox(controlPanel, 50, 0, -10.0F, -5.0F, 1.0F, 10, 5, 1, 0.0F));
        controlPanel.cubeList.add(new ModelBox(controlPanel, 64, 48, -9.0F, -4.0F, 0.0F, 1, 2, 1, 0.0F));
        controlPanel.cubeList.add(new ModelBox(controlPanel, 62, 65, -7.0F, -4.0F, 0.0F, 1, 2, 1, 0.0F));
        controlPanel.cubeList.add(new ModelBox(controlPanel, 0, 66, -5.0F, -4.0F, 0.0F, 1, 2, 1, 0.0F));
        controlPanel.cubeList.add(new ModelBox(controlPanel, 64, 39, -3.0F, -4.0F, 0.0F, 2, 3, 1, 0.0F));

        base = new ModelRenderer(this);
        base.setRotationPoint(0.0F, 16.0F, 0.0F);
        base.cubeList.add(new ModelBox(base, 0, 34, 6.0F, 6.0F, -7.0F, 1, 2, 15, 0.0F));
        base.cubeList.add(new ModelBox(base, 32, 34, -7.0F, 6.0F, -7.0F, 1, 2, 15, 0.0F));
        base.cubeList.add(new ModelBox(base, 44, 27, -6.0F, 6.0F, -7.0F, 12, 2, 1, 0.0F));
        base.cubeList.add(new ModelBox(base, 44, 30, -6.0F, 6.0F, 7.0F, 12, 2, 1, 0.0F));

        decorative = new ModelRenderer(this);
        decorative.setRotationPoint(6.0F, 24.0F, 7.0F);

        plug1 = new ModelRenderer(this);
        plug1.setRotationPoint(0.0F, 0.0F, 0.0F);
        decorative.addChild(plug1);
        plug1.cubeList.add(new ModelBox(plug1, 64, 43, 0.0F, -10.0F, -12.0F, 1, 4, 1, 0.0F));
        plug1.cubeList.add(new ModelBox(plug1, 42, 65, 0.0F, -10.0F, -10.0F, 1, 4, 1, 0.0F));
        plug1.cubeList.add(new ModelBox(plug1, 46, 65, 0.0F, -10.0F, -8.0F, 1, 4, 1, 0.0F));
        plug1.cubeList.add(new ModelBox(plug1, 50, 22, 0.0F, -7.0F, -11.0F, 1, 1, 1, 0.0F));
        plug1.cubeList.add(new ModelBox(plug1, 54, 22, 0.0F, -7.0F, -9.0F, 1, 1, 1, 0.0F));
        plug1.cubeList.add(new ModelBox(plug1, 58, 22, 0.0F, -10.0F, -11.0F, 1, 1, 1, 0.0F));
        plug1.cubeList.add(new ModelBox(plug1, 62, 22, 0.0F, -10.0F, -9.0F, 1, 1, 1, 0.0F));

        plug2 = new ModelRenderer(this);
        plug2.setRotationPoint(0.0F, 0.0F, 0.0F);
        decorative.addChild(plug2);
        plug2.cubeList.add(new ModelBox(plug2, 50, 65, 0.0F, -10.0F, -6.0F, 1, 4, 1, 0.0F));
        plug2.cubeList.add(new ModelBox(plug2, 54, 65, 0.0F, -10.0F, -4.0F, 1, 4, 1, 0.0F));
        plug2.cubeList.add(new ModelBox(plug2, 58, 65, 0.0F, -10.0F, -2.0F, 1, 4, 1, 0.0F));
        plug2.cubeList.add(new ModelBox(plug2, 4, 66, 0.0F, -7.0F, -5.0F, 1, 1, 1, 0.0F));
        plug2.cubeList.add(new ModelBox(plug2, 66, 6, 0.0F, -7.0F, -3.0F, 1, 1, 1, 0.0F));
        plug2.cubeList.add(new ModelBox(plug2, 8, 66, 0.0F, -10.0F, -5.0F, 1, 1, 1, 0.0F));
        plug2.cubeList.add(new ModelBox(plug2, 66, 8, 0.0F, -10.0F, -3.0F, 1, 1, 1, 0.0F));

        fluids = new ModelRenderer(this);
        fluids.setRotationPoint(0.0F, 0.0F, 0.0F);
        decorative.addChild(fluids);
        fluids.cubeList.add(new ModelBox(fluids, 42, 59, -13.0F, -10.0F, -4.0F, 1, 3, 3, 0.0F));
        fluids.cubeList.add(new ModelBox(fluids, 50, 59, -13.0F, -10.0F, -12.0F, 1, 3, 3, 0.0F));
        fluids.cubeList.add(new ModelBox(fluids, 64, 33, -13.0F, -10.0F, -8.0F, 1, 3, 3, 0.0F));

        bone = new ModelRenderer(this);
        bone.setRotationPoint(8.0F, 24.0F, -8.0F);
        bone.cubeList.add(new ModelBox(bone, 0, 0, -14.0F, -11.0F, 2.0F, 12, 11, 13, 0.0F));
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        exhaust.render(f5);
        controlPanel.render(f5);
        base.render(f5);
        decorative.render(f5);
        bone.render(f5);
    }

    @Override
    public void renderModel(float f5) {
        exhaust.render(f5);
        controlPanel.render(f5);
        base.render(f5);
        decorative.render(f5);
        bone.render(f5);
    }

    @Override
    public void setRotationAngles(float p_78087_1_, float p_78087_2_, float p_78087_3_, float p_78087_4_,
        float p_78087_5_, float p_78087_6_, Entity p_78087_7_) {
        super.setRotationAngles(p_78087_1_, p_78087_2_, p_78087_3_, p_78087_4_, p_78087_5_, p_78087_6_, p_78087_7_);
    }

    // public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z, Entity entity) {
    // modelRenderer.rotateAngleX = x;
    // modelRenderer.rotateAngleY = y;
    // modelRenderer.rotateAngleZ = z;
    // }
}
