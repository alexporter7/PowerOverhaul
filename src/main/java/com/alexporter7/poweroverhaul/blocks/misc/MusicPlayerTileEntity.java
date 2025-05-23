package com.alexporter7.poweroverhaul.blocks.misc;

import com.alexporter7.poweroverhaul.blocks.meta.MetaPowerOverhaulTileEntityUI;
import com.alexporter7.poweroverhaul.gui.GuiDefinitions;
import com.cleanroommc.modularui.factory.PosGuiData;
import com.cleanroommc.modularui.screen.ModularPanel;
import com.cleanroommc.modularui.value.sync.PanelSyncManager;

public class MusicPlayerTileEntity extends MetaPowerOverhaulTileEntityUI {

    @Override
    public ModularPanel buildUI(PosGuiData data, PanelSyncManager syncManager) {
        return GuiDefinitions.buildMusicPlayerGui(data, syncManager, this);
    }
}
