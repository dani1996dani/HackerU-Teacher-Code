package com.company;

public class Main {

    public static void main(String[] args) {
	    int[] arr = {65,3,47,54,23};
	    MaxHeap queue = new MaxHeap(arr);
	    for (int i = arr.length-1; i >= 0; i--) {
		    arr[i] = queue.extractMax();
	    }
	    for (int i = 0; i < arr.length; i++) {
		    System.out.print(arr[i] + " ");
	    }
    }
}
