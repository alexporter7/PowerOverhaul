package com.alexporter7.poweroverhaul.api.sound;

import com.alexporter7.poweroverhaul.api.enums.Sound;
import com.alexporter7.poweroverhaul.blocks.meta.MetaPowerOverhaulTEBase;

public class MachineSoundHandler extends TileEntitySoundHandlerBase{

    public MachineSoundHandler(Sound sound, MetaPowerOverhaulTEBase tileEntity) {
        super(sound, tileEntity);
    }

    @Override
    public void update() {
        super.update();
    }

}
