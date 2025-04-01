package com.alexporter7.poweroverhaul.api.modularui2.slot;

import com.cleanroommc.modularui.widgets.FluidSlot;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;

import java.util.HashSet;

public class FilteredFluidSlot extends FluidSlot {

    private final boolean WHITE_LIST;
    private HashSet<Fluid> fluids = new HashSet<>();

    public FilteredFluidSlot() {
        super();
        this.WHITE_LIST = true;
    }

    public FilteredFluidSlot(boolean whiteList) {
        super();
        this.WHITE_LIST = whiteList;
    }

    public boolean canFill(FluidStack fluidStack) {
        return (this.fluids.contains(fluidStack.getFluid()))
            ? WHITE_LIST && true
            : WHITE_LIST && false;
    }


}
