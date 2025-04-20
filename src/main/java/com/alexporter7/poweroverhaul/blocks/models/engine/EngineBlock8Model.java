package com.alexporter7.poweroverhaul.blocks.models.engine;

// Made with Blockbench 4.12.4
// Exported for Minecraft version 1.7 - 1.12
// Paste this class into your mod and generate all required imports

import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

import com.alexporter7.poweroverhaul.render.PowerOverhaulModelBase;

public class EngineBlock8Model extends PowerOverhaulModelBase {

    private final ModelRenderer base;
    private final ModelRenderer top;
    private final ModelRenderer cylinders;
    private final ModelRenderer leftBank;
    private final ModelRenderer cylinderB;
    private final ModelRenderer cylinderB3;
    private final ModelRenderer cylinderC;
    private final ModelRenderer cylinderD;
    private final ModelRenderer rightBank;
    private final ModelRenderer cylinderB2;
    private final ModelRenderer cylinderC2;
    private final ModelRenderer cylinderD2;
    private final ModelRenderer cylinderD3;

    public EngineBlock8Model() {
        textureWidth = 128;
        textureHeight = 128;

        base = new ModelRenderer(this);
        base.setRotationPoint(0.0F, 24.0F, 0.0F);
        base.cubeList.add(new ModelBox(base, 0, 18, -8.0F, -2.0F, -8.0F, 5, 2, 16, 0.0F));
        base.cubeList.add(new ModelBox(base, 42, 36, -7.0F, -4.0F, -8.0F, 5, 2, 16, 0.0F));
        base.cubeList.add(new ModelBox(base, 0, 36, 3.0F, -2.0F, -8.0F, 5, 2, 16, 0.0F));
        base.cubeList.add(new ModelBox(base, 42, 18, 2.0F, -4.0F, -8.0F, 5, 2, 16, 0.0F));
        base.cubeList.add(new ModelBox(base, 0, 0, -7.0F, -6.0F, -8.0F, 14, 2, 16, 0.0F));

        top = new ModelRenderer(this);
        top.setRotationPoint(0.0F, 24.0F, 0.0F);
        top.cubeList.add(new ModelBox(top, 0, 54, -6.0F, -12.0F, -8.0F, 1, 6, 16, 0.0F));
        top.cubeList.add(new ModelBox(top, 37, 54, 5.0F, -12.0F, -8.0F, 1, 6, 16, 0.0F));
        top.cubeList.add(new ModelBox(top, 71, 28, -1.0F, -12.0F, -8.0F, 2, 6, 16, 0.0F));

        cylinders = new ModelRenderer(this);
        cylinders.setRotationPoint(0.0F, 24.0F, 0.0F);

        leftBank = new ModelRenderer(this);
        leftBank.setRotationPoint(0.0F, 0.0F, 1.0F);
        cylinders.addChild(leftBank);

        cylinderB = new ModelRenderer(this);
        cylinderB.setRotationPoint(-3.0F, 0.0F, 1.0F);
        leftBank.addChild(cylinderB);
        cylinderB.cubeList.add(new ModelBox(cylinderB, 50, 76, -2.0F, -12.0F, -5.0F, 1, 6, 2, 0.0F));
        cylinderB.cubeList.add(new ModelBox(cylinderB, 56, 76, 1.0F, -12.0F, -5.0F, 1, 6, 2, 0.0F));
        cylinderB.cubeList.add(new ModelBox(cylinderB, 72, 64, -2.0F, -12.0F, -3.0F, 4, 6, 1, 0.0F));
        cylinderB.cubeList.add(new ModelBox(cylinderB, 63, 3, -2.0F, -12.0F, -6.0F, 4, 6, 1, 0.0F));

        cylinderB3 = new ModelRenderer(this);
        cylinderB3.setRotationPoint(-3.0F, 0.0F, -3.0F);
        leftBank.addChild(cylinderB3);
        cylinderB3.cubeList.add(new ModelBox(cylinderB3, 50, 76, -2.0F, -12.0F, -5.0F, 1, 6, 2, 0.0F));
        cylinderB3.cubeList.add(new ModelBox(cylinderB3, 56, 76, 1.0F, -12.0F, -5.0F, 1, 6, 2, 0.0F));
        cylinderB3.cubeList.add(new ModelBox(cylinderB3, 72, 64, -2.0F, -12.0F, -3.0F, 4, 6, 1, 0.0F));
        cylinderB3.cubeList.add(new ModelBox(cylinderB3, 63, 3, -2.0F, -12.0F, -6.0F, 4, 6, 1, 0.0F));

        cylinderC = new ModelRenderer(this);
        cylinderC.setRotationPoint(-3.0F, 0.0F, 5.0F);
        leftBank.addChild(cylinderC);
        cylinderC.cubeList.add(new ModelBox(cylinderC, 62, 76, -2.0F, -12.0F, -5.0F, 1, 6, 2, 0.0F));
        cylinderC.cubeList.add(new ModelBox(cylinderC, 68, 78, 1.0F, -12.0F, -5.0F, 1, 6, 2, 0.0F));
        cylinderC.cubeList.add(new ModelBox(cylinderC, 72, 71, -2.0F, -12.0F, -3.0F, 4, 6, 1, 0.0F));
        cylinderC.cubeList.add(new ModelBox(cylinderC, 0, 76, -2.0F, -12.0F, -6.0F, 4, 6, 1, 0.0F));

        cylinderD = new ModelRenderer(this);
        cylinderD.setRotationPoint(-3.0F, 0.0F, 9.0F);
        leftBank.addChild(cylinderD);
        cylinderD.cubeList.add(new ModelBox(cylinderD, 74, 78, -2.0F, -12.0F, -5.0F, 1, 6, 2, 0.0F));
        cylinderD.cubeList.add(new ModelBox(cylinderD, 80, 78, 1.0F, -12.0F, -5.0F, 1, 6, 2, 0.0F));
        cylinderD.cubeList.add(new ModelBox(cylinderD, 61, 11, -2.0F, -12.0F, -3.0F, 4, 6, 1, 0.0F));
        cylinderD.cubeList.add(new ModelBox(cylinderD, 76, 0, -2.0F, -12.0F, -6.0F, 4, 6, 1, 0.0F));

        rightBank = new ModelRenderer(this);
        rightBank.setRotationPoint(1.0F, 0.0F, -1.0F);
        cylinders.addChild(rightBank);

        cylinderB2 = new ModelRenderer(this);
        cylinderB2.setRotationPoint(2.0F, 0.0F, -1.0F);
        rightBank.addChild(cylinderB2);
        cylinderB2.cubeList.add(new ModelBox(cylinderB2, 82, 64, -2.0F, -12.0F, -5.0F, 1, 6, 2, 0.0F));
        cylinderB2.cubeList.add(new ModelBox(cylinderB2, 0, 83, 1.0F, -12.0F, -5.0F, 1, 6, 2, 0.0F));
        cylinderB2.cubeList.add(new ModelBox(cylinderB2, 10, 76, -2.0F, -12.0F, -3.0F, 4, 6, 1, 0.0F));
        cylinderB2.cubeList.add(new ModelBox(cylinderB2, 73, 11, -2.0F, -12.0F, -6.0F, 4, 6, 1, 0.0F));

        cylinderC2 = new ModelRenderer(this);
        cylinderC2.setRotationPoint(2.0F, 0.0F, 3.0F);
        rightBank.addChild(cylinderC2);
        cylinderC2.cubeList.add(new ModelBox(cylinderC2, 6, 83, -2.0F, -12.0F, -5.0F, 1, 6, 2, 0.0F));
        cylinderC2.cubeList.add(new ModelBox(cylinderC2, 12, 83, 1.0F, -12.0F, -5.0F, 1, 6, 2, 0.0F));
        cylinderC2.cubeList.add(new ModelBox(cylinderC2, 20, 76, -2.0F, -12.0F, -3.0F, 4, 6, 1, 0.0F));
        cylinderC2.cubeList.add(new ModelBox(cylinderC2, 30, 76, -2.0F, -12.0F, -6.0F, 4, 6, 1, 0.0F));

        cylinderD2 = new ModelRenderer(this);
        cylinderD2.setRotationPoint(2.0F, 0.0F, 7.0F);
        rightBank.addChild(cylinderD2);
        cylinderD2.cubeList.add(new ModelBox(cylinderD2, 18, 83, -2.0F, -12.0F, -5.0F, 1, 6, 2, 0.0F));
        cylinderD2.cubeList.add(new ModelBox(cylinderD2, 24, 83, 1.0F, -12.0F, -5.0F, 1, 6, 2, 0.0F));
        cylinderD2.cubeList.add(new ModelBox(cylinderD2, 75, 57, -2.0F, -12.0F, -3.0F, 4, 6, 1, 0.0F));
        cylinderD2.cubeList.add(new ModelBox(cylinderD2, 40, 76, -2.0F, -12.0F, -6.0F, 4, 6, 1, 0.0F));

        cylinderD3 = new ModelRenderer(this);
        cylinderD3.setRotationPoint(2.0F, 0.0F, 11.0F);
        rightBank.addChild(cylinderD3);
        cylinderD3.cubeList.add(new ModelBox(cylinderD3, 18, 83, -2.0F, -12.0F, -5.0F, 1, 6, 2, 0.0F));
        cylinderD3.cubeList.add(new ModelBox(cylinderD3, 24, 83, 1.0F, -12.0F, -5.0F, 1, 6, 2, 0.0F));
        cylinderD3.cubeList.add(new ModelBox(cylinderD3, 75, 57, -2.0F, -12.0F, -3.0F, 4, 6, 1, 0.0F));
        cylinderD3.cubeList.add(new ModelBox(cylinderD3, 40, 76, -2.0F, -12.0F, -6.0F, 4, 6, 1, 0.0F));
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        base.render(f5);
        top.render(f5);
        cylinders.render(f5);
    }

    @Override
    public void renderModel(float f5) {
        base.render(f5);
        top.render(f5);
        cylinders.render(f5);
    }
}
