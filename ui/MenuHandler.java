package com.codeanalyzer.ui;

import com.codeanalyzer.core.AnalysisEngine;
import com.codeanalyzer.models.*;

import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.Scanner;
import java.util.concurrent.CompletableFuture;

public class MenuHandler {
    private final AnalysisEngine engine;
    
    public MenuHandler(AnalysisEngine engine) {
        this.engine = engine;
    }
    
    public void handleChoice(String choice, Scanner scanner) {
        switch (choice) {
            case "1" -> analyzeDirectory(scanner);
            case "2" -> analyzeFile(scanner);
            case "3" -> generateReport();
            case "4" -> findCodeSmells();
            case "5" -> showComplexityMetrics();
            case "6" -> analyzeDependencies();
            case "7" -> exportResults(scanner);
            default -> System.out.println("❌ Invalid option. Please try again.");
        }
    }
    
    private void analyzeDirectory(Scanner scanner) {
        System.out.print("Enter directory path: ");
        String dirPath = scanner.nextLine().trim();
        
        if (!Files.exists(Paths.get(dirPath))) {
            System.out.println("❌ Directory not found: " + dirPath);
            return;
        }
        
        System.out.println("🔄 Analyzing directory: " + dirPath);
        long startTime = System.currentTimeMillis();
        
        CompletableFuture<AnalysisResult> future = engine.analyzeDirectory(Paths.get(dirPath));
        future.thenAccept(result -> {
            long duration = System.currentTimeMillis() - startTime;
            System.out.printf("✅ Analysis complete! Processed %d files in %d ms%n", 
                            result.getTotalFiles(), duration);
        }).join();
    }
    
    private void analyzeFile(Scanner scanner) {
        System.out.print("Enter Java file path: ");
        String filePath = scanner.nextLine().trim();
        
        if (!Files.exists(Paths.get(filePath))) {
            System.out.println("❌ File not found: " + filePath);
            return;
        }
        
        System.out.println("🔄 Analyzing file: " + filePath);
        CompletableFuture<FileAnalysis> future = engine.analyzeFile(Paths.get(filePath));
        future.thenAccept(this::displayFileAnalysis).join();
    }
    
    private void generateReport() {
        if (engine.getAnalysisCache().isEmpty()) {
            System.out.println("❌ No analysis results available.");
            return;
        }
        
        AnalysisResult result = engine.generateReport();
        displayAnalysisResult(result);
    }
    
    private void findCodeSmells() {
        if (engine.getAnalysisCache().isEmpty()) {
            System.out.println("❌ No analysis results available.");
            return;
        }
        
        System.out.println("\n🔍 === CODE SMELLS DETECTED ===");
        engine.getAnalysisCache().values().forEach(analysis -> {
            analysis.getCodeSmells().entrySet().stream()
                .filter(entry -> entry.getValue() > 0)
                .forEach(entry -> 
                    System.out.printf("  %s in %s: %d occurrences%n", 
                        entry.getKey(), 
                        analysis.getFileName(), 
                        entry.getValue())
                );
        });
    }
    
    private void showComplexityMetrics() {
        if (engine.getAnalysisCache().isEmpty()) {
            System.out.println("❌ No analysis results available.");
            return;
        }
        
        AnalysisResult result = engine.generateReport();
        System.out.println("\n📈 === COMPLEXITY METRICS ===");
        System.out.printf("Average Cyclomatic Complexity: %.2f%n", result.getAverageComplexity());
        System.out.printf("Average Maintainability Index: %.2f%n", result.getAverageMaintainability());
        
        System.out.println("\n⚠️ Most Complex Files:");
        result.getTopComplexFiles(5).forEach(analysis ->
            System.out.printf("  %s (complexity: %d)%n",
                analysis.getFileName(),
                analysis.getComplexityMetrics().getCyclomaticComplexity())
        );
    }
    
    private void analyzeDependencies() {
        if (engine.getAnalysisCache().isEmpty()) {
            System.out.println("❌ No analysis results available.");
            return;
        }
        
        System.out.println("\n🔗 === DEPENDENCY ANALYSIS ===");
        engine.getAnalysisCache().values().forEach(analysis -> {
            if (!analysis.getDependencies().isEmpty()) {
                System.out.println("File: " + analysis.getFileName());
                analysis.getDependencies().forEach(dep ->
                    System.out.println("  " + dep));
            }
        });
    }
    
    private void exportResults(Scanner scanner) {
        if (engine.getAnalysisCache().isEmpty()) {
            System.out.println("❌ No analysis results available.");
            return;
        }
        
        System.out.print("Enter output file path: ");
        String outputPath = scanner.nextLine().trim();
        
        try {
            AnalysisResult result = engine.generateReport();
            engine.reportGenerator.exportToFile(result, outputPath);
            System.out.println("✅ Results exported to: " + outputPath);
        } catch (Exception e) {
            System.out.println("❌ Error exporting results: " + e.getMessage());
        }
    }
    
    private void displayFileAnalysis(FileAnalysis analysis) {
        System.out.println("\n📄 === FILE ANALYSIS ===");
        System.out.println("File: " + analysis.getFileName());
        System.out.println("Lines: " + analysis.getMetrics().getLineCount());
        System.out.println("Classes: " + analysis.getMetrics().getClassCount());
        System.out.println("Methods: " + analysis.getMetrics().getMethodCount());
        System.out.println("Complexity: " + analysis.getComplexityMetrics().getCyclomaticComplexity());
        System.out.printf("Maintainability: %.2f%n", analysis.getMaintainabilityIndex());
    }
    
    private void displayAnalysisResult(AnalysisResult result) {
        System.out.println("\n📊 === ANALYSIS REPORT ===");
        System.out.printf("Total Files: %d%n", result.getTotalFiles());
        System.out.printf("Total Lines: %,d%n", result.getTotalLines());
        System.out.printf("Total Classes: %d%n", result.getTotalClasses());
        System.out.printf("Total Methods: %d%n", result.getTotalMethods());
        System.out.printf("Average Complexity: %.2f%n", result.getAverageComplexity());
        System.out.printf("Average Maintainability: %.2f%n", result.getAverageMaintainability());
        System.out.printf("Total Code Smells: %d%n", result.getTotalCodeSmells());
    }
}
