package com.alexporter7.poweroverhaul.api.model;

import java.util.HashMap;
import java.util.function.Supplier;

import com.alexporter7.poweroverhaul.api.blocks.BlockVariationSet;
import com.alexporter7.poweroverhaul.render.PowerOverhaulModelBase;
import net.minecraft.block.Block;

public class ModelSet<T extends BlockVariationSet<T, B>, B extends Block> {

    private final HashMap<T, Supplier<PowerOverhaulModelBase>> MODELS = new HashMap<>();

    public ModelSet() {

    }

    public ModelSet<T, B> registerModel(T key, Supplier<PowerOverhaulModelBase> supplier) {
        MODELS.put(key, supplier);
        return this;
    }

    public PowerOverhaulModelBase getModel(T variation) {
        return MODELS.get(variation).get();
    }
}
