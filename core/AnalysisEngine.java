package com.codeanalyzer.core;

import com.codeanalyzer.analyzers.*;
import com.codeanalyzer.models.*;
import com.codeanalyzer.config.AnalysisConfiguration;
import com.codeanalyzer.exceptions.AnalysisException;

import java.nio.file.Path;
import java.util.concurrent.*;
import java.util.Map;

public class AnalysisEngine {
    private final FileProcessor fileProcessor;
    private final ReportGenerator reportGenerator;
    public void exportReportToFile(AnalysisResult result, String outputPath) throws Exception {
        reportGenerator.exportToFile(result, outputPath);
    }
    private final ExecutorService executorService;
    private final Map<String, FileAnalysis> analysisCache;
    
    public AnalysisEngine() {
        this.fileProcessor = new FileProcessor(this);
        this.reportGenerator = new ReportGenerator();
        this.executorService = Executors.newFixedThreadPool(
            AnalysisConfiguration.getThreadPoolSize()
        );
        this.analysisCache = new ConcurrentHashMap<>();
    }
    
    public CompletableFuture<AnalysisResult> analyzeDirectory(Path directory) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                return fileProcessor.processDirectory(directory);
            } catch (Exception e) {
                throw new AnalysisException("Failed to analyze directory: " + directory, e);
            }
        }, executorService);
    }
    
    public CompletableFuture<FileAnalysis> analyzeFile(Path file) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                return fileProcessor.processFile(file);
            } catch (Exception e) {
                throw new AnalysisException("Failed to analyze file: " + file, e);
            }
        }, executorService);
    }
    
    public AnalysisResult generateReport() {
        return reportGenerator.generateSummaryReport(analysisCache);
    }
    
    public void addToCache(String filePath, FileAnalysis analysis) {
        analysisCache.put(filePath, analysis);
    }
    
    public Map<String, FileAnalysis> getAnalysisCache() {
        return analysisCache;
    }
    
    public void clearCache() {
        analysisCache.clear();
    }
    
    public void shutdown() {
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(5, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
