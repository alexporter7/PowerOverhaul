package com.alexporter7.poweroverhaul.blocks.generators;

import com.alexporter7.poweroverhaul.PowerOverhaul;
import com.alexporter7.poweroverhaul.api.properties.GeneratorProperties;
import com.alexporter7.poweroverhaul.fluid.PowerOverhaulFluid;
import com.alexporter7.poweroverhaul.init.PropertyDef;
import com.alexporter7.poweroverhaul.util.PowerOverhaulUtil;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;

import com.alexporter7.poweroverhaul.gui.GuiDefinitions;
import com.alexporter7.poweroverhaul.blocks.meta.MetaPowerOverhaulTileEntityUI;
import com.alexporter7.poweroverhaul.api.modularui2.gui.GuiHelper;
import com.cleanroommc.modularui.factory.PosGuiData;
import com.cleanroommc.modularui.screen.ModularPanel;
import com.cleanroommc.modularui.utils.item.ItemStackHandler;
import com.cleanroommc.modularui.value.sync.PanelSyncManager;

public class DieselGeneratorTileEntity extends MetaPowerOverhaulTileEntityUI {

    private static final GeneratorProperties generatorProperties =
        new GeneratorProperties(PropertyDef.DIESEL_GEN_PROPS);

    public enum State {
        OFF,
        STARTING,
        WARM_UP,
        IDLE,
        ACTIVE,
        MAINTENANCE,
        PROBLEM
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

    public final ItemStackHandler engineSlot = GuiHelper.createStackHandlerLimit(1);
    public final ItemStackHandler turboSlot = GuiHelper.createStackHandlerLimit(1);
    public final ItemStackHandler nosSlot = GuiHelper.createStackHandlerLimit(1);

    public final FluidTank coolant = new FluidTank(16000);
    public final FluidTank oil = new FluidTank(16000);
    public final FluidTank fuel = new FluidTank(16000);

    public DieselGeneratorTileEntity() {

    }

    @Override
    public void writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);

        compound.setString("engineState", this.state.name());

        compound.setTag("engineSlot", this.engineSlot.serializeNBT());
        compound.setTag("turboSlot", this.turboSlot.serializeNBT());
        compound.setTag("nosSlot", this.nosSlot.serializeNBT());

        compound.setTag("coolant", this.coolant.writeToNBT(new NBTTagCompound()));
        compound.setTag("oil", this.oil.writeToNBT(new NBTTagCompound()));
        compound.setTag("fuel", this.fuel.writeToNBT(new NBTTagCompound()));
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);

        this.state = State.valueOf(compound.getString("engineState"));

        this.engineSlot.deserializeNBT(compound.getCompoundTag("engineSlot"));
        this.turboSlot.deserializeNBT(compound.getCompoundTag("turboSlot"));
        this.nosSlot.deserializeNBT(compound.getCompoundTag("nosSlot"));

        this.coolant.readFromNBT(compound.getCompoundTag("coolant"));
        this.oil.readFromNBT(compound.getCompoundTag("oil"));
        this.fuel.readFromNBT(compound.getCompoundTag("fuel"));

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
            updateFluids();
            updateTemperature();
            markDirty();
            try {
//                String t = getCoolantString();
               PowerOverhaul.LOG.info(this.coolant.getFluidAmount());
            } catch (Exception ignored) {

            }

        }
//        else {
//            try {
//                getCoolantString();
//            } catch (Exception ignored) {
//
//            }
//        }

    }

    public void updateRpm() {
        int targetRpm = getTargetRpm();
        if(this.rpm == targetRpm)
            return;

        if(this.rpm < targetRpm)
            this.rpm += Math.min(
                PowerOverhaulUtil.getRandomValue(generatorProperties.engineTargetRpmStep),
                targetRpm - this.rpm);
        else
            this.rpm -= Math.min(
                PowerOverhaulUtil.getRandomValue(generatorProperties.engineTargetRpmStep),
                this.rpm - targetRpm);
    }

    public void updateState() {
        if(!this.ignition && this.state != State.MAINTENANCE) {
            this.state = State.OFF;
            return;
        }

        if(this.engineTemp < generatorProperties.engineIdleTemp)
            this.state = State.WARM_UP;
        else
            this.state = (this.throttle == 0)
                ? State.IDLE
                : State.ACTIVE;
    }

    public void updateTemperature() {
        switch (this.state) {
            case OFF -> decrementEngineTemp(PowerOverhaulUtil.getRandomValue(
                generatorProperties.engineOffTempStep));
            case WARM_UP -> incrementEngineTemp(PowerOverhaulUtil.getRandomValue(
                generatorProperties.engineWarmUpTempStep));
//            case IDLE -> incrementEngineTemp(PowerOverhaulUtil.getRandomValue(
//                ENGINE_IDLE_TEMP_PROPS[0], ENGINE_IDLE_TEMP_PROPS[1], ENGINE_IDLE_TEMP_PROPS[2]));
        }
    }

    private void decrementEngineTemp(int temp) {
        this.engineTemp = Math.max(this.engineTemp - temp, generatorProperties.engineOffTemp);
    }

    private void incrementEngineTemp(int temp) {
        if(this.state == State.ACTIVE)
            this.engineTemp = Math.min(this.engineTemp + temp, generatorProperties.engineMaxTemp);
        else
            this.engineTemp = Math.min(this.engineTemp + temp, generatorProperties.engineIdleTemp);
    }

    public void updateHorsepower() {

    }

    public void updateFluids() {
        if(this.state != State.OFF && this.state != State.MAINTENANCE)
            return;
//        if(this.coolant.getFluidAmount() != 0)
//            ((PowerOverhaulFluid)this.coolant.getFluid().getFluid()).decrementQuality();
    }

    private boolean hasCoolant() {
        return this.coolant.getFluidAmount() != 0;
    }

    private boolean hasOil() {
        return this.oil.getFluidAmount() != 0;
    }

    private boolean hasFuel() {
        return this.fuel.getFluidAmount() != 0;
    }

    private int getTargetRpm() {
        if(this.state == State.OFF)
            return 0;
        else if(this.state == State.WARM_UP && this.throttle == 0)
            return generatorProperties.engineWarmUpTargetRpm;
        else if(this.state == State.IDLE && this.throttle == 0)
            return generatorProperties.engineIdleTargetRpm;
        else
            return (int)(Math.max(getThrottlePercent() * this.maxRpm, getIdleRpmTarget()));
    }

    private double getThrottlePercent() {
        return (double) this.throttle / 100;
    }

    private int getIdleRpmTarget() {
        return (this.state == State.WARM_UP)
            ? generatorProperties.engineWarmUpTargetRpm
            : generatorProperties.engineIdleTargetRpm;
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

    public boolean canEditFluids() {
        return this.state == State.MAINTENANCE;
    }

    public String getCoolantString() {
        FluidTank fluidTank = this.coolant;
        FluidStack fluidStack = fluidTank.getFluid();
        PowerOverhaulFluid fluid = (PowerOverhaulFluid) fluidStack.getFluid();
        return "Quality: " + fluid.getQuality() + "%";
    }

}
