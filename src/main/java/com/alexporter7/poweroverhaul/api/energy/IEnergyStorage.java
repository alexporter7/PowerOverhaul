package com.alexporter7.poweroverhaul.api.energy;

/**
 * Implemented when an object will store energy
 */
public interface IEnergyStorage {

    /**
     * Gets energy stored in object
     * 
     * @return amount of energy object currently contains
     */
    int getEnergyStored();

    /**
     * Adds energy into the object
     * 
     * @param energy amount of energy to add
     */
    void addEnergy(int energy);

    /**
     * Uses energy from the object's buffer
     * 
     * @param energy amount of energy to use
     */
    void useEnergy(int energy);

    /**
     * Whether a machine can accept energy
     * 
     * @return true if it can, false if it cannot
     */
    boolean canAcceptEnergy();
}
