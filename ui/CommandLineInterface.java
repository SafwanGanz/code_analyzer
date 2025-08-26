package com.codeanalyzer.ui;

import com.codeanalyzer.core.AnalysisEngine;

import java.util.Scanner;

public class CommandLineInterface {
    private final AnalysisEngine engine;
    private final MenuHandler menuHandler;
    private final Scanner scanner;
    
    public CommandLineInterface(AnalysisEngine engine) {
        this.engine = engine;
        this.menuHandler = new MenuHandler(engine);
        this.scanner = new Scanner(System.in);
    }
    
    public void start() {
        displayWelcome();
        
        while (true) {
            displayMenu();
            String choice = scanner.nextLine().trim();
            
            if ("8".equals(choice)) {
                shutdown();
                break;
            }
            
            menuHandler.handleChoice(choice, scanner);
        }
    }
    
    private void displayWelcome() {
        System.out.println("🚀 Smart Code Analyzer v2.0");
        System.out.println("Professional Edition");
        System.out.println("===========================");
    }
    
    private void displayMenu() {
        System.out.println("\n📋 Select an option:");
        System.out.println("1. 📁 Analyze Directory");
        System.out.println("2. 📄 Analyze Single File");
        System.out.println("3. 📊 Generate Analysis Report");
        System.out.println("4. 🔍 Find Code Smells");
        System.out.println("5. 📈 Show Complexity Metrics");
        System.out.println("6. 🔗 Analyze Dependencies");
        System.out.println("7. 💾 Export Results");
        System.out.println("8. 🚪 Exit");
        System.out.print("Choice: ");
    }
    
    private void shutdown() {
        engine.shutdown();
        scanner.close();
        System.out.println("👋 Thank you for using Smart Code Analyzer!");
    }
}