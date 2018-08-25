package com.company;

public class MaxHeap {

	Comparable[] arr;
	int size;

	public MaxHeap(){
		arr = new Comparable[100];
	}


	//O(n)
	public MaxHeap(Comparable[] keys){
		arr = keys;
		size = arr.length;
		for (int i = arr.length / 2 - 1; i >= 0; i--) {
			heapify(i);
		}
	}

	private int left(int i){
		return 2*i+1;
	}

	private int right(int i){
		return 2*i+2;
	}

	private int parent(int i){
		return (i-1)/2;
	}

	private void heapify(int i){
		int l = left(i);
		int r = right(i);
		int largest = i;
		if(l < size  && arr[l].compare(arr[largest]))
			largest = l;
		if(r < size && arr[r].compare(arr[largest]))
			largest = r;
		if(largest != i){
			Comparable temp = arr[i];
			arr[i] = arr[largest];
			arr[largest] = temp;
			heapify(largest);
		}
	}

	public Comparable getMax(){
		if(size == 0)
			throw new RuntimeException();
		return arr[0];
	}

	public void add(Comparable key){
		//TODO: make room if no room
		arr[size] = key;
		int i = size;
		size++;
		int p;
		//assignment within a boolean expression
		while (i != 0 && arr[i].compare(arr[p=parent(i)])){
			Comparable temp = arr[p];
			arr[p] = arr[i];
			arr[i] = temp;
			i = p;
		}
	}

	private void increasePriority(int i, Comparable increasedPriority){
		arr[i] = increasedPriority;
		int p;
		while (i != 0 && arr[i].compare(arr[p=parent(i)])){
			Comparable temp = arr[p];
			arr[p] = arr[i];
			arr[i] = temp;
			i = p;
		}

	}

	public Comparable extractMax(){
		if(size == 0)
			throw new RuntimeException();
		if(size == 1){
			size--;
			return arr[0];
		}
		Comparable result = arr[0];
		arr[0] = arr[size-1];
		size--;
		heapify(0);
		return result;

	}

	private Comparable maxValue;
	public void setMaxValue(Comparable maxValue){
		this.maxValue = maxValue;
	}

	private void removeAtIndex(int index){
		if(maxValue == null)
			throw new RuntimeException("must set max value first!!!");
		increasePriority(index, maxValue);
		extractMax();
	}

	public boolean isEmpty(){
		return size == 0;
	}
}
