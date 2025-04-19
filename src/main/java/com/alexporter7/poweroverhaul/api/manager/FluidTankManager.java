package com.alexporter7.poweroverhaul.api.manager;

import com.alexporter7.poweroverhaul.api.enums.FluidEnum;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidTank;

import java.util.HashMap;

public class FluidTankManager<T extends Fluid> {

    private final HashMap<Enum<?>, FluidTank> TANKS = new HashMap<>();

    public FluidTankManager() {

    }

    public FluidTankManager<T> createFluidTank(Enum<?> fluid, int capacity) {
        TANKS.put(fluid, new FluidTank(capacity));
        return this;
    }

    public T getFluid(Enum<?> fluid) {
        return (T) TANKS.get(fluid).getFluid().getFluid();
    }

    public FluidTank getTank(Enum<?> fluid) {
        return (TANKS.containsKey(fluid)) ? TANKS.get(fluid) : new FluidTank(1000);
    }

    public void writeTanksToNbt(NBTTagCompound compound) {
        TANKS.forEach((key, tank) -> this.writeTankToNbt(compound, key, tank));
    }

    public void writeTankToNbt(NBTTagCompound compound, Enum<?> key, FluidTank tank) {
        compound.setTag(key.toString(), tank.writeToNBT(new NBTTagCompound()));
    }

    public void readTanksFromNbt(NBTTagCompound compound) {
        TANKS.forEach((key, tank) -> this.readTankFromNbt(compound, key, tank));
    }

    public void readTankFromNbt(NBTTagCompound compound, Enum<?> key, FluidTank tank) {
        tank.readFromNBT(compound.getCompoundTag(key.toString()));
    }

}
