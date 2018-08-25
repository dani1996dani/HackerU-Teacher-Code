package com.company;

public class BadPriorityQueue {
	//private int[] arr;
	//private int size;
	private MyArrayList myArrayList;


	public BadPriorityQueue(){
		//arr = new int[10];
		//size = 0;
		myArrayList = new MyArrayList();
	}




	public void add(int value){
		myArrayList.add(value);
	}



	public int size(){
		return myArrayList.size();
	}

	private int indexOfMax(){
		if(myArrayList.size() == 0)
			throw new RuntimeException("attemp to get the max of empty set");

		int max = myArrayList.get(0);
		int maxIndex = 0;
		for (int i = 0; i < myArrayList.size(); i++) {
			if(myArrayList.get(i) > max) {
				max = myArrayList.get(i);
				maxIndex = i;
			}
		}
		return maxIndex;
	}

	public int getMax(){
		return myArrayList.get(indexOfMax());
	}

	public int extractMax(){
		int indexOfMax = indexOfMax();
		int max = myArrayList.get(indexOfMax);
		myArrayList.removeAt(indexOfMax);
		return max;
	}
}
