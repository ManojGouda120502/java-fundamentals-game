package com.gameapp.main;

import java.util.Scanner;

public class InputValidator {

	private Scanner scanner;
	
	public InputValidator(Scanner scanner) {
		this.scanner = scanner;
	}
	
	public int getInt(String prompt) {
		int value = 0;
		boolean valid = false;
		
		do {
			System.out.println(prompt);
			try {
				String input = scanner.nextLine();
				value = Integer.parseInt(input);
				
				valid = true;
			}catch(NumberFormatException e) {
				System.out.println(" Invalid input! please enter a valid number.");
			}
		}while(!valid);
		
		return value;
	}
	
	public int getInt(String prompt, int min, int max) {
		int value;
		do {
			value = getInt(prompt);
			if(value < min || value > max) {
				System.out.println("Please enter a number between " + min + " and " + max);
			}
		}while(value < min || value > max);
		
		return value;
	
	}
	
	public boolean confirm(String prompt) {
		System.out.println(prompt + " (y/n): ");
		String input = 
				scanner.nextLine().trim().toLowerCase();
		return input.length() > 0 && (input.charAt(0) == 'y');
	}
}
