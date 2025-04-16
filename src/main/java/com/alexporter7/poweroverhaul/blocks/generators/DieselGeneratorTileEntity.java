package com.alexporter7.poweroverhaul.blocks.generators;

import com.alexporter7.poweroverhaul.api.enums.FluidEnum;
import com.alexporter7.poweroverhaul.api.enums.SlotType;
import com.alexporter7.poweroverhaul.api.manager.FluidTankManager;
import com.alexporter7.poweroverhaul.api.state.StateManager;
import com.alexporter7.poweroverhaul.blocks.meta.MetaGeneratorTileEntity;
import com.alexporter7.poweroverhaul.init.StateDef;
import com.cleanroommc.modularui.api.IPanelHandler;
import net.minecraft.client.audio.SoundHandler;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;

import com.alexporter7.poweroverhaul.PowerOverhaul;
import com.alexporter7.poweroverhaul.api.modularui2.gui.GuiHelper;
import com.alexporter7.poweroverhaul.api.properties.GeneratorProperties;
import com.alexporter7.poweroverhaul.blocks.meta.MetaPowerOverhaulTileEntityUI;
import com.alexporter7.poweroverhaul.fluid.PowerOverhaulFluid;
import com.alexporter7.poweroverhaul.gui.GuiDefinitions;
import com.alexporter7.poweroverhaul.init.PropertyDef;
import com.alexporter7.poweroverhaul.util.PowerOverhaulUtil;
import com.cleanroommc.modularui.factory.PosGuiData;
import com.cleanroommc.modularui.screen.ModularPanel;
import com.cleanroommc.modularui.utils.item.ItemStackHandler;
import com.cleanroommc.modularui.value.sync.PanelSyncManager;

import static com.alexporter7.poweroverhaul.api.enums.FluidEnum.*;
import static com.alexporter7.poweroverhaul.api.enums.SlotType.*;

public class DieselGeneratorTileEntity extends MetaGeneratorTileEntity {

    private final StateManager<State> stateManager;
    private final int totalStartingTicks = 14;
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
    }

    public StateManager<State> getStateManager() {
        return stateManager;
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
        if(!ignition) {
            state = State.OFF;
            startingTicks = totalStartingTicks;
            return;
        }
        if(state == State.OFF) {
            state = State.STARTING;
            playStartingSound();
            return;
        }
        if(state == State.STARTING && startingTicks > 0) {
            startingTicks--;
            return;
        } else if (state == State.STARTING && startingTicks == 0){
            state = State.WARM_UP;
            startingTicks = totalStartingTicks;
            playIdleSound();
        }

        if (this.engineTemp < generatorProperties.engineIdleTemp) this.state = State.WARM_UP;
        else this.state = (this.throttle == 0) ? State.IDLE : State.ACTIVE;

    }

    public void playStartingSound() {
        getWorldObj().playSoundEffect(xCoord, yCoord, zCoord, PowerOverhaul.MODID + ":diesel_engine_start",
            1.0f, 1.0f);

    }

    public void stopStartingSound() {

    }

    public void playIdleSound() {
        getWorldObj().playSoundEffect(xCoord, yCoord, zCoord, PowerOverhaul.MODID + ":diesel_engine_idle",
            1.0f, 1.0f);
    }

    public void stopIdleSound() {

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

}
