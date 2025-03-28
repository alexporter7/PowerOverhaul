package com.alexporter7.poweroverhaul.api.modularui2;

import com.alexporter7.poweroverhaul.blocks.generators.DieselGeneratorTileEntity;
import com.alexporter7.poweroverhaul.gui.GuiHelper;
import com.cleanroommc.modularui.utils.Alignment;
import com.cleanroommc.modularui.value.DoubleValue;
import com.cleanroommc.modularui.value.DynamicValue;
import com.cleanroommc.modularui.value.sync.DoubleSyncValue;
import com.cleanroommc.modularui.value.sync.IntSyncValue;
import com.cleanroommc.modularui.value.sync.SyncHandlers;
import com.cleanroommc.modularui.widgets.*;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fluids.FluidTank;

import com.alexporter7.poweroverhaul.util.GuiTextures;
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

        //IntSyncValue updateEngine = new IntSyncValue(() -> tileEntity.engineDays, val -> tileEntity.engineDays = val);
        //syncManager.syncValue("engineDays", updateEngine);

        IWidget operationLabels = new Column()
            .child(new Row()
                .child(GuiHelper.textWidget("Ignition: "))
                .child(new ToggleButton()
                    .height(14)
                    .width(14)
                    .rightRelAnchor(0f, 0f))
                .coverChildrenHeight())
            .child(new Row()
                .child(GuiHelper.textWidget("Throttle: "))
                .coverChildrenHeight())
            .child(new Row()
                .child(new SliderWidget()
                    .widthRel(0.9f)
                    .height(14)
                    .stopper(0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100)
                    .bounds(0, 100)
                    .marginLeft(5)
                    .background(com.cleanroommc.modularui.drawable.GuiTextures.SLOT_FLUID)
                    .value(new DoubleSyncValue(
                        () -> (double) tileEntity.throttle,
                        value -> tileEntity.throttle = (int) value)
                    ))
                .coverChildrenHeight())
            .child(new Row()
                .child(GuiHelper.textWidget("Turbo: "))
                .child(new ToggleButton()
                    .height(14)
                    .width(14)
                    .rightRelAnchor(0f, 0f))
                .coverChildrenHeight()
                .marginTop(2))
            .child(new Row()
                .child(GuiHelper.textWidget("NO2: "))
                .child(new ToggleButton()
                    .height(14)
                    .width(14)
                    .rightRelAnchor(0f, 0f))
                .coverChildrenHeight()
                .marginTop(2))
            .leftRelAnchor(0f, 0f)
            .sizeRel(0.5f)
            .marginTop(8);

        IWidget operationStats = new Column()
            .child(new Row()
                .child(GuiHelper.textWidget("RPM: "))
                .child(IKey.dynamic(() -> String.valueOf(tileEntity.rpm))
                    .asWidget()
                    .widthRel(0.4f)
                    .anchorRight(0f)
                    .color(0xFFFFFF)
                    .marginTop(2)
                    .alignment(Alignment.CenterRight))
                .coverChildrenHeight())
            .child(new Row()
                .child(GuiHelper.textWidget("HP: "))
                .child(IKey.dynamic(() -> String.valueOf(tileEntity.horsepower))
                    .asWidget()
                    .widthRel(0.4f)
                    .anchorRight(0f)
                    .color(0xFFFFFF)
                    .marginTop(2)
                    .alignment(Alignment.CenterRight))
                .coverChildrenHeight())
            .child(new Row()
                .child(GuiHelper.textWidget("Temp: "))
                .child(IKey.dynamic(() -> String.valueOf(tileEntity.engineTemp))
                    .asWidget()
                    .widthRel(0.4f)
                    .anchorRight(0f)
                    .color(0xFFFFFF)
                    .marginTop(2)
                    .alignment(Alignment.CenterRight))
                .coverChildrenHeight())
            .leftRelAnchor(0.5f, 0f)
            .sizeRel(0.5f)
            .marginTop(8)
            .paddingRight(10);




        panel.child(operationLabels).child(operationStats);


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
