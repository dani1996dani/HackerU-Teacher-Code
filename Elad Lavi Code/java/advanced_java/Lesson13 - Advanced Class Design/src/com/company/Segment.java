package com.company;

public class Segment {

	private Point p1, p2;
	private double length;
	private boolean lengthIsUpToDate = false;

	public Segment(Point p1, Point p2) {
		setP1(p1);
		setP2(p2);
	}

	public Point getP1() {
		return p1;
	}

	public void setP1(Point p1) {
		lengthIsUpToDate = false;
		this.p1 = p1;
	}

	public Point getP2() {
		return p2;
	}

	public void setP2(Point p2) {
		lengthIsUpToDate = false;
		this.p2 = p2;
	}

	public double length(){
		if(!lengthIsUpToDate)
			calculateLength();
		return length;
	}

	private void calculateLength(){
		double deltaX = p1.getX() - p2.getX();
		double deltaY = p1.getY() - p2.getY();
		this.length = Math.sqrt(deltaX*deltaX + deltaY*deltaY);
		lengthIsUpToDate = true;
	}

	private double A(){
		double deltaX = p1.getX() - p2.getX();
		if(deltaX == 0)
			return Double.MAX_VALUE;
		double deltaY = -(p1.getY() - p2.getY());
		return deltaY / deltaX;
	}
	private double B(){
		return 1;
	}
	private double C(){
		return -A()*p1.getX()-B()*p1.getY();
	}

	public double distanceFrom(Point p){
		if(p1.getX() == p2.getX()){//handles vertical segment
			return Math.abs(p.getX()-p1.getX());
		}
		final double A = A();
		final double B = B();
		final double C = C();
		//A = 12.0;
		return Math.abs((A*p.getX()+B*p.getY()+C)/(Math.sqrt(A*A+B*B)));
	}
}
