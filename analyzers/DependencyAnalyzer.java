package com.codeanalyzer.analyzers;

import com.codeanalyzer.utils.PatternMatcher;

import java.util.List;

public class DependencyAnalyzer {
    
    public List<String> analyzeDependencies(String content) {
        return PatternMatcher.extractImports(content);
    }
}
