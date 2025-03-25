package com.alexporter7.poweroverhaul.blocks.generators;

import net.minecraft.tileentity.TileEntity;

import com.alexporter7.poweroverhaul.PowerOverhaul;
import com.alexporter7.poweroverhaul.api.modularui2.GuiDefinitions;
import com.cleanroommc.modularui.api.IGuiHolder;
import com.cleanroommc.modularui.factory.PosGuiData;
import com.cleanroommc.modularui.screen.ModularPanel;
import com.cleanroommc.modularui.value.sync.PanelSyncManager;
import com.cleanroommc.modularui.widgets.RichTextWidget;

public class DieselGeneratorTileEntity extends TileEntity implements IGuiHolder<PosGuiData> {

    public DieselGeneratorTileEntity() {

    }

    @Override
    public ModularPanel buildUI(PosGuiData data, PanelSyncManager syncManager) {
        return GuiDefinitions.buildGui(GuiDefinitions.Machine.DIESEL_GENERATOR, data, syncManager);
    }

}
