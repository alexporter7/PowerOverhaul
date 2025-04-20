package com.alexporter7.poweroverhaul.api.sound;

import com.alexporter7.poweroverhaul.api.enums.Sound;

// TODO: use generic for sound enum
public interface ISoundManager<T extends Enum<T>> {

    /**
     * Returns an Enum based off the state (T) of the TileEntity
     * 
     * @param state Enum that is driving the state of the TileEntity
     * @return Enum used in SoundManager#addSoundHandler
     */
    Sound getSoundFromState(T state);

    /**
     * Stops all sounds on TileEntity
     * 
     * @param previousState unused
     * @param newState      unused
     */
    void stopSound(T previousState, T newState);

    /**
     * Used to stop the current sound if there is one and play the next requested sound
     * 
     * @param previousState unused
     * @param newState      state that the machine is entering
     */
    void requestSound(T previousState, T newState);
}
