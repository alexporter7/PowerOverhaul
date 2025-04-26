package com.alexporter7.poweroverhaul.api.model;

import com.alexporter7.poweroverhaul.render.PowerOverhaulModelBase;
import net.minecraft.client.model.ModelBase;
import net.minecraft.util.ResourceLocation;

public class RenderedBlockModel<T extends ModelBase> {

    private final T MODEL;
    private final ResourceLocation TEXTURE;

    public RenderedBlockModel(T model, ResourceLocation texture) {
        MODEL = model;
        TEXTURE = texture;
    }

    public T getModel() {
        return MODEL;
    }

    public ResourceLocation getTexture() {
        return TEXTURE;
    }
}
