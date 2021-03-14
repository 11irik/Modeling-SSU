package com.kirill.modeling;

class DiscreteRandomValue {
    private final int [] values;
    private final double [] distributionFunction;

    public DiscreteRandomValue(int[] values, double[] probabilities) {
        if (values.length != probabilities.length) {
            throw new IllegalArgumentException("Arrays sizes must match");
        }
        
        this.values = values;
        
        distributionFunction = new double[probabilities.length];
        distributionFunction[0] = probabilities[0];
        for (int i = 1; i < probabilities.length; i++) {
            distributionFunction[i] = distributionFunction[i-1] + probabilities[i];
        }
    }

    public int getNext() {
        double r = Math.random();
        for (int i = 0; i < values.length; i++) {
            if (r <= distributionFunction[i]) {
                return values[i];
            }
        }
        throw new RuntimeException(); //TODO: Add/create exception
    }
    
    public int daysTillRefill() {
        int detailsCount = 8;
        int daysCount = 0;
        
        while (detailsCount > 2) {
            daysCount++;
            detailsCount -= getNext();
        }
     
        return daysCount;
    }
}