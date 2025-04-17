package com.alexporter7.poweroverhaul.api.manager;

import java.util.HashMap;

public class MachineStatManager<T extends Enum<T>> {

    private final HashMap<T, Object> STATS = new HashMap<>();

    public MachineStatManager<T> addStat(T stat, Object value) {
        STATS.put(stat, value);
        return this;
    }

    public Object getStat(T stat) {
        return STATS.get(stat);
    }

}
