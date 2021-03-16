package com.kirill.modeling;

import java.util.Random;

public class EvenDistribution {
    
    private final Random random = new Random();
    private double leftLimit = 0;
    private double rightLimit = 25;

    public EvenDistribution(double leftLimit, double rightLimit) {
        this.leftLimit = leftLimit;
        this.rightLimit = rightLimit;
    }
    
    public double getNextDouble() {
        return leftLimit + random.nextDouble() * (rightLimit - leftLimit);
    }
    
    public boolean isCross() {
        double firstTime = getNextDouble();
        double secondTime = getNextDouble();

        if (firstTime > secondTime) {
            return firstTime - secondTime < 2;
        } else {
            return secondTime - firstTime < 1;
        }
    }
}
