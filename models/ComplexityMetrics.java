package com.codeanalyzer.models;

public class ComplexityMetrics {
    private final int cyclomaticComplexity;
    private final int cognitiveComplexity;
    private final int maxNestingDepth;
    
    public ComplexityMetrics(int cyclomaticComplexity, int cognitiveComplexity, int maxNestingDepth) {
        this.cyclomaticComplexity = cyclomaticComplexity;
        this.cognitiveComplexity = cognitiveComplexity;
        this.maxNestingDepth = maxNestingDepth;
    }
    
    public int getCyclomaticComplexity() { return cyclomaticComplexity; }
    public int getCognitiveComplexity() { return cognitiveComplexity; }
    public int getMaxNestingDepth() { return maxNestingDepth; }
    
    public String getComplexityLevel() {
        if (cyclomaticComplexity <= 5) return "LOW";
        if (cyclomaticComplexity <= 10) return "MODERATE";
        if (cyclomaticComplexity <= 20) return "HIGH";
        return "VERY_HIGH";
    }
}