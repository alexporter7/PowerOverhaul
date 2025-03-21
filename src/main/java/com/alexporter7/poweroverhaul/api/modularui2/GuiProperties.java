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

    public GuiProperties() {
        this.props = new HashMap<>();
    }

    public GuiProperties(HashMap<Property, String> props) {
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
}
