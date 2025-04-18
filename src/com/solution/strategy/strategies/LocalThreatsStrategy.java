package com.solution.strategy.strategies;

import com.solution.strategy.Strategy;

public class LocalThreatsStrategy implements Strategy {
    @Override
    public int working() {
        return 3;
    }
}
