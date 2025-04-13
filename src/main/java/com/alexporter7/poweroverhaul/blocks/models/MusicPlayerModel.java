package com.alexporter7.poweroverhaul.blocks.models;

// Made with Blockbench 4.12.3
// Exported for Minecraft version 1.7 - 1.12
// Paste this class into your mod and generate all required imports
import com.alexporter7.poweroverhaul.render.PowerOverhaulModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class MusicPlayerModel extends PowerOverhaulModelBase {
    private final ModelRenderer body;
    private final ModelRenderer radioInterface;

    public MusicPlayerModel() {
        textureWidth = 32;
        textureHeight = 32;

        body = new ModelRenderer(this);
        body.setRotationPoint(0.0F, 24.0F, 0.0F);
        body.cubeList.add(new ModelBox(body, 0, 0, -5.0F, -6.0F, -3.0F, 10, 6, 6, 0.0F));
        body.cubeList.add(new ModelBox(body, 12, 12, -4.0F, -10.0F, 1.0F, 1, 4, 1, 0.0F));

        radioInterface = new ModelRenderer(this);
        radioInterface.setRotationPoint(-4.0F, 18.0F, 2.0F);
        radioInterface.cubeList.add(new ModelBox(radioInterface, 16, 12, 0.0F, 1.0F, -6.0F, 2, 1, 1, 0.0F));
        radioInterface.cubeList.add(new ModelBox(radioInterface, 16, 14, 0.0F, 4.0F, -6.0F, 2, 1, 1, 0.0F));
        radioInterface.cubeList.add(new ModelBox(radioInterface, 0, 12, 3.0F, 1.0F, -6.0F, 5, 4, 1, 0.0F));
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        body.render(f5);
        radioInterface.render(f5);
    }

    @Override
    public void renderModel(float f5) {
        body.render(f5);
        radioInterface.render(f5);
    }

    @Override
    public void setRotationAngles(float f1, float f2, float f3, float f4, float f5, float f6, Entity entity) {
        super.setRotationAngles(f1, f2, f3, f4, f5, f6, entity);
    }
}
