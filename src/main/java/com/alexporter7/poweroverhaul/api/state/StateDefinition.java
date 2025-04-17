package com.alexporter7.poweroverhaul.api.state;

import java.util.HashSet;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class StateDefinition<T extends Enum<T>> {

    private final T state;
    private final HashSet<T> nextStates;
    private final Consumer<T> onEnter;
    private final Consumer<T> onExit;
    private final Supplier<T> conditions;
    private final Consumer<T> eventTick;

    public StateDefinition(Builder<T> builder) {
        state = builder.state;
        nextStates = builder.nextStates;
        onEnter = builder.onEnter;
        onExit = builder.onExit;
        conditions = builder.conditions;
        eventTick = builder.eventTick;
    }

    public boolean isValidExit(T nextState) {
        return nextStates.contains(nextState);
    }

    public T getState() {
        return state;
    }

    public void enterState(T previousState) {
        if(onEnter != null)
            onEnter.accept(previousState);
    }

    public void exitState(T nextState) {
        if(onExit != null)
            onExit.accept(nextState);
    }

    public T checkConditions() {
        if(conditions != null)
            return conditions.get();
        return this.state;
    }

    public void executeAction(T currentState) {
        if(eventTick != null)
            eventTick.accept(currentState);
    }

    public static class Builder<T extends Enum<T>> {

        public T state;
        public final HashSet<T> nextStates = new HashSet<>();
        public Consumer<T> onEnter;
        public Consumer<T> onExit;
        public Supplier<T> conditions;
        public Consumer<T> eventTick;

        public Builder<T> fromState(T state) {
            this.state = state;
            return this;
        }

        public Builder<T> registerNextState(T state) {
            nextStates.add(state);
            return this;
        }

        /**
         * Accepts consumer with previous state
         * @param consumer function that executes when this state is successfully requested
         * @return Builder
         */
        public Builder<T> registerOnEnter(Consumer<T> consumer) {
            this.onEnter = consumer;
            return this;
        }

        /**
         * Accepts consumer with next state
         * @param consumer function that executes when the next state is successfully requested
         * @return Builder
         */
        public Builder<T> registerOnExit(Consumer<T> consumer) {
            this.onExit = consumer;
            return this;
        }

        public Builder<T> registerConditions(Supplier<T> conditionsSupplier) {
            this.conditions = conditionsSupplier;
            return this;
        }

        public Builder<T> registerEventTick(Consumer<T> currentEvent) {
            this.eventTick = currentEvent;
            return this;
        }

        public StateDefinition<T> build() {
            return new StateDefinition<>(this);
        }
    }
}
