package com.alexporter7.poweroverhaul.util;

import java.util.Arrays;
import java.util.List;

import com.alexporter7.poweroverhaul.items.components.ComponentMaterial;
import com.alexporter7.poweroverhaul.items.engines.EngineProperties;

public class EngineUtil {

    private static final int defaultTorque = 100;
    private static final int defaultMaxRpm = 5000;
    private static final int powerFactor = 1;
    private static final int conversionFactor = 10;

    public static EngineProperties createEngineProperties(ComponentMaterial piston, ComponentMaterial engineBlock,
        ComponentMaterial engineHead) {
        int torque = calculateTorque(Arrays.asList(piston, engineBlock, engineHead));
        int maxRpm = calculateRpm(Arrays.asList(piston, engineBlock, engineHead));
        int horsepower = calculateHorsePower(torque, maxRpm);
        return new EngineProperties(piston, engineBlock, engineHead, torque, maxRpm, horsepower);
    }

    public static int calculateHorsePower(int torque, int maxRpm) {
        return (torque * maxRpm) / 5252;
    }

    public static int calculateTorque(List<ComponentMaterial> components) {
        double torqueFactor = 1;
        for (ComponentMaterial component : components) torqueFactor = torqueFactor * component.getTorqueFactor();
        return (int) (torqueFactor * defaultTorque);
    }

    public static int calculateRpm(List<ComponentMaterial> components) {
        double rpmFactor = 1;
        for (ComponentMaterial component : components) rpmFactor = rpmFactor * component.getRpmFactor();
        return (int) (rpmFactor * defaultMaxRpm);
    }

    public static double calculatePowerEfficiency(int currentRpm, int maxRpm, double peFactor) {
        return Math.max(peFactor, ((double) currentRpm) / ((double) maxRpm));
    }

    public static int calculatePower(int horsepower, int peFactor) {
        return powerFactor * horsepower * conversionFactor * peFactor;
    }

}
