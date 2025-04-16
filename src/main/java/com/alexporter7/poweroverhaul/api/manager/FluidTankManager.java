package com.alexporter7.poweroverhaul.api.manager;

import com.alexporter7.poweroverhaul.fluid.PowerOverhaulFluid;
import net.minecraftforge.fluids.FluidTank;

import java.util.HashMap;

public class FluidTankManager {

    private final HashMap<Enum<?>, FluidTank> tanks = new HashMap<>();

    public FluidTankManager() {

    }

    public FluidTankManager createFluidTank(Enum<?> fluid, int capacity) {
        tanks.put(fluid, new FluidTank(capacity));
        return this;
    }

    public FluidTank getTank(Enum<?> fluid) {
        return (tanks.containsKey(fluid)) ? tanks.get(fluid) : new FluidTank(1000);
    }

}
