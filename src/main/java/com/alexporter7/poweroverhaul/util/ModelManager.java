package com.alexporter7.poweroverhaul.util;

import net.minecraft.util.ResourceLocation;

import com.alexporter7.poweroverhaul.PowerOverhaul;

public class ModelManager {

    public enum Texture {

        /* Blocks */
        DIESEL_GENERATOR("textures/models/diesel_generator"),
        MUSIC_PLAYER("textures/models/music_player"),
        ALLOY_SMELTER("textures/models/alloy_smelter"),

        /* Items */
        NETWORK_TOOL("textures/models/network_tool");

        private final ResourceLocation resourceLocation;

        Texture(String location) {
            this.resourceLocation = new ResourceLocation(PowerOverhaul.MODID + ":" + location + ".png");
        }

        public ResourceLocation getResourceLocation() {
            return this.resourceLocation;
        }
    }

}
