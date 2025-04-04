package com.alexporter7.poweroverhaul.util;

import com.alexporter7.poweroverhaul.PowerOverhaul;

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
        return (getRandomChance(percent))
            ? RANDOM.nextInt(max + 1) + min
            : 0;
    }

    public static int getRandomValue(int[] properties) {
        return (properties.length == 2)
            ? getRandomValue(properties[0], properties[1])
            : getRandomValue(properties[0], properties[1], properties[2]);
    }

}
