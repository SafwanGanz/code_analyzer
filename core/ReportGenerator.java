package com.codeanalyzer.core;

import com.codeanalyzer.models.*;
import com.codeanalyzer.utils.StatisticsUtils;

import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Collection;

public class ReportGenerator {
    
    public AnalysisResult generateSummaryReport(Map<String, FileAnalysis> analysisCache) {
        return new AnalysisResult(analysisCache.values());
    }
    
    public void exportToFile(AnalysisResult result, String outputPath) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(outputPath))) {
            writeHeader(writer);
            writeSummaryStatistics(writer, result);
            writeDetailedAnalysis(writer, result);
            writeRecommendations(writer, result);
        }
    }
    
    private void writeHeader(PrintWriter writer) {
        writer.println("Smart Code Analyzer Report");
        writer.println("Generated: " + LocalDateTime.now().format(
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
        ));
        writer.println("================================");
    }
    
    private void writeSummaryStatistics(PrintWriter writer, AnalysisResult result) {
        writer.println("\nSUMMARY STATISTICS");
        writer.println("==================");
        writer.printf("Total Files: %d%n", result.getTotalFiles());
        writer.printf("Total Lines: %,d%n", result.getTotalLines());
        writer.printf("Total Classes: %d%n", result.getTotalClasses());
        writer.printf("Total Methods: %d%n", result.getTotalMethods());
        writer.printf("Average Complexity: %.2f%n", result.getAverageComplexity());
        writer.printf("Average Maintainability: %.2f%n", result.getAverageMaintainability());
    }
    
    private void writeDetailedAnalysis(PrintWriter writer, AnalysisResult result) {
        writer.println("\nDETAILED ANALYSIS");
        writer.println("=================");
        
        result.getTopComplexFiles(5).forEach(analysis -> {
            writer.printf("File: %s%n", analysis.getFileName());
            writer.printf("  Lines: %d, Complexity: %d, Maintainability: %.2f%n",
                analysis.getMetrics().getLineCount(),
                analysis.getComplexityMetrics().getCyclomaticComplexity(),
                analysis.getMaintainabilityIndex());
        });
    }
    
    private void writeRecommendations(PrintWriter writer, AnalysisResult result) {
        writer.println("\nRECOMMENDATIONS");
        writer.println("===============");
        
        if (result.getAverageComplexity() > 10) {
            writer.println("- Consider refactoring high-complexity methods");
        }
        if (result.getAverageMaintainability() < 70) {
            writer.println("- Focus on improving code maintainability");
        }
        if (result.getTotalCodeSmells() > result.getTotalFiles() * 2) {
            writer.println("- Address identified code smells");
        }
    }
}
