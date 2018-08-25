package com.company;

public class Dog {
	String name;
	String breed;
	float age;

	public Dog(){
		name = "";
		breed = "no breed";
		age = 10f;
	}


	void bark(){
		System.out.println("waf waf " + name);
	}

}
