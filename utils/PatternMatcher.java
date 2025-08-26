package com.codeanalyzer.utils;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class PatternMatcher {
    private static final Pattern CLASS_PATTERN = Pattern.compile(
        "\\b(?:public|private|protected|abstract|final)*\\s*class\\s+(\\w+)"
    );
    
    private static final Pattern METHOD_PATTERN = Pattern.compile(
        "\\b(?:public|private|protected|static|final|synchronized|abstract|native)*\\s*" +
        "(?:\\w+\\s+)*\\w+\\s+(\\w+)\\s*\\([^)]*\\)\\s*(?:throws\\s+[\\w,\\s]+)?\\s*\\{"
    );
    
    private static final Pattern IMPORT_PATTERN = Pattern.compile(
        "import\\s+(?:static\\s+)?([\\w.]+(?:\\.\\*)?);?"
    );
    
    public static int countClasses(String content) {
        return (int) CLASS_PATTERN.matcher(content).results().count();
    }
    
    public static int countMethods(String content) {
        return (int) METHOD_PATTERN.matcher(content).results().count();
    }
    
    public static int countKeyword(String content, String keyword) {
        Pattern pattern = Pattern.compile("\\b" + Pattern.quote(keyword) + "\\b");
        return (int) pattern.matcher(content).results().count();
    }
    
    public static List<String> extractClassNames(String content) {
        return CLASS_PATTERN.matcher(content)
            .results()
            .map(match -> match.group(1))
            .collect(Collectors.toList());
    }
    
    public static List<String> extractMethodNames(String content) {
        return METHOD_PATTERN.matcher(content)
            .results()
            .map(match -> match.group(1))
            .collect(Collectors.toList());
    }
    
    public static List<String> extractImports(String content) {
        return IMPORT_PATTERN.matcher(content)
            .results()
            .map(match -> match.group(1))
            .collect(Collectors.toList());
    }
}