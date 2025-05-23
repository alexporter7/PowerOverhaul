package com.alexporter7.poweroverhaul.api.modularui2.gui;

import com.cleanroommc.modularui.api.drawable.IKey;
import com.cleanroommc.modularui.api.widget.IWidget;
import com.cleanroommc.modularui.drawable.UITexture;
import com.cleanroommc.modularui.factory.GuiData;
import com.cleanroommc.modularui.screen.ModularPanel;
import com.cleanroommc.modularui.value.sync.PanelSyncManager;
import com.cleanroommc.modularui.widget.ParentWidget;

public class GuiBuilder<T extends GuiData> {

    private final T guiData;
    private final PanelSyncManager syncManager;
    private final GuiProperties guiProperties;
    private ModularPanel panel;

    private final int width;
    private final int height;

    public GuiBuilder(T data, PanelSyncManager syncManager, GuiProperties guiProperties) {
        this.guiData = data;
        this.syncManager = syncManager;
        this.guiProperties = guiProperties;
        this.width = guiProperties.getWidth();
        this.height = guiProperties.getHeight();
        this.panel = ModularPanel
            .defaultPanel(this.guiProperties.getProperty(GuiProperties.Property.GUI_NAME), this.width, this.height);
    }

    public ModularPanel build() {
        this.panel.bindPlayerInventory();
        return this.panel;
    }

    public GuiBuilder<T> createTitle() {
        this.panel.child(
            new ParentWidget<>().coverChildren()
                .topRelAnchor(0, 1)
                .background(buildTitleBackground())
                .child(
                    IKey.str(this.guiProperties.getProperty(GuiProperties.Property.TITLE))
                        .asWidget()
                        .color(0xFFFFFF)
                        .marginLeft(5)
                        .marginRight(5)
                        .marginTop(5)
                        .marginBottom(1)));
        return this;
    }

    public GuiBuilder<T> setBackground() {
        this.panel.background(buildGuiBackground());
        return this;
    }

    public GuiBuilder<T> addWidget(IWidget widget) {
        this.panel.child(widget);
        return this;
    }

    private UITexture buildTitleBackground() {
        return UITexture.builder()
            .location(this.guiProperties.getProperty(GuiProperties.Property.TITLE_BACKGROUND))
            .imageSize(28, 28)
            .adaptable(4)
            .name(this.guiProperties.getProperty(GuiProperties.Property.TITLE_NAME))
            .build();
    }

    private UITexture buildGuiBackground() {
        return UITexture.builder()
            .location(this.guiProperties.getProperty(GuiProperties.Property.GUI_BACKGROUND))
            .imageSize(this.width, this.height)
            .adaptable(4)
            .name(this.guiProperties.getProperty(GuiProperties.Property.GUI_NAME))
            .build();
    }
}
