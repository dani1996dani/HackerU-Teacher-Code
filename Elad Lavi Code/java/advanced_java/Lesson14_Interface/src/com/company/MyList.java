package com.company;

public interface MyList {

	void add(int x);
	void addAt(int index, int x);
	void set(int index, int x);
	void removeAt(int index);
	int size();
	int indexOf(int x);
	int get(int index);

	int[] toArray();
}
