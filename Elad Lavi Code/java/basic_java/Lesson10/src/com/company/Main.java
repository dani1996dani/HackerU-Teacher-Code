package com.company;

public class Main {


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


    //if k is 1 this is the minimum, if k is 2 we're looking for the second smallest element
    static int kSmallest(int[] arr, int l, int r, int k){
        if(k<=0 || k>(r-l+1))
            throw new RuntimeException("k is illegal");
        int pi = partition(arr,l,r);
        if(pi - l + 1 == k)
            return arr[pi];
        else if(pi - l + 1 > k){
            return kSmallest(arr,l,pi-1,k);
        }else{
            return kSmallest(arr,pi+1,r,k-(pi-l+1));
        }

    }

    static int median(int[] arr){
        return kSmallest(arr,0,arr.length-1,arr.length/2);
    }

    static void kSmallestInStream(Node head, int k){
        MaxHeap maxHeap = new MaxHeap();
        Node current = head;
        while (current != null){
            int value = current.value;
            if(maxHeap.getSize() < k)
                maxHeap.add(value);
            else {
                if(value < maxHeap.getMax()){
                    maxHeap.extractMax();
                    maxHeap.add(value);
                }
            }
            current = current.next;
        }
    }


    public static void main(String[] args) {
	// write your code here
    }
}
class Node{
    int value;
    Node next;

    public Node(int value) {
        this.value = value;
    }
}