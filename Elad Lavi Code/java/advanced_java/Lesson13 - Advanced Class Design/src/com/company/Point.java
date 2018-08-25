package com.company;

public class Point {

	private int x, y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}


	@Override
	public String toString() {
		return "(" + x + "," + y + ")";
	}

	public static void sayHello(){
		//this method should be static because it doesn't access the object fields!
		System.out.println("hello");
	}
}
