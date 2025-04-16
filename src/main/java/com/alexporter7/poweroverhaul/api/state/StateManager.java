package com.alexporter7.poweroverhaul.api.state;

import com.alexporter7.poweroverhaul.PowerOverhaul;
import net.minecraft.tileentity.TileEntity;

import java.util.HashMap;

public class StateManager<T extends Enum<T>> {

    private StateDefinition<T> previousState;
    private StateDefinition<T> currentState;

    private final HashMap<Enum<T>, StateDefinition<T>> STATES = new HashMap<>();

    public StateManager() {
    }

    public StateManager<T> addStateDefinition(StateDefinition<T> stateDefinition) {
        STATES.put(stateDefinition.getState(), stateDefinition);
        return this;
    }

    public boolean requestNextState(StateDefinition<T> nextState) {
        if(!currentState.isValidExit(nextState.getState()))
            return false;
        currentState.exitState(nextState.getState());
        nextState.enterState(currentState.getState());
        previousState = currentState;
        currentState = nextState;
        logEvent();
        return true;
    }

    private void logEvent() {
        PowerOverhaul.LOG.info(
            "PowerOverhaulStateManager: TileEntity went from ["
                + previousState.getState()
                + "] to [" + currentState.getState() + "]");
    }

}
