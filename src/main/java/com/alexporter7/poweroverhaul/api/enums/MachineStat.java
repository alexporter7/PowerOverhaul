package com.alexporter7.poweroverhaul.api.enums;

public class MachineStat {

    public enum Generator {
        IGNITION,
        RPM,
        MAX_RPM,
        TORQUE,
        HORSEPOWER,
        ENGINE_TEMP,
        THROTTLE,
        STARTING_TICKS
    }

    public enum MACHINE {
        ACTIVE,
        INTERNAL_TEMPERATURE,
        EXTERNAL_TEMPERATURE,
        RECIPE_PROGRESS
    }

    public enum ENGINE_BLOCK {
        DURABILITY
    }

}
