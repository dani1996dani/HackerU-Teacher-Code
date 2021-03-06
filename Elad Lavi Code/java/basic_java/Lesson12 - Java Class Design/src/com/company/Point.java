package com.company;

public class Point {
	private int x, y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Point(Point other){
		this.x = other.x;
		this.y = other.y;
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
		return "(" + commaSeparatedComponents() + ")";
	}

	protected String commaSeparatedComponents(){
		return x + "," + y;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null)
			return false;
		if(this == obj)
			return true;
		if(obj instanceof Point){
			Point other = (Point)obj;
			return this.x == other.x && this.y == other.y;
		}
		return false;
	}
}
