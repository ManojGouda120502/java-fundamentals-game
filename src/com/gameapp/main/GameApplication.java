package com.gameapp.main;

import java.util.Scanner;


public class GameApplication {
    
   
    private static final String APP_VERSION = "2.0";
    
    public static void main(String[] args) {
       
        showBanner();
        
        // Create and run the menu controller
        MenuController menu = new MenuController();
        menu.run();
        
        System.out.println("\n👋 Thanks for playing! Goodbye.");
    }
    
  
    private static void showBanner() {
        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║     🎮 JAVA FUNDAMENTALS MASTER 🎮   ║");
        System.out.println("║     Number Guess + Pattern Gen       ║");
        System.out.println("║           Version " + APP_VERSION + "              ║");
        System.out.println("╚══════════════════════════════════════╝");
        System.out.println();
    }
}