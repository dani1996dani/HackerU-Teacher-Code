package com.company;

public class Rectangle extends Shape {

	private int x,y;
	private int width,height;

	public Rectangle(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	@Override
	public void paint(boolean[][] canvas) {
		for (int i = 0; i < width; i++) {
			canvas[y][x+i] = true;
			canvas[y+height][x+i] = true;
		}
		for (int i = 0; i <= height; i++) {
			canvas[y+i][x] = true;
			canvas[y+i][x+width]= true;
		}
	}


	public int getX() {
		return x;
	}

	public void setX(int x) {
		if(x < 0)
			return;
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		if(y < 0)
			return;
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		if(width < 0)
			return;
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		if(height < 0)
			return;
		this.height = height;
	}
}
