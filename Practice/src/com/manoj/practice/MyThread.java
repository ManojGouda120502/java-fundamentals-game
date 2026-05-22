package com.manoj.practice;

public class MyThread extends Thread{

	public void run() {
		
		int count = 1;
		while(true) {
			System.out.println(count++);
			}
	}
}
