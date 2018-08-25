package com.company;

public class Circle implements Comparable {
	private int x, y;
	private int radius;

	public Circle(int x, int y, int radius) {
		this.x = x;
		this.y = y;
		this.radius = radius;
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

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	@Override
	public boolean compare(Object other) {
		if(other == null)
		throw new RuntimeException("is null");
		if(!(other instanceof Circle))
			throw new RuntimeException("not a circle");
		Circle otherCircle = (Circle)other;
		return this.radius > otherCircle.radius;
	}
}
