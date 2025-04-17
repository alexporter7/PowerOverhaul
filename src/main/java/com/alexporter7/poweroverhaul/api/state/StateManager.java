package com.alexporter7.poweroverhaul.api.state;

import com.alexporter7.poweroverhaul.PowerOverhaul;
import com.alexporter7.poweroverhaul.blocks.meta.MetaPowerOverhaulTEBase;

import java.util.HashMap;

public class StateManager<T extends Enum<T>, C extends MetaPowerOverhaulTEBase<T>> {

    private StateDefinition<T> previousState;
    private StateDefinition<T> currentState;
    private StateDefinition<T> nextState;

    private final HashMap<T, StateDefinition<T>> STATES = new HashMap<>();
    private final C TILE_ENTITY;

    public StateManager(C tileEntity) {
        TILE_ENTITY = tileEntity;
    }

    public StateManager<T, C> addStateDefinition(StateDefinition<T> stateDefinition) {
        STATES.put(stateDefinition.getState(), stateDefinition);
        return this;
    }

    public void initialState(T state) {
        currentState = STATES.get(state);
        currentState.enterState(STATES.get(state).getState(), STATES.get(state).getState());
    }

    public void tickState() {
        currentState.executeAction(currentState.getState());
        if(!needStateChange())
            return;
        if(!requestNextState(nextState))
            logEvent();
        updateTileEntityState(currentState.getState());

    }

    public boolean requestNextState(StateDefinition<T> nextState) {
        if(!currentState.isValidExit(nextState.getState()))
            return false;
        currentState.exitState(nextState.getState(), currentState.getState());
        nextState.enterState(currentState.getState(), nextState.getState());
        previousState = currentState;
        currentState = nextState;
        logEvent();
        return true;
    }

    private void updateTileEntityState(T state) {
        TILE_ENTITY.updateEntityState(state);
    }

    private boolean needStateChange() {
        nextState = STATES.get(currentState.checkConditions());
        return !nextState.equals(currentState);
    }

    private void logEvent() {
        PowerOverhaul.LOG.info(
            "PowerOverhaulStateManager: TileEntity went from ["
                + previousState.getState()
                + "] to [" + currentState.getState() + "]");
    }

}
