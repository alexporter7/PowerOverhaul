package com.alexporter7.poweroverhaul.api.properties;

import static com.alexporter7.poweroverhaul.api.properties.PropertyList.*;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;

public class OreGenProperties {

    private final int minVeinSize;
    private final int maxVeinSize;
    private final int minHeight;
    private final int maxHeight;
    private final int chance;

    private final Block generatesIn;
    private final Block oreBlock;

    public OreGenProperties(Properties<Integer> properties, Block oreBlock) {
        this(properties, oreBlock, Blocks.stone);
    }

    public OreGenProperties(Properties<Integer> properties, Block oreBlock, Block generatesIn) {
        minVeinSize = properties.getProperty(OreGen.MIN_VEIN_SIZE);
        maxVeinSize = properties.getProperty(OreGen.MAX_VEIN_SIZE);
        minHeight = properties.getProperty(OreGen.MIN_HEIGHT);
        maxHeight = properties.getProperty(OreGen.MAX_HEIGHT);
        chance = properties.getProperty(OreGen.CHANCE);

        this.oreBlock = oreBlock;
        this.generatesIn = generatesIn;
    }

    public int getMinVeinSize() {
        return minVeinSize;
    }

    public int getMaxVeinSize() {
        return maxVeinSize;
    }

    public int getMinHeight() {
        return minHeight;
    }

    public int getMaxHeight() {
        return maxHeight;
    }

    public int getChance() {
        return chance;
    }

    public Block getOreBlock() {
        return oreBlock;
    }

    public Block getGeneratesIn() {
        return generatesIn;
    }
}
