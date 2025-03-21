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
        // return new ModularPanel(PowerOverhaul.MODID + ":diesel_generator_gui")
        // .child(IKey.str("Test Text").asWidget());

        return GuiDefinitions.buildGui(GuiDefinitions.Machine.DIESEL_GENERATOR, data, syncManager);
    }

    private ModularPanel buildMachineGui() {
        ModularPanel panel = new ModularPanel(PowerOverhaul.MODID + ":diesel_generator_gui");
        panel.padding(10, 10, 5, 0);
        panel.child(
            new RichTextWidget().add("rich text")
                .anchorTop(1));
        return panel;
    }
}
