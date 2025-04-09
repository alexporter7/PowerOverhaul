package com.alexporter7.poweroverhaul.api.material;

public class MaterialUtil {

    public enum MaterialType {
        INGOT,
        BLOCK,
        ORE_BLOCK,
        FLUID,
        BUCKET
    }

    public static String getRegistryName(PowerOverhaulMaterial material, MaterialType materialType) {
        return material.getName() + "_" + materialType.toString().toLowerCase();
    }
}
