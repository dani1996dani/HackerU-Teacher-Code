package com.company;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
	    int[] arr = new int[10];
	    Random random = new Random(System.currentTimeMillis());
	    for (int i = 0; i < arr.length; i++) {
		    arr[i] = random.nextInt(100);
	    }
	    printArray(arr);
	    System.out.println(partition(arr,0,arr.length-1));
	    printArray(arr);
    }


	/**
	 *
	 * @param arr
	 */
    static void printArray(int[] arr){
	    if(arr == null){
		    System.out.println("null");
		    return;
	    }
    	System.out.print("{");
	    for (int i = 0; i < arr.length - 1; i++) {
		    System.out.print(arr[i]+",");
	    }
	    if(arr.length > 0)
		    System.out.print(arr[arr.length-1]);
	    System.out.println("}");
    }

    static void printJaggedArray(int[][] jaggedArray){
    	if(jaggedArray == null){
		    System.out.println("null");
		    return;
	    }
	    System.out.println("{");
	    for (int i = 0; i < jaggedArray.length; i++) {
		    printArray(jaggedArray[i]);
	    }
	    System.out.println("}");
    }

    static int largestDigit(int num){
    	int result = 0;
    	while (num != 0) {
		    int lastDigit = num % 10;
		    if(lastDigit > result)
		    	result = lastDigit;
		    num /= 10;
	    }
	    return result;
    }

	static int sumOfDigits(int num){
		int result = 0;
		while (num != 0) {
			int lastDigit = num % 10;
			result += lastDigit;
			num /= 10;
		}
		return result;
	}

	static int reverseDigits(int num){
		int result = 0;
		while (num != 0) {
			int lastDigit = num % 10;
			result = result*10 + lastDigit;
			num /= 10;
		}
		return result;
	}

	static boolean matrixContainsVer1(int[][] arr, int x){
		if(arr == null)
			return false;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if(arr[i][j] == x)
					return true;
			}
		}
		return false;
	}

	static boolean matrixContainsVer2(int[][] arr, int x){
		if(arr == null)
			return false;
		for (int i = 0; i < arr.length; i++) {
			if(binarySearch(arr[i],x) != -1)
				return true;
		}
		return false;
	}


	/**
	 * searches an element in a column+row sorted matrix
	 * @param arr the matrix to search in
	 * @param x the number to be search for in arr
	 * @return return true iff x exists in arr
	 */
	static boolean matrixContainsVer3(int[][] arr, int x){
		int n = arr.length;
		int i=0, j=n-1;
		while (i<n && j>=0){ //as long as we are inside the matrix
			if(arr[i][j] == x)
				return true;
			if(arr[i][j] > x)
				j--;
			else
				i++;
		}
		return false;
	}

	static int binarySearch(int[] arr, int x){
		//TODO: check if arr is null
		int l = 0;
		int r = arr.length -1;
		while (l<=r){
			int m = l+(r-l)/2;
			if(arr[m] == x)
				return m;
			if(arr[m] > x)
				r = m-1;
			else l = m+1;
		}
		return -1;
	}

	static void printRectangle(int x, int y, int width, int height, boolean[][] canvas){
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				//f is true if we're on the frame of the rectangle
				boolean f = i==0 || j==0 || i==height-1 || j==width-1;
				if(f)
					canvas[y+i][x+j] = true;
			}
		}
	}


	static void render(boolean[][] canvas){
		for (int i = 0; i < canvas.length; i++) {
			for (int j = 0; j < canvas[i].length; j++) {
				System.out.print(canvas[i][j] ? "*" : " ");
			}
			System.out.println();
		}
	}


	static int randomPartition(int[] arr, int low, int high){
		Random random = new Random(System.currentTimeMillis());
		int r = low + random.nextInt(high-low+1);
		int temp = arr[high];
		arr[high] = arr[r];
		arr[r] = temp;
		return partition(arr,low,high);
	}


	static int partition(int[] arr, int low, int high){
		int pivot = arr[high];
		int i = low-1;
		for (int j = low; j < high; j++) {
			if(arr[j] <= pivot){
				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		int temp = arr[i+1];
		arr[i+1] = pivot;
		arr[high] = temp;
		return i+1;
	}

	static void quickSort(int[] arr, int low, int high){
		if(low >= high)
			return;
		int pi = partition(arr,low,high);
		quickSort(arr,low,pi-1);
		quickSort(arr,pi+1,high);
	}




}
