package com.alexporter7.poweroverhaul.util;

import java.util.HashMap;

public class SoundHandler {

    private final HashMap<Enum<?>, String> sounds;

    public SoundHandler() {
        this.sounds = new HashMap<>();
    }

    public SoundHandler addSound(Enum<?> state, String soundPath) {
        sounds.put(state, soundPath);
        return this;
    }

    public String getSound(Enum<?> state) {
        return this.sounds.get(state);
    }
}
