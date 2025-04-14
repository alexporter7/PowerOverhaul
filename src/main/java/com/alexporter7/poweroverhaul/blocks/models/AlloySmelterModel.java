package com.alexporter7.poweroverhaul.blocks.models;

// Made with Blockbench 4.12.4
// Exported for Minecraft version 1.7 - 1.12
// Paste this class into your mod and generate all required imports


import com.alexporter7.poweroverhaul.render.PowerOverhaulModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class AlloySmelterModel extends PowerOverhaulModelBase {
    private final ModelRenderer outline;
    private final ModelRenderer frontFace;
    private final ModelRenderer interior;
    private final ModelRenderer top;

    public AlloySmelterModel() {
        outline = new ModelRenderer(this);
        outline.setRotationPoint(0.0F, 24.0F, 0.0F);
        outline.cubeList.add(new ModelBox(outline, 0, 30, 6.0F, -16.0F, -7.0F, 2, 16, 14, 0.0F));
        outline.cubeList.add(new ModelBox(outline, 1, 0, -6.0F, -1.0F, -7.0F, 12, 1, 14, 0.0F));
        outline.cubeList.add(new ModelBox(outline, 32, 30, -8.0F, -16.0F, -7.0F, 2, 16, 14, 0.0F));
        outline.cubeList.add(new ModelBox(outline, 56, 0, -8.0F, -16.0F, 7.0F, 16, 16, 1, 0.0F));

        frontFace = new ModelRenderer(this);
        frontFace.setRotationPoint(0.0F, 24.0F, 0.0F);
        frontFace.cubeList.add(new ModelBox(frontFace, 64, 34, -8.0F, -4.0F, -8.0F, 16, 4, 1, 0.0F));
        frontFace.cubeList.add(new ModelBox(frontFace, 64, 39, -8.0F, -16.0F, -8.0F, 16, 3, 1, 0.0F));
        frontFace.cubeList.add(new ModelBox(frontFace, 87, 68, -8.0F, -13.0F, -8.0F, 2, 9, 1, 0.0F));
        frontFace.cubeList.add(new ModelBox(frontFace, 72, 75, 6.0F, -13.0F, -8.0F, 2, 9, 1, 0.0F));

        interior = new ModelRenderer(this);
        interior.setRotationPoint(0.0F, 24.0F, 0.0F);
        interior.cubeList.add(new ModelBox(interior, 64, 43, -6.0F, -13.0F, -8.0F, 12, 9, 1, 0.0F));
        interior.cubeList.add(new ModelBox(interior, 0, 15, -6.0F, -2.0F, -7.0F, 12, 1, 13, 0.0F));
        interior.cubeList.add(new ModelBox(interior, 64, 17, -6.0F, -16.0F, 6.0F, 12, 15, 1, 0.0F));

        top = new ModelRenderer(this);
        top.setRotationPoint(0.0F, 24.0F, 0.0F);
        top.cubeList.add(new ModelBox(top, 0, 60, -6.0F, -16.0F, -7.0F, 4, 2, 13, 0.0F));
        top.cubeList.add(new ModelBox(top, 34, 60, 2.0F, -16.0F, -7.0F, 4, 2, 13, 0.0F));
        top.cubeList.add(new ModelBox(top, 68, 66, -2.0F, -16.0F, 2.0F, 4, 2, 4, 0.0F));
        top.cubeList.add(new ModelBox(top, 64, 53, -2.0F, -16.0F, -7.0F, 4, 2, 5, 0.0F));
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        outline.render(f5);
        frontFace.render(f5);
        interior.render(f5);
        top.render(f5);
    }

    @Override
    public void renderModel(float f5) {
        outline.render(f5);
        frontFace.render(f5);
        interior.render(f5);
        top.render(f5);
    }

    @Override
    public void setRotationAngles(float f1, float f2, float f3, float f4, float f5, float f6, Entity entity) {
        super.setRotationAngles(f1, f2, f3, f4, f5, f6, entity);
    }
}
