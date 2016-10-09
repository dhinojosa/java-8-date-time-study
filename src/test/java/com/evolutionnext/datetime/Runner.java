package com.evolutionnext.datetime;

import java.util.function.BiFunction;


public class Runner {
    public static int add3ToPreexistingFunction(BiFunction<Integer, Integer, Integer> biFunction) {
        return biFunction.apply(4, 5) + 3;
    }
}
