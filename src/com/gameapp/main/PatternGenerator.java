package com.gameapp.main;

public class PatternGenerator {
    private InputValidator validator;
    
    public PatternGenerator(InputValidator validator) {
        this.validator = validator;
    }
    
    public void run() {
        boolean running = true;
        
        while (running) {
            System.out.println("\n🎨 PATTERN GENERATOR");
            System.out.println("─────────────────────");
            System.out.println("1. Number Pyramid");
            System.out.println("2. Star Diamond");
            System.out.println("3. Character Triangle (ASCII casting)");
            System.out.println("4. Binary Pattern (bitwise operators)");
            System.out.println("5. Multiplication Table");
            System.out.println("6. Back to Main Menu");
            
            int choice = validator.getInt("Select pattern: ", 1, 6);
            
            if (choice == 6) {
                running = false;
                continue; // Skip to next iteration (will exit)
            }
            
            int size = validator.getInt("Enter size (1-20): ", 1, 20);
            
            // Switch with pattern selection
            switch (choice) {
                case 1 -> numberPyramid(size);
                case 2 -> starDiamond(size);
                case 3 -> charTriangle(size); // Demonstrates casting
                case 4 -> binaryPattern(size); // Demonstrates bitwise
                case 5 -> multiplicationTable(size);
            }
            
            System.out.println(); // Spacing
        }
    }
    
    /**
     * Number Pyramid
     * Demonstrates: nested for loops, arithmetic progression
     */
    private void numberPyramid(int size) {
        System.out.println("\n📐 NUMBER PYRAMID");
        System.out.println("──────────────────");
        
        // Outer loop for rows
        for (int i = 1; i <= size; i++) {
            // Print spaces (decreasing)
            for (int j = 1; j <= size - i; j++) {
                System.out.print("  ");
            }
            
            // Print increasing numbers
            for (int k = 1; k <= i; k++) {
                System.out.print(k + " ");
            }
            
            // Print decreasing numbers (demonstrates: arithmetic)
            for (int l = i - 1; l >= 1; l--) {
                System.out.print(l + " ");
            }
            
            System.out.println(); // New line
        }
    }
    
    /**
     * Star Diamond
     * Demonstrates: nested loops, symmetry, ternary logic
     */
    private void starDiamond(int size) {
        System.out.println("\n💎 STAR DIAMOND");
        System.out.println("────────────────");
        
        int rows = size * 2 - 1;
        
        for (int i = 1; i <= rows; i++) {
            // Calculate stars for this row using ternary
            int stars = (i <= size) ? (2 * i - 1) : (2 * (rows - i + 1) - 1);
            int spaces = (i <= size) ? (size - i) : (i - size);
            
            // Print spaces
            for (int j = 1; j <= spaces; j++) {
                System.out.print(" ");
            }
            
            // Print stars
            for (int k = 1; k <= stars; k++) {
                System.out.print("* ");
            }
            
            System.out.println();
        }
    }
    
    /**
     * Character Triangle
     * Demonstrates: int to char casting, ASCII arithmetic, type promotion
     */
    private void charTriangle(int size) {
        System.out.println("\n🔤 CHARACTER TRIANGLE");
        System.out.println("─────────────────────");
        System.out.println("Type: 1=Uppercase, 2=Lowercase, 3=Digits, 4=Symbols");
        
        int type = validator.getInt("Choice: ", 1, 4);
        char startChar;
        
        // Determine starting character using ASCII values
        switch (type) {
            case 1 -> startChar = 'A'; // ASCII 65
            case 2 -> startChar = 'a'; // ASCII 97
            case 3 -> startChar = '0'; // ASCII 48
            case 4 -> startChar = '!'; // ASCII 33
            default -> startChar = 'A';
        }
        
        int startAscii = (int) startChar; // Explicit casting: char → int
        
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= i; j++) {
                // Calculate character with wrap-around using modulus
                int charOffset = (j - 1) % 26; // Wrap after 26 chars
                char currentChar = (char) (startAscii + charOffset); // int → char casting
                
                System.out.print(currentChar + " ");
            }
            System.out.println();
        }
        
        // Demonstrate type promotion
        System.out.println("\n📊 ASCII Values:");
        System.out.println("Start char '" + startChar + "' = ASCII " + startAscii);
        System.out.println("End char would be ASCII " + (startAscii + size - 1));
    }
    
    /**
     * Binary Pattern
     * Demonstrates: bitwise operators (&, |, ^, <<, >>)
     */
    private void binaryPattern(int size) {
        System.out.println("\n🔢 BINARY PATTERN (Bitwise Ops)");
        System.out.println("───────────────────────────────");
        
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                // Use bitwise AND to create checkerboard pattern
                // If both row and column have same least significant bit
                boolean sameParity = ((i & 1) == (j & 1)); // Bitwise AND & comparison
                
                // Use bitwise OR to combine conditions
                boolean isBorder = (i == 0) | (i == size - 1) | (j == 0) | (j == size - 1);
                
                // Use bitwise XOR for alternating center
                boolean xorPattern = (i ^ j) < (size / 2); // Bitwise XOR
                
                // Combine with logical AND (short-circuit) and bitwise
                char symbol = (isBorder && sameParity) ? '#' : 
                             (xorPattern ? '○' : '·');
                
                System.out.print(symbol + " ");
            }
            System.out.println();
        }
        
        // Demonstrate bit shifting
        System.out.println("\n📊 Bit Shift Demo:");
        int num = 1;
        System.out.println("1 << 0 = " + (num << 0));  // 1
        System.out.println("1 << 1 = " + (num << 1));  // 2
        System.out.println("1 << 2 = " + (num << 2));  // 4
        System.out.println("1 << 3 = " + (num << 3));  // 8
        System.out.println("8 >> 1 = " + (8 >> 1));    // 4 (right shift)
    }
    
    /**
     * Multiplication Table
     * Demonstrates: nested loops, formatted output, arithmetic
     */
    private void multiplicationTable(int size) {
        System.out.println("\n✖️ MULTIPLICATION TABLE");
        System.out.println("────────────────────────");
        
        // Header row
        System.out.print("    |");
        for (int i = 1; i <= size; i++) {
            System.out.printf("%4d", i); // Formatted width
        }
        System.out.println();
        
        // Separator
        System.out.print("----+");
        for (int i = 1; i <= size; i++) {
            System.out.print("----");
        }
        System.out.println();
        
        // Table body
        for (int i = 1; i <= size; i++) {
            System.out.printf("%3d |", i); // Row header
            
            for (int j = 1; j <= size; j++) {
                int product = i * j; // Multiplication operator
                
                // Highlight squares (demonstrates: equality check)
                if (i == j) {
                    System.out.printf("[%2d]", product); // Square numbers
                } else {
                    System.out.printf("%4d", product);
                }
            }
            System.out.println();
        }
        
        // Sum of diagonal (demonstrates: compound operators in loop)
        int diagonalSum = 0;
        for (int i = 1; i <= size; i++) {
            diagonalSum += i * i; // Compound addition-assignment
        }
        System.out.println("\n📊 Sum of diagonal (squares): " + diagonalSum);
    }
}