package com.company;

public class Dog {

	private static int dogCount;
	public static final double E = 2.718;
	public static final String SERVER_ADDRESS = "127.3.6.4";

	static {
		dogCount = 0;
	}

	public Dog(){
		dogCount++;
	}

	public static Dog getDog(){
		return new Dog();
	}

	public static int getDogCount(){
		return dogCount;
	}

	public void myFunc(){
		System.out.println(E);
	}
}
