package com.alexporter7.poweroverhaul.datagen;

import com.alexporter7.poweroverhaul.api.material.MaterialUtil;
import com.alexporter7.poweroverhaul.api.material.PowerOverhaulMaterial;
import com.alexporter7.poweroverhaul.init.MaterialDef;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.HashSet;

public class EnglishLangGenerator {

    private static final String langFile = "./src/main/resources/assets/poweroverhaul/lang/en_US.lang";

    private static HashSet<String> langLines = new HashSet<>();

    public static void main(String[] args) throws FileNotFoundException {
        HashSet<PowerOverhaulMaterial> materials = MaterialDef.createMaterialList();
        for(PowerOverhaulMaterial material : materials)
            langLines.addAll(getMaterialComponents(material));
        writeToFile();
    }

    private static HashSet<String> getMaterialComponents(PowerOverhaulMaterial material) {
        HashSet<String> lines = new HashSet<>();
        for(MaterialUtil.Component component : MaterialUtil.Component.values())
            lines.add(MaterialUtil.getLangName(material, component)
                + MaterialUtil.getEnglishTranslation(material, component));
        return lines;
    }

    private static void writeToFile() throws FileNotFoundException {
        PrintWriter printWriter = new PrintWriter(new FileOutputStream(langFile));
        for(String line : langLines)
            printWriter.write(line + "\n");
        printWriter.close();
    }
}
