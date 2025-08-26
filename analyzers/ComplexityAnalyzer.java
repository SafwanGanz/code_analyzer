package com.codeanalyzer.analyzers;

import com.codeanalyzer.models.ComplexityMetrics;
import com.codeanalyzer.utils.PatternMatcher;

public class ComplexityAnalyzer {
    
    public ComplexityMetrics analyze(String content) {
        int cyclomaticComplexity = calculateCyclomaticComplexity(content);
        int cognitiveComplexity = calculateCognitiveComplexity(content);
        int nestingDepth = calculateMaxNestingDepth(content);
        
        return new ComplexityMetrics(cyclomaticComplexity, cognitiveComplexity, nestingDepth);
    }
    
    private int calculateCyclomaticComplexity(String content) {
        int complexity = 1;
        String[] keywords = {"if", "else", "while", "for", "switch", "case", "catch", "&&", "||", "?"};
        
        for (String keyword : keywords) {
            complexity += PatternMatcher.countKeyword(content, keyword);
        }
        
        return complexity;
    }
    
    private int calculateCognitiveComplexity(String content) {
        return PatternMatcher.countKeyword(content, "if") * 2 +
               PatternMatcher.countKeyword(content, "switch") * 2 +
               PatternMatcher.countKeyword(content, "for") +
               PatternMatcher.countKeyword(content, "while");
    }
    
    private int calculateMaxNestingDepth(String content) {
        int maxDepth = 0;
        int currentDepth = 0;
        
        for (char c : content.toCharArray()) {
            if (c == '{') {
                currentDepth++;
                maxDepth = Math.max(maxDepth, currentDepth);
            } else if (c == '}') {
                currentDepth--;
            }
        }
        
        return maxDepth;
    }
}