package com.alexporter7.poweroverhaul.world;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

import com.alexporter7.poweroverhaul.api.properties.OreGenProperties;

import cpw.mods.fml.common.IWorldGenerator;

public class MaterialOreGeneration implements IWorldGenerator {

    private final OreGenProperties overworldProperties;
    private OreGenProperties netherProperties;
    private OreGenProperties endProperties;

    public MaterialOreGeneration(OreGenProperties properties) {
        overworldProperties = properties;
    }

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator,
        IChunkProvider chunkProvider) {
        switch (world.provider.dimensionId) {
            case 0:
                generateOre(random, chunkX, chunkZ, world, overworldProperties);
                break;
            case 1:
                generateOre(random, chunkX, chunkZ, world, netherProperties);
                break;
            case 2:
                generateOre(random, chunkX, chunkZ, world, endProperties);
                break;
        }
    }

    public void generateOre(Random random, int chunkX, int chunkZ, World world, OreGenProperties properties) {
        int veinSize = random.nextInt(properties.getMaxVeinSize() + 1) - properties.getMinVeinSize();
        int heightRange = properties.getMaxHeight() - properties.getMinHeight();
        WorldGenMinable oreGen = new WorldGenMinable(properties.getOreBlock(), veinSize, properties.getGeneratesIn());

        for (int i = 0; i < properties.getChance(); i++) {
            int xRandom = (chunkX * 16) + random.nextInt(16);
            int yRandom = random.nextInt(heightRange + 1) + properties.getMinHeight();
            int zRandom = (chunkZ * 16) + random.nextInt(16);
            oreGen.generate(world, random, xRandom, yRandom, zRandom);
        }

    }

}
