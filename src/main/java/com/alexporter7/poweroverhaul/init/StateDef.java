package com.alexporter7.poweroverhaul.init;

import com.alexporter7.poweroverhaul.api.enums.TileEntityState.GeneratorState;
import com.alexporter7.poweroverhaul.api.state.StateDefinition;
import com.alexporter7.poweroverhaul.api.state.StateManager;
import com.alexporter7.poweroverhaul.blocks.generators.DieselGeneratorTileEntity;

public class StateDef {

    public static StateManager<GeneratorState, DieselGeneratorTileEntity> initDieselGenStateManager(
        DieselGeneratorTileEntity tileEntity) {

        StateManager<GeneratorState, DieselGeneratorTileEntity> stateManager = new StateManager<>(tileEntity);

        StateDefinition<GeneratorState> OFF = new StateDefinition.Builder<GeneratorState>()
            .fromState(GeneratorState.OFF)
            .registerNextState(GeneratorState.STARTING)
            .registerNextState(GeneratorState.MAINTENANCE)
            .registerNextState(GeneratorState.PROBLEM)
            .registerOnEnter((previousState, thisState) -> {
                tileEntity.resetStartingTickes();
                tileEntity.stopSound(previousState, thisState);
            })
            .registerConditions(tileEntity::checkOffConditions)
            .build();
        StateDefinition<GeneratorState> STARTING = new StateDefinition.Builder<GeneratorState>()
            .fromState(GeneratorState.STARTING)
            .registerNextState(GeneratorState.OFF)
            .registerNextState(GeneratorState.WARM_UP)
            .registerNextState(GeneratorState.IDLE)
            .registerNextState(GeneratorState.ACTIVE)
            .registerOnEnter(tileEntity::requestSound)
            // .registerOnExit((nextState, thisState) -> tileEntity.stopStartingSound())
            .registerConditions(tileEntity::checkStartingConditions)
            .registerEventTick((tileEntity::decrementStartingTicks))
            .build();
        StateDefinition<GeneratorState> WARM_UP = new StateDefinition.Builder<GeneratorState>()
            .fromState(GeneratorState.WARM_UP)
            .registerNextState(GeneratorState.OFF)
            .registerNextState(GeneratorState.IDLE)
            .registerNextState(GeneratorState.ACTIVE)
            .registerOnEnter(tileEntity::requestSound)
            // .registerOnExit((nextState, thisState) -> tileEntity.stopWarmUpSound())
            .registerConditions(tileEntity::checkWarmUpConditions)
            .build();
        StateDefinition<GeneratorState> IDLE = new StateDefinition.Builder<GeneratorState>()
            .fromState(GeneratorState.IDLE)
            .registerNextState(GeneratorState.OFF)
            .registerNextState(GeneratorState.ACTIVE)
            .registerOnEnter(tileEntity::requestSound)
            // .registerOnExit((nextState, thisState) -> tileEntity.stopIdleSound())
            .registerConditions(tileEntity::checkIdleConditions)
            .build();
        StateDefinition<GeneratorState> ACTIVE = new StateDefinition.Builder<GeneratorState>()
            .fromState(GeneratorState.ACTIVE)
            .registerNextState(GeneratorState.OFF)
            .registerNextState(GeneratorState.IDLE)
            .registerOnEnter(tileEntity::requestSound)
            .registerConditions(tileEntity::checkActiveConditions)
            .build();

        stateManager.addStateDefinition(OFF)
            .addStateDefinition(STARTING)
            .addStateDefinition(WARM_UP)
            .addStateDefinition(IDLE)
            .addStateDefinition(ACTIVE)
            .initialState(GeneratorState.OFF);

        return stateManager;
    }
}
