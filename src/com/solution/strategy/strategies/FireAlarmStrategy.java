package com.solution.strategy.strategies;

import com.solution.strategy.Strategy;

public class FireAlarmStrategy implements Strategy {
    @Override
    public int working() {
        return 5;
    }
}
