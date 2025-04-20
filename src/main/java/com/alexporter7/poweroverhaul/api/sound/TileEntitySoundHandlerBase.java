package com.alexporter7.poweroverhaul.api.sound;

import com.alexporter7.poweroverhaul.PowerOverhaul;
import com.alexporter7.poweroverhaul.api.enums.Sound;
import com.alexporter7.poweroverhaul.blocks.meta.MetaPowerOverhaulTEBase;
import net.minecraft.client.audio.ITickableSound;
import net.minecraft.client.audio.MovingSound;
import net.minecraft.client.audio.PositionedSound;
import net.minecraft.util.ResourceLocation;

public class TileEntitySoundHandlerBase extends MovingSound {

    private final MetaPowerOverhaulTEBase TILE_ENTITY;
    private float volume = 1.0f;
    private float pitch = 1.0f;
    private boolean requestPlay = false;

    public TileEntitySoundHandlerBase(Sound sound, MetaPowerOverhaulTEBase tileEntity) {
        super(new ResourceLocation(PowerOverhaul.MODID + ":" + sound.toString().toLowerCase()));
        TILE_ENTITY = tileEntity;
    }

    public void setVolume(float volume) {
        this.volume = volume;
    }

    public void setPitch(float pitch) {
        this.pitch = pitch;
    }

    public void requestStop() {
        requestPlay = false;
    }

    public void requestStart() {
        requestPlay = true;
    }

    public void togglePlay() {
        requestPlay = !requestPlay;
    }

    @Override
    public boolean canRepeat() {
        return true;
    }

    @Override
    public int getRepeatDelay() {
        return 0;
    }

    @Override
    public float getVolume() {
        return volume;
    }

    @Override
    public float getPitch() {
        return pitch;
    }

    @Override
    public float getXPosF() {
        return TILE_ENTITY.xCoord;
    }

    @Override
    public float getYPosF() {
        return TILE_ENTITY.yCoord;
    }

    @Override
    public float getZPosF() {
        return TILE_ENTITY.zCoord;
    }

    @Override
    public void update() {
        donePlaying = !requestPlay;
    }
}
