package com.alexporter7.poweroverhaul.api.model;

import java.util.HashMap;
import java.util.function.Supplier;

import com.alexporter7.poweroverhaul.render.PowerOverhaulModelBase;

public class ModelSet<T extends Enum<T>> {

    private final HashMap<T, Supplier<PowerOverhaulModelBase>> MODELS = new HashMap<>();

    public ModelSet() {

    }

    public ModelSet<T> registerModel(T key, Supplier<PowerOverhaulModelBase> supplier) {
        MODELS.put(key, supplier);
        return this;
    }
}
