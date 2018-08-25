package com.company;

public class GraphicalEngine {
	private boolean[][] canvas;
	private Shape[] shapes;
	private int numberOfShapes;
	public GraphicalEngine(){
		canvas = new boolean[30][100];
		shapes = new Shape[100];
	}

	public void addShape(Shape shape){
		if(numberOfShapes >= shapes.length)
			throw new RuntimeException();
		shapes[numberOfShapes++] = shape;
	}

	public void paint(){
		for(Shape shape : shapes){
			shape.paint(canvas);
		}
		renderCanvas();
	}

	private void renderCanvas(){
		for (int i = 0; i < canvas.length; i++) {
			for (int j = 0; j < canvas[i].length; j++) {
				System.out.print(canvas[i][j] ? "*" : " ");
			}
			System.out.println();
		}
		System.out.println();
	}



}
