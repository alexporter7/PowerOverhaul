package com.alexporter7.poweroverhaul.items.components;

public enum ComponentMaterial {

    IRON(1.0, 1.0, 0.5, 0.2, "Iron"),
    STEEL(1.2, 1.2, 0.7, 0.3, "Steel"),
    ALUMINIUM(1.4, 1.4, 0.9, 0.4, "Aluminium"),
    DARK_STEEL(1.5, 1.6, 1.2, 0.5, "Dark Steel");

    private final double durabilityFactor;
    private final double rpmFactor;
    private final double torqueFactor;
    private final double powerEfficiencyFactor;
    private final String materialName;
    private final String unlocalizedMaterialName;

    ComponentMaterial(double durabilityFactor, double rpmFactor, double torqueFactor, double powerEfficiencyFactor,
        String materialName) {
        this.durabilityFactor = durabilityFactor;
        this.rpmFactor = rpmFactor;
        this.torqueFactor = torqueFactor;
        this.powerEfficiencyFactor = powerEfficiencyFactor;
        this.materialName = materialName;
        this.unlocalizedMaterialName = formatUnlocalizedMaterialName(materialName);
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

    public String getMaterialName() {
        return materialName;
    }

    public String getUnlocalizedMaterialName() {
        return this.unlocalizedMaterialName;
    }

    public static String formatUnlocalizedMaterialName(String materialName) {
        return materialName.replaceAll(" ", "_").toLowerCase();
    }
}
