package com.codeanalyzer.models;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class AnalysisResult {
    private final Collection<FileAnalysis> fileAnalyses;
    
    public AnalysisResult(Collection<FileAnalysis> fileAnalyses) {
        this.fileAnalyses = fileAnalyses;
    }
    
    public int getTotalFiles() {
        return fileAnalyses.size();
    }
    
    public int getTotalLines() {
        return fileAnalyses.stream()
            .mapToInt(analysis -> analysis.getMetrics().getLineCount())
            .sum();
    }
    
    public int getTotalClasses() {
        return fileAnalyses.stream()
            .mapToInt(analysis -> analysis.getMetrics().getClassCount())
            .sum();
    }
    
    public int getTotalMethods() {
        return fileAnalyses.stream()
            .mapToInt(analysis -> analysis.getMetrics().getMethodCount())
            .sum();
    }
    
    public double getAverageComplexity() {
        return fileAnalyses.stream()
            .mapToInt(analysis -> analysis.getComplexityMetrics().getCyclomaticComplexity())
            .average()
            .orElse(0.0);
    }
    
    public double getAverageMaintainability() {
        return fileAnalyses.stream()
            .mapToDouble(FileAnalysis::getMaintainabilityIndex)
            .average()
            .orElse(0.0);
    }
    
    public int getTotalCodeSmells() {
        return fileAnalyses.stream()
            .mapToInt(analysis -> analysis.getCodeSmells().values().stream()
                .mapToInt(Integer::intValue)
                .sum())
            .sum();
    }
    
    public List<FileAnalysis> getTopComplexFiles(int limit) {
        return fileAnalyses.stream()
            .sorted((a, b) -> Integer.compare(
                b.getComplexityMetrics().getCyclomaticComplexity(),
                a.getComplexityMetrics().getCyclomaticComplexity()))
            .limit(limit)
            .collect(Collectors.toList());
    }
    
    public Collection<FileAnalysis> getAllAnalyses() {
        return fileAnalyses;
    }
}