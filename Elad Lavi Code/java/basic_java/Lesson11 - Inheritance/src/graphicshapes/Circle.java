package graphicshapes;

public class Circle extends Shape {

	private int x,y,radius;

	public Circle(int x, int y, int radius) {
		setX(x);
		setY(y);
		setRadius(radius);
	}

	public Circle(){
		this(20,20,10);
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
		if(radius < 0)
			return;
		this.radius = radius;
	}

	@Override
	public double getArea() {
		return Math.PI * radius * radius;
	}
}
