package com.alexporter7.poweroverhaul.init;

import static com.alexporter7.poweroverhaul.api.material.MaterialUtil.Component;

import java.util.HashSet;

import com.alexporter7.poweroverhaul.api.material.MaterialBuilder;
import com.alexporter7.poweroverhaul.api.material.MaterialUtil;
import com.alexporter7.poweroverhaul.api.material.PowerOverhaulMaterial;

public class MaterialDef {

    public static final HashSet<PowerOverhaulMaterial> MATERIALS = new HashSet<>();

    public static HashSet<Component> ALL_COMPONENTS = MaterialUtil.getAllComponents();
    public static HashSet<Component> COMPONENTS_NO_ENGINE = MaterialUtil.getAllComponentsNoEngine();

    public static HashSet<PowerOverhaulMaterial> createMaterialList() {
        HashSet<PowerOverhaulMaterial> materialsList = new HashSet<>();

        /*
         * Base Materials
         */

        /* Weak */
        materialsList.add(createMaterial("tin", 10, 450, 118, 0xD3D4D5, COMPONENTS_NO_ENGINE));
        materialsList.add(createMaterial("copper", 3, 1983, 64, 0xB87333, COMPONENTS_NO_ENGINE));
        materialsList.add(createMaterial("nickel", 10, 2651, 59, 0xC1BCAF, COMPONENTS_NO_ENGINE));
        materialsList.add(createMaterial("lithium", 10, 357, 7, 0xB3CCD1, COMPONENTS_NO_ENGINE));
        materialsList.add(createMaterial("sodium", 10, 208, 23, 0x54BBD2, COMPONENTS_NO_ENGINE));
        materialsList.add(createMaterial("magnesium", 10, 1202, 24, 0xC2C4BF, COMPONENTS_NO_ENGINE));

        /* Strong */
        materialsList.add(createMaterial("titanium", 10, 3040, 48, 0x5B798E, ALL_COMPONENTS));
        materialsList.add(createMaterial("aluminium", 10, 1220, 27, 0xADB2BD, ALL_COMPONENTS));

        /*
         * Alloys
         */

        /* Weak */
        materialsList.add(createMaterial("bronze", 10, 1675, 15, 0xCE8946, COMPONENTS_NO_ENGINE));

        /* Strong */
        materialsList.add(createMaterial("steel", 10, 1500, 15, 0x71797E, ALL_COMPONENTS));

        return materialsList;
    }

    public static void registerMaterials() {
        MATERIALS.addAll(createMaterialList());

        for (PowerOverhaulMaterial material : MATERIALS) material.register();
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
