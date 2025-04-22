package com.alexporter7.poweroverhaul.api.blocks;

import net.minecraft.block.Block;

import java.util.HashMap;

public class BlockVariationSet<T, B extends Block> {

    private final HashMap<T, B> VARIATIONS = new HashMap<>();

    public BlockVariationSet<T, B> addVariation(T key, B block) {
        VARIATIONS.put(key, block);
        return this;
    }

    public B getVariation(T key) {
        return VARIATIONS.get(key);
    }
}
