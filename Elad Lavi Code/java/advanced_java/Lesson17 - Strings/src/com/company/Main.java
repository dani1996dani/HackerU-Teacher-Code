package com.company;

public class Main {

    public static void main(String[] args) {
	    String s = "hello world how are you today?";
	    String[] words = s.split(" ");
	    for(String word : words)
            System.out.println(word);

    }
}
