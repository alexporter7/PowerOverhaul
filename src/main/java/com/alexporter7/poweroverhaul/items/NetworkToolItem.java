package com.alexporter7.poweroverhaul.items;

import com.alexporter7.poweroverhaul.PowerOverhaul;
import com.alexporter7.poweroverhaul.gui.GuiDefinitions;
import com.cleanroommc.modularui.api.IGuiHolder;
import com.cleanroommc.modularui.factory.GuiData;
import com.cleanroommc.modularui.factory.GuiFactories;
import com.cleanroommc.modularui.factory.PosGuiData;
import com.cleanroommc.modularui.screen.ModularPanel;
import com.cleanroommc.modularui.value.sync.PanelSyncManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.UUID;

public class NetworkToolItem extends PowerOverhaulItem implements IGuiHolder<GuiData> {

    private UUID network;

    public NetworkToolItem() {
        this.maxStackSize = 1;
    }

    @Override
    public ModularPanel buildUI(GuiData data, PanelSyncManager syncManager) {
        return GuiDefinitions.buildNetworkToolGui(data, syncManager);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer player) {
        if(!worldIn.isRemote)
            GuiFactories.item().open(player);
        return super.onItemRightClick(itemStackIn, worldIn, player);
    }
}
