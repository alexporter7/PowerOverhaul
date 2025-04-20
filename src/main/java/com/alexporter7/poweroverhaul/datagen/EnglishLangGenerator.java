package com.alexporter7.poweroverhaul.datagen;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.HashSet;

import com.alexporter7.poweroverhaul.api.enums.FluidEnum;
import com.alexporter7.poweroverhaul.api.material.MaterialUtil;
import com.alexporter7.poweroverhaul.api.material.PowerOverhaulMaterial;
import com.alexporter7.poweroverhaul.init.MaterialDef;

public class EnglishLangGenerator {

    private static final String langFile = "./src/main/resources/assets/poweroverhaul/lang/en_US.lang";

    private static HashSet<String> langLines = new HashSet<>();

    public static void main(String[] args) throws FileNotFoundException {
        HashSet<PowerOverhaulMaterial> materials = MaterialDef.createMaterialList();
        for (PowerOverhaulMaterial material : materials) langLines.addAll(getMaterialComponents(material));
        langLines.addAll(getFluids());
        writeToFile();
    }

    private static HashSet<String> getMaterialComponents(PowerOverhaulMaterial material) {
        HashSet<String> lines = new HashSet<>();
        for (MaterialUtil.Component component : MaterialUtil.Component.values()) lines.add(
            MaterialUtil.getLangName(material, component) + MaterialUtil.getEnglishTranslation(material, component));
        return lines;
    }

    private static HashSet<String> getFluids() {
        HashSet<String> lines = new HashSet<>();
        for (Enum<FluidEnum> fluid : FluidEnum.values()) lines.add(
            "fluid." + fluid.toString()
                .toLowerCase() + ".name=" + formatWord(fluid.toString()));
        return lines;
    }

    private static void writeToFile() throws FileNotFoundException {
        PrintWriter printWriter = new PrintWriter(new FileOutputStream(langFile));
        for (String line : langLines) printWriter.write(line + "\n");
        printWriter.close();
    }

    private static String formatWord(String word) {
        return word.substring(0, 1)
            .toUpperCase()
            + word.substring(1)
                .toLowerCase();
    }
}
