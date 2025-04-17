package com.alexporter7.poweroverhaul.util;

import net.minecraft.client.audio.PositionedSound;
import com.alexporter7.poweroverhaul.api.enums.Sound;

import java.util.HashMap;

public class SoundManager<T extends PositionedSound> {

    private final HashMap<Sound, T> SOUNDS = new HashMap<>();

    public SoundManager() {

    }

    public SoundManager<T> addSound(Sound sound, T soundHandler) {
        SOUNDS.put(sound, soundHandler);
        return this;
    }

    public void playSound(Sound sound) {

    }

}
