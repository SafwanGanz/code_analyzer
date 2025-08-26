package com.codeanalyzer.models;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.List;

public class FileAnalysis {
    private final String filePath;
    private final CodeMetrics metrics;
    private ComplexityMetrics complexityMetrics;
    private Map<String, Integer> codeSmells;
    private List<String> dependencies;
    private double maintainabilityIndex;
    
    public FileAnalysis(String filePath, CodeMetrics metrics) {
        this.filePath = filePath;
        this.metrics = metrics;
    }
    
    public String getFilePath() { return filePath; }
    public String getFileName() { return Paths.get(filePath).getFileName().toString(); }
    public CodeMetrics getMetrics() { return metrics; }
    public ComplexityMetrics getComplexityMetrics() { return complexityMetrics; }
    public Map<String, Integer> getCodeSmells() { return codeSmells; }
    public List<String> getDependencies() { return dependencies; }
    public double getMaintainabilityIndex() { return maintainabilityIndex; }
    
    public void setComplexityMetrics(ComplexityMetrics complexityMetrics) {
        this.complexityMetrics = complexityMetrics;
    }
    
    public void setCodeSmells(Map<String, Integer> codeSmells) {
        this.codeSmells = codeSmells;
    }
    
    public void setDependencies(List<String> dependencies) {
        this.dependencies = dependencies;
    }
    
    public void setMaintainabilityIndex(double maintainabilityIndex) {
        this.maintainabilityIndex = maintainabilityIndex;
    }
}
