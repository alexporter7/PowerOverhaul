package com.alexporter7.poweroverhaul.init;

import com.alexporter7.poweroverhaul.api.material.MaterialBuilder;
import com.alexporter7.poweroverhaul.api.material.PowerOverhaulMaterial;

import java.util.HashSet;

public class MaterialDef {

    public static HashSet<PowerOverhaulMaterial> materials = new HashSet<>();

    public static void createMaterials() {
        materials.add(createMaterial("steel", 10, 1500, 15, 0x71797E));
        materials.add(createMaterial("bronze", 10, 1500, 15, 0xCE8946));
        materials.add(createMaterial("copper", 10, 1500, 15, 0xB87333));
        materials.add(createMaterial("tin", 10, 1500, 15, 0xD3D4D5));

        registerMaterials();
    }

    public static PowerOverhaulMaterial createMaterial(String name, int hardness, int meltingPoint,
                                                       int weight, int color) {
        return new PowerOverhaulMaterial(new MaterialBuilder()
            .setName(name)
            .setHardness(hardness)
            .setMeltingPoint(meltingPoint)
            .setWeight(weight)
            .setColor(color));
    }

    private static void registerMaterials() {
        for(PowerOverhaulMaterial material : materials)
            material.register();
    }

}
