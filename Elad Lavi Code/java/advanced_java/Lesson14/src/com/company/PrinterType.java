package com.company;

public enum PrinterType {
	INK_JET(4), LASER(5), THREE_D(100), DOT_MATRIX(400);

	private int capacity;

	private PrinterType(int capacity){
		this.capacity = capacity;
	}

	public int getCapacity(){
		return capacity;
	}
}
