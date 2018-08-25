package com.company;

public class Circle extends Shape {

	private Point center;
	private int radius;


	public Circle(Point center, int radius) {
		setCenter(center);
		setRadius(radius);
	}
	public Circle(Circle other){
		this(new Point(other.center), other.radius);

	}

	@Override
	public void paint(boolean[][] canvas) {
		super.paint(canvas);
	}

	public Point getCenter() {
		return new Point(center);
	}

	public void setCenter(Point center) {
		if(center.getX() < 0 || center.getY() < 0)
			return;
		this.center = new Point(center);
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		if(radius < 0)
			return;
		this.radius = radius;
	}

	@Override
	public double getArea() {
		return Math.PI * radius * radius;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null)
			return false;
		if(this == obj)
			return true;
		if(obj instanceof Circle){
			Circle other = (Circle)obj;
			return this.radius == other.radius && this.center.equals(other.center);
		}
		return false;
	}

	@Override
	public String toString() {
		return "center = " + center +" and radois = " + radius;
	}
}
