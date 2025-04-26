package com.alexporter7.poweroverhaul.api.model;

import com.alexporter7.poweroverhaul.render.PowerOverhaulModelBase;
import net.minecraft.util.ResourceLocation;

public interface ICustomModel {
    RenderedBlockModel<?> getRenderedBlockModel();
}
