package com.alexporter7.poweroverhaul.blocks.generators;

import com.alexporter7.poweroverhaul.PowerOverhaul;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fluids.FluidTank;

import com.alexporter7.poweroverhaul.api.modularui2.GuiDefinitions;
import com.alexporter7.poweroverhaul.blocks.meta.MetaPowerOverhaulTileEntity;
import com.alexporter7.poweroverhaul.gui.GuiHelper;
import com.cleanroommc.modularui.factory.PosGuiData;
import com.cleanroommc.modularui.screen.ModularPanel;
import com.cleanroommc.modularui.utils.item.ItemStackHandler;
import com.cleanroommc.modularui.value.sync.PanelSyncManager;

public class DieselGeneratorTileEntity extends MetaPowerOverhaulTileEntity {

    private static final int ENGINE_OFF_TEMP = 75;
    private static final int ENGINE_IDLE_TEMP = 190;
    private static final int ENGINE_MAX_TEMP = 230;

    private static final int ENGINE_WARM_UP_TARGET_RPM = 1200;
    private static final int ENGINE_IDLE_TARGET_RPM = 750;

    public enum State {
        OFF,
        STARTING,
        WARM_UP,
        IDLE,
        ACTIVE
    }

    public boolean ignition = false;
    public boolean turbo = false;
    public boolean nos = false;

    public State state = State.OFF;

    /* Engine Derived Values */
    public int maxRpm = 4500;
    public int torque;

    public int rpm = 0;
    public int horsepower = 0;
    public int engineTemp = 0;
    public int engineDays = 0;

    public int throttle = 0;

    public final FluidTank coolant = new FluidTank(16000);
    public final FluidTank oil = new FluidTank(16000);
    public final FluidTank fuel = new FluidTank(16000);

    public final ItemStackHandler engineSlot = GuiHelper.createStackHandlerLimit(1);
    public final ItemStackHandler turboSlot = GuiHelper.createStackHandlerLimit(1);
    public final ItemStackHandler nosSlot = GuiHelper.createStackHandlerLimit(1);

    public DieselGeneratorTileEntity() {

    }

    @Override
    public void writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);

        this.coolant.writeToNBT(compound);
        this.oil.writeToNBT(compound);
        this.fuel.writeToNBT(compound);

        compound.setTag("engineSlot", this.engineSlot.serializeNBT());
        compound.setTag("turboSlot", this.turboSlot.serializeNBT());
        compound.setTag("nosSlot", this.nosSlot.serializeNBT());
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);

        this.coolant.readFromNBT(compound);
        this.oil.readFromNBT(compound);
        this.fuel.readFromNBT(compound);

        this.engineSlot.deserializeNBT(compound.getCompoundTag("engineSlot"));
        this.turboSlot.deserializeNBT(compound.getCompoundTag("turboSlot"));
        this.nosSlot.deserializeNBT(compound.getCompoundTag("nosSlot"));
    }

    public void toggleIgnition() {
        this.ignition = !this.ignition;
    }

    @Override
    public ModularPanel buildUI(PosGuiData data, PanelSyncManager syncManager) {
        return GuiDefinitions.buildDieselGeneratorGui(data, syncManager, this);
    }

    @Override
    public void updateEntity() {

        if(getWorldObj().isRemote) {
            updateState();
            updateRpm();
        }

    }

    public void updateRpm() {
        int targetRpm = getTargetRpm();
        if(this.rpm == targetRpm)
            return;

        if(this.rpm < targetRpm)
            this.rpm += Math.min(100, targetRpm - this.rpm);
        else
            this.rpm -= Math.min(100, this.rpm - targetRpm);
    }

    public void updateState() {
        if(!this.ignition) {
            this.state = State.OFF;
            return;
        }

        if(this.engineTemp < ENGINE_IDLE_TEMP)
            this.state = State.WARM_UP;
        else
            this.state = (this.throttle == 0)
                ? State.IDLE
                : State.ACTIVE;
    }

    public void updateTemperature() {

    }

    public void updateHorsepower() {

    }

    public void updateFluids() {

    }

    private int getTargetRpm() {
        if(this.state == State.OFF)
            return 0;
        else if(this.state == State.WARM_UP && this.throttle == 0)
            return ENGINE_WARM_UP_TARGET_RPM;
        else if(this.state == State.IDLE && this.throttle == 0)
            return ENGINE_IDLE_TARGET_RPM;
        else
            return (int)(Math.max(getThrottlePercent() * this.maxRpm, getIdleRpmTarget()));
    }

    private double getThrottlePercent() {
        return (double) this.throttle / 100;
    }

    private int getIdleRpmTarget() {
        return (this.state == State.WARM_UP) ? ENGINE_WARM_UP_TARGET_RPM : ENGINE_IDLE_TARGET_RPM;
    }

    public String getStateString() {
        return this.state.toString().substring(0, 1).toUpperCase() +
            this.state.toString().substring(1).toLowerCase().replaceAll("_", " ");
    }

    public String getRpmString() {
        return String.valueOf(this.rpm);
    }

    public String getHorsepowerString() {
        return String.valueOf(this.horsepower);
    }

    public String getTemperatureString() {
        return String.valueOf(this.engineTemp);
    }

    public String getThrottleString() {
        return String.valueOf(this.throttle) + "%";
    }

}
