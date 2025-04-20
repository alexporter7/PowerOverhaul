package com.alexporter7.poweroverhaul.api.state;

public interface IStateManager<T extends Enum<T>> {

    void updateEntityState(T state);

    T getEntityState();

}
