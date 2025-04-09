package com.alexporter7.poweroverhaul.api.properties;

public class PropertyList {

    public enum Generator {
        RPM_STEP_MIN,
        RPM_STEP_MAX,
        TEMP_OFF,
        TEMP_IDLE,
        TEMP_MAX,
        TARGET_RPM_WARM_UP,
        TARGET_RPM_IDLE,
        TEMP_STEP_OFF_CHANCE,
        TEMP_STEP_OFF_MIN,
        TEMP_STEP_OFF_MAX,
        TEMP_STEP_WARM_UP_CHANCE,
        TEMP_STEP_WARM_UP_MIN,
        TEMP_STEP_WARM_UP_MAX
    }

    public enum OreGen {
        MIN_VEIN_SIZE,
        MAX_VEIN_SIZE,
        MIN_HEIGHT,
        MAX_HEIGHT,
        CHANCE,
        GENERATE_IN,
        ORE
    }
}
