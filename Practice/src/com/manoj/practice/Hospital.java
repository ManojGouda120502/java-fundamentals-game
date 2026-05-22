package com.manoj.practice;

abstract class Hospital {

	abstract public void emergency();
	
	abstract public void appoitment();
	
	abstract public void admit();
	
	abstract public void billing();
}

class MyHospital extends Hospital{
	
	public void emergency() {
		System.out.println("This is an Emergency Department");
	}
	
	public void appoitment() {
		System.out.println("This is an Appoitment Department");
	}
	
	public void admit() {
		System.out.println("This is  Admin Department");
	}
	
	public void billing() {
		System.out.println("This is a Billing Department");
	}
}