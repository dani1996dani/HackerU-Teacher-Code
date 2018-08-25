package graphicshapes;

public class Circle extends Shape {
	private int x,y,radius;

	public Circle(){
		x = 20;
		y = 20;
		radius = 10;
	}

	public double area(){
		return Math.PI * radius * radius;
	}

	@Override
	public String toString() {
		return "center = (" + x + "," + y + ") and radius = " + radius + " and color = " + color;
	}
}
