package com.alexporter7.poweroverhaul.blocks.models.engine.head;

// Made with Blockbench 4.12.4
// Exported for Minecraft version 1.7 - 1.12
// Paste this class into your mod and generate all required imports


import com.alexporter7.poweroverhaul.render.PowerOverhaulModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class EngineHead4Model extends PowerOverhaulModelBase {
    private final ModelRenderer engineHead;
    private final ModelRenderer base;
    private final ModelRenderer valveCover;
    private final ModelRenderer heatsink;

    public EngineHead4Model() {
        textureWidth = 128;
        textureHeight = 128;

        engineHead = new ModelRenderer(this);
        engineHead.setRotationPoint(0.0F, 24.0F, 0.0F);


        base = new ModelRenderer(this);
        base.setRotationPoint(0.0F, 0.0F, 0.0F);
        engineHead.addChild(base);
        base.cubeList.add(new ModelBox(base, 0, 20, -4.0F, -2.0F, -8.0F, 8, 2, 16, 0.0F));
        base.cubeList.add(new ModelBox(base, 0, 0, -5.0F, -6.0F, -8.0F, 10, 4, 16, 0.0F));

        valveCover = new ModelRenderer(this);
        valveCover.setRotationPoint(0.0F, 0.0F, 0.0F);
        engineHead.addChild(valveCover);
        valveCover.cubeList.add(new ModelBox(valveCover, 0, 38, -4.0F, -8.0F, -8.0F, 8, 2, 16, 0.0F));

        heatsink = new ModelRenderer(this);
        heatsink.setRotationPoint(0.0F, 0.0F, 0.0F);
        engineHead.addChild(heatsink);
        heatsink.cubeList.add(new ModelBox(heatsink, 48, 20, -3.5F, -9.0F, -7.0F, 1, 1, 14, 0.0F));
        heatsink.cubeList.add(new ModelBox(heatsink, 48, 35, -1.5F, -9.0F, -7.0F, 1, 1, 14, 0.0F));
        heatsink.cubeList.add(new ModelBox(heatsink, 48, 50, 0.5F, -9.0F, -7.0F, 1, 1, 14, 0.0F));
        heatsink.cubeList.add(new ModelBox(heatsink, 52, 0, 2.5F, -9.0F, -7.0F, 1, 1, 14, 0.0F));
    }

    @Override
    public void renderModel(float f5) {
        engineHead.render(f5);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        engineHead.render(f5);
    }

}
