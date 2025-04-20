package com.alexporter7.poweroverhaul.api.modularui2.gui;

import java.util.function.Predicate;
import java.util.function.Supplier;

import net.minecraftforge.fluids.FluidTank;

import org.jetbrains.annotations.NotNull;

import com.cleanroommc.modularui.api.drawable.IKey;
import com.cleanroommc.modularui.api.widget.IWidget;
import com.cleanroommc.modularui.utils.Alignment;
import com.cleanroommc.modularui.utils.Color;
import com.cleanroommc.modularui.utils.item.ItemStackHandler;
import com.cleanroommc.modularui.value.sync.BooleanSyncValue;
import com.cleanroommc.modularui.value.sync.SyncHandlers;
import com.cleanroommc.modularui.widgets.FluidSlot;
import com.cleanroommc.modularui.widgets.ItemSlot;
import com.cleanroommc.modularui.widgets.TextWidget;
import com.cleanroommc.modularui.widgets.ToggleButton;
import com.cleanroommc.modularui.widgets.layout.Row;

public class GuiHelper {

    public static ItemStackHandler createStackHandlerLimit(int slotLimit) {
        return new ItemStackHandler(1) {

            @Override
            public int getSlotLimit(int slot) {
                return slotLimit;
            }
        };
    }

    /* Text Widgets */
    public static TextWidget textWidget(String text) {
        return textWidget(text, 5, 5, 0, 0);
    }

    public static TextWidget textWidget(String text, int marginLeft, int marginTop) {
        return textWidget(text, marginLeft, marginTop, 0, 0);
    }

    public static TextWidget textWidget(String text, int marginLeft, int marginTop, int marginRight) {
        return textWidget(text, marginLeft, marginTop, marginRight, 0);
    }

    public static TextWidget textWidget(String text, int marginLeft, int marginTop, int marginRight, int marginBottom) {
        return IKey.str(text)
            .asWidget()
            .color(0xFFFFFF)
            .margin(marginLeft, marginRight, marginTop, marginBottom);
    }

    /* Row Widget Groups */
    public static IWidget createDynamicRow(String label, @NotNull Supplier<String> value) {
        return new Row().child(textWidget(label, 0, 5).alignment(Alignment.CenterLeft))
            .child(
                IKey.dynamic(value)
                    .asWidget()
                    .widthRel(0.6f)
                    .anchorRight(0f)
                    .color(Color.WHITE.main)
                    .marginTop(2)
                    .alignment(Alignment.CenterRight))
            .coverChildrenHeight();
    }

    public static IWidget createToggleButtonRow(String label, BooleanSyncValue value) {
        return new Row().child(textWidget(label, 0, 0).alignment(Alignment.CenterLeft))
            .child(
                new ToggleButton().height(14)
                    .width(14)
                    .rightRelAnchor(0f, 0f)
                    .value(value))
            .coverChildrenHeight()
            .marginTop(2);
    }

    public static IWidget createToggleButtonRow(String label, BooleanSyncValue value,
        Predicate<ToggleButton> predicate) {
        return new Row().child(textWidget(label, 0, 0).alignment(Alignment.CenterLeft))
            .child(
                new ToggleButton().height(14)
                    .width(14)
                    .rightRelAnchor(0f, 0f)
                    .value(value)
                    .setEnabledIf(predicate))
            .coverChildrenHeight()
            .marginTop(2);
    }

    public static IWidget createItemSlotRow(String label, ItemStackHandler itemStackHandler, int index) {
        return new Row().child(textWidget(label, 0, 0).alignment(Alignment.CenterLeft))
            .child(
                new ItemSlot().slot(SyncHandlers.itemSlot(itemStackHandler, index))
                    .rightRelAnchor(0f, 0f))
            .coverChildrenHeight();
    }

    public static IWidget createFluidSlotRow(String label, FluidTank fluidTank) {
        return new Row().child(textWidget(label, 0, 0).alignment(Alignment.CenterLeft))
            .child(
                new FluidSlot().syncHandler(SyncHandlers.fluidSlot(fluidTank))
                    .rightRelAnchor(0f, 0f))
            .coverChildrenHeight();
    }

    public static IWidget createFluidSlotRow(String label, FluidTank fluidTank, @NotNull Supplier<String> value) {
        return new Row().child(textWidget(label, 0, 0).alignment(Alignment.CenterLeft))
            .child(
                new FluidSlot().syncHandler(fluidTank)
                    .rightRelAnchor(0f, 0f)
                    .tooltip((tooltip) -> tooltip.addLine(IKey.dynamic(value))))
            .coverChildrenHeight();
    }

    public static IWidget createLockableFluidSlotRow(String label, FluidTank fluidTank,
        Predicate<FluidSlot> condition) {
        return new Row().child(textWidget(label, 0, 0).alignment(Alignment.CenterLeft))
            .child(
                new FluidSlot().syncHandler(fluidTank)
                    .setEnabledIf(condition)
                    .rightRelAnchor(0f, 0f))
            .coverChildrenHeight();
    }
}
