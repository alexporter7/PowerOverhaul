package com.alexporter7.poweroverhaul.gui;

import com.cleanroommc.modularui.api.drawable.IKey;
import com.cleanroommc.modularui.api.widget.IWidget;
import com.cleanroommc.modularui.utils.item.ItemStackHandler;

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
    public static IWidget textWidget(String text) {
        return textWidget(text, 5, 5, 0, 0);
    }

    public static IWidget textWidget(String text, int marginLeft, int marginTop) {
        return textWidget(text, marginLeft, marginTop, 0, 0);
    }

    public static IWidget textWidget(String text, int marginLeft, int marginTop, int marginRight) {
        return textWidget(text, marginLeft, marginTop, marginRight, 0);
    }

    public static IWidget textWidget(String text, int marginLeft, int marginTop, int marginRight, int marginBottom) {
        return IKey.str(text)
            .asWidget()
            .color(0xFFFFFF)
            .margin(marginLeft, marginRight, marginTop, marginBottom);
    }
}
