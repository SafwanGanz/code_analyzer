package com.codeanalyzer.analyzers;

import com.codeanalyzer.models.FileAnalysis;

public class MaintainabilityCalculator {
    
    public double calculate(FileAnalysis analysis) {
        double volume = analysis.getMetrics().getLineCount() * 
                       Math.log(analysis.getMetrics().getMethodCount() + 1);
        double complexity = analysis.getComplexityMetrics().getCyclomaticComplexity();
        
        return Math.max(0, 171 - 5.2 * Math.log(volume) - 
                          0.23 * complexity - 
                          16.2 * Math.log(analysis.getMetrics().getLineCount()));
    }
}