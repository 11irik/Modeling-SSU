package com.kirill.modeling;

import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Arrays;

public class PopulationDynamicTest {

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

}
