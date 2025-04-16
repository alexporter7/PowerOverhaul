package com.alexporter7.poweroverhaul.api.state;

import java.util.HashSet;
import java.util.function.Consumer;

public class StateDefinition<T extends Enum<T>> {

    private final Enum<T> state;
    private final HashSet<Enum<T>> nextStates;
    private final Consumer<Enum<T>> onEnter;
    private final Consumer<Enum<T>> onExit;

    public StateDefinition(Builder<T> builder) {
        state = builder.state;
        nextStates = builder.nextStates;
        onEnter = builder.onEnter;
        onExit = builder.onExit;
    }

    public boolean isValidExit(Enum<T> nextState) {
        return nextStates.contains(nextState);
    }

    public Enum<T> getState() {
        return state;
    }

    public void enterState(Enum<T> previousState) {
        onEnter.accept(previousState);
    }

    public void exitState(Enum<T> nextState) {
        onExit.accept(nextState);
    }

    public static class Builder<T extends Enum<T>> {

        public Enum<T> state;
        public final HashSet<Enum<T>> nextStates = new HashSet<>();
        public Consumer<Enum<T>> onEnter;
        public Consumer<Enum<T>> onExit;

        public Builder<T> fromState(Enum<T> state) {
            this.state = state;
            return this;
        }

        public Builder<T> registerNextState(Enum<T> state) {
            nextStates.add(state);
            return this;
        }

        /**
         * Accepts consumer with previous state
         * @param consumer function that executes when this state is successfully requested
         * @return Builder
         */
        public Builder<T> registerOnEnter(Consumer<Enum<T>> consumer) {
            this.onEnter = consumer;
            return this;
        }

        /**
         * Accepts consumer with next state
         * @param consumer function that executes when the next state is successfully requested
         * @return Builder
         */
        public Builder<T> registerOnExit(Consumer<Enum<T>> consumer) {
            this.onExit = consumer;
            return this;
        }

        public StateDefinition<T> build() {
            if(onEnter == null)
                onEnter = (s) -> { };
            if(onExit == null)
                onExit = (s) -> { };
            return new StateDefinition<>(this);
        }
    }
}
