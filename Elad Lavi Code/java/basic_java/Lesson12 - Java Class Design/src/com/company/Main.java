package com.company;

public class Main {

    public static void main(String[] args) {



    }

	static void example1() {
		GraphicalEngine engine = new GraphicalEngine();
		engine.addShape(new Rectangle(3,4,12,12));
		engine.addShape(new Rectangle(6,9,12,8));
		engine.paint();
	}

	static void example2(){
    	Point p = new Point(4,5);
		System.out.println(p);
	}

	static void example3(){
		Point p1 = new Point(4,3);
		Circle circle = new Circle(p1,20);
		Point p2 = new Point(4,-3);
		circle.setCenter(p2);
		Point p3 = circle.getCenter();
		p3.setY(-3);
		p3.setY(10);
		p1.setY(-3);
		System.out.println(circle);
	}

	static void example4(){
		Dog d = new Dog();
		Aniaml a = d; //upcasting
		a.makeSound();
		//a = new Cat();
		if(a instanceof Dog) {
			Dog d2 = (Dog) a; //downcasting
			d2.bark();
		}

		//Cat cat = (Cat)d;


	}

	public void example5(){
		Shape shape = new Circle(new Point(4,3), 20);
		shape.setPricePerUnit(12.34);
		System.out.println(shape.getTotalPrice());
	}


	static void example6(){
		Point p1 = new Point(4,3);
		Point p2 = new Point(4,3);
		System.out.println(p1 == p2);
		System.out.println(p1.equals(p2));
	}


}
class Aniaml{
	void makeSound(){
		System.out.println("making some noise...");
	}
}

class Dog extends Aniaml{
	void bark(){
		System.out.println("waf waf..");
	}

	@Override
	void makeSound() {
		bark();
	}
}
class Cat extends Aniaml{
	void growl(){
		System.out.println("grrrrrr...");
	}
}

class Poodle extends Dog{
	@Override
	void bark() {
		System.out.println("bfff bffff..");
	}
}