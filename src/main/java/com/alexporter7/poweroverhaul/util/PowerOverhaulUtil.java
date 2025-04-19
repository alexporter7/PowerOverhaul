package com.alexporter7.poweroverhaul.util;

import java.util.Random;

public class PowerOverhaulUtil {

    public static final Random RANDOM = new Random();

    public static boolean getRandomChance(int percent) {
        return (percent > (Math.random() * 100));
    }

    public static int getRandomValue(int min, int max) {
        return RANDOM.nextInt(max + 1) + min;
    }

    public static int getRandomValue(int percent, int min, int max) {
        return (getRandomChance(percent)) ? RANDOM.nextInt(max + 1) + min : 0;
    }

    public static int getRandomValue(int[] properties) {
        return (properties.length == 2) ? getRandomValue(properties[0], properties[1])
            : getRandomValue(properties[0], properties[1], properties[2]);
    }

    public static float getPitchFromRpm(int minRpm, int maxRpm, int rpm) {
        float range = maxRpm - minRpm;
        float percentage = rpm / range;
        return 1.0f + percentage;
    }

    public static String formatEnum(Enum<?> value) {
        return value.toString().charAt(0) + value.toString().substring(1).toLowerCase();
    }

}
