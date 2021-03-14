package com.kirill.modeling;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class DRVDistribution {

    public static Map<Integer, Double> calculateDistribution(int[] vals) {
        Map<Integer, Integer> frequency = new TreeMap();
        for (int val : vals) {
            if (frequency.containsKey(val)) {
                int freq = frequency.get(val);
                frequency.put(val, ++freq);
            } else {
                frequency.put(val, 1);
            }
        }

        Map<Integer, Double> distribution = new HashMap(frequency);
        for (Integer key : frequency.keySet()) {
            double p = frequency.get(key) / (double) vals.length;
            distribution.put(key, p);
        }
        
        return distribution;
    }
}