package com.company;

public class Kayak<T,K> {
    private T front;
    private K rear;

    public Kayak(T front, K rear) {
        this.front = front;
        this.rear = rear;
    }
    public T getFront() {
        return front;
    }

    public void setFront(T front) {
        this.front = front;
    }

    public K getRear() {
        return rear;
    }

    public void setRear(K rear) {
        this.rear = rear;
    }
}
