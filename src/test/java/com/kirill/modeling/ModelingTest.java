package com.kirill.modeling;

import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Arrays;

public class ModelingTest {

    @Test
    public void testOne() throws IOException {
        PopulationDynamic populationDynamic = new PopulationDynamic(
                0.0, 10.0, 1.0, 10.0, 
                1.0, 10, 0.0, 100.0);
        populationDynamic.calcMethodEuler();

        XYChart chart = QuickChart.getChart("Population Dynamic", "X", "Y", "y(x)", 
                Arrays.asList(populationDynamic.getXs().clone()), Arrays.asList(populationDynamic.getYs().clone()));
        new SwingWrapper(chart).displayChart();
        System.in.read();
    }

    @Test
    public void testTwo() throws IOException {
        
        double[] xs = {0, 1, 2, 3, 4, 5, 3};
        double[] ys = {0, 2, 0, 2, 0, 2, 1};

        XYChart chart = QuickChart.getChart("Population Dynamic", "X", "Y", "y(x)", xs, ys);
        new SwingWrapper(chart).displayChart();
        System.in.read();
    }

    @Test
    public void distributionTest() {
        int experimentCount = 10000;
        int[] allValues = new int[experimentCount];
        DiscreteRandomValue drv = new DiscreteRandomValue(
                new int[] {6, 5, 3, 4, 2},
                new double[] {0.1, 0.1, 0.5, 0.2, 0.1}
        );

        for (int i = 0; i <experimentCount; i++) {
            allValues[i] = drv.getNext();
        }

        System.out.println("Distribution:\n" + DRVDistribution.calculateDistribution(allValues));
    }

    @Test
    public void task3() {
        int experimentCount = 1000;
        int[] daysCounts = new int[experimentCount];
        DiscreteRandomValue drv = new DiscreteRandomValue(
                new int[] {0, 1, 2, 3},
                new double[] {0.2, 0.3, 0.4, 0.1}
        );

        for (int i = 0; i <experimentCount; i++) {
            daysCounts[i] = drv.daysTillRefill();
        }

        System.out.println(Arrays.stream(daysCounts).average().getAsDouble());
    }
}
