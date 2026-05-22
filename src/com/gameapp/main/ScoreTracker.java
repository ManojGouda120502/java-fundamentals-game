package com.gameapp.main;

public class ScoreTracker {
    private int[] scores;
    private int count;
    private static final int MAX_SCORES = 10;
    
    public ScoreTracker() {
        // Array initialization (demonstrates: new keyword, array syntax)
        scores = new int[MAX_SCORES];
        count = 0;
    }
    
    // Add score with overflow protection (demonstrates: arithmetic, casting)
    public void addScore(int score) {
        if (count < MAX_SCORES) {
            scores[count++] = score;
            System.out.println("⭐ Score saved! (" + count + "/" + MAX_SCORES + " slots used)");
        } else {
            // Shift array left (demonstrates: array manipulation, for loop)
            for (int i = 0; i < MAX_SCORES - 1; i++) {
                scores[i] = scores[i + 1]; // Assignment operator
            }
            scores[MAX_SCORES - 1] = score;
            System.out.println("⭐ Score saved! (Oldest score removed)");
        }
    }
    
    // Calculate average (demonstrates: casting int to double, division)
    public double getAverage() {
        if (count == 0) return 0.0;
        
        int sum = 0;
        for (int i = 0; i < count; i++) {
            sum += scores[i]; // Compound assignment operator (+=)
        }
        // Explicit casting: int → double to get decimal result
        return (double) sum / count;
    }
    
    // Display all scores (demonstrates: enhanced for loop, String.format)
    public void displayScores() {
        if (count == 0) {
            System.out.println("📊 No scores recorded yet.");
            return;
        }
        
        System.out.println("\n╔════════════════════════════════════╗");
        System.out.println("║         🏆 HIGH SCORES 🏆          ║");
        System.out.println("╠════════════════════════════════════╣");
        
        // Find max for percentage calculation (demonstrates: Math.max)
        int maxScore = scores[0];
        for (int i = 1; i < count; i++) {
            maxScore = Math.max(maxScore, scores[i]);
        }
        
        // Display each score with percentage bar
        for (int i = 0; i < count; i++) {
            int percentage = (int) ((scores[i] * 100.0) / maxScore); // Mixed casting
            String bar = "#".repeat(percentage / 5); // String repeat operator
            
            System.out.printf("║ %2d. %3d pts [%s%s] %3d%% ║%n", 
                i + 1, scores[i], bar, " ".repeat(20 - bar.length()), percentage);
        }
        
        System.out.printf("║ Average: %.2f points            ║%n", getAverage());
        System.out.println("╚════════════════════════════════════╝");
    }
    
    public int getCount() {
        return count;
    }
}