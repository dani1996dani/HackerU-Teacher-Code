package com.company;

public class Shape {

	private double pricePerUnit;

	public double getPricePerUnit() {
		return pricePerUnit;
	}

	public void setPricePerUnit(double pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}

	public double getTotalPrice(){
		return getArea() * pricePerUnit;
	}

	public double getArea(){
		return 0.0;
	}

	public void paint(boolean[][] canvas){

	}
}
