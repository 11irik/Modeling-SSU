package com.kirill.modeling;

public class NormalDistribution {
    
    private final double mu;
    private final double sigma;

    public NormalDistribution(double mu, double sigma) {
        this.mu = mu;
        this.sigma = sigma;
    }

    public Double get() {
        double randomSum = 0;
        for (int i = 0; i < 12; ++i) {
            randomSum += Math.random();
        }
        
        return mu + sigma * (randomSum - 6);
    }
}
