package com.to.studies.sicknesssimulator.util.random;

import java.util.Random;

public class HandicappedRandomGenerator implements RandomGenerator {

    @Override
    public double generate() {
        Random random = new Random();
        return random.nextDouble();
    }
}
