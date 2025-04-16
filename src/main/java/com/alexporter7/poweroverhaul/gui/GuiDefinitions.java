package com.alexporter7.poweroverhaul.gui;

import com.alexporter7.poweroverhaul.api.enums.FluidEnum;
import com.alexporter7.poweroverhaul.api.modularui2.gui.GuiBuilder;
import com.alexporter7.poweroverhaul.api.modularui2.gui.GuiHelper;
import com.alexporter7.poweroverhaul.api.modularui2.gui.GuiProperties;
import com.alexporter7.poweroverhaul.blocks.generators.DieselGeneratorTileEntity;
import com.alexporter7.poweroverhaul.blocks.misc.MusicPlayerTileEntity;
import com.cleanroommc.modularui.api.widget.IWidget;
import com.cleanroommc.modularui.factory.PosGuiData;
import com.cleanroommc.modularui.screen.ModularPanel;
import com.cleanroommc.modularui.value.sync.*;
import com.cleanroommc.modularui.widget.ParentWidget;
import com.cleanroommc.modularui.widgets.PageButton;
import com.cleanroommc.modularui.widgets.PagedWidget;
import com.cleanroommc.modularui.widgets.SliderWidget;
import com.cleanroommc.modularui.widgets.layout.Column;
import com.cleanroommc.modularui.widgets.layout.Row;

import static com.alexporter7.poweroverhaul.api.enums.FluidEnum.*;
import static com.alexporter7.poweroverhaul.api.enums.SlotType.*;

public class GuiDefinitions {

    public enum Machine {
        DIESEL_GENERATOR
    }

    public static class GUI_ID {

        public static final String DIESEL_GENERATOR = "poweroverhaul:diesel_generator_ui";

    }

    public static ModularPanel buildMusicPlayerGui(PosGuiData posGuiData, PanelSyncManager syncManager,
                                                   MusicPlayerTileEntity tileEntity) {
        GuiProperties musicGuiProps = new GuiProperties(176, 166)
            .addProperty(GuiProperties.Property.GUI_BACKGROUND, GuiTextures.STEEL_BACKGROUND.getLocation())
            .addProperty(GuiProperties.Property.GUI_NAME, GuiTextures.STEEL_BACKGROUND.getName())
            .addProperty(GuiProperties.Property.TITLE, "Music Player")
            .addProperty(GuiProperties.Property.TITLE_NAME, GuiTextures.TITLE_BACKGROUND.getName())
            .addProperty(GuiProperties.Property.TITLE_BACKGROUND, GuiTextures.TITLE_BACKGROUND.getLocation());

        ModularPanel panel = new GuiBuilder(posGuiData, syncManager, musicGuiProps)
            .createTitle()
            .setBackground()
            .build();

        return panel;
    }

    public static ModularPanel buildDieselGeneratorGui(PosGuiData posGuiData, PanelSyncManager syncManager,
        DieselGeneratorTileEntity tileEntity) {
        GuiProperties dieselGuiProps = new GuiProperties(176, 166)
            .addProperty(GuiProperties.Property.GUI_BACKGROUND, GuiTextures.STEEL_BACKGROUND.getLocation())
            .addProperty(GuiProperties.Property.GUI_NAME, GuiTextures.STEEL_BACKGROUND.getName())
            .addProperty(GuiProperties.Property.TITLE, "Diesel Generator")
            .addProperty(GuiProperties.Property.TITLE_NAME, GuiTextures.TITLE_BACKGROUND.getName())
            .addProperty(GuiProperties.Property.TITLE_BACKGROUND, GuiTextures.TITLE_BACKGROUND.getLocation());

        syncManager.syncValue("stateSync", new StringSyncValue(tileEntity::getState, tileEntity::setState));
        syncManager.syncValue("rpmSync", new IntSyncValue(tileEntity::getRpm, tileEntity::setRpm));
        syncManager.syncValue("hpSync", new IntSyncValue(tileEntity::getHp, tileEntity::setHp));
        syncManager.syncValue("tempSync", new IntSyncValue(tileEntity::getTemp, tileEntity::setTemp));

        ModularPanel panel = new GuiBuilder(posGuiData, syncManager, dieselGuiProps).createTitle()
            .setBackground()
            .build();

        IWidget operationLabels = new Column()
            .child(
                GuiHelper.createToggleButtonRow(
                    "Ignition: ",
                    new BooleanSyncValue(tileEntity::getIgnition, tileEntity::setIgnition)))
            .child(GuiHelper.createDynamicRow("Throttle: ", tileEntity::getThrottleString))
            .child(
                new Row().child(
                    new SliderWidget().widthRel(1.0f)
                        .height(14)
                        .stopper(0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100)
                        .bounds(0, 100)
                        .background(com.cleanroommc.modularui.drawable.GuiTextures.SLOT_FLUID)
                        .value(
                            new DoubleSyncValue(
                                () -> (double) tileEntity.throttle,
                                value -> tileEntity.throttle = (int) value)))
                    .coverChildrenHeight())
            .child(
                GuiHelper.createToggleButtonRow(
                    "Turbo: ",
                    new BooleanSyncValue(() -> tileEntity.turbo, value -> tileEntity.turbo = value)))
            .child(
                GuiHelper.createToggleButtonRow(
                    "NO2",
                    new BooleanSyncValue(() -> tileEntity.nos, value -> tileEntity.nos = value)))
            .leftRelAnchor(0f, 0f)
            .sizeRel(0.5f)
            .paddingTop(6)
            .paddingLeft(12);

        IWidget operationStats = new Column().child(GuiHelper.createDynamicRow("State: ", tileEntity::getStateString))
            .child(GuiHelper.createDynamicRow("RPM: ", tileEntity::getRpmString))
            .child(GuiHelper.createDynamicRow("HP: ", tileEntity::getHorsepowerString))
            .child(GuiHelper.createDynamicRow("Temp: ", tileEntity::getTemperatureString))
            .leftRelAnchor(0.5f, 0f)
            .sizeRel(0.5f)
            .paddingTop(6)
            .paddingRight(12);

        IWidget itemSlots = new Column()
            .child(GuiHelper.createItemSlotRow("Engine: ", tileEntity.getItemStack(ENGINE_SLOT), 0))
            .child(GuiHelper.createItemSlotRow("Turbo: ", tileEntity.getItemStack(TURBO_SLOT), 0))
            .child(GuiHelper.createItemSlotRow("NO2: ", tileEntity.getItemStack(NOS_SLOT), 0))
            .leftRelAnchor(0f, 0f)
            .sizeRel(0.5f)
            .paddingTop(6)
            .paddingLeft(12);

        IWidget fluidSlots = new Column()
            .child(GuiHelper.createFluidSlotRow("Coolant: ", tileEntity.getFluidTank(COOLANT)))
            .child(GuiHelper.createFluidSlotRow("Oil: ", tileEntity.getFluidTank(OIL)))
            .child(GuiHelper.createFluidSlotRow("Fuel: ", tileEntity.getFluidTank(DIESEL)))
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

        panel.child(tabs)
            .child(
                new PagedWidget<>().sizeRel(1f)
                    .controller(tabController)
                    .addPage(
                        new ParentWidget<>().sizeRel(1f)
                            .child(operationLabels)
                            .child(operationStats))
                    .addPage(
                        new ParentWidget<>().sizeRel(1f)
                            .child(itemSlots)
                            .child(fluidSlots))
                    .coverChildrenHeight());

        return panel;
    }

}
