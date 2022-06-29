package com.farm.game.StateManager;

import java.util.HashMap;
import java.util.Map;

public class StateManager {

    private HashMap<IState, String> _stateMap = new HashMap<>();

    public void pushState(IState state, String stateName) {
        _stateMap.put(state, stateName);
    }

    public void play(String name) {
        for (Map.Entry<IState, String> entry : _stateMap.entrySet()) {
            if (entry.getValue().equals(name)) {
                entry.getKey().play();
                return;
            }
        }
    }
}
