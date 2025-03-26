package com.alexporter7.poweroverhaul.util;

import net.minecraft.util.ResourceLocation;

import com.alexporter7.poweroverhaul.PowerOverhaul;

public class ModelManager {

    public enum Texture {

        DIESEL_GENERATOR("textures/models/diesel_generator");

        private final ResourceLocation resourceLocation;

        Texture(String location) {
            this.resourceLocation = new ResourceLocation(PowerOverhaul.MODID + ":" + location + ".png");
        }

        public ResourceLocation getResourceLocation() {
            return this.resourceLocation;
        }
    }

}
