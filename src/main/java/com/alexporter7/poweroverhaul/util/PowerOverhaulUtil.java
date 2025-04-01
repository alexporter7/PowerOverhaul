package com.alexporter7.poweroverhaul.util;

import com.alexporter7.poweroverhaul.PowerOverhaul;

import java.util.Random;

public class PowerOverhaulUtil {

    public static final Random RANDOM = new Random();

    public static boolean getRandomChance(int percent) {
        return (percent > (Math.random() * 100));
    }

    public static int getRandomValue(int percent, int min, int max) {
        return (getRandomChance(percent))
            ? RANDOM.nextInt(max + 1) + min
            : 0;
    }

}
