package com.codeanalyzer.exceptions;

public class AnalysisException extends RuntimeException {
    public AnalysisException(String message) {
        super(message);
    }
    
    public AnalysisException(String message, Throwable cause) {
        super(message, cause);
    }
}