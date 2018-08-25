package com.company;

public class Overloaded {

	/*
	public static void aMethod(int val){ System.out.println("int"); }
	public static void aMethod(short val){ System.out.println("short"); }
	public static void aMethod(Object val){ System.out.println("object"); }
	public static void aMethod(String val){ System.out.println("string"); }
	*/

	/*
	public static void aMethod(byte val){ System.out.println("byte"); }
	public static void aMethod(short val){ System.out.println("short"); }
	*/

	public static void aMethod(long val1, int val2){ System.out.println("long,int"); }
	public static void aMethod(int val1, long val2){ System.out.println("int,long"); }

}
