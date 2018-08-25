package com.company;

public class MyArrayList {
	private int[] arr;
	private int size;

	public MyArrayList(){
		arr = new int[10];
		size = 0;
	}


	public int get(int index){
		if(index < 0 || index >= size)
			throw new IndexOutOfBoundsException();
		return arr[index];
	}
	public void set(int index, int value){
		if(index < 0 || index >= size)
			throw new IndexOutOfBoundsException();
		arr[index] = value;
	}
	public void add(int value){
		makeRoom();
		arr[size] = value;
		size++;
	}

	private void makeRoom() {
		if(arr.length == size){
			int[] temp = new int[size*2];
			for (int i = 0; i < size; i++) {
				temp[i] = arr[i];
			}
			arr = temp;
		}
	}

	public void addAt(int index, int value){
		makeRoom();
		for (int i = size; i > index; i--) {
			arr[i] = arr[i-1];
		}
		arr[index] = value;
		size++;
	}

	public void removeAt(int index){
		for (int i = index; i <size; i++) {
			arr[i] = arr[i+1];
		}

		size--;
	}

	public int size(){
		return size;
	}

	public int indexOf(int value){
		for (int i = 0; i < size; i++) {
			if(arr[i] == value)
				return i;
		}
		return -1;
	}

	public int[] toArray(){
		int[] temp = new int[size];
		for (int i = 0; i < size; i++) {
			temp[i] = arr[i];
		}
		return temp;
	}
}
