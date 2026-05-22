package com.manoj.practice;

class Upi implements Payment, Cardpayment{

	
	public void pay() {
		System.out.println("This is Upi payments");
	}
	
	public void Cardpay() {
		System.out.println("Card Payment is made");
	}
}
