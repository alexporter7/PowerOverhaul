package com.alexporter7.poweroverhaul.blocks.meta;

import com.cleanroommc.modularui.api.IGuiHolder;
import com.cleanroommc.modularui.factory.PosGuiData;
import com.cleanroommc.modularui.screen.ModularPanel;
import com.cleanroommc.modularui.screen.ModularScreen;
import com.cleanroommc.modularui.value.sync.PanelSyncManager;

public class MetaPowerOverhaulTileEntityUI<T extends Enum<T>> extends MetaPowerOverhaulTEBase<T> implements IGuiHolder<PosGuiData> {

    @Override
    public ModularScreen createScreen(PosGuiData data, ModularPanel mainPanel) {
        return IGuiHolder.super.createScreen(data, mainPanel);
    }

    @Override
    public ModularPanel buildUI(PosGuiData data, PanelSyncManager syncManager) {
        return new ModularPanel("meta_poweroverhaul_te_base");
    }

}
