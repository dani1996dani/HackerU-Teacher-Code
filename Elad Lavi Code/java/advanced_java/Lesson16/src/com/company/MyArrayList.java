package com.company;

public class MyArrayList<T> implements MyList<T> {
	private T[] arr;
	private int size;

	public MyArrayList(){
		arr = (T[])new Object[10];
		size = 0;



	}

	@Override
	public T get(int index){
		if(index < 0 || index >= size)
			throw new IndexOutOfBoundsException();
		return arr[index];
	}

	@Override
	public void set(int index, T value){
		if(index < 0 || index >= size)
			throw new IndexOutOfBoundsException();
		arr[index] = value;
	}

	@Override
	public void add(T value){
		makeRoom();
		arr[size] = value;
		size++;
	}

	private void makeRoom() {
		if(arr.length == size){
			T[] temp = (T[]) new Object[size*2];
			for (int i = 0; i < size; i++) {
				temp[i] = arr[i];
			}
			arr = temp;
		}
	}

	@Override
	public void addAt(int index, T value){
		makeRoom();
		for (int i = size; i > index; i--) {
			arr[i] = arr[i-1];
		}
		arr[index] = value;
		size++;
	}

	@Override
	public void removeAt(int index){
		for (int i = index; i <size; i++) {
			arr[i] = arr[i+1];
		}

		size--;
	}

	@Override
	public int size(){
		return size;
	}

	@Override
	public int indexOf(T value){
		for (int i = 0; i < size; i++) {
			if(arr[i].equals(value))
				return i;
		}
		return -1;
	}

	@Override
	public T[] toArray(){
		T[] temp = (T[]) new Object[size];
		for (int i = 0; i < size; i++) {
			temp[i] = arr[i];
		}
		return temp;
	}
}
