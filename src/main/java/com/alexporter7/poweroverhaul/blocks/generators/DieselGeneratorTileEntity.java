package com.alexporter7.poweroverhaul.blocks.generators;

import com.alexporter7.poweroverhaul.PowerOverhaul;
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
        WARM_UP,
        IDLE,
        ACTIVE,
    }

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

    private void toggleEngineOn() {
        if (this.engineTemp < ENGINE_IDLE_TEMP) this.state = State.WARM_UP;
        else this.state = State.IDLE;
    }

    private void toggleEngineOff() {
        this.state = State.OFF;
    }

    @Override
    public ModularPanel buildUI(PosGuiData data, PanelSyncManager syncManager) {
        return GuiDefinitions.buildDieselGeneratorGui(data, syncManager, this);
    }

    @Override
    public void updateEntity() {

        if(getWorldObj().isRemote)
            updateRpm();

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

    private int getTargetRpm() {
        if(this.state == State.WARM_UP && this.throttle == 0)
            return ENGINE_WARM_UP_TARGET_RPM;
        else if(this.state == State.IDLE && this.throttle == 0)
            return ENGINE_IDLE_TARGET_RPM;
        else
            return (int)(((double) this.throttle / 100) * this.maxRpm);
    }
}
