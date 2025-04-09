package com.alexporter7.poweroverhaul.api.enums;

public enum Dimension {

    OVERWORLD(0),
    NETHER(1),
    END(2);

    private final int dimensionId;

    Dimension(int dimensionId) {
        this.dimensionId = dimensionId;
    }

    public int ID() {
        return this.dimensionId;
    }
}
