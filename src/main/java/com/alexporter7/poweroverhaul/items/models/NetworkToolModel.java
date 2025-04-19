package com.alexporter7.poweroverhaul.items.models;

// Made with Blockbench 4.12.4
// Exported for Minecraft version 1.7 - 1.12
// Paste this class into your mod and generate all required imports

import com.alexporter7.poweroverhaul.render.PowerOverhaulModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class NetworkToolModel extends PowerOverhaulModelBase {
    private final ModelRenderer screen;
    private final ModelRenderer outline;
    private final ModelRenderer antenna;

    public NetworkToolModel() {
        textureWidth = 32;
        textureHeight = 32;

        screen = new ModelRenderer(this);
        screen.setRotationPoint(0.0F, 23.0F, 0.0F);
        screen.cubeList.add(new ModelBox(screen, 0, 6, -4.0F, -5.0F, 0.0F, 8, 5, 1, 0.0F));

        outline = new ModelRenderer(this);
        outline.setRotationPoint(0.0F, 24.0F, 0.0F);
        outline.cubeList.add(new ModelBox(outline, 0, 0, -5.0F, -1.0F, -1.0F, 10, 1, 2, 0.0F));
        outline.cubeList.add(new ModelBox(outline, 0, 3, -5.0F, -7.0F, -1.0F, 10, 1, 2, 0.0F));
        outline.cubeList.add(new ModelBox(outline, 0, 12, -5.0F, -6.0F, -1.0F, 1, 5, 2, 0.0F));
        outline.cubeList.add(new ModelBox(outline, 6, 12, 4.0F, -6.0F, -1.0F, 1, 5, 2, 0.0F));

        antenna = new ModelRenderer(this);
        antenna.setRotationPoint(0.0F, 24.0F, 0.0F);
        antenna.cubeList.add(new ModelBox(antenna, 12, 12, -5.0F, -11.0F, 0.0F, 1, 4, 1, 0.0F));
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        screen.render(f5);
        outline.render(f5);
        antenna.render(f5);
    }

    @Override
    public void renderModel(float f5) {
        screen.render(f5);
        outline.render(f5);
        antenna.render(f5);
    }

    @Override
    public void setRotationAngles(float f1, float f2, float f3, float f4, float f5, float f6, Entity entity) {
        super.setRotationAngles(f1, f2, f3, f4, f5, f6, entity);
    }
}
