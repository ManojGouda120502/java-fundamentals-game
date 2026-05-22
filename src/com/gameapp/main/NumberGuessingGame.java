package com.gameapp.main;

import java.util.Random;

public class NumberGuessingGame {

	private Random random;
	private ScoreTracker scoreTracker;
	private InputValidator validator;
	
	private static final int EASY_MAX = 50;
	private static final int MEDIUM_MAX = 100;
	private static final int HARD_MAX = 200;
	
	public NumberGuessingGame(ScoreTracker scoreTracker, InputValidator validator) {
		this.random = new Random();
		this.scoreTracker = scoreTracker;
		this.validator = validator;
	  }

	public void play() {
		System.out.println("\n NUMBER GUESSING GAME");
		System.out.println("================================================");
		
		System.out.println("Select Difficulty");
		System.out.println("1. Easy (1-5-, 10 attempts)");
		System.out.println("2. Medium (1-100, 7 attempts");
		System.out.println("3. Hard (1-200, 5 attempts)");
		
		int choice = validator.getInt("Choice: ", 1, 3);
		int maxNumber, maxAttempts;
		
		switch(choice) {
		case 1:
			maxNumber = EASY_MAX;
			maxAttempts = 10;
			break;
			
		case 2:
			maxNumber  = MEDIUM_MAX;
			maxAttempts = 7;
			break;
			
		case 3:
			maxNumber = HARD_MAX;
			maxAttempts = 5;
			break;
			default:
				maxNumber = MEDIUM_MAX; 
				maxAttempts = 7;
		}
		
		int target = random.nextInt(maxNumber) + 1;
		int attempts = 0;
		boolean won = false;
		int guess = 0;
		
		System.out.println("\n I'M THINKING OF A NUMBER BETWEEN 1 AND " + maxNumber);
		System.out.println("you have " + maxAttempts + "attempts.good luck!\n");
		
		while(attempts < maxAttempts) {
			int remaining = maxAttempts - attempts;
			System.out.println("Attempts remaining: " +remaining);
			guess = validator.getInt("Entere your guess: ", 1, maxNumber);
			attempts++;
			
			if(guess == target) {
				System.out.println(" CORRECT! YOU GUSSED IT IN " + attempts + "attempts!");
				won = true;
				break;
			}else if(guess < target) {
				System.out.println(" TOO LOW! TRY HIGHER.");
				
			}else {
				System.out.println("TOO HIGH TRY LOWER.");
			}
			
			if(attempts >= 3 && attempts < maxAttempts) {
				int diff = Math.abs(guess - target);
				System.out.println(" HINT: YOU'RE " + diff + "numbers away!");
				
				if(diff % 2 == 0) {
					System.out.println(" (TARGET IS AN EVEN DIISTANCE AWAY)");
				}else {
					System.out.println(" (TARGET IS AN ODD DISTANCE AWAY)");
				}
			}
			
			System.out.println();
		}
		
		if(!won) {
			System.out.println(" GAME OVER! THE NUMBER WAS: " + target);
		}
		
		int score = calculateScore(won, attempts, maxAttempts, maxNumber, guess, target);
		System.out.println(" YOUR SCORE: " + score + " POINTS ");
		
		scoreTracker.addScore(score);
		
		if(validator.confirm("PLAY AGAIN?")) {
			play();
		}
	}
	
	private int calculateScore(boolean won, int attempts, int maxAttempts, 
			int maxNumber, int lastGuess, int target) {
		if(!won) {
			return 0;
		}
		
		int baseScore = maxNumber;
		
		int attemptBonus = (maxAttempts - attempts) * 50;
		
		double accuracy = 1.0 - ((double) attempts / maxAttempts);
		int accuracyBonus = (int) (accuracy * 100);
		int proximity = Math.abs(lastGuess - target);
		int proximityBonus = (proximity == 0) ? 100 : 0;
		int total = baseScore + attemptBonus + accuracyBonus + proximityBonus;
		
		int multiplier = switch (maxNumber) {
		case 5 -> 1;
		case 100 -> 2;
		case 200 -> 3;
		default -> 1;
		};
		
		return total * multiplier;
	}
}
