package com.alexporter7.poweroverhaul.blocks.meta;

import com.alexporter7.poweroverhaul.api.state.IStateManager;
import net.minecraft.tileentity.TileEntity;

public class MetaPowerOverhaulTEBase<T extends Enum<T>> extends TileEntity implements IStateManager<T> {

    public boolean isActive() { return false; }

    @Override
    public void updateEntityState(T state) {

    }

    @Override
    public T getEntityState() {
        return null;
    }
}
