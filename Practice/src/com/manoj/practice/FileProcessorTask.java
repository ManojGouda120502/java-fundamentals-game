package com.manoj.practice;

import java.nio.file.*;
import java.io.*;


public class FileProcessorTask implements Runnable{
	
	private final Path filePath;
	
	public FileProcessorTask(Path filePath) {
		this.filePath = filePath;
	}
	
	public void run() {
		
		try {
			String content = Files.readString(filePath);
			int wordCount = content.split("\\s+").length;
			int lineCount = content.split("\n").length;
			
			System.out.println(
					Thread.currentThread().getName() + 
					" | " + filePath.getFileName() + 
					" | " + wordCount +
					" | " + lineCount
					);
		} catch(IOException e) {
			System.err.println("Failed: " + filePath + " -> " + e.getMessage());
		}
	}
}
