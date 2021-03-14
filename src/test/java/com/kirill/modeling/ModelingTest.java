package com.kirill.modeling;

import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.*;

public class ModelingTest {

    @Test
    public void task1() throws IOException {
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
    public void task2() throws IOException {
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

    @Test
    public void task4() {
        //x - y < 1
        //y - x < 2
    }
    
    @Test
    public void task5() {
        Double mu = 80.0;
        Double sigmaSqr = 25.0;
        NormalDistribution normalDistribution = new NormalDistribution(mu, Math.sqrt(sigmaSqr));
        
        List<Double> list1 = new ArrayList<>();
        List<Double> list2 = new ArrayList<>();
        List<Double> list3 = new ArrayList<>();

        for (int i = 0; i < 1000; ++i) {
            Double[] elems = {normalDistribution.get(), normalDistribution.get(), normalDistribution.get()};
            Arrays.sort(elems);
            list1.add(elems[0]);
            list2.add(elems[1]);
            list3.add(elems[2]);
        }

        System.out.println(list1.stream()
                .mapToDouble((x) -> x)
                .summaryStatistics());
        System.out.println(list2.stream()
                .mapToDouble((x) -> x)
                .summaryStatistics());
        System.out.println(list3.stream()
                .mapToDouble((x) -> x)
                .summaryStatistics());
    }

    @Test
    public void task6() {
        Double lambda= 0.1;

        ExponentialDistribution exponentialDistribution = new ExponentialDistribution(lambda);
        List<Double> systemLife = new ArrayList<>();
        List<Double> beforeSecondDied = new ArrayList<>();

        for (int i = 0; i < 1000; ++i) {
            Double[] elems = {exponentialDistribution.get(), exponentialDistribution.get()};
            Arrays.sort(elems);

            Double reserve = exponentialDistribution.get();

            systemLife.add(elems[1] + reserve);
            beforeSecondDied.add(elems[1]);
        }

        System.out.println(systemLife.stream()
                .mapToDouble((x) -> x)
                .summaryStatistics());
        System.out.println(beforeSecondDied.stream()
                .mapToDouble((x) -> x)
                .summaryStatistics());
    }
}
