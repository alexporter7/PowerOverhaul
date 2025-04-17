package com.alexporter7.poweroverhaul.util;

import com.alexporter7.poweroverhaul.api.sound.TileEntitySoundHandlerBase;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.PositionedSound;
import com.alexporter7.poweroverhaul.api.enums.Sound;

import java.util.HashMap;

public class SoundManager<T extends TileEntitySoundHandlerBase> {

    private final HashMap<Sound, T> SOUNDS = new HashMap<>();
    private Sound currentSound;

    public SoundManager() {

    }

    public SoundManager<T> addSound(Sound sound, T soundHandler) {
        SOUNDS.put(sound, soundHandler);
        return this;
    }

    public void requestSound(Sound sound) {
        if(currentSound != null)
            SOUNDS.get(currentSound).requestStop();
        currentSound = sound;
        Minecraft.getMinecraft().getSoundHandler().playSound(SOUNDS.get(sound));
        SOUNDS.get(currentSound).requestStart();
    }

    public void stopSound() {
        if(currentSound != null)
            SOUNDS.get(currentSound).requestStop();
    }

    public T getSoundHandler(Sound sound) {
        return SOUNDS.get(sound);
    }

}
