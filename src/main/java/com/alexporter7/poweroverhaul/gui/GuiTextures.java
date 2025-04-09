package com.alexporter7.poweroverhaul.gui;

import com.alexporter7.poweroverhaul.PowerOverhaul;
import com.cleanroommc.modularui.api.GuiAxis;
import com.cleanroommc.modularui.drawable.TabTexture;
import com.cleanroommc.modularui.drawable.UITexture;

public enum GuiTextures {

    STEEL_BACKGROUND("gui/background/steel", "steel_background"),

    BUTTON_STANDARD("gui/button/standard", "standard_button"),
    BUTTON_PRESSED("gui/button/standard_pressed", "standard_button_pressed"),
    BUTTON_DISABLED("gui/button/standard_disabled", "standard_button_disabled"),

    BUTTON_TOGGLE("gui/button/standard_toggle", "standard_toggle"),
    BUTTON_TOGGLE_DISABLED("gui/button/standard_toggle_disabled", "standard_toggle_disabled"),

    TITLE_BACKGROUND("gui/tab/title_dark_steel", "title_dark_steel"),

    TAB_RIGHT("gui/tab/tabs_right", "tabs_right");

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

    public static final TabTexture STEEL_TAB_RIGHT = TabTexture
        .of(UITexture.fullImage(GuiTextures.TAB_RIGHT.getLocation()), GuiAxis.X, true, 32, 28, 4);
}
