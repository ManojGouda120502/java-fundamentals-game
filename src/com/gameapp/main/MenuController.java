package com.gameapp.main;

import java.util.Scanner;


public class MenuController {
    private Scanner scanner;
    private InputValidator validator;
    private ScoreTracker scoreTracker;
    private NumberGuessingGame guessingGame;
    private PatternGenerator patternGenerator;
    private boolean running;
    
    public MenuController() {
        this.scanner = new Scanner(System.in);
        this.validator = new InputValidator(scanner);
        this.scoreTracker = new ScoreTracker();
        this.guessingGame = new NumberGuessingGame(scoreTracker, validator);
        this.patternGenerator = new PatternGenerator(validator);
        this.running = true;
    }
    
    /**
     * Main application loop
     * Demonstrates: while loop, switch statement, method calls
     */
    public void run() {
        while (running) {
            displayMenu();
            int choice = validator.getInt("Enter choice (1-5): ", 1, 5);
            
            // Process choice using switch (demonstrates: arrow syntax, yield)
            switch (choice) {
                case 1 -> {
                    guessingGame.play();
                    System.out.println("\nPress Enter to continue...");
                    scanner.nextLine();
                }
                case 2 -> {
                    patternGenerator.run();
                }
                case 3 -> {
                    scoreTracker.displayScores();
                    System.out.println("\nPress Enter to continue...");
                    scanner.nextLine();
                }
                case 4 -> {
                    showFundamentalsDemo();
                    System.out.println("\nPress Enter to continue...");
                    scanner.nextLine();
                }
                case 5 -> {
                    if (validator.confirm("Are you sure you want to exit?")) {
                        running = false; // Assignment operator
                        System.out.println("Saving session data...");
                    }
                }
            }
        }
    }
    
    
    private void displayMenu() {
        System.out.println("\n╔════════════════════════════════════╗");
        System.out.println("║         📋 MAIN MENU                 ║");
        System.out.println("╠════════════════════════════════════╣");
        System.out.println("║  1. 🎯 Number Guessing Game         ║");
        System.out.println("║  2. 🎨 Pattern Generator            ║");
        System.out.println("║  3. 🏆 View High Scores             ║");
        System.out.println("║  4. 📚 Java Fundamentals Demo       ║");
        System.out.println("║  5. 🚪 Exit                         ║");
        System.out.println("╚════════════════════════════════════╝");
    }
    
    
    private void showFundamentalsDemo() {
        System.out.println("\n📚 JAVA FUNDAMENTALS DEMONSTRATION");
        System.out.println("═══════════════════════════════════");
        
        // 1. ARITHMETIC OPERATORS
        System.out.println("\n1️⃣ ARITHMETIC OPERATORS");
        int a = 17, b = 5;
        System.out.println("a = " + a + ", b = " + b);
        System.out.println("a + b = " + (a + b));   // 22
        System.out.println("a - b = " + (a - b));   // 12
        System.out.println("a * b = " + (a * b));   // 85
        System.out.println("a / b = " + (a / b));   // 3 (integer division)
        System.out.println("a % b = " + (a % b));   // 2 (modulus)
        System.out.println("(double)a / b = " + ((double)a / b)); // 3.4 (casting)
        
        // 2. RELATIONAL OPERATORS
        System.out.println("\n2️⃣ RELATIONAL OPERATORS");
        System.out.println("a == b: " + (a == b));  // false
        System.out.println("a != b: " + (a != b));  // true
        System.out.println("a > b:  " + (a > b));   // true
        System.out.println("a <= b: " + (a <= b));  // false
        
        // 3. LOGICAL OPERATORS
        System.out.println("\n3️⃣ LOGICAL OPERATORS");
        boolean x = true, y = false;
        System.out.println("x = " + x + ", y = " + y);
        System.out.println("x && y: " + (x && y));  // false (AND)
        System.out.println("x || y: " + (x || y));  // true  (OR)
        System.out.println("!x:     " + (!x));      // false (NOT)
        
        // 4. BITWISE OPERATORS
        System.out.println("\n4️⃣ BITWISE OPERATORS");
        int m = 5, n = 3;  // 101 & 011
        System.out.println("m = " + m + " (binary: " + Integer.toBinaryString(m) + ")");
        System.out.println("n = " + n + " (binary: " + Integer.toBinaryString(n) + ")");
        System.out.println("m & n:  " + (m & n) + "  (AND)");   // 1
        System.out.println("m | n:  " + (m | n) + "  (OR)");    // 7
        System.out.println("m ^ n:  " + (m ^ n) + "  (XOR)");   // 6
        System.out.println("~m:     " + (~m) + "  (NOT)");      // -6
        System.out.println("m << 1: " + (m << 1) + "  (Left shift)");  // 10
        System.out.println("m >> 1: " + (m >> 1) + "  (Right shift)"); // 2
        
        // 5. ASSIGNMENT OPERATORS
        System.out.println("\n5️⃣ ASSIGNMENT & COMPOUND OPERATORS");
        int val = 10;
        System.out.println("Initial: val = " + val);
        val += 5;  System.out.println("val += 5 →  " + val);  // 15
        val -= 3;  System.out.println("val -= 3 →  " + val);  // 12
        val *= 2;  System.out.println("val *= 2 →  " + val);  // 24
        val /= 4;  System.out.println("val /= 4 →  " + val);  // 6
        val %= 4;  System.out.println("val %= 4 →  " + val);  // 2
        
        // 6. INCREMENT/DECREMENT
        System.out.println("\n6️⃣ INCREMENT/DECREMENT OPERATORS");
        int count = 5;
        System.out.println("count = " + count);
        System.out.println("count++ = " + (count++) + " (postfix, count now " + count + ")");
        System.out.println("++count = " + (++count) + " (prefix, count now " + count + ")");
        
        // 7. TYPE CASTING
        System.out.println("\n7️⃣ TYPE CASTING");
        int bigInt = 1000;
        byte smallByte = (byte) bigInt; // Narrowing cast (potential data loss)
        System.out.println("int " + bigInt + " → byte: " + smallByte);
        
        double pi = 3.14159;
        int truncated = (int) pi; // Truncates decimal
        System.out.println("double " + pi + " → int: " + truncated);
        
        char letter = 'A';
        int ascii = (int) letter; // Widening (implicit, but shown explicit)
        System.out.println("char '" + letter + "' → int ASCII: " + ascii);
        
        // 8. TERNARY OPERATOR
        System.out.println("\n8️⃣ TERNARY OPERATOR");
        int age = 20;
        String status = (age >= 18) ? "Adult" : "Minor";
        System.out.println("Age " + age + " is " + status);
        
        // 9. LOOP DEMONSTRATIONS
        System.out.println("\n9️⃣ LOOP STRUCTURES");
        System.out.print("for loop: ");
        for (int i = 0; i < 5; i++) {
            System.out.print(i + " ");
        }
        
        System.out.print("\nwhile loop: ");
        int w = 0;
        while (w < 5) {
            System.out.print(w + " ");
            w++;
        }
        
        System.out.print("\ndo-while loop: ");
        int d = 0;
        do {
            System.out.print(d + " ");
            d++;
        } while (d < 5);
        
        // 10. BREAK & CONTINUE
        System.out.println("\n\n🔟 BREAK & CONTINUE");
        System.out.print("Break at 5: ");
        for (int i = 1; i <= 10; i++) {
            if (i == 5) break; // Exit loop
            System.out.print(i + " ");
        }
        
        System.out.print("\nSkip evens: ");
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) continue; // Skip iteration
            System.out.print(i + " ");
        }
        
        System.out.println("\n\n✅ Fundamentals demonstration complete!");
    }
}