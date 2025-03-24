package com.alexporter7.poweroverhaul.util;

public class RenderUtil {

    public static float[] getCorrectedTranslateFloats(double x, double y, double z) {
        return new float[] {(float) x + 0.5f, (float) y + 1.5f, (float) z + 0.5f};
    }

}
