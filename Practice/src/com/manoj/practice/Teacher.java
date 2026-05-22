package com.manoj.practice;

abstract class Teacher {
	
	Teacher(){
		System.out.println("Teacher 1 is here");
	}
	
	public void teach2() {
		System.out.println("Teacher 2 is here");
		}
	
	abstract public void teach3();
	
}

class Master extends Teacher{
	
	@Override
	public void teach3() {
		System.out.println("Teacher 3 is here");
	}
}