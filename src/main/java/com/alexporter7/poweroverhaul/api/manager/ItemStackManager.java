package com.alexporter7.poweroverhaul.api.manager;

import java.util.HashMap;

import net.minecraft.nbt.NBTTagCompound;

import com.alexporter7.poweroverhaul.api.enums.SlotType;
import com.alexporter7.poweroverhaul.api.modularui2.gui.GuiHelper;
import com.cleanroommc.modularui.utils.item.ItemStackHandler;

public class ItemStackManager {

    private final HashMap<Enum<SlotType>, ItemStackHandler> STACK_HANDLERS = new HashMap<>();

    public ItemStackManager() {

    }

    public ItemStackManager createItemStackHandler(Enum<SlotType> slotType) {
        STACK_HANDLERS.put(slotType, GuiHelper.createStackHandlerLimit(1));
        return this;
    }

    public ItemStackManager createItemStackHandler(Enum<SlotType> slotType, int limit) {
        STACK_HANDLERS.put(slotType, new ItemStackHandler(limit) {

            @Override
            public int getSlotLimit(int slot) {
                return super.getSlotLimit(limit);
            }
        });
        return this;
    }

    public ItemStackHandler getItemStack(Enum<SlotType> slotType) {
        return STACK_HANDLERS.get(slotType);
    }

    public void writeItemStacksToNbt(NBTTagCompound compound) {
        STACK_HANDLERS.forEach((key, itemStack) -> this.writeItemStackToNbt(compound, key, itemStack));
    }

    public void writeItemStackToNbt(NBTTagCompound compound, Enum<SlotType> key, ItemStackHandler itemStackHandler) {
        compound.setTag(key.toString(), itemStackHandler.serializeNBT());
    }

    public void readItemStacksFromNbt(NBTTagCompound compound) {
        STACK_HANDLERS.forEach((key, itemStack) -> this.readItemStackFromNbt(compound, key, itemStack));
    }

    public void readItemStackFromNbt(NBTTagCompound compound, Enum<SlotType> key, ItemStackHandler itemStackHandler) {
        itemStackHandler.deserializeNBT(compound.getCompoundTag(key.toString()));
    }
}
