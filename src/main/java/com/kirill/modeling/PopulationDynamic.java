package com.kirill.modeling;

public class PopulationDynamic {

    private final Double eps;
    private final Double s;
    private final Double mu;
    private final Double k;
    private final Double h;
    private final Integer count;
    private final Double[] xs;
    private final Double[] ys;

    public PopulationDynamic(Double eps, Double s, Double mu, Double k, Double h, Integer count, Double x0, Double y0) {
        this.eps = eps;
        this.s = s;
        this.mu = mu;
        this.k = k;
        this.h = h;
        this.count = count;

        xs = new Double[count];
        ys = new Double[count];
        xs[0] = x0;
        ys[0] = y0;
    }

    public Double[] getXs() {
        return xs;
    }

    public Double[] getYs() {
        return ys;
    }

    public void calcMethodEuler() {
        for (int i = 1; i < count; i++) {
            xs[i] = i * h;
            ys[i] = methodEuler(ys[i - 1]);
        }
    }

    private Double methodEuler(Double y) {
        return y + h * firstDerivative(y);
    }
    
    public Double firstDerivative(Double m) {
        return firstDerivative(m, eps, s, mu, k);
    }

    public static Double firstDerivative(Double m, Double eps, Double s, Double mu, Double k) {
        return mu * m * s / (k + s) - eps * m;
    }
}
