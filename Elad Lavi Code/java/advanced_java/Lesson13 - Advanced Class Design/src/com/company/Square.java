package com.company;

public final class Square extends Rectangle {

	public Square(int x, int y, int side) {
		super(x, y, side, side);
	}

	@Override
	public void setWidth(int width) {
		setSide(width);
	}

	@Override
	public void setHeight(int height) {
		setSide(height);
	}

	public void setSide(int side){
		super.setHeight(side);
		super.setWidth(side);
	}
}
