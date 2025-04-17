package com.alexporter7.poweroverhaul.blocks.generators;

import com.alexporter7.poweroverhaul.api.enums.FluidEnum;
import com.alexporter7.poweroverhaul.api.enums.Sound;
import com.alexporter7.poweroverhaul.api.sound.MachineSoundHandler;
import com.alexporter7.poweroverhaul.api.state.IStateManager;
import com.alexporter7.poweroverhaul.api.state.StateManager;
import com.alexporter7.poweroverhaul.blocks.meta.MetaGeneratorTileEntity;
import com.alexporter7.poweroverhaul.init.StateDef;
import com.alexporter7.poweroverhaul.util.SoundManager;
import net.minecraft.client.Minecraft;
import net.minecraft.nbt.NBTTagCompound;

import com.alexporter7.poweroverhaul.PowerOverhaul;
import com.alexporter7.poweroverhaul.api.properties.GeneratorProperties;
import com.alexporter7.poweroverhaul.gui.GuiDefinitions;
import com.alexporter7.poweroverhaul.init.PropertyDef;
import com.cleanroommc.modularui.factory.PosGuiData;
import com.cleanroommc.modularui.screen.ModularPanel;
import com.cleanroommc.modularui.value.sync.PanelSyncManager;

import static com.alexporter7.poweroverhaul.api.enums.FluidEnum.*;
import static com.alexporter7.poweroverhaul.api.enums.SlotType.*;

public class DieselGeneratorTileEntity extends MetaGeneratorTileEntity<MetaGeneratorTileEntity.State>
    implements IStateManager<MetaGeneratorTileEntity.State> {

    private final StateManager<State, DieselGeneratorTileEntity> stateManager;
    private final SoundManager<MachineSoundHandler> soundManager;
    //private final int totalStartingTicks = 14;
    private final int totalStartingTicks = 28;
    private int startingTicks = 0;

    public DieselGeneratorTileEntity() {
        super(new GeneratorProperties(PropertyDef.DIESEL_GEN_PROPS));
        this.maxRpm = 4500;
        this.fluidTankManager
            .createFluidTank(COOLANT, 16000)
            .createFluidTank(OIL, 16000)
            .createFluidTank(DIESEL, 16000);
        this.itemStackManager
            .createItemStackHandler(ENGINE_SLOT)
            .createItemStackHandler(TURBO_SLOT)
            .createItemStackHandler(NOS_SLOT);
        this.stateManager = StateDef.initDieselGenStateManager(this);
        this.soundManager = new SoundManager<MachineSoundHandler>()
            .addSound(Sound.DIESEL_ENGINE_START, new MachineSoundHandler(Sound.DIESEL_ENGINE_START, this))
            .addSound(Sound.DIESEL_ENGINE_WARM_UP, new MachineSoundHandler(Sound.DIESEL_ENGINE_WARM_UP, this))
            .addSound(Sound.DIESEL_ENGINE_IDLE, new MachineSoundHandler(Sound.DIESEL_ENGINE_IDLE, this));
    }



    @Override
    public void writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);
        fluidTankManager.writeTanksToNbt(compound);
        itemStackManager.writeItemStacksToNbt(compound);
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        fluidTankManager.readTanksFromNbt(compound);
        itemStackManager.readItemStacksFromNbt(compound);
    }

    @Override
    public ModularPanel buildUI(PosGuiData data, PanelSyncManager syncManager) {
        return GuiDefinitions.buildDieselGeneratorGui(data, syncManager, this);
    }

    public boolean getIgnition() {
        return this.ignition;
    }

    public void setIgnition(boolean val) {
        this.ignition = val;
    }

    @Override
    public void updateEntity() {
        if(getWorldObj().isRemote)
            return;

        updateState();
        updateRpm();
        updateFluids();
        updateTemperature();
        markDirty();
    }

    @Override
    protected void updateFluids() {
        if(!hasFuel()) {
            ignition = false;
            throttle = 0;
            return;
        }

//        if(state != State.OFF && state != State.MAINTENANCE && state != State.PROBLEM)
//            fluidTankManager.getTank(DIESEL).drain(10, true);
    }

    //TODO: implement maintenance
    @Override
    protected void updateState() {
        stateManager.tickState();
    }

    public void requestSound(State previousState, State newState) {
        soundManager.requestSound(getSoundFromState(newState));
    }

    public void stopSound(State previousState, State newState) {
        if(soundManager != null)
            soundManager.stopSound();
    }

    private Sound getSoundFromState(State state) {
        return switch(state) {
            case STARTING -> Sound.DIESEL_ENGINE_START;
            case WARM_UP -> Sound.DIESEL_ENGINE_WARM_UP;
            case IDLE -> Sound.DIESEL_ENGINE_IDLE;
            default -> null;
        };
    }

    public boolean hasCoolant() {
        return this.fluidTankManager.getTank(FluidEnum.COOLANT).getFluidAmount() != 0;
    }

    public boolean hasOil() {
        return this.fluidTankManager.getTank(FluidEnum.OIL).getFluidAmount() != 0;
    }

    public boolean hasFuel() {
        return this.fluidTankManager.getTank(FluidEnum.DIESEL).getFluidAmount() != 0;
    }

    /* Off State */
    public void resetStartingTickes() {
        startingTicks = totalStartingTicks;
    }

    public State checkOffConditions() {
        return (ignition) ? State.STARTING : State.OFF;
    }

    /* Starting State */
    public State checkStartingConditions() {
        if(!ignition)
            return State.OFF;
        if(startingTicks == 0)
            return checkWarmUpConditions();
        return State.STARTING;
    }

    public void decrementStartingTicks(Enum<State> state) {
        if(startingTicks > 0)
            startingTicks--;
    }

    /* Warm Up State */
    public State checkWarmUpConditions() {
        if(!ignition)
            return State.OFF;
        if (this.engineTemp < generatorProperties.engineIdleTemp)
            return State.WARM_UP;
        else
            return (this.throttle == 0) ? State.IDLE : State.ACTIVE;
    }

    /* Idle State */
    public State checkIdleConditions() {
        if(!ignition)
            return State.OFF;
        if(throttle != 0)
            return State.ACTIVE;
        return State.IDLE;
    }

    /* Active State */
    public State checkActiveConditions() {
        if(!ignition)
            return State.OFF;
        if(throttle == 0)
            return State.IDLE;
        return State.ACTIVE;
    }

    @Override
    public void updateEntityState(State state) {
        this.state = state;
    }

    @Override
    public State getEntityState() {
        return this.state;
    }
}
