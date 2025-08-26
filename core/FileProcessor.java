package com.codeanalyzer.core;

import com.codeanalyzer.analyzers.*;
import com.codeanalyzer.models.*;
import com.codeanalyzer.utils.FileUtils;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

public class FileProcessor {
    private final AnalysisEngine engine;
    private final ComplexityAnalyzer complexityAnalyzer;
    private final CodeSmellDetector codeSmellDetector;
    private final DependencyAnalyzer dependencyAnalyzer;
    private final MaintainabilityCalculator maintainabilityCalculator;
    
    public FileProcessor(AnalysisEngine engine) {
        this.engine = engine;
        this.complexityAnalyzer = new ComplexityAnalyzer();
        this.codeSmellDetector = new CodeSmellDetector();
        this.dependencyAnalyzer = new DependencyAnalyzer();
        this.maintainabilityCalculator = new MaintainabilityCalculator();
    }
    
    public AnalysisResult processDirectory(Path directory) throws IOException {
        List<CompletableFuture<FileAnalysis>> futures = new ArrayList<>();
        
        Files.walkFileTree(directory, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
                if (FileUtils.isJavaFile(file)) {
                    CompletableFuture<FileAnalysis> future = 
                        CompletableFuture.supplyAsync(() -> processFile(file));
                    futures.add(future);
                }
                return FileVisitResult.CONTINUE;
            }
        });
        
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
        
        return new AnalysisResult(engine.getAnalysisCache().values());
    }
    
    public FileAnalysis processFile(Path file) {
        try {
            String content = Files.readString(file);
            FileAnalysis analysis = createBaseAnalysis(file, content);
            
            analysis.setComplexityMetrics(complexityAnalyzer.analyze(content));
            analysis.setCodeSmells(codeSmellDetector.detectSmells(content));
            analysis.setDependencies(dependencyAnalyzer.analyzeDependencies(content));
            analysis.setMaintainabilityIndex(
                maintainabilityCalculator.calculate(analysis)
            );
            
            engine.addToCache(file.toString(), analysis);
            return analysis;
            
        } catch (IOException e) {
            throw new RuntimeException("Failed to process file: " + file, e);
        }
    }
    
    private FileAnalysis createBaseAnalysis(Path file, String content) {
        CodeMetrics metrics = new CodeMetrics(content);
        return new FileAnalysis(file.toString(), metrics);
    }
}
