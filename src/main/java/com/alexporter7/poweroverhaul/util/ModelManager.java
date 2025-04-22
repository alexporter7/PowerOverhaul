package com.alexporter7.poweroverhaul.util;

import net.minecraft.util.ResourceLocation;

import com.alexporter7.poweroverhaul.PowerOverhaul;

public class ModelManager {

    public enum Texture {

        /* Blocks */
        DIESEL_GENERATOR("textures/models/diesel_generator"),
        MUSIC_PLAYER("textures/models/music_player"),
        ALLOY_SMELTER("textures/models/alloy_smelter"),

        ENGINE_BLOCK_4("textures/models/engine_block_4"),
        ENGINE_BLOCK_6("textures/models/engine_block_6"),
        ENGINE_BLOCK_8("textures/models/engine_block_8"),

        ENGINE_HEAD_4("textures/models/engine_head_4"),
        ENGINE_HEAD_6("textures/models/engine_head_6"),
        ENGINE_HEAD_8("textures/models/engine_head_8"),

        /* Items */
        NETWORK_TOOL("textures/models/network_tool"),

        /* Entities */
        APPA_ENTITY("textures/models/entities/appa");

        private final ResourceLocation resourceLocation;

        Texture(String location) {
            this.resourceLocation = new ResourceLocation(PowerOverhaul.MODID + ":" + location + ".png");
        }

        public ResourceLocation getResourceLocation() {
            return this.resourceLocation;
        }
    }

}
