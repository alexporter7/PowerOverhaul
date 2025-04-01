package com.alexporter7.poweroverhaul.gui;

import com.alexporter7.poweroverhaul.api.modularui2.gui.GuiBuilder;
import com.alexporter7.poweroverhaul.api.modularui2.gui.GuiProperties;
import com.alexporter7.poweroverhaul.api.modularui2.gui.GuiHelper;
import com.alexporter7.poweroverhaul.blocks.generators.DieselGeneratorTileEntity;
import com.cleanroommc.modularui.value.IntValue;
import com.cleanroommc.modularui.value.sync.BooleanSyncValue;
import com.cleanroommc.modularui.value.sync.DoubleSyncValue;
import com.cleanroommc.modularui.value.sync.IntSyncValue;
import com.cleanroommc.modularui.widget.ParentWidget;
import com.cleanroommc.modularui.widgets.*;
import net.minecraftforge.fluids.FluidTank;

import com.cleanroommc.modularui.api.drawable.IKey;
import com.cleanroommc.modularui.api.widget.IWidget;
import com.cleanroommc.modularui.factory.PosGuiData;
import com.cleanroommc.modularui.screen.ModularPanel;
import com.cleanroommc.modularui.value.sync.PanelSyncManager;
import com.cleanroommc.modularui.widgets.layout.Column;
import com.cleanroommc.modularui.widgets.layout.Row;
import com.cleanroommc.modularui.widgets.textfield.TextFieldWidget;

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

    public static ModularPanel buildDieselGeneratorGui(PosGuiData posGuiData, PanelSyncManager syncManager, DieselGeneratorTileEntity tileEntity) {
        GuiProperties dieselGuiProps = new GuiProperties(176, 166)
            .addProperty(GuiProperties.Property.GUI_BACKGROUND, GuiTextures.STEEL_BACKGROUND.getLocation())
            .addProperty(GuiProperties.Property.GUI_NAME, GuiTextures.STEEL_BACKGROUND.getName())
            .addProperty(GuiProperties.Property.TITLE, "Diesel Generator")
            .addProperty(GuiProperties.Property.TITLE_NAME, GuiTextures.TITLE_BACKGROUND.getName())
            .addProperty(GuiProperties.Property.TITLE_BACKGROUND, GuiTextures.TITLE_BACKGROUND.getLocation());

        ModularPanel panel = new GuiBuilder(posGuiData, syncManager, dieselGuiProps)
            .createTitle()
            .setBackground()
            .build();
        panel.flex();

        IWidget operationLabels = new Column()
            .child(GuiHelper.createToggleButtonRow(
                "Ignition: ",
                new BooleanSyncValue(
                    () -> tileEntity.ignition,
                    value -> tileEntity.ignition = value
                )))
            .child(GuiHelper.createDynamicRow(
                "Throttle: ",
                    tileEntity::getThrottleString))
            .child(new Row()
                .child(new SliderWidget()
                    .widthRel(1.0f)
                    .height(14)
                    .stopper(0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100)
                    .bounds(0, 100)
                    .background(com.cleanroommc.modularui.drawable.GuiTextures.SLOT_FLUID)
                    .value(new DoubleSyncValue(
                        () -> (double) tileEntity.throttle,
                        value -> tileEntity.throttle = (int) value)
                    ))
                .coverChildrenHeight())
            .child(GuiHelper.createToggleButtonRow(
                "Turbo: ",
                new BooleanSyncValue(
                    () -> tileEntity.turbo,
                    value -> tileEntity.turbo = value
                )))
            .child(GuiHelper.createToggleButtonRow("NO2",
                new BooleanSyncValue(
                    () -> tileEntity.nos,
                    value -> tileEntity.nos = value
                )))
            .leftRelAnchor(0f, 0f)
            .sizeRel(0.5f)
            .paddingTop(6)
            .paddingLeft(12);

        IWidget operationStats = new Column()
            .child(GuiHelper.createDynamicRow(
                "State: ",
                tileEntity::getStateString))
            .child(GuiHelper.createDynamicRow(
                "RPM: ",
                tileEntity::getRpmString))
            .child(GuiHelper.createDynamicRow(
                "HP: ",
                tileEntity::getHorsepowerString))
            .child(GuiHelper.createDynamicRow(
                "Temp: ",
                tileEntity::getTemperatureString))
            .leftRelAnchor(0.5f, 0f)
            .sizeRel(0.5f)
            .paddingTop(6)
            .paddingRight(12);

        IWidget itemSlots = new Column()
            .child(GuiHelper.createItemSlotRow("Engine: ", tileEntity.engineSlot, 0))
            .child(GuiHelper.createItemSlotRow("Turbo: ", tileEntity.turboSlot, 0))
            .child(GuiHelper.createItemSlotRow("NO2: ", tileEntity.nosSlot, 0))
            .leftRelAnchor(0f, 0f)
            .sizeRel(0.5f)
            .paddingTop(6)
            .paddingLeft(12);

        IWidget fluidSlots = new Column()
            .child(GuiHelper.createFluidSlotRow("Coolant: ", tileEntity.coolant, tileEntity::getCoolantQuality))
            .child(GuiHelper.createFluidSlotRow("Oil: ", tileEntity.oil))
            .child(GuiHelper.createFluidSlotRow("Fuel: ", tileEntity.fuel))
            .leftRelAnchor(0.5f, 0f)
            .sizeRel(0.5f)
            .paddingTop(6)
            .paddingRight(12);

        PagedWidget.Controller tabController = new PagedWidget.Controller();
        IWidget tabs = new Column()
            .child(new PageButton(0, tabController).tab(GuiTextures.STEEL_TAB_RIGHT, -1))
            .child(new PageButton(1, tabController).tab(GuiTextures.STEEL_TAB_RIGHT, 0))
            .coverChildren()
            .rightRel(0f, 4, 1f);

        panel
            .child(tabs)
            .child(
                new PagedWidget<>()
                    .sizeRel(1f)
                    .controller(tabController)
                    .addPage(new ParentWidget<>()
                        .sizeRel(1f)
                        .child(operationLabels)
                        .child(operationStats)
                    )
                    .addPage(new ParentWidget<>()
                        .sizeRel(1f)
                        .child(itemSlots)
                        .child(fluidSlots))
                    .coverChildrenHeight()
            );

        return panel;
    }

    public static ModularPanel buildDieselGeneratorGui(PosGuiData data, PanelSyncManager syncManager) {
        GuiProperties dieselGuiProps = new GuiProperties(176, 249)
            .addProperty(GuiProperties.Property.GUI_BACKGROUND, GuiTextures.STEEL_BACKGROUND.getLocation())
            .addProperty(GuiProperties.Property.GUI_NAME, GuiTextures.STEEL_BACKGROUND.getName())
            .addProperty(GuiProperties.Property.TITLE, "Diesel Generator")
            .addProperty(GuiProperties.Property.TITLE_NAME, GuiTextures.TITLE_BACKGROUND.getName())
            .addProperty(GuiProperties.Property.TITLE_BACKGROUND, GuiTextures.TITLE_BACKGROUND.getLocation());

        IWidget operationLabels = new Column().child(
            IKey.str("Ignition: ")
                .asWidget()
                .color(0xFFFFFF)
                .marginTop(8)
                .marginLeft(5))
            .child(
                new ToggleButton().margin(0, 0, 2, 2)
                    .widthRel(0.8f))
            .child(
                IKey.str("Throttle: ")
                    .asWidget()
                    .color(0xFFFFFF)
                    .marginLeft(5))
            .child(
                new TextFieldWidget().setNumbers(0, 100)
                    .widthRel(0.8f)
                    .setDefaultNumber(0))
            .child(
                IKey.str("Turbo: ")
                    .asWidget()
                    .color(0xFFFFFF)
                    .marginTop(5)
                    .marginLeft(5))
            .child(
                new ToggleButton().margin(0, 0, 2, 2)
                    .widthRel(0.8f))
            .child(
                IKey.str("NO2: ")
                    .asWidget()
                    .color(0xFFFFFF)
                    .marginTop(5)
                    .marginLeft(5))
            .child(
                new ToggleButton().margin(0, 0, 2, 2)
                    .widthRel(0.8f))
            .leftRelAnchor(0f, 0f)
            .sizeRel(0.5f);

        IWidget engineInformation = new Row().child(
            new Column().child(
                IKey.str("RPM: ")
                    .asWidget()
                    .color(0xFFFFFF)
                    .marginTop(5)
                    .marginLeft(5))
                .child(
                    IKey.str("Power: ")
                        .asWidget()
                        .color(0xFFFFFF)
                        .marginLeft(5))
                .child(
                    IKey.str("Temp: ")
                        .asWidget()
                        .color(0xFFFFFF)
                        .marginLeft(5))
                .child(
                    IKey.str("L/t: ")
                        .asWidget()
                        .color(0xFFFFFF)
                        .marginLeft(5))
                .child(
                    IKey.str("Engine Days: ")
                        .asWidget()
                        .color(0xFFFFFF)
                        .marginLeft(5)));

        IWidget engineFluidsInfo = new Row().child(new FluidSlot().syncHandler(new FluidTank(16000)))
            .child(new FluidSlot().syncHandler(new FluidTank(16000)))
            .child(new FluidSlot().syncHandler(new FluidTank(16000)));

        IWidget engineOverview = new Column().child(engineInformation)
            .child(engineFluidsInfo)
            .leftRelAnchor(0.5f, 0f)
            .sizeRel(0.5f, 0.5f);

        return new GuiBuilder(data, syncManager, dieselGuiProps).createTitle()
            .setBackground()
            .addWidget(operationLabels)
            .addWidget(engineOverview)
            .build();

    }

}
