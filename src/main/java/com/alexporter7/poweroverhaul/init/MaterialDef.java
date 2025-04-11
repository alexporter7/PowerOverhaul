package com.alexporter7.poweroverhaul.init;

import com.alexporter7.poweroverhaul.api.material.MaterialBuilder;
import com.alexporter7.poweroverhaul.api.material.MaterialUtil;
import com.alexporter7.poweroverhaul.api.material.PowerOverhaulMaterial;

import java.util.HashSet;

import static com.alexporter7.poweroverhaul.api.material.MaterialUtil.Component;

public class MaterialDef {

    public static HashSet<PowerOverhaulMaterial> materials = new HashSet<>();

    public static HashSet<Component> ALL_COMPONENTS = MaterialUtil.getAllComponents();
    public static HashSet<Component> COMPONENTS_NO_ENGINE = MaterialUtil.getAllComponentsNoEngine();

    public static HashSet<PowerOverhaulMaterial> createMaterialList() {
        HashSet<PowerOverhaulMaterial> materialsList = new HashSet<>();

        materialsList.add(createMaterial("tin", 10, 450, 15, 0xD3D4D5, COMPONENTS_NO_ENGINE));
        materialsList.add(createMaterial("copper", 10, 1983, 15, 0xB87333, COMPONENTS_NO_ENGINE));
        materialsList.add(createMaterial("nickel", 10, 2651, 15, 0xC1BCAF, COMPONENTS_NO_ENGINE));
        materialsList.add(createMaterial("bronze", 10, 1675, 15, 0xCE8946, COMPONENTS_NO_ENGINE));

        materialsList.add(createMaterial("titanium", 10, 3040, 15, 0x5B798E, ALL_COMPONENTS));
        materialsList.add(createMaterial("steel", 10, 1500, 15, 0x71797E, ALL_COMPONENTS));

        return materialsList;
    }

    public static void registerMaterials() {
        materials.addAll(createMaterialList());

        for (PowerOverhaulMaterial material : materials) material.register();
    }

    public static PowerOverhaulMaterial createMaterial(String name, int hardness, int meltingPoint, int weight,
        int color, HashSet<Component> components) {
        return new PowerOverhaulMaterial(
            new MaterialBuilder().setName(name)
                .setHardness(hardness)
                .setMeltingPoint(meltingPoint)
                .setWeight(weight)
                .setColor(color)
                .setComponents(components));
    }

}
