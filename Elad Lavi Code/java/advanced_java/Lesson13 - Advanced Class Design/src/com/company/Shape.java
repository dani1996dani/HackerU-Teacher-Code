package com.company;

public abstract class Shape {

	private double pricePerUnit;
	protected Color color;

	public abstract double area();

	public abstract double perimeter();

	public final double totalPrice(){
		return area()*pricePerUnit;
	}

	public static class Color{
		private int red,green,blue;

		public Color(int red, int green, int blue) {
			this.red = red;
			this.green = green;
			this.blue = blue;
		}

		public int getRed() {
			return red;
		}

		public void setRed(int red) {
			this.red = red;
		}

		public int getGreen() {
			return green;
		}

		public void setGreen(int green) {
			this.green = green;
		}

		public int getBlue() {
			return blue;
		}

		public void setBlue(int blue) {
			this.blue = blue;
		}
	}
}
