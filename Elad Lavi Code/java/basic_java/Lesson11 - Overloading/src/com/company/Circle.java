package com.company;

public class Circle {

	private int x,y,radius;

	public Circle(int x, int y){
		this(x,y,10);
	}
	public Circle(int x, int y, int radius){
		this.x = x;
		this.y = y;
		this.radius = radius;
	}

	public Circle(){
		this(20,20);
	}

	public void fillColor(int red, int green, int blue){
	}

	public void fillColor(float hue, float saturation, float brightness){

	}

	@Override
	public String toString() {
		return "center = (" + x + "," + y + ") and radius = " + radius;
	}
}
