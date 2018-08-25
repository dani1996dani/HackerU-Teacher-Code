package com.company;

import graphicshapes.Circle;
import graphicshapes.Rectangle;
import graphicshapes.Shape;
import graphicshapes.Square;

public class Main {

	public static void main(String[] args){
		RationalNumber num1 = new RationalNumber(-3,-4);
		RationalNumber num2 = new RationalNumber(-5,-6);
		System.out.println(num2.compareTo(num1));
	}


	public static Shape maxShape(Shape[] shapes){
		if(shapes == null || shapes.length == 0)
			throw new RuntimeException("give me some shapes and then I'll tell which is max");
		Shape maxShape = shapes[0];
		double maxArea = maxShape.getArea();
		double temp;
		for(Shape barak : shapes){
			if((temp = barak.getArea()) > maxArea){
				maxShape = barak;
				maxArea = temp;
			}
		}
		return maxShape;
	}

	public static double sum(Number[] nums){
		double sum = 0;
		for(Number num : nums){
			sum += num.doubleValue();
		}
		return sum;
	}



	public static void feedAniaml(Animal a){

	}
}
class Animal{
	void breath(){
		System.out.println("I am breathing...");
	}
}
class Dog extends Animal{

	@Override
	void breath() {
		System.out.println("hhhhh.... hhhh.....");
	}

	void bark(){
		System.out.println("waf waf...");
	}
}
class Cat extends Animal{
	@Override
	void breath() {
		System.out.println("brrrrr....");
	}
}

class Poodle extends Dog{

}
class Tomato{

}