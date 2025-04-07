package com.alexporter7.poweroverhaul.init;

import com.alexporter7.poweroverhaul.api.material.MaterialBuilder;
import com.alexporter7.poweroverhaul.api.material.PowerOverhaulMaterial;

import java.util.HashSet;

public class MaterialDef {

    public static HashSet<PowerOverhaulMaterial> materials = new HashSet<>();

    public static void createMaterials() {
        materials.add(createMaterial("steel", 10, 1500, 15));
    }

    public static PowerOverhaulMaterial createMaterial(String name, int hardness, int meltingPoint, int weight) {
        return new PowerOverhaulMaterial(new MaterialBuilder()
            .setName("steel")
            .setHardness(10)
            .setMeltingPoint(1500)
            .setWeight(15));
    }

    private static void registerMaterials() {
        for(PowerOverhaulMaterial material : materials)
            material.register();
    }

}
