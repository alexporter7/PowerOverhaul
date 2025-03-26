package com.alexporter7.poweroverhaul.api.modularui2;

import java.util.HashMap;

public class GuiProperties {

    public enum Property {
        GUI_BACKGROUND,
        GUI_NAME,

        TITLE,
        TITLE_NAME,
        TITLE_BACKGROUND
    }

    private final HashMap<Property, String> props;
    private final int width;
    private final int height;

    public GuiProperties() {
        this(176, 166, new HashMap<Property, String>());
    }

    public GuiProperties(int width, int height) {
        this(width, height, new HashMap<Property, String>());
    }

    public GuiProperties(int width, int height, HashMap<Property, String> props) {
        this.width = width;
        this.height = height;
        this.props = props;
    }

    public GuiProperties addProperty(Property property, String value) {
        this.props.put(property, value);
        return this;
    }

    public String getProperty(Property property) {
        return this.props.get(property);
    }

    public void setProperty(Property property, String value) {
        this.addProperty(property, value);
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }
}
