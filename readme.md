# Smart Code Analyzer


<div align="center">

[![Java](https://img.shields.io/badge/Java-11%2B-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](https://openjdk.java.net/)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg?style=for-the-badge)](https://opensource.org/licenses/MIT)
[![GitHub stars](https://img.shields.io/github/stars/SafwanGanz/code_analyzer?style=for-the-badge)](https://github.com/SafwanGanz/code_analyzer/stargazers)
[![GitHub forks](https://img.shields.io/github/forks/SafwanGanz/code_analyzer?style=for-the-badge)](https://github.com/SafwanGanz/code_analyzer/network)
[![GitHub issues](https://img.shields.io/github/issues/SafwanGanz/code_analyzer?style=for-the-badge)](https://github.com/SafwanGanz/code_analyzer/issues)
[![GitHub release](https://img.shields.io/github/v/release/SafwanGanz/code_analyzer?style=for-the-badge)](https://github.com/SafwanGanz/code_analyzer/releases)
[![Build Status](https://img.shields.io/github/actions/workflow/status/SafwanGanz/code_analyzer/ci.yml?style=for-the-badge)](https://github.com/SafwanGanz/code_analyzer/actions)
[![Code Coverage](https://img.shields.io/codecov/c/github/SafwanGanz/code_analyzer?style=for-the-badge)](https://codecov.io/gh/SafwanGanz/code_analyzer)

**Professional-grade Java code analysis tool for enterprise-level quality assessment**

[Documentation](#table-of-contents) • [Quick Start](#quick-start) • [Features](#key-features) • [API Reference](#api-reference) • [Contributing](#contributing)

</div>

---

## Overview

Smart Code Analyzer is a comprehensive Java code analysis tool designed for enterprise-level code quality assessment. It provides deep insights into code complexity, maintainability, dependencies, and identifies potential code smells with professional-grade reporting capabilities.

### Why Choose Smart Code Analyzer?

**Enterprise-Ready** | **Multi-threaded Processing** | **Comprehensive Analysis** | **Extensible Architecture**

- **High Performance**: Multi-threaded analysis engine processes thousands of files in seconds
- **Professional Metrics**: Advanced metrics including cognitive complexity, maintainability index, and technical debt analysis
- **Smart Detection**: Intelligent code smell detection with customizable patterns
- **Architecture Analysis**: Comprehensive dependency mapping and architectural issue identification
- **Export Capabilities**: Generate reports in multiple formats (HTML, JSON, XML, TXT)
- **Zero Configuration**: Works out of the box with sensible defaults

## Table of Contents

- [Quick Start](#quick-start)
- [Key Features](#key-features)
- [Architecture](#architecture)
- [Installation & Setup](#installation--setup)
- [Usage Guide](#usage-guide)
- [Features Deep Dive](#features-deep-dive)
- [API Reference](#api-reference)
- [Configuration](#configuration)
- [Performance](#performance)
- [Extending the Tool](#extending-the-tool)
- [Troubleshooting](#troubleshooting)
- [Contributing](#contributing)
- [License](#license)

## Quick Start

```bash
# Clone and build
git clone https://github.com/SafwanGanz/code_analyzer.git
cd code_analyzer
javac -d build -cp src src/main/java/com/codeanalyzer/**/*.java
jar cfm SmartCodeAnalyzer.jar MANIFEST.MF -C build .

# Run analysis
java -jar SmartCodeAnalyzer.jar
```

### Analyze Your First Project

1. Start the application: `java -jar SmartCodeAnalyzer.jar`
2. Choose option 1: "Analyze Directory"
3. Enter your Java project path
4. View comprehensive analysis results

## Key Features

<table>
<tr>
<td width="50%">

### Advanced Analysis Engine
- **Cyclomatic Complexity** measurement
- **Cognitive Complexity** analysis
- **Maintainability Index** scoring (0-100 scale)
- **Technical Debt** quantification
- **Code Smell** detection with 15+ patterns

</td>
<td width="50%">

### Performance & Scalability
- **Multi-threaded** parallel processing
- **Memory optimized** for large codebases
- **Streaming analysis** for massive projects
- **Configurable thread pools**
- **Efficient resource management**

</td>
</tr>
</table>

### Supported Code Quality Metrics

| Metric | Description | Range |
|--------|-------------|-------|
| **Cyclomatic Complexity** | Measures code path complexity | 1+ (Lower is better) |
| **Cognitive Complexity** | Human-perceived code difficulty | 1+ (Lower is better) |
| **Maintainability Index** | Overall code maintainability score | 0-100 (Higher is better) |
| **Technical Debt Ratio** | Ratio of problematic to clean code | 0-1 (Lower is better) |
| **Lines of Code** | Total lines including comments | N/A |
| **Method Count** | Number of methods per class | N/A |

## Architecture

The Smart Code Analyzer follows a modular architecture with clean separation of concerns:

```
┌─────────────────┐    ┌─────────────────┐    ┌─────────────────┐
│   CLI Interface │────│ Analysis Engine │────│ Report Generator│
└─────────────────┘    └─────────────────┘    └─────────────────┘
                              │
                    ┌─────────┼─────────┐
                    │         │         │
            ┌───────▼───┐ ┌───▼────┐ ┌──▼──────────┐
            │File       │ │Metrics │ │Code Smell   │
            │Processor  │ │Analyzer│ │Detector     │
            └───────────┘ └────────┘ └─────────────┘
```

### Design Patterns Implementation

| Pattern | Usage | Benefit |
|---------|--------|---------|
| **Strategy** | Different analysis implementations | Flexible analysis strategies |
| **Factory** | Configuration-based component creation | Easy extensibility |
| **Observer** | Asynchronous result processing | Non-blocking operations |
| **Command** | Menu operation encapsulation | Clean command handling |

## Installation & Setup

### Prerequisites

[![Java](https://img.shields.io/badge/Java-11%2B-ED8B00?style=flat-square&logo=openjdk)](https://openjdk.java.net/)
[![Maven](https://img.shields.io/badge/Maven-3.6%2B-C71A36?style=flat-square&logo=apache-maven)](https://maven.apache.org/)
[![Memory](https://img.shields.io/badge/RAM-2GB%2B-9cf?style=flat-square)](https://github.com/SafwanGanz/code_analyzer)

### System Requirements

| Component | Minimum | Recommended | Enterprise |
|-----------|---------|-------------|------------|
| **Java Version** | 11 | 17+ | 21+ |
| **RAM** | 2GB | 4GB | 8GB+ |
| **CPU Cores** | 2 | 4 | 8+ |
| **Storage** | 100MB | 500MB | 2GB+ |

### Installation Methods

#### Method 1: Pre-built Release (Recommended)

```bash
# Download latest release
curl -L https://github.com/SafwanGanz/code_analyzer/releases/latest/download/SmartCodeAnalyzer.jar -o SmartCodeAnalyzer.jar

# Verify installation
java -jar SmartCodeAnalyzer.jar --version
```

#### Method 2: Build from Source

```bash
# Clone repository
git clone https://github.com/SafwanGanz/code_analyzer.git
cd code_analyzer

# Build with Maven (if available)
mvn clean compile assembly:single

# Or build manually
javac -d build -cp src src/main/java/com/codeanalyzer/**/*.java
jar cfm SmartCodeAnalyzer.jar MANIFEST.MF -C build .
```

#### Method 3: Docker (Coming Soon)

```bash
# Pull Docker image
docker pull safwanganz/smart-code-analyzer:latest

# Run analysis
docker run -v /your/project:/workspace safwanganz/smart-code-analyzer
```

## Usage Guide

### Interactive Menu System

```
Smart Code Analyzer v2.0
Professional Edition
===========================

Select an option:
1. Analyze Directory          5. Show Complexity Metrics
2. Analyze Single File        6. Analyze Dependencies  
3. Generate Analysis Report   7. Export Results
4. Find Code Smells          8. Exit
```

### Command Line Examples

#### Analyze a Spring Boot Project

```bash
java -jar SmartCodeAnalyzer.jar

# Choose: 1 (Analyze Directory)
Choice: 1

# Enter project path
Enter directory path: /workspace/my-spring-project/src/main/java

# Output:
Analyzing directory: /workspace/my-spring-project/src/main/java
Processing files... 100% (127/127)
Using 8 threads for parallel processing
Analyzing complexity patterns...
Detecting code smells...
Mapping dependencies...

Analysis complete! 
Processed 127 files in 2,341 ms
Found 23 potential improvements
Average maintainability: 78.5/100
```

#### Single File Analysis

```bash
Choice: 2
Enter Java file path: /path/to/UserService.java

=== FILE ANALYSIS ===
File: UserService.java
Lines: 156 | Classes: 1 | Methods: 8
Complexity: 12 (Moderate)
Maintainability: 73.45/100 (Good)

Recommendations:
• Consider breaking down the processUserData method (78 lines)
• Remove 3 TODO comments
• Replace magic number 10 with named constant
```

## Features Deep Dive

### Code Smell Detection

The analyzer detects 15+ types of code smells with configurable patterns:

| Smell Type | Description | Detection Pattern | Severity |
|------------|-------------|-------------------|----------|
| **Long Method** | Methods exceeding 500 characters | `\{[^}]{500,}\}` | High |
| **Magic Numbers** | Hardcoded numeric literals | `\b(?<!\.)\\d{2,}\b` | Medium |
| **TODO Comments** | Unfinished implementation markers | `//\s*TODO` | Low |
| **Debug Statements** | System.out.println usage | `System\.out\.print` | Medium |
| **Empty Catch** | Exception handling without action | `catch\s*\([^)]+\)\s*\{\s*\}` | High |
| **God Class** | Classes with excessive responsibilities | `class\s+\w+[^}]{2000,}` | High |
| **Feature Envy** | Excessive method chaining | `(\w+\.){3,}\w+` | Medium |

### Complexity Analysis Scales

#### Cyclomatic Complexity Levels

| Range | Level | Description | Action Needed |
|-------|--------|-------------|---------------|
| 1-5 | Low | Simple, easy to test | Maintain current quality |
| 6-10 | Moderate | More complex, manageable | Monitor for growth |
| 11-20 | High | Complex, difficult to test | Consider refactoring |
| 21+ | Very High | Immediate attention needed | Refactor immediately |

#### Maintainability Index Scale

```
Maintainability Score (0-100):

85-100  ████████████████████ Excellent    
70-84   ████████████████     Good        
50-69   ████████████         Needs Work  
0-49    ████████             Legacy Code  
```

### Dependency Analysis Features

- **Import Mapping**: Complete tracking of all import statements
- **Package Usage Analysis**: Identification of most frequently used packages
- **External Dependency Detection**: Highlights non-JDK dependencies
- **Circular Dependency Detection**: Identifies potential architectural issues
- **Dependency Tree Visualization**: Visual representation of component relationships

## API Reference

### Core Classes

#### AnalysisEngine

The central orchestration class for all analysis operations.

```java
public class AnalysisEngine {
    // Asynchronous directory analysis
    public CompletableFuture<AnalysisResult> analyzeDirectory(Path directory)
    
    // Single file analysis  
    public CompletableFuture<FileAnalysis> analyzeFile(Path file)
    
    // Generate comprehensive report
    public AnalysisResult generateReport()
    
    // Graceful shutdown with resource cleanup
    public void shutdown()
}
```

#### FileAnalysis

Represents detailed analysis results for a single file.

```java
public class FileAnalysis {
    public String getFilePath()                        // File path information
    public CodeMetrics getMetrics()                    // Basic code metrics
    public ComplexityMetrics getComplexityMetrics()    // Complexity analysis data
    public Map<String, Integer> getCodeSmells()        // Detected code smells
    public double getMaintainabilityIndex()            // Maintainability score
    public List<String> getDependencies()              // File dependencies
    public QualityGrade getOverallGrade()              // Overall quality assessment
}
```

#### AnalysisResult

Aggregated results for multiple files with summary statistics.

```java
public class AnalysisResult {
    public int getTotalFiles()                         // Total analyzed files
    public double getAverageComplexity()               // Average complexity score
    public List<FileAnalysis> getTopComplexFiles(int limit)  // Most complex files
    public int getTotalCodeSmells()                    // Total code smell count
    public Map<String, Integer> getCodeSmellSummary()  // Code smell distribution
    public TechnicalDebtSummary getTechnicalDebt()     // Technical debt analysis
}
```

### Analyzer Interfaces

#### ComplexityAnalyzer Interface

```java
public interface ComplexityAnalyzer {
    ComplexityMetrics analyze(String content);
    ComplexityGrade calculateGrade(ComplexityMetrics metrics);
}
```

#### CodeSmellDetector Interface

```java
public interface CodeSmellDetector {
    Map<String, Integer> detectSmells(String content);
    List<CodeSmellInstance> getDetailedSmells(String content);
}
```

#### DependencyAnalyzer Interface

```java
public interface DependencyAnalyzer {
    List<String> analyzeDependencies(String content);
    DependencyGraph buildDependencyGraph(List<FileAnalysis> analyses);
}
```

## Configuration

### Analysis Configuration

The `AnalysisConfiguration` class provides centralized settings management:

```java
public class AnalysisConfiguration {
    // Thread pool configuration
    public static int getThreadPoolSize()
    
    // Code smell detection patterns
    public static Map<String, Pattern> getCodeSmellPatterns()
    
    // Complexity analysis thresholds
    public static ComplexityThresholds getComplexityThresholds()
    
    // File inclusion/exclusion rules
    public static FileFilterSettings getFileFilters()
    
    // Report generation settings
    public static ReportConfiguration getReportSettings()
}
```

### Customizing Code Smell Detection

Add custom code smell patterns:

```java
private static Map<String, Pattern> initializeCodeSmellPatterns() {
    Map<String, Pattern> patterns = new HashMap<>();
    
    // God Class detection
    patterns.put("God Class", 
        Pattern.compile("class\\s+\\w+[^}]{2000,}"));
        
    // Feature Envy detection  
    patterns.put("Feature Envy", 
        Pattern.compile("(\\w+\\.){3,}\\w+"));
        
    // Custom security patterns
    patterns.put("Hardcoded Password", 
        Pattern.compile("password\\s*=\\s*[\"'][^\"']+[\"']"));
        
    return patterns;
}
```

### Thread Pool Configuration

Customize thread pool settings for optimal performance:

```java
// Default configuration based on system capabilities
private static final int DEFAULT_THREAD_POOL_SIZE = 
    Runtime.getRuntime().availableProcessors();

// Custom configuration
System.setProperty("analyzer.threads", "8");
System.setProperty("analyzer.queue.size", "1000");
System.setProperty("analyzer.timeout", "300");
```

## Performance

### Benchmark Results

Performance metrics across different project sizes:

| Project Size | Files | Processing Time | Memory Usage | Throughput |
|--------------|-------|-----------------|--------------|------------|
| **Small** | 45 | 1.2s | 128MB | 37 files/s |
| **Medium** | 156 | 4.8s | 256MB | 32 files/s |
| **Large** | 743 | 18.3s | 512MB | 40 files/s |
| **Enterprise** | 2,451 | 67.2s | 1GB | 36 files/s |

### Performance Optimization

#### Memory Optimization

```bash
# For large projects
java -Xmx4g -XX:+UseG1GC -jar SmartCodeAnalyzer.jar

# Monitor GC performance
java -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -jar SmartCodeAnalyzer.jar

# Profile memory usage
java -XX:+HeapDumpOnOutOfMemoryError -jar SmartCodeAnalyzer.jar
```

#### Thread Pool Tuning

```java
// Optimize for CPU-bound tasks
System.setProperty("analyzer.threads", String.valueOf(Runtime.getRuntime().availableProcessors()));

// Optimize for I/O-bound tasks
System.setProperty("analyzer.threads", String.valueOf(Runtime.getRuntime().availableProcessors() * 2));

// Custom queue configuration
System.setProperty("analyzer.queue.size", "1000");
System.setProperty("analyzer.timeout", "300");
```

#### File System Performance Tips

- Use SSD storage for better I/O performance
- Exclude unnecessary directories (test, target, build)
- Process files in batches for very large codebases
- Enable file system caching for repeated analyses

## Extending the Tool

### Adding Custom Analyzers

#### Example: Security Analyzer

```java
public class SecurityAnalyzer {
    private static final Pattern SQL_INJECTION = 
        Pattern.compile("String\\s+sql\\s*=.*\\+.*");
    
    private static final Pattern HARDCODED_PASSWORD = 
        Pattern.compile("password\\s*=\\s*[\"'][^\"']{8,}[\"']");
    
    private static final Pattern WEAK_CRYPTO = 
        Pattern.compile("DES|MD5|SHA1");
    
    public SecurityMetrics analyze(String content) {
        SecurityMetrics metrics = new SecurityMetrics();
        
        // Detect SQL injection vulnerabilities
        metrics.setSqlInjectionRisks(countMatches(SQL_INJECTION, content));
        
        // Detect hardcoded passwords
        metrics.setHardcodedPasswords(countMatches(HARDCODED_PASSWORD, content));
        
        // Detect weak cryptographic algorithms
        metrics.setWeakCryptoUsage(countMatches(WEAK_CRYPTO, content));
        
        return metrics;
    }
}
```

#### Integration with Analysis Engine

```java
public class EnhancedFileProcessor extends FileProcessor {
    private final SecurityAnalyzer securityAnalyzer = new SecurityAnalyzer();
    
    @Override
    public FileAnalysis processFile(Path file) throws IOException {
        FileAnalysis analysis = super.processFile(file);
        
        // Add security analysis
        String content = Files.readString(file);
        SecurityMetrics securityMetrics = securityAnalyzer.analyze(content);
        analysis.setSecurityMetrics(securityMetrics);
        
        return analysis;
    }
}
```

### Custom Report Formats

#### JSON Report Generator

```java
public class JsonReportGenerator extends ReportGenerator {
    private final Gson gson = new GsonBuilder()
        .setPrettyPrinting()
        .setDateFormat("yyyy-MM-dd HH:mm:ss")
        .create();
    
    public void exportToJson(AnalysisResult result, String outputPath) throws IOException {
        JsonReportModel report = JsonReportModel.builder()
            .timestamp(Instant.now())
            .summary(createSummary(result))
            .fileAnalyses(result.getFileAnalyses())
            .codeSmellDistribution(result.getCodeSmellSummary())
            .complexityDistribution(result.getComplexityDistribution())
            .build();
        
        try (FileWriter writer = new FileWriter(outputPath)) {
            gson.toJson(report, writer);
        }
    }
}
```

#### HTML Report Generator with Charts

```java
public class HtmlReportGenerator extends ReportGenerator {
    public void exportToHtml(AnalysisResult result, String outputPath) throws IOException {
        VelocityEngine velocityEngine = new VelocityEngine();
        Template template = velocityEngine.getTemplate("report-template.html");
        
        VelocityContext context = new VelocityContext();
        context.put("result", result);
        context.put("chartData", generateChartData(result));
        context.put("generatedAt", LocalDateTime.now());
        
        try (FileWriter writer = new FileWriter(outputPath)) {
            template.merge(context, writer);
        }
    }
}
```

## Troubleshooting

### Common Issues and Solutions

#### OutOfMemoryError

**Problem**: `java.lang.OutOfMemoryError: Java heap space`

**Root Causes**:
- Analyzing very large files or projects
- Insufficient heap memory allocation
- Memory leaks in custom analyzers

**Solutions**:
```bash
# Increase heap size
java -Xmx4g -jar SmartCodeAnalyzer.jar

# Use memory-efficient garbage collector
java -XX:+UseG1GC -XX:MaxGCPauseMillis=200 -jar SmartCodeAnalyzer.jar

# Enable heap dump for analysis
java -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/tmp/ -jar SmartCodeAnalyzer.jar

# Process files in smaller batches
java -Danalyzer.batch.size=50 -jar SmartCodeAnalyzer.jar
```

#### File Access Permission Issues

**Problem**: `java.nio.file.AccessDeniedException`

**Solutions**:
```bash
# Fix file permissions (Linux/Mac)
chmod -R 755 /path/to/project

# Run with appropriate permissions (if necessary)
sudo java -jar SmartCodeAnalyzer.jar

# Windows: Run Command Prompt as Administrator
```

#### Thread Pool Exhaustion

**Problem**: `java.util.concurrent.RejectedExecutionException`

**Solutions**:
```bash
# Reduce concurrent processing
java -Danalyzer.threads=4 -jar SmartCodeAnalyzer.jar

# Increase queue size
java -Danalyzer.queue.size=2000 -jar SmartCodeAnalyzer.jar

# Increase timeout
java -Danalyzer.timeout=600 -jar SmartCodeAnalyzer.jar
```

#### Performance Issues

**Symptoms**: Analysis takes unusually long time

**Common Causes and Solutions**:

1. **Large Files**: 
   ```bash
   # Skip very large files
   java -Danalyzer.max.file.size=1000000 -jar SmartCodeAnalyzer.jar
   ```

2. **Complex Regex Patterns**:
   ```bash
   # Disable expensive patterns
   java -Danalyzer.disable.patterns=long_method,god_class -jar SmartCodeAnalyzer.jar
   ```

3. **Insufficient Memory**:
   ```bash
   # Increase memory allocation
   java -Xmx8g -jar SmartCodeAnalyzer.jar
   ```

4. **I/O Bottlenecks**:
   ```bash
   # Exclude unnecessary directories
   java -Danalyzer.exclude=test,target,build,node_modules -jar SmartCodeAnalyzer.jar
   ```

### Debug Mode and Logging

#### Enable Verbose Logging

```bash
# Debug level logging
java -Dlogging.level=DEBUG -jar SmartCodeAnalyzer.jar

# Trace level for detailed analysis
java -Dlogging.level=TRACE -jar SmartCodeAnalyzer.jar

# Log to file
java -Dlogging.file=/tmp/analyzer.log -jar SmartCodeAnalyzer.jar
```

#### Performance Profiling

```bash
# Enable JVM profiling
java -XX:+PrintCompilation -XX:+UnlockDiagnosticVMOptions -XX:+PrintInlining -jar SmartCodeAnalyzer.jar

# Monitor thread activity
java -XX:+PrintGCApplicationStoppedTime -XX:+PrintGCApplicationConcurrentTime -jar SmartCodeAnalyzer.jar

# Flight recorder (Java 11+)
java -XX:+FlightRecorder -XX:StartFlightRecording=duration=60s,filename=analysis.jfr -jar SmartCodeAnalyzer.jar
```

## Contributing

<div align="center">

[![Contributors](https://img.shields.io/github/contributors/SafwanGanz/code_analyzer?style=for-the-badge)](https://github.com/SafwanGanz/code_analyzer/graphs/contributors)
[![PRs Welcome](https://img.shields.io/badge/PRs-welcome-brightgreen.svg?style=for-the-badge)](http://makeapullrequest.com)
[![Good First Issues](https://img.shields.io/github/issues/SafwanGanz/code_analyzer/good%20first%20issue?style=for-the-badge)](https://github.com/SafwanGanz/code_analyzer/issues?q=is%3Aissue+is%3Aopen+label%3A%22good+first+issue%22)

</div>

### How to Contribute

We welcome contributions from the community! Here are several ways you can help:

<table>
<tr>
<td width="33%" align="center">

**Report Bugs**  
Found an issue? Help us improve by reporting it.  
[Create Bug Report](https://github.com/SafwanGanz/code_analyzer/issues/new?template=bug_report.md)

</td>
<td width="33%" align="center">

**Suggest Features**  
Have an idea for improvement?  
[Request Feature](https://github.com/SafwanGanz/code_analyzer/issues/new?template=feature_request.md)

</td>
<td width="33%" align="center">

**Submit Code**  
Ready to contribute code?  
[View Contributing Guide](CONTRIBUTING.md)

</td>
</tr>
</table>

### Development Setup

```bash
# Fork the repository
gh repo fork SafwanGanz/code_analyzer

# Clone your fork
git clone https://github.com/YOUR_USERNAME/code_analyzer.git
cd code_analyzer

# Create feature branch
git checkout -b feature/amazing-new-feature

# Make changes and commit
git commit -m "Add amazing new feature"

# Push and create PR
git push origin feature/amazing-new-feature
```

### Pull Request Guidelines

Before submitting a pull request, please ensure:

- [ ] **Tests Pass**: Run `mvn test` to verify all tests pass
- [ ] **Code Style**: Follow existing code style and formatting
- [ ] **Documentation**: Update documentation for new features
- [ ] **Performance**: Consider performance impact of changes
- [ ] **Backward Compatibility**: Maintain API compatibility where possible

### Code Style Guidelines

- Use meaningful variable and method names
- Follow Java naming conventions
- Add JavaDoc comments for public APIs
- Include unit tests for new functionality
- Maintain consistent indentation (4 spaces)

### Issue Labels

We use labels to categorize issues:

- ![bug](https://img.shields.io/badge/bug-d73a4a) - Something isn't working
- ![enhancement](https://img.shields.io/badge/enhancement-a2eeef) - New feature or request  
- ![good first issue](https://img.shields.io/badge/good%20first%20issue-7057ff) - Good for newcomers
- ![help wanted](https://img.shields.io/badge/help%20wanted-008672) - Extra attention is needed
- ![documentation](https://img.shields.io/badge/documentation-0075ca) - Improvements or additions to documentation

## License

<div align="center">

[![License: MIT](LICENSE)

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

</div>

---

<div align="center">

### Star History

[![Star History Chart](https://api.star-history.com/svg?repos=SafwanGanz/code_analyzer&type=Timeline)](https://star-history.com/#SafwanGanz/code_analyzer&Timeline)

### Support the Project

If this tool helps you write better code, consider supporting the project:

[![GitHub Sponsors](https://img.shields.io/badge/GitHub-Sponsors-pink?style=for-the-badge&logo=github)](https://github.com/sponsors/SafwanGanz)
[![Buy Me A Coffee](https://img.shields.io/badge/Buy%20Me%20A%20Coffee-support-yellow?style=for-the-badge&logo=buy-me-a-coffee)](https://www.buymeacoffee.com/safwanganz)

### Connect With the Team

[![GitHub](https://img.shields.io/badge/GitHub-follow-black?style=for-the-badge&logo=github)](https://github.com/SafwanGanz)

---

**Smart Code Analyzer** - Empowering developers with actionable code quality insights  
Made with care by [SafwanGanz](https://github.com/SafwanGanz) and [contributors](https://github.com/SafwanGanz/code_analyzer/graphs/contributors)

</div>
