package com.alexporter7.poweroverhaul;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class Config {

    public static float powerFactor = 1.0f;
    public static float rfConversionFactor = 10.0f;

    public static void synchronizeConfiguration(File configFile) {
        Configuration configuration = new Configuration(configFile);

        powerFactor = configuration.getFloat(
                "powerFactor",
                Configuration.CATEGORY_GENERAL,
                powerFactor,
                0.1f,
                10.0f,
                "Multiplies after all calculations have been run");
        rfConversionFactor = configuration.getFloat(
            "powerFactor",
            Configuration.CATEGORY_GENERAL,
            powerFactor,
            0.1f,
            10.0f,
            "Multiplies after all calculations have been run");

        if (configuration.hasChanged()) {
            configuration.save();
        }
    }

    public static void announceConfig() {
        PowerOverhaul.LOG.info(new StringBuilder()
            .append("Loading configuration")
            .append("\nPower Factor: " + powerFactor)
            .append("\nRF Conversion Factor" + rfConversionFactor)
            .toString());
    }
}
