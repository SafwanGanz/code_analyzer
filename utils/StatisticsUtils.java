package com.codeanalyzer.utils;

import java.util.Collection;
import java.util.DoubleSummaryStatistics;

public class StatisticsUtils {
    
    public static DoubleSummaryStatistics calculateStatistics(Collection<Double> values) {
        return values.stream().mapToDouble(Double::doubleValue).summaryStatistics();
    }
    
    public static double calculatePercentile(Collection<Double> values, double percentile) {
        return values.stream()
            .sorted()
            .skip((long) (values.size() * percentile / 100))
            .findFirst()
            .orElse(0.0);
    }
}