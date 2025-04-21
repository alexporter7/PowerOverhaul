package com.alexporter7.poweroverhaul.blocks.models.engine.block;

// Made with Blockbench 4.12.4
// Exported for Minecraft version 1.7 - 1.12
// Paste this class into your mod and generate all required imports

import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

import com.alexporter7.poweroverhaul.render.PowerOverhaulModelBase;

public class EngineBlock4Model extends PowerOverhaulModelBase {

    private final ModelRenderer base;
    private final ModelRenderer top;
    private final ModelRenderer cylinders;
    private final ModelRenderer cylinderA;
    private final ModelRenderer cylinderB;
    private final ModelRenderer cylinderC;
    private final ModelRenderer cylinderD;

    public EngineBlock4Model() {
        textureWidth = 128;
        textureHeight = 128;

        base = new ModelRenderer(this);
        base.setRotationPoint(0.0F, 24.0F, 0.0F);
        base.cubeList.add(new ModelBox(base, 0, 18, -6.0F, -2.0F, -8.0F, 4, 2, 16, 0.0F));
        base.cubeList.add(new ModelBox(base, 40, 36, -5.0F, -4.0F, -8.0F, 4, 2, 16, 0.0F));
        base.cubeList.add(new ModelBox(base, 0, 36, 2.0F, -2.0F, -8.0F, 4, 2, 16, 0.0F));
        base.cubeList.add(new ModelBox(base, 40, 18, 1.0F, -4.0F, -8.0F, 4, 2, 16, 0.0F));
        base.cubeList.add(new ModelBox(base, 0, 0, -5.0F, -6.0F, -8.0F, 10, 2, 16, 0.0F));

        top = new ModelRenderer(this);
        top.setRotationPoint(0.0F, 24.0F, 0.0F);
        top.cubeList.add(new ModelBox(top, 0, 54, -4.0F, -12.0F, -8.0F, 2, 6, 16, 0.0F));
        top.cubeList.add(new ModelBox(top, 36, 54, 2.0F, -12.0F, -8.0F, 2, 6, 16, 0.0F));

        cylinders = new ModelRenderer(this);
        cylinders.setRotationPoint(0.0F, 24.0F, 0.0F);

        cylinderA = new ModelRenderer(this);
        cylinderA.setRotationPoint(0.0F, 0.0F, -2.0F);
        cylinders.addChild(cylinderA);
        cylinderA.cubeList.add(new ModelBox(cylinderA, 72, 68, -2.0F, -12.0F, -5.0F, 1, 6, 2, 0.0F));
        cylinderA.cubeList.add(new ModelBox(cylinderA, 0, 76, 1.0F, -12.0F, -5.0F, 1, 6, 2, 0.0F));
        cylinderA.cubeList.add(new ModelBox(cylinderA, 52, 0, -2.0F, -12.0F, -3.0F, 4, 6, 1, 0.0F));
        cylinderA.cubeList.add(new ModelBox(cylinderA, 52, 7, -2.0F, -12.0F, -6.0F, 4, 6, 1, 0.0F));

        cylinderB = new ModelRenderer(this);
        cylinderB.setRotationPoint(0.0F, 0.0F, 2.0F);
        cylinders.addChild(cylinderB);
        cylinderB.cubeList.add(new ModelBox(cylinderB, 6, 76, -2.0F, -12.0F, -5.0F, 1, 6, 2, 0.0F));
        cylinderB.cubeList.add(new ModelBox(cylinderB, 12, 76, 1.0F, -12.0F, -5.0F, 1, 6, 2, 0.0F));
        cylinderB.cubeList.add(new ModelBox(cylinderB, 62, 0, -2.0F, -12.0F, -3.0F, 4, 6, 1, 0.0F));
        cylinderB.cubeList.add(new ModelBox(cylinderB, 62, 7, -2.0F, -12.0F, -6.0F, 4, 6, 1, 0.0F));

        cylinderC = new ModelRenderer(this);
        cylinderC.setRotationPoint(0.0F, 0.0F, 6.0F);
        cylinders.addChild(cylinderC);
        cylinderC.cubeList.add(new ModelBox(cylinderC, 18, 76, -2.0F, -12.0F, -5.0F, 1, 6, 2, 0.0F));
        cylinderC.cubeList.add(new ModelBox(cylinderC, 24, 76, 1.0F, -12.0F, -5.0F, 1, 6, 2, 0.0F));
        cylinderC.cubeList.add(new ModelBox(cylinderC, 72, 0, -2.0F, -12.0F, -3.0F, 4, 6, 1, 0.0F));
        cylinderC.cubeList.add(new ModelBox(cylinderC, 72, 7, -2.0F, -12.0F, -6.0F, 4, 6, 1, 0.0F));

        cylinderD = new ModelRenderer(this);
        cylinderD.setRotationPoint(0.0F, 0.0F, 10.0F);
        cylinders.addChild(cylinderD);
        cylinderD.cubeList.add(new ModelBox(cylinderD, 30, 76, -2.0F, -12.0F, -5.0F, 1, 6, 2, 0.0F));
        cylinderD.cubeList.add(new ModelBox(cylinderD, 36, 76, 1.0F, -12.0F, -5.0F, 1, 6, 2, 0.0F));
        cylinderD.cubeList.add(new ModelBox(cylinderD, 72, 54, -2.0F, -12.0F, -3.0F, 4, 6, 1, 0.0F));
        cylinderD.cubeList.add(new ModelBox(cylinderD, 72, 61, -2.0F, -12.0F, -6.0F, 4, 6, 1, 0.0F));
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
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
