package com.codeanalyzer;

import com.codeanalyzer.core.AnalysisEngine;
import com.codeanalyzer.ui.CommandLineInterface;

public class SmartCodeAnalyzer {
    public static void main(String[] args) {
        AnalysisEngine engine = new AnalysisEngine();
        CommandLineInterface cli = new CommandLineInterface(engine);
        cli.start();
    }
}