package com.codeanalyzer.analyzers;

import com.codeanalyzer.config.AnalysisConfiguration;

import java.util.Map;
import java.util.HashMap;
import java.util.regex.Pattern;

public class CodeSmellDetector {
    private final Map<String, Pattern> smellPatterns;
    
    public CodeSmellDetector() {
        this.smellPatterns = AnalysisConfiguration.getCodeSmellPatterns();
    }
    
    public Map<String, Integer> detectSmells(String content) {
        Map<String, Integer> detectedSmells = new HashMap<>();
        
        for (Map.Entry<String, Pattern> entry : smellPatterns.entrySet()) {
            int count = countMatches(content, entry.getValue());
            detectedSmells.put(entry.getKey(), count);
        }
        
        return detectedSmells;
    }
    
    private int countMatches(String content, Pattern pattern) {
        return (int) pattern.matcher(content).results().count();
    }
}