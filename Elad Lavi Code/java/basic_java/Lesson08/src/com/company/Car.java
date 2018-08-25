package com.company;

public class Car {
	String model,make;
	String licensePlate;
	int color;
	int killometers;
	boolean hasAirBags;


	void honk(){
		System.out.println("beep beep");
	}

	void drive(boolean forward){
		System.out.println("hmmmm hmmmm....");
		killometers++;
	}
}
