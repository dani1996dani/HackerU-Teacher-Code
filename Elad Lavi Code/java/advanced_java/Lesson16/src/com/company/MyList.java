package com.company;

public interface MyList<T> {
    T get(int index);
    void set(int index, T value);
    void add(T value);
    void addAt(int index, T value);
    void removeAt(int index);
    int size();
    int indexOf(T value);
    T[] toArray();
}
