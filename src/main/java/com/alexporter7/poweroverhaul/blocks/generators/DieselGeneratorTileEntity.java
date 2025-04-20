package com.alexporter7.poweroverhaul.blocks.generators;

import static com.alexporter7.poweroverhaul.api.enums.FluidEnum.*;
import static com.alexporter7.poweroverhaul.api.enums.SlotType.*;

import net.minecraft.nbt.NBTTagCompound;

import com.alexporter7.poweroverhaul.api.enums.FluidEnum;
import com.alexporter7.poweroverhaul.api.enums.Sound;
import com.alexporter7.poweroverhaul.api.enums.TileEntityState;
import com.alexporter7.poweroverhaul.api.properties.GeneratorProperties;
import com.alexporter7.poweroverhaul.api.sound.ISoundManager;
import com.alexporter7.poweroverhaul.api.sound.MachineSoundHandler;
import com.alexporter7.poweroverhaul.api.sound.SoundManager;
import com.alexporter7.poweroverhaul.api.state.IStateManager;
import com.alexporter7.poweroverhaul.api.state.StateManager;
import com.alexporter7.poweroverhaul.blocks.meta.MetaGeneratorTileEntity;
import com.alexporter7.poweroverhaul.gui.GuiDefinitions;
import com.alexporter7.poweroverhaul.init.PropertyDef;
import com.alexporter7.poweroverhaul.init.StateDef;
import com.alexporter7.poweroverhaul.util.PowerOverhaulUtil;
import com.cleanroommc.modularui.factory.PosGuiData;
import com.cleanroommc.modularui.screen.ModularPanel;
import com.cleanroommc.modularui.value.sync.PanelSyncManager;

// TODO: make ISoundManager interface
public class DieselGeneratorTileEntity extends MetaGeneratorTileEntity<TileEntityState.GeneratorState>
    implements IStateManager<TileEntityState.GeneratorState>, ISoundManager<TileEntityState.GeneratorState> {

    private final StateManager<TileEntityState.GeneratorState, DieselGeneratorTileEntity> stateManager;
    private final SoundManager<MachineSoundHandler> soundManager;
    // private final int totalStartingTicks = 14;
    private final int totalStartingTicks = 14;
    private int startingTicks = 0;

    public DieselGeneratorTileEntity() {
        super(new GeneratorProperties(PropertyDef.DIESEL_GEN_PROPS));
        this.maxRpm = 4500;
        this.fluidTankManager.createFluidTank(COOLANT, 16000)
            .createFluidTank(OIL, 16000)
            .createFluidTank(DIESEL, 16000);
        this.itemStackManager.createItemStackHandler(ENGINE_SLOT)
            .createItemStackHandler(TURBO_SLOT)
            .createItemStackHandler(NOS_SLOT);
        this.stateManager = StateDef.initDieselGenStateManager(this);
        this.soundManager = new SoundManager<MachineSoundHandler>()
            .addSound(Sound.DIESEL_ENGINE_START, new MachineSoundHandler(Sound.DIESEL_ENGINE_START, this))
            .addSound(Sound.DIESEL_ENGINE_WARM_UP, new MachineSoundHandler(Sound.DIESEL_ENGINE_WARM_UP, this))
            .addSound(Sound.DIESEL_ENGINE_IDLE, new MachineSoundHandler(Sound.DIESEL_ENGINE_IDLE, this))
            .addSound(Sound.DIESEL_ENGINE_ACTIVE, new MachineSoundHandler(Sound.DIESEL_ENGINE_ACTIVE, this));
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
        if (getWorldObj().isRemote) return;

        updateState();
        updateRpm();
        updateFluids();
        updateTemperature();
        markDirty();
    }

    @Override
    protected void updateFluids() {
        if (!hasFuel()) {
            ignition = false;
            throttle = 0;
            return;
        }
        if (hasCoolant()) if (PowerOverhaulUtil.getRandomChance(1)) fluidTankManager.getFluid(COOLANT)
            .decrementQuality();

        // if(state != State.OFF && state != State.MAINTENANCE && state != State.PROBLEM)
        // fluidTankManager.getTank(DIESEL).drain(10, true);
    }

    // TODO: implement maintenance
    @Override
    protected void updateState() {
        stateManager.tickState();
        if (state != TileEntityState.GeneratorState.OFF && state != TileEntityState.GeneratorState.STARTING)
            updateEnginePitch();
    }

    public void updateEnginePitch() {
        this.soundManager.getSoundHandler(getSoundFromState(state))
            .setPitch(PowerOverhaulUtil.getPitchFromRpm(generatorProperties.engineIdleTargetRpm, maxRpm, rpm));
    }

    @Override
    public void requestSound(TileEntityState.GeneratorState previousState, TileEntityState.GeneratorState newState) {
        soundManager.requestSound(getSoundFromState(newState));
    }

    @Override
    public void stopSound(TileEntityState.GeneratorState previousState, TileEntityState.GeneratorState newState) {
        if (soundManager != null) soundManager.stopSound();
    }

    @Override
    public Sound getSoundFromState(TileEntityState.GeneratorState state) {
        return switch (state) {
            case STARTING -> Sound.DIESEL_ENGINE_START;
            case WARM_UP -> Sound.DIESEL_ENGINE_WARM_UP;
            case IDLE -> Sound.DIESEL_ENGINE_IDLE;
            case ACTIVE -> Sound.DIESEL_ENGINE_ACTIVE;
            default -> null;
        };
    }

    public boolean hasCoolant() {
        return this.fluidTankManager.getTank(FluidEnum.COOLANT)
            .getFluidAmount() != 0;
    }

    public boolean hasOil() {
        return this.fluidTankManager.getTank(FluidEnum.OIL)
            .getFluidAmount() != 0;
    }

    public boolean hasFuel() {
        return this.fluidTankManager.getTank(FluidEnum.DIESEL)
            .getFluidAmount() != 0;
    }

    /* Off State */
    public void resetStartingTickes() {
        startingTicks = totalStartingTicks;
    }

    public TileEntityState.GeneratorState checkOffConditions() {
        return (ignition) ? TileEntityState.GeneratorState.STARTING : TileEntityState.GeneratorState.OFF;
    }

    /* Starting State */
    public TileEntityState.GeneratorState checkStartingConditions() {
        if (!ignition) return TileEntityState.GeneratorState.OFF;
        if (startingTicks == 0) return checkWarmUpConditions();
        return TileEntityState.GeneratorState.STARTING;
    }

    public void decrementStartingTicks(Enum<TileEntityState.GeneratorState> state) {
        if (startingTicks > 0) startingTicks--;
    }

    /* Warm Up State */
    public TileEntityState.GeneratorState checkWarmUpConditions() {
        if (!ignition) return TileEntityState.GeneratorState.OFF;
        if (this.engineTemp < generatorProperties.engineIdleTemp) return TileEntityState.GeneratorState.WARM_UP;
        else return (this.throttle == 0) ? TileEntityState.GeneratorState.IDLE : TileEntityState.GeneratorState.ACTIVE;
    }

    /* Idle State */
    public TileEntityState.GeneratorState checkIdleConditions() {
        if (!ignition) return TileEntityState.GeneratorState.OFF;
        if (throttle != 0) return TileEntityState.GeneratorState.ACTIVE;
        return TileEntityState.GeneratorState.IDLE;
    }

    /* Active State */
    public TileEntityState.GeneratorState checkActiveConditions() {
        if (!ignition) return TileEntityState.GeneratorState.OFF;
        if (throttle == 0) return TileEntityState.GeneratorState.IDLE;
        return TileEntityState.GeneratorState.ACTIVE;
    }

    @Override
    public void updateEntityState(TileEntityState.GeneratorState state) {
        this.state = state;
    }

    @Override
    public TileEntityState.GeneratorState getEntityState() {
        return this.state;
    }
}
