package com.alexporter7.poweroverhaul.blocks.generators;

import com.alexporter7.poweroverhaul.PowerOverhaul;
import com.cleanroommc.modularui.api.IGuiHolder;
import com.cleanroommc.modularui.api.drawable.IKey;
import com.cleanroommc.modularui.factory.PosGuiData;
import com.cleanroommc.modularui.screen.ModularPanel;
import com.cleanroommc.modularui.value.sync.PanelSyncManager;
import net.minecraft.tileentity.TileEntity;

public class DieselGeneratorTileEntity extends TileEntity implements IGuiHolder<PosGuiData> {

    public DieselGeneratorTileEntity() {

    }

    @Override
    public ModularPanel buildUI(PosGuiData data, PanelSyncManager syncManager) {
        return new ModularPanel(PowerOverhaul.MODID + ":diesel_generator_gui")
            .child(IKey.str("Test Text").asWidget());
    }
}
