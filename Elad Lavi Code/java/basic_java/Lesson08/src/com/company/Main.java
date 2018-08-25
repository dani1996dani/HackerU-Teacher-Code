package com.company;

public class Main {

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.add(764);
        list.add(342);
        list.add(7657);
        list.add(1113);
        list.add(8765);
        list.addAt(1, 1000);
        list.removeAt(3);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
        int[] arr = list.toArray();
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }



    }

}
