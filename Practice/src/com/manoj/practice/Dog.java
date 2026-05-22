package com.manoj.practice;

public class Dog <T, U> {

	T id;
	
	U price;
	
	Dog(T id, U price){
		
		this.id = id;
		this.price = price;
	}
	
	public T getID() {
		
		return this.id;
	}
	
	public U getPrice() {
		
		return this.price;
	}
}
