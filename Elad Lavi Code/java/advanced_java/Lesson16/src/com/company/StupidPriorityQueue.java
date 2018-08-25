package com.company;

public class StupidPriorityQueue implements PriorityQueue {

    private int[] arr;
    private int size;

    public StupidPriorityQueue() {
        arr = new int[100];
        size = 0;
    }

    @Override
    public void add(int key) {
        //make room if no room
        arr[size++] = key;
    }

    @Override
    public int extractMax() {
        if(size == 0)
            throw new RuntimeException("queue is empty!");
        int max = arr[0];
        int indexOfMax = 0;
        for (int i = 1; i < size; i++) {
            if(arr[i] > max) {
                max = arr[i];
                indexOfMax = i;
            }
        }
        for (int i = indexOfMax; i < size - 1; i++) {
            arr[i] = arr[i+1];
        }
        size--;
        return max;
    }

    @Override
    public int getMax() {
        if(size == 0)
            throw new RuntimeException("queue is empty!");
        int max = arr[0];
        for (int i = 1; i < size; i++) {
            if(arr[i] > max)
                max = arr[i];
        }
        return max;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
