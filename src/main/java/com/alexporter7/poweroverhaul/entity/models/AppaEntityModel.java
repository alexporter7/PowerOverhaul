package com.alexporter7.poweroverhaul.entity.models;

// Made with Blockbench 4.12.4
// Exported for Minecraft version 1.7 - 1.12
// Paste this class into your mod and generate all required imports


import com.alexporter7.poweroverhaul.render.PowerOverhaulModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class AppaEntityModel extends PowerOverhaulModelBase {
    private final ModelRenderer appa;
    private final ModelRenderer legs;
    private final ModelRenderer frontLeft;
    private final ModelRenderer frontRight;
    private final ModelRenderer backRight;
    private final ModelRenderer backLeft;
    private final ModelRenderer body;
    private final ModelRenderer head;
    private final ModelRenderer ears;
    private final ModelRenderer leftEarBone;
    private final ModelRenderer leftEar_r1;
    private final ModelRenderer rightEarBone;
    private final ModelRenderer rightEar_r1;
    private final ModelRenderer tail;
    private final ModelRenderer tailB_r1;
    private final ModelRenderer tailA_r1;

    public AppaEntityModel() {
        textureWidth = 128;
        textureHeight = 128;

        appa = new ModelRenderer(this);
        appa.setRotationPoint(0.0F, 24.0F, 0.0F);


        legs = new ModelRenderer(this);
        legs.setRotationPoint(0.0F, 0.0F, 0.0F);
        appa.addChild(legs);


        frontLeft = new ModelRenderer(this);
        frontLeft.setRotationPoint(-4.5F, -10.0F, -4.75F);
        legs.addChild(frontLeft);
        frontLeft.cubeList.add(new ModelBox(frontLeft, 40, 85, -1.5F, 0.0F, -1.25F, 3, 9, 3, 0.0F));
        frontLeft.cubeList.add(new ModelBox(frontLeft, 66, 57, -1.5F, 9.0F, -2.25F, 3, 1, 4, 0.0F));

        frontRight = new ModelRenderer(this);
        frontRight.setRotationPoint(4.5F, -10.0F, -4.75F);
        legs.addChild(frontRight);
        frontRight.cubeList.add(new ModelBox(frontRight, 58, 69, -1.5F, 0.0F, -1.25F, 3, 9, 3, 0.0F));
        frontRight.cubeList.add(new ModelBox(frontRight, 32, 74, -1.5F, 9.0F, -2.25F, 3, 1, 4, 0.0F));

        backRight = new ModelRenderer(this);
        backRight.setRotationPoint(4.5F, -10.0F, 12.25F);
        legs.addChild(backRight);
        backRight.cubeList.add(new ModelBox(backRight, 70, 69, -1.5F, 0.0F, -1.25F, 3, 9, 3, 0.0F));
        backRight.cubeList.add(new ModelBox(backRight, 76, 40, -1.5F, 9.0F, -2.25F, 3, 1, 4, 0.0F));

        backLeft = new ModelRenderer(this);
        backLeft.setRotationPoint(-4.5F, -10.0F, 12.25F);
        legs.addChild(backLeft);
        backLeft.cubeList.add(new ModelBox(backLeft, 0, 84, -1.5F, 0.0F, -1.25F, 3, 9, 3, 0.0F));
        backLeft.cubeList.add(new ModelBox(backLeft, 12, 78, -1.5F, 9.0F, -2.25F, 3, 1, 4, 0.0F));

        body = new ModelRenderer(this);
        body.setRotationPoint(0.0F, -3.0F, 0.0F);
        appa.addChild(body);
        body.cubeList.add(new ModelBox(body, 0, 28, -3.0F, -7.0F, -6.0F, 6, 2, 20, 0.0F));
        body.cubeList.add(new ModelBox(body, 34, 50, -2.0F, -5.0F, -6.0F, 4, 1, 12, 0.0F));
        body.cubeList.add(new ModelBox(body, 52, 28, -1.5F, -4.0F, -6.0F, 3, 1, 11, 0.0F));
        body.cubeList.add(new ModelBox(body, 0, 0, -6.0F, -15.0F, -6.0F, 12, 8, 20, 0.0F));

        head = new ModelRenderer(this);
        head.setRotationPoint(0.0F, -3.0F, 0.0F);
        appa.addChild(head);
        head.cubeList.add(new ModelBox(head, 64, 6, -3.0F, -19.0F, -9.0F, 7, 7, 3, 0.0F));
        head.cubeList.add(new ModelBox(head, 0, 50, -6.0F, -21.0F, -14.0F, 12, 11, 5, 0.0F));
        head.cubeList.add(new ModelBox(head, 59, 99, -5.0F, -20.0F, -16.0F, 10, 9, 1, 0.0F));
        head.cubeList.add(new ModelBox(head, 59, 99, -5.0F, -20.0F, -15.0F, 10, 9, 1, 0.0F));
        head.cubeList.add(new ModelBox(head, 92, 22, -3.0F, -15.0F, -19.0F, 6, 2, 3, 0.0F));
        head.cubeList.add(new ModelBox(head, 91, 10, -2.5F, -13.0F, -19.0F, 5, 2, 3, 0.0F));

        ears = new ModelRenderer(this);
        ears.setRotationPoint(0.0F, -20.0F, -12.0F);
        head.addChild(ears);


        leftEarBone = new ModelRenderer(this);
        leftEarBone.setRotationPoint(-6.0F, -1.0F, 0.0F);
        ears.addChild(leftEarBone);


        leftEar_r1 = new ModelRenderer(this);
        leftEar_r1.setRotationPoint(-1.0F, 7.0F, 1.0F);
        leftEarBone.addChild(leftEar_r1);
        setRotationAngle(leftEar_r1, 0.0F, 0.0F, -1.3963F);
        leftEar_r1.cubeList.add(new ModelBox(leftEar_r1, 58, 63, -1.0F, -1.0F, -3.0F, 8, 1, 5, 0.0F));

        rightEarBone = new ModelRenderer(this);
        rightEarBone.setRotationPoint(6.0F, -1.0F, 0.0F);
        ears.addChild(rightEarBone);


        rightEar_r1 = new ModelRenderer(this);
        rightEar_r1.setRotationPoint(0.0F, 1.0F, 1.0F);
        rightEarBone.addChild(rightEar_r1);
        setRotationAngle(rightEar_r1, 0.0F, 0.0F, 1.3963F);
        rightEar_r1.cubeList.add(new ModelBox(rightEar_r1, 64, 0, -1.0F, -1.0F, -3.0F, 8, 1, 5, 0.0F));

        tail = new ModelRenderer(this);
        tail.setRotationPoint(0.0F, -17.0F, 14.0F);
        appa.addChild(tail);


        tailB_r1 = new ModelRenderer(this);
        tailB_r1.setRotationPoint(0.0F, -4.0F, 7.0F);
        tail.addChild(tailB_r1);
        setRotationAngle(tailB_r1, 0.6981F, 0.0F, 0.0F);
        tailB_r1.cubeList.add(new ModelBox(tailB_r1, 66, 48, -1.0F, -2.0F, -1.0F, 2, 2, 7, 0.0F));

        tailA_r1 = new ModelRenderer(this);
        tailA_r1.setRotationPoint(0.0F, 1.0F, 1.0F);
        tail.addChild(tailA_r1);
        setRotationAngle(tailA_r1, 0.6981F, 0.0F, 0.0F);
        tailA_r1.cubeList.add(new ModelBox(tailA_r1, 64, 16, -1.0F, -2.0F, -1.0F, 2, 2, 8, 0.0F));
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        appa.render(f5);
    }

    @Override
    public void renderModel(float f5) {
        appa.render(f5);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
