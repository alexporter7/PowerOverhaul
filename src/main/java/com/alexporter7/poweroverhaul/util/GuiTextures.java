package com.alexporter7.poweroverhaul.util;

import com.alexporter7.poweroverhaul.PowerOverhaul;

public enum GuiTextures {

    STEEL_BACKGROUND("gui/background/steel", "steel_background"),

    BUTTON_STANDARD("gui/button/standard", "standard_button"),
    BUTTON_PRESSED("gui/button/standard_pressed", "standard_button_pressed"),
    BUTTON_DISABLED("gui/button/standard_disabled", "standard_button_disabled"),

    BUTTON_TOGGLE("gui/button/standard_toggle", "standard_toggle"),
    BUTTON_TOGGLE_DISABLED("gui/button/standard_toggle_disabled", "standard_toggle_disabled"),

    TITLE_BACKGROUND("gui/tab/title_dark_steel", "title_dark_steel");

    private final String location;
    private final String name;

    GuiTextures(String location, String name) {
        this.location = PowerOverhaul.MODID + ":" + location;
        this.name = PowerOverhaul.MODID + ":" + name;
    }

    public String getLocation() {
        return this.location;
    }

    public String getName() {
        return this.name;
    }
}
