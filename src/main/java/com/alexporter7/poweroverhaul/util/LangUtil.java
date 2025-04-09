package com.alexporter7.poweroverhaul.util;

public class LangUtil {

    public static final String ITEM = "item.";
    public static final String BLOCK = "tile.";
    public static final String FLUID = "fluid.";

    public static String getLangKey(String prefix, String itemName) {
        StringBuilder key = new StringBuilder().append(prefix);
        for (String word : itemName.split("_")) key.append(
            word.substring(0, 1)
                .toUpperCase())
            .append(
                word.substring(1)
                    .toLowerCase());
        key.append(".name");
        return key.toString();
    }
}
