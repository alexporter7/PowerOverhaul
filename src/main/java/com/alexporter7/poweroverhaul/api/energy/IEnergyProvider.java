package com.alexporter7.poweroverhaul.api.energy;

import net.minecraftforge.common.util.ForgeDirection;

public interface IEnergyProvider {

    /**
     * Whether a machine can export energy (if it has enough, if there's something that can accept it)
     * @param side Side to export energy
     * @return true if conditions are met
     */
    boolean canExportEnergy(ForgeDirection side);

    /**
     * Exports energy to the side specified
     * @param side Side to export energy
     * @return Returns true if the block accepting the energy was able to accept
     */
    boolean exportEnergy(ForgeDirection side);

}
