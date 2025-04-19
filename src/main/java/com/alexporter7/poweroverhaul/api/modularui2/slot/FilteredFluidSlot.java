package com.alexporter7.poweroverhaul.api.modularui2.slot;

import java.util.HashSet;

import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;

import com.cleanroommc.modularui.widgets.FluidSlot;

public class FilteredFluidSlot<T extends Fluid> extends FluidSlot {

    private final boolean WHITE_LIST;
    private final HashSet<T> FLUIDS = new HashSet<>();

    public FilteredFluidSlot() {
        this(true);
    }

    public FilteredFluidSlot(boolean whiteList) {
        super();
        this.WHITE_LIST = whiteList;
    }

    public FilteredFluidSlot<T> addFluid(T fluid) {
        FLUIDS.add(fluid);
        return this;
    }

    public boolean canFill(T fluid) {
        return this.FLUIDS.contains(fluid) && WHITE_LIST;
    }



}
