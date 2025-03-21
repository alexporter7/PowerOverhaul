package com.alexporter7.poweroverhaul.api.modularui2;

import com.alexporter7.poweroverhaul.util.GuiTextures;
import com.cleanroommc.modularui.api.drawable.IKey;
import com.cleanroommc.modularui.api.widget.IWidget;
import com.cleanroommc.modularui.factory.PosGuiData;
import com.cleanroommc.modularui.screen.ModularPanel;
import com.cleanroommc.modularui.value.sync.PanelSyncManager;
import com.cleanroommc.modularui.widgets.layout.Column;

public class GuiDefinitions {

    public enum Machine {
        DIESEL_GENERATOR
    }

    public static class GUI_ID {

        public static final String DIESEL_GENERATOR = "poweroverhaul:diesel_generator_ui";
    }

    public static ModularPanel buildGui(Machine machine, PosGuiData data, PanelSyncManager syncManager) {
        return switch (machine) {
            case DIESEL_GENERATOR -> buildDieselGeneratorGui(data, syncManager);
        };
    }

    public static ModularPanel buildDieselGeneratorGui(PosGuiData data, PanelSyncManager syncManager) {
        GuiProperties dieselGuiProps = new GuiProperties()
            .addProperty(GuiProperties.Property.GUI_BACKGROUND, GuiTextures.STEEL_BACKGROUND.getLocation())
            .addProperty(GuiProperties.Property.GUI_NAME, GuiTextures.STEEL_BACKGROUND.getName())
            .addProperty(GuiProperties.Property.TITLE, "Diesel Generator")
            .addProperty(GuiProperties.Property.TITLE_NAME, GuiTextures.TITLE_BACKGROUND.getName())
            .addProperty(GuiProperties.Property.TITLE_BACKGROUND, GuiTextures.TITLE_BACKGROUND.getLocation());

        IWidget operationLabels = new Column()
            .child(IKey.str("Status: ").asWidget().color(0xFFFFFF).marginTop(5).marginLeft(5))
            .child(IKey.str("Throttle: ").asWidget().color(0xFFFFFF).marginLeft(5))
            .leftRelAnchor(0f, 0f)
            .sizeRel(0.5f, 0.5f)
            .coverChildrenWidth();

        IWidget machineStats = new Column()
            .child(IKey.str("RPM: ").asWidget().color(0xFFFFFF).marginTop(5).marginLeft(5))
            .child(IKey.str("Power: ").asWidget().color(0xFFFFFF).marginLeft(5))
            .leftRelAnchor(0.5f, 0f)
            .sizeRel(0.5f, 0.5f)
            .coverChildrenWidth();

        return new GuiBuilder(data, syncManager, dieselGuiProps)
            .createTitle()
            .setBackground()
            .addWidget(operationLabels)
            .addWidget(machineStats)
            .build();

    }

}
