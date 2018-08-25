package com.company;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class Main {



    public static void main(String[] args) {

		MyLinkedList<Integer> myList = new MyLinkedList<>();
		myList.add(5);
		myList.add(8);
		myList.add(2);
		myList.add(6);
		myList.add(89);
		myList.add(-30);
		myList.add(15);
		int sum = 0;

		/*
		for (int i = 0; i < myList.size(); i++) {
			sum += myList.get(i);
		}
		*/
		for(int x : myList)
			sum += x;
		System.out.println("sum = " + sum);

		ArrayList<Integer> arrayList;
		LinkedList<Integer> linkedList;
		HashSet<Integer> hashSet;



    }

    public static int handleIntegersKayak(Kayak<Integer, Integer> kayak){
    	return kayak.getFront() * kayak.getRear();
	}

	private static void example1() {
		MyList<Integer> myList = new MyLinkedList<Integer>();


		myList.add(5);
		myList.add(8);
		myList.add(2);
		myList.add(6);
		myList.add(89);
		myList.add(-30);
		myList.add(15);
		//myList.add("some string");

		int sum = 0;
		/*
		for (int i = 0; i < myList.size(); i++) {
			//instance of
			sum += (Integer)myList.get(i);
		}
		*/
		for (int i = 0; i < myList.size(); i++) {
			sum += myList.get(i);
		}
		System.out.println("the sum of all elements is " + sum);


		//myList.add("what's up man?");
		System.out.println("the list has " + myList.size() + " elements");
		System.out.println("the position of 8 in the list is: " + myList.indexOf(8));
		//Object seventhElement = myList.get(7);
		Object sixthElement = myList.get(6);
		System.out.println("sixth element: " + sixthElement);
		//System.out.println("seventh element: " + seventhElement);
	}


}
