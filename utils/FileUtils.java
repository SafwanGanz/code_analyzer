package com.codeanalyzer.utils;

import java.nio.file.Path;

public class FileUtils {
    
    public static boolean isJavaFile(Path file) {
        return file.toString().endsWith(".java");
    }
    
    public static String getFileExtension(Path file) {
        String fileName = file.getFileName().toString();
        int lastDotIndex = fileName.lastIndexOf('.');
        return lastDotIndex > 0 ? fileName.substring(lastDotIndex + 1) : "";
    }
    
    public static long getFileSize(Path file) {
        try {
            return java.nio.file.Files.size(file);
        } catch (Exception e) {
            return 0;
        }
    }
}