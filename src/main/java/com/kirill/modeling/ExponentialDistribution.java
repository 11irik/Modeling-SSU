package com.kirill.modeling;

public class ExponentialDistribution {

    private final Double lambda;

    public ExponentialDistribution(Double lambda) {
        this.lambda = lambda;
    }
    
    public Double get() {
        return -1 / lambda * Math.log(Math.random());
    }
}
