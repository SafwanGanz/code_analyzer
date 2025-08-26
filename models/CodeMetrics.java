package com.codeanalyzer.models;

import com.codeanalyzer.utils.PatternMatcher;

import java.util.List;

public class CodeMetrics {
    private final int lineCount;
    private final int characterCount;
    private final int classCount;
    private final int methodCount;
    private final List<String> classNames;
    private final List<String> methodNames;
    
    public CodeMetrics(String content) {
        this.lineCount = content.split("\n").length;
        this.characterCount = content.length();
        this.classCount = PatternMatcher.countClasses(content);
        this.methodCount = PatternMatcher.countMethods(content);
        this.classNames = PatternMatcher.extractClassNames(content);
        this.methodNames = PatternMatcher.extractMethodNames(content);
    }
    
    public int getLineCount() { return lineCount; }
    public int getCharacterCount() { return characterCount; }
    public int getClassCount() { return classCount; }
    public int getMethodCount() { return methodCount; }
    public List<String> getClassNames() { return classNames; }
    public List<String> getMethodNames() { return methodNames; }
}