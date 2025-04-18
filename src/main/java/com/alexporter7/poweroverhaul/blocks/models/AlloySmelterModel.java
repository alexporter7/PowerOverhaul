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
    private final ModelRenderer leftWindow;
    private final ModelRenderer rightWindow;

    public AlloySmelterModel() {
        textureWidth = 128;
        textureHeight = 128;

        outline = new ModelRenderer(this);
        outline.setRotationPoint(0.0F, 24.0F, 0.0F);
        outline.cubeList.add(new ModelBox(outline, 0, 36, -7.0F, -15.0F, -3.0F, 14, 14, 11, 0.0F));
        outline.cubeList.add(new ModelBox(outline, 86, 34, 5.0F, -15.0F, -8.0F, 2, 1, 5, 0.0F));
        outline.cubeList.add(new ModelBox(outline, 67, 91, 6.0F, -14.0F, -8.0F, 1, 1, 5, 0.0F));
        outline.cubeList.add(new ModelBox(outline, 65, 0, -7.0F, -15.0F, -8.0F, 8, 1, 5, 0.0F));
        outline.cubeList.add(new ModelBox(outline, 35, 75, -7.0F, -14.0F, -8.0F, 7, 1, 5, 0.0F));
        outline.cubeList.add(new ModelBox(outline, 60, 75, -7.0F, -13.0F, -8.0F, 6, 1, 5, 0.0F));
        outline.cubeList.add(new ModelBox(outline, 0, 0, -8.0F, -16.0F, -8.0F, 16, 1, 16, 0.0F));
        outline.cubeList.add(new ModelBox(outline, 0, 62, -8.0F, -15.0F, -8.0F, 1, 15, 16, 0.0F));
        outline.cubeList.add(new ModelBox(outline, 0, 18, -7.0F, -1.0F, -8.0F, 14, 1, 16, 0.0F));
        outline.cubeList.add(new ModelBox(outline, 51, 36, 7.0F, -15.0F, -8.0F, 1, 15, 16, 0.0F));

        frontFace = new ModelRenderer(this);
        frontFace.setRotationPoint(0.0F, 25.0F, 0.0F);
        frontFace.cubeList.add(new ModelBox(frontFace, 61, 27, -7.0F, -3.0F, -8.0F, 14, 1, 5, 0.0F));
        frontFace.cubeList.add(new ModelBox(frontFace, 61, 18, -7.0F, -9.0F, -8.0F, 14, 3, 5, 0.0F));
        frontFace.cubeList.add(new ModelBox(frontFace, 67, 82, -7.0F, -6.0F, -8.0F, 1, 3, 5, 0.0F));
        frontFace.cubeList.add(new ModelBox(frontFace, 80, 82, -0.5F, -6.0F, -8.0F, 1, 3, 5, 0.0F));
        frontFace.cubeList.add(new ModelBox(frontFace, 85, 68, 6.0F, -6.0F, -8.0F, 1, 3, 5, 0.0F));

        leftWindow = new ModelRenderer(this);
        leftWindow.setRotationPoint(-1.0F, 24.0F, 0.0F);
        leftWindow.cubeList.add(new ModelBox(leftWindow, 65, 7, -6.0F, -9.0F, -8.0F, 7, 1, 5, 0.0F));
        leftWindow.cubeList.add(new ModelBox(leftWindow, 35, 68, -6.0F, -12.0F, -8.0F, 7, 1, 5, 0.0F));
        leftWindow.cubeList.add(new ModelBox(leftWindow, 86, 41, -6.0F, -11.0F, -8.0F, 1, 2, 5, 0.0F));
        leftWindow.cubeList.add(new ModelBox(leftWindow, 86, 49, 0.0F, -11.0F, -8.0F, 1, 2, 5, 0.0F));

        rightWindow = new ModelRenderer(this);
        rightWindow.setRotationPoint(0.0F, 24.0F, 0.0F);
        rightWindow.cubeList.add(new ModelBox(rightWindow, 60, 68, 0.0F, -9.0F, -8.0F, 7, 1, 5, 0.0F));
        rightWindow.cubeList.add(new ModelBox(rightWindow, 86, 57, -1.0F, -13.0F, -8.0F, 1, 1, 5, 0.0F));
        rightWindow.cubeList.add(new ModelBox(rightWindow, 35, 89, 0.0F, -14.0F, -8.0F, 1, 1, 5, 0.0F));
        rightWindow.cubeList.add(new ModelBox(rightWindow, 35, 82, 1.0F, -15.0F, -8.0F, 4, 1, 5, 0.0F));
        rightWindow.cubeList.add(new ModelBox(rightWindow, 54, 82, 6.0F, -13.0F, -8.0F, 1, 4, 5, 0.0F));
        rightWindow.cubeList.add(new ModelBox(rightWindow, 90, 7, 5.0F, -14.0F, -8.0F, 1, 1, 5, 0.0F));
    }


    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        outline.render(f5);
        frontFace.render(f5);
        leftWindow.render(f5);
        rightWindow.render(f5);
    }

    @Override
    public void renderModel(float f5) {
        outline.render(f5);
        frontFace.render(f5);
        leftWindow.render(f5);
        rightWindow.render(f5);
    }

    @Override
    public void setRotationAngles(float f1, float f2, float f3, float f4, float f5, float f6, Entity entity) {
        super.setRotationAngles(f1, f2, f3, f4, f5, f6, entity);
    }
}
