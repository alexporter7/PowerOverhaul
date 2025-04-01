package com.alexporter7.poweroverhaul.api.modularui2.gui;

import com.cleanroommc.modularui.api.drawable.IKey;
import com.cleanroommc.modularui.api.widget.IWidget;
import com.cleanroommc.modularui.drawable.UITexture;
import com.cleanroommc.modularui.factory.PosGuiData;
import com.cleanroommc.modularui.screen.ModularPanel;
import com.cleanroommc.modularui.value.sync.PanelSyncManager;
import com.cleanroommc.modularui.widget.ParentWidget;

public class GuiBuilder {

    private final PosGuiData posGuiData;
    private final PanelSyncManager syncManager;
    private final GuiProperties guiProperties;
    private ModularPanel panel;

    private final int width;
    private final int height;

    public GuiBuilder(PosGuiData data, PanelSyncManager syncManager, GuiProperties guiProperties) {
        this.posGuiData = data;
        this.syncManager = syncManager;
        this.guiProperties = guiProperties;
        this.width = guiProperties.getWidth();
        this.height = guiProperties.getHeight();
        this.panel = ModularPanel
            .defaultPanel(this.guiProperties.getProperty(GuiProperties.Property.GUI_NAME), this.width, this.height);
    }

    public ModularPanel build() {
        this.panel.bindPlayerInventory();
        //this.syncManager.bindPlayerInventory(this.posGuiData.getPlayer());
        return this.panel;
    }

    public GuiBuilder createTitle() {
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

    public GuiBuilder setBackground() {
        this.panel.background(buildGuiBackground());
        return this;
    }

    public GuiBuilder addWidget(IWidget widget) {
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
