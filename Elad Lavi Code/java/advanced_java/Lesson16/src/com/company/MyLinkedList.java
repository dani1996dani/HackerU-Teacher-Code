package com.company;

import java.util.Iterator;

public class MyLinkedList<T> implements MyList<T>, Iterable<T>, Iterator<T> {

	private int size;
	private Node<T> anchor;
	private Node<T> last;

	private Node<T> current;

	public MyLinkedList(){
		anchor = new Node<>(null);
		last = anchor;
		size = 0;
	}

	@Override
	public T get(int index){
		if(index < 0 || index >= size)
			throw new IndexOutOfBoundsException();
		Node<T> node = anchor;
		for (int i = 0; i < index + 1; i++) {
			node = node.next;
		}
		return node.value;
	}
	@Override
	public void set(int index, T value){
		if(index < 0 || index >= size)
			throw new IndexOutOfBoundsException();
		Node<T> node = anchor;
		for (int i = 0; i < index + 1; i++) {
			node = node.next;
		}
		node.value = value;
	}
	@Override
	public void add(T value){
		/*Node last = anchor;
		while (last.next != null)
			last = last.next;*/
		last.next = new Node<>(value);
		last = last.next;
		size++;
	}


	@Override
	public void addAt(int index, T value){
		if(index < 0 || index >= size)
			throw new IndexOutOfBoundsException();

		Node<T> theOneBefore = anchor;
		for (int i = 0; i < index; i++) {
			theOneBefore = theOneBefore.next;
		}
		Node<T> node = new Node<>(value);
		node.next = theOneBefore.next;
		theOneBefore.next = node;
		size++;
	}
	@Override
	public void removeAt(int index){
		if(index < 0 || index >= size)
			throw new IndexOutOfBoundsException();

		Node<T> theOneBefore = anchor;
		for (int i = 0; i < index; i++) {
			theOneBefore = theOneBefore.next;
		}
		theOneBefore.next = theOneBefore.next.next;
		size--;

	}
	@Override
	public int size(){
		return size;
	}

	@Override
	public int indexOf(T value){
		Node<T> node = anchor;
		int index = 0;
		while (node.next != null){
			if(node.next.value.equals(value))
				return index;
			index++;
			node = node.next;
		}
		return -1;
	}

	@Override
	public T[] toArray(){
		T[] arr = (T[])new Object[size];
		Node<T> temp = anchor;
		for (int i = 0; i < size; i++) {
			temp = temp.next;
			arr[i] = temp.value;
		}
		return arr;
	}



	private static class Node<T>{

		T value;
		Node<T> next;

		public Node(T theValue){
			value = theValue;
		}



	}

	@Override
	public boolean hasNext() {
		if(current.next == null)
			return false;
		else{
			current = current.next;
			return true;
		}
	}

	@Override
	public T next() {
		return current.value;
	}

	@Override
	public Iterator<T> iterator() {
		current = anchor;
		return this;
	}
}

