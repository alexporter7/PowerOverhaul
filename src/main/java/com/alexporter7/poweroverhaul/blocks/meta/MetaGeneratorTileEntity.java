package com.alexporter7.poweroverhaul.blocks.meta;

import com.alexporter7.poweroverhaul.api.modularui2.gui.GuiHelper;
import com.alexporter7.poweroverhaul.api.properties.GeneratorProperties;
import com.alexporter7.poweroverhaul.blocks.generators.DieselGeneratorTileEntity;
import com.alexporter7.poweroverhaul.util.PowerOverhaulUtil;
import com.cleanroommc.modularui.utils.item.ItemStackHandler;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fluids.FluidTank;

public class MetaGeneratorTileEntity extends MetaPowerOverhaulTileEntityUI {

    public enum State {
        OFF,
        STARTING,
        WARM_UP,
        IDLE,
        ACTIVE,
        MAINTENANCE,
        PROBLEM
    }

    private final GeneratorProperties generatorProperties;

    /* Configuration */
    public boolean turbo = false;
    public boolean nos = false;

    /* Engine Derived Values */
    public int maxRpm;
    public int torque = 0;

    /* State */
    public boolean ignition = false;
    public int rpm = 0;
    public int horsepower = 0;
    public int engineTemp = 0;
    public int throttle = 0;

    /* Slots */
    //TODO: probably create some ItemSlotManager object as a wrapper
    public final ItemStackHandler engineSlot = GuiHelper.createStackHandlerLimit(1);
    public final ItemStackHandler turboSlot = GuiHelper.createStackHandlerLimit(1);
    public final ItemStackHandler nosSlot = GuiHelper.createStackHandlerLimit(1);

    //TODO: probably create some FluidTankManager object as a wrapper (look at GTNH Railcraft)
    public final FluidTank coolant = new FluidTank(16000);
    public final FluidTank oil = new FluidTank(16000);
    public final FluidTank fuel = new FluidTank(16000);

    public State state = State.OFF;

    public MetaGeneratorTileEntity(GeneratorProperties generatorProperties) {
        this.generatorProperties = generatorProperties;
    }

    public GeneratorProperties getGeneratorProperties() {
        return generatorProperties;
    }

    @Override
    public void writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);

        compound.setString("engineState", this.state.name());
        compound.setInteger("rpm", this.rpm);
        compound.setInteger("horsepower", this.horsepower);
        compound.setInteger("temp", this.engineTemp);

        compound.setBoolean("ignition", this.ignition);
        compound.setInteger("throttle", this.throttle);
        compound.setBoolean("turbo", this.turbo);
        compound.setBoolean("nos", this.nos);

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

        this.rpm = compound.getInteger("rpm");
        this.horsepower = compound.getInteger("horsepower");
        this.engineTemp = compound.getInteger("temp");

        this.ignition = compound.getBoolean("ignition");
        this.throttle = compound.getInteger("throttle");
        this.turbo = compound.getBoolean("turbo");
        this.nos = compound.getBoolean("nos");

        this.engineSlot.deserializeNBT(compound.getCompoundTag("engineSlot"));
        this.turboSlot.deserializeNBT(compound.getCompoundTag("turboSlot"));
        this.nosSlot.deserializeNBT(compound.getCompoundTag("nosSlot"));

        this.coolant.readFromNBT(compound.getCompoundTag("coolant"));
        this.oil.readFromNBT(compound.getCompoundTag("oil"));
        this.fuel.readFromNBT(compound.getCompoundTag("fuel"));

    }

    protected void updateRpm() {
        int targetRpm = getTargetRpm();
        if (this.rpm == targetRpm) return;

        if (this.rpm < targetRpm) this.rpm += Math
            .min(PowerOverhaulUtil.getRandomValue(generatorProperties.engineTargetRpmStep), targetRpm - this.rpm);
        else this.rpm -= Math
            .min(PowerOverhaulUtil.getRandomValue(generatorProperties.engineTargetRpmStep), this.rpm - targetRpm);
    }

    protected int getTargetRpm() {
        if (this.state == State.OFF) return 0;
        else if (this.state == State.WARM_UP && this.throttle == 0) return generatorProperties.engineWarmUpTargetRpm;
        else if (this.state == State.IDLE && this.throttle == 0) return generatorProperties.engineIdleTargetRpm;
        else return (int) (Math.max(getThrottlePercent() * this.maxRpm, getIdleRpmTarget()));
    }

    private int getIdleRpmTarget() {
        return (this.state == State.WARM_UP) ? generatorProperties.engineWarmUpTargetRpm
            : generatorProperties.engineIdleTargetRpm;
    }

    protected void updateState() {
        if (!this.ignition && this.state != State.MAINTENANCE) {
            this.state = State.OFF;
            return;
        }

        if (this.engineTemp < generatorProperties.engineIdleTemp) this.state = State.WARM_UP;
        else this.state = (this.throttle == 0) ? State.IDLE : State.ACTIVE;
    }

    protected void updateHorsepower() {

    }

    protected void updateFluids() {

    }

    protected void updateTemperature() {
        switch (this.state) {
            case OFF -> decrementEngineTemp(PowerOverhaulUtil.getRandomValue(generatorProperties.engineOffTempStep));
            case WARM_UP -> incrementEngineTemp(
                PowerOverhaulUtil.getRandomValue(generatorProperties.engineWarmUpTempStep));
        }
    }

    protected void decrementEngineTemp(int temp) {
        this.engineTemp = Math.max(this.engineTemp - temp, generatorProperties.engineOffTemp);
    }

    protected void incrementEngineTemp(int temp) {
        if (this.state == State.ACTIVE)
            this.engineTemp = Math.min(this.engineTemp + temp, generatorProperties.engineMaxTemp);
        else
            this.engineTemp = Math.min(this.engineTemp + temp, generatorProperties.engineIdleTemp);
    }

    protected boolean hasCoolant() {
        return this.coolant.getFluidAmount() != 0;
    }

    protected boolean hasOil() {
        return this.oil.getFluidAmount() != 0;
    }

    protected boolean hasFuel() {
        return this.fuel.getFluidAmount() != 0;
    }

    protected double getThrottlePercent() {
        return (double) this.throttle / 100;
    }

    public String getRpmString() {
        return String.valueOf(this.rpm);
    }

    public String getHorsepowerString() {
        return String.valueOf(this.horsepower);
    }

    public String getTemperatureString() {
        return this.engineTemp + "°F";
    }

    public String getThrottleString() {
        return this.throttle + "%";
    }

    public String getStateString() {
        return this.state.toString()
            .substring(0, 1)
            .toUpperCase()
            + this.state.toString()
            .substring(1)
            .toLowerCase()
            .replaceAll("_", " ");
    }

    public String getState() { return this.state.toString(); }
    public void setState(String state) { this.state = State.valueOf(state); }
    public int getRpm() { return this.rpm; }
    public void setRpm(int rpm) { this.rpm = rpm; }
    public int getHp() { return this.horsepower; }
    public void setHp(int horsepower) { this.horsepower = horsepower; }
    public int getTemp() { return this.engineTemp; }
    public void setTemp(int temp) { this.engineTemp = temp; }
    public int getThrottle() { return this.throttle; }
    public void setThrottle(int val) { this.throttle = val; }
}
