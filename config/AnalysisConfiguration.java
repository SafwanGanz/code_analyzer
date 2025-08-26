package com.codeanalyzer.config;

import java.util.Map;
import java.util.HashMap;
import java.util.regex.Pattern;

public class AnalysisConfiguration {
    private static final int DEFAULT_THREAD_POOL_SIZE = Runtime.getRuntime().availableProcessors();
    private static final Map<String, Pattern> CODE_SMELL_PATTERNS = initializeCodeSmellPatterns();
    
    public static int getThreadPoolSize() {
        return DEFAULT_THREAD_POOL_SIZE;
    }
    
    public static Map<String, Pattern> getCodeSmellPatterns() {
        return CODE_SMELL_PATTERNS;
    }
    
    private static Map<String, Pattern> initializeCodeSmellPatterns() {
        Map<String, Pattern> patterns = new HashMap<>();
        patterns.put("Long Method", Pattern.compile("\\{[^}]{500,}\\}"));
        patterns.put("Magic Numbers", Pattern.compile("\\b(?<!\\.)\\d{2,}\\b(?!\\s*[;,)])"));
        patterns.put("TODO Comments", Pattern.compile("//\\s*TODO", Pattern.CASE_INSENSITIVE));
        patterns.put("System.out.println", Pattern.compile("System\\.out\\.print"));
        patterns.put("Empty Catch", Pattern.compile("catch\\s*\\([^)]+\\)\\s*\\{\\s*\\}"));
        return patterns;
    }
}