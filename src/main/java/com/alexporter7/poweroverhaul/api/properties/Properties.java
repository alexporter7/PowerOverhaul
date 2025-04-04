package com.alexporter7.poweroverhaul.api.properties;

import java.util.HashMap;

public class Properties<K> {

    private final HashMap<Enum<?>, K> properties;

    public Properties(PropertyBuilder<K> builder) {
        this.properties = builder.getProperties();
    }

    public K getProperty(Enum<?> property) {
        return properties.get(property);
    }

    public static class PropertyBuilder<K> {

        private final HashMap<Enum<?>, K> properties = new HashMap<>();

        public PropertyBuilder() {}

        public PropertyBuilder<K> addProperty(Enum<?> property, K value) {
            this.properties.put(property, value);
            return this;
        }

        public HashMap<Enum<?>, K> getProperties() {
            return this.properties;
        }

        public Properties<K> build() {
            return new Properties<K>(this);
        }
    }

}
