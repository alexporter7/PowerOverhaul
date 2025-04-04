package com.alexporter7.poweroverhaul.blocks.meta;

import com.alexporter7.poweroverhaul.PowerOverhaul;
import net.minecraft.tileentity.TileEntity;

import com.cleanroommc.modularui.api.IGuiHolder;
import com.cleanroommc.modularui.factory.PosGuiData;
import com.cleanroommc.modularui.screen.ModularPanel;
import com.cleanroommc.modularui.screen.ModularScreen;
import com.cleanroommc.modularui.value.sync.PanelSyncManager;

public class MetaPowerOverhaulTileEntity extends TileEntity implements IGuiHolder<PosGuiData> {

    @Override
    public ModularScreen createScreen(PosGuiData data, ModularPanel mainPanel) {
        return IGuiHolder.super.createScreen(data, mainPanel);
    }

    @Override
    public ModularPanel buildUI(PosGuiData data, PanelSyncManager syncManager) {
        return null;
    }

}
