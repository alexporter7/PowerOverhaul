package com.alexporter7.poweroverhaul.items.components;

public enum ComponentMaterial {

    TIER1(1.0, 1.0, 0.5, 0.2),
    TIER2(1.2, 1.2, 0.7, 0.3),
    TIER3(1.4, 1.4, 0.9, 0.4),
    TIER4(1.5, 1.6, 1.2, 0.5);

    private final double durabilityFactor;
    private final double rpmFactor;
    private final double torqueFactor;
    private final double powerEfficiencyFactor;

    ComponentMaterial(double durabilityFactor, double rpmFactor, double torqueFactor, double powerEfficiencyFactor) {
        this.durabilityFactor = durabilityFactor;
        this.rpmFactor = rpmFactor;
        this.torqueFactor = torqueFactor;
        this.powerEfficiencyFactor = powerEfficiencyFactor;
    }

    public double getDurabilityFactor() {
        return durabilityFactor;
    }

    public double getRpmFactor() {
        return rpmFactor;
    }

    public double getTorqueFactor() {
        return torqueFactor;
    }

    public double getPowerEfficiencyFactor() {
        return powerEfficiencyFactor;
    }
}
