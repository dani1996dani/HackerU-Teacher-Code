package com.company;

import java.util.Random;

public class Node {
	private String value;
	private Node next;

	public Node(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public static String chooseRandom(final Node head){
		if(head == null)
			return null;
		String result = head.value;

		Random random = new Random(System.nanoTime());
		Node node = head;
		int n = 1;
		while (node != null){
			if(random.nextInt(n) == 0){
				result = node.value;
			}
			n++;
			node = node.next;
		}
		return result;
	}
}
