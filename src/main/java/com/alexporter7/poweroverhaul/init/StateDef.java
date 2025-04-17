package com.alexporter7.poweroverhaul.init;

import com.alexporter7.poweroverhaul.api.state.StateDefinition;
import com.alexporter7.poweroverhaul.api.state.StateManager;
import com.alexporter7.poweroverhaul.blocks.generators.DieselGeneratorTileEntity;
import com.alexporter7.poweroverhaul.blocks.meta.MetaGeneratorTileEntity.State;

public class StateDef {

    public static StateManager<State, DieselGeneratorTileEntity>
            initDieselGenStateManager(DieselGeneratorTileEntity tileEntity) {

        StateManager<State, DieselGeneratorTileEntity> stateManager =
            new StateManager<>(tileEntity);

        StateDefinition<State> OFF =
            new StateDefinition.Builder<State>()
                .fromState(State.OFF)
                .registerNextState(State.STARTING)
                .registerNextState(State.MAINTENANCE)
                .registerNextState(State.PROBLEM)
                .registerOnEnter((previousState) -> tileEntity.resetStartingTickes())
                .registerConditions(tileEntity::checkOffConditions)
                .build();
        StateDefinition<State> STARTING =
            new StateDefinition.Builder<State>()
                .fromState(State.STARTING)
                .registerNextState(State.OFF)
                .registerNextState(State.WARM_UP)
                .registerNextState(State.IDLE)
                .registerNextState(State.ACTIVE)
                .registerOnEnter((previousState) -> tileEntity.playStartingSound())
                .registerOnExit((nextState) -> tileEntity.stopStartingSound())
                .registerConditions(tileEntity::checkStartingConditions)
                .registerEventTick((tileEntity::decrementStartingTicks))
                .build();
        StateDefinition<State> WARM_UP =
            new StateDefinition.Builder<State>()
                .fromState(State.WARM_UP)
                .registerNextState(State.OFF)
                .registerNextState(State.IDLE)
                .registerNextState(State.ACTIVE)
                .registerOnEnter((previousState) -> tileEntity.playIdleSound())
                .registerOnExit((nextState) -> tileEntity.stopIdleSound())
                .registerConditions(tileEntity::checkWarmUpConditions)
                .build();
        StateDefinition<State> IDLE =
            new StateDefinition.Builder<State>()
                .fromState(State.IDLE)
                .registerNextState(State.OFF)
                .registerNextState(State.ACTIVE)
                .registerConditions(tileEntity::checkIdleConditions)
                .build();
        StateDefinition<State> ACTIVE =
            new StateDefinition.Builder<State>()
                .fromState(State.ACTIVE)
                .registerNextState(State.OFF)
                .registerNextState(State.IDLE)
                .registerConditions(tileEntity::checkActiveConditions)
                .build();

        stateManager
            .addStateDefinition(OFF)
            .addStateDefinition(STARTING)
            .addStateDefinition(WARM_UP)
            .addStateDefinition(IDLE)
            .addStateDefinition(ACTIVE)
            .initialState(State.OFF);

        return stateManager;
    }
}
