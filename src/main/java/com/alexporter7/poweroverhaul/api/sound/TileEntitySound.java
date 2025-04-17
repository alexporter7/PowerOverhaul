package com.alexporter7.poweroverhaul.api.sound;

import com.alexporter7.poweroverhaul.blocks.meta.MetaPowerOverhaulTEBase;
import net.minecraft.client.audio.ISound;
import net.minecraft.client.audio.ITickableSound;
import net.minecraft.client.audio.PositionedSound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class TileEntitySound extends PositionedSound implements ITickableSound {

    private final MetaPowerOverhaulTEBase<?> TILE_ENTITY;
    private boolean isPlaying = false;
    private float volume = 1.0f;
    private float pitch = 1.0f;

    protected TileEntitySound(ResourceLocation soundResource, MetaPowerOverhaulTEBase<?> tileEntity) {
        super(soundResource);
        TILE_ENTITY = tileEntity;
    }

    public void setVolume(float volume) {
        this.volume = volume;
    }

    public void setPitch(float pitch) {
        this.pitch = pitch;
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
    public boolean isDonePlaying() {
        return isPlaying;
    }

    @Override
    public void update() {
        isPlaying = TILE_ENTITY.isActive();
    }
}
