package graphicshapes;

public class Rectangle extends Shape {

	private int x, y;
	private int width,height;

	public Rectangle(int x, int y, int width, int height) {
		setX(x);
		setY(y);
		setHeight(height);
		setWidth(width);
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

	@Override
	public double getArea() {
		return width * height;
	}
}
