package com.alexporter7.poweroverhaul.api.energy;

import net.minecraftforge.common.util.ForgeDirection;

public interface IEnergyConsumer {

    /**
     * Whether a machine can import energy (if not at capacity, if there's something that can export it)
     * 
     * @param side Side to import energy
     * @return True if conditions are met
     */
    boolean canImportEnergy(ForgeDirection side);

    /**
     * Imports energy from the side specified
     * 
     * @param side Side to import energy
     * @return Returns true if the block providing the energy was able to export
     */
    boolean importEnergy(ForgeDirection side);

}
