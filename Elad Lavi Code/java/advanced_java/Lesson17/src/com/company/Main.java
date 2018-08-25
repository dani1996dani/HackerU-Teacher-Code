package com.company;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
	    int x = 5;
	    //0...00101
        int y = 3;
        //0...00011

        int z;
        z = x & y;
        //0...00001
        z = x | y;
        //0...00111
        z = x ^ y;
        //0...00110
        z = x >> 1;
        //0...00010
        //System.out.println(z);

        int a = 128;
        byte b = (byte)a;
        int c = b & 0xFF;


        int t = 1231234534;
        t = t >> 8;
        //System.out.println(c);

        Set<Integer> mySet = new HashSet<>();

    }

    /**
     * is B a sub set of A ?
     * @param A list of size n
     * @param B list of size m
     * @return true iff all elements of B are also elements of A
     */
    public boolean isSubSet(List<Integer> A, List<Integer> B){
        /*
        //naive solution: O(n*m)
        for (int i = 0; i < B.size(); i++) {
            int b = B.get(i);
            boolean found = false;
            for (int j = 0; j < A.size(); j++) {
                if(A.get(j) == b){
                    found = true;
                    break;
                }
            }
            if(!found)
                return false;
        }

        return true;
        */
        //Set<Integer> setA = new HashSet<>(A);
        Set<Integer> setA = new HashSet<>();
        //setA.addAll(A);
        for (int i = 0; i < A.size(); i++) {
            setA.add(A.get(i));
        }
        for (int i = 0; i < B.size(); i++) {
            if(!setA.contains(B.get(i)))
                return false;
        }
        //O(m + n)
        return true;
    }
}
