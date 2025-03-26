package com.alexporter7.poweroverhaul.blocks.generators;

import com.alexporter7.poweroverhaul.api.modularui2.GuiDefinitions;
import com.alexporter7.poweroverhaul.blocks.meta.MetaPowerOverhaulTileEntity;
import com.cleanroommc.modularui.factory.PosGuiData;
import com.cleanroommc.modularui.screen.ModularPanel;
import com.cleanroommc.modularui.value.sync.PanelSyncManager;

public class DieselGeneratorTileEntity extends MetaPowerOverhaulTileEntity {

    private enum State {
        OFF,
        WARM_UP,
        IDLE,
        ACTIVE
    }

    public DieselGeneratorTileEntity() {

    }

    @Override
    public ModularPanel buildUI(PosGuiData data, PanelSyncManager syncManager) {
        return GuiDefinitions.buildGui(GuiDefinitions.Machine.DIESEL_GENERATOR, data, syncManager);
    }

}
