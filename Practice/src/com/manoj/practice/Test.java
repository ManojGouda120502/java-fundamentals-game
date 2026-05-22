package com.manoj.practice;

import java.io.IOException;
import java.io.*;

public class Test  {
	
	public static void main(String[] args) throws IOException {

		
		PrintWriter pw = new PrintWriter("test.txt");
		
		pw.println("Manoj");
		pw.println("24");
		
		pw.close();
	}

} 
 