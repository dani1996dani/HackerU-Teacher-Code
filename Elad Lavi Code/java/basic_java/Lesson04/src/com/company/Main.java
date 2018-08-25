package com.company;

public class Main {

    public static void main(String[] args) {
        int[] arr1 = {7, 4, 3, 7, 2, 4, 3, 4, 1, 4, 5, 7};
        int[] arr2 = {4, 3, 4, 1};
        System.out.println(subArray(arr1,arr2));



        int[] x = {5};
        int[] y = x;
        x[0]++;
        System.out.println(y[0]);


    }

    static float average(int[] grades) {
        int sum = 0;
        for (int i = 0; i < grades.length; i++)
            sum += grades[i];

        float result = sum;
        result /= grades.length;
        return result;

    }



    static int max(int[] nums){
        if(nums.length == 0){
            //exception
        }
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] >  result)
                result = nums[i];
        }

        return result;
    }

    static int sum(int[] nums){

        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result += nums[i];
        }

        return result;
    }


    static boolean contains(int[] arr, int num){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == num)
                return true;
        }

        return false;
    }

    //O(nm)
    //O(n)=m   =>     O(n^2)
    static boolean contains(int[] arr1, int[] arr2){
        for (int i = 0; i < arr2.length; i++) {
            if(!contains(arr1, arr2[i]))
                return false;
        }
        return true;
    }

    //O(n+m)
    //O(n)=m   =>     O(n)
    static boolean contains2(int[] arr1, int[] arr2){
        boolean[] existingNumber = new boolean[600-500];
        for (int i = 0; i < arr1.length; i++) {
            existingNumber[arr1[i]-500] = true;
        }
        for (int i = 0; i < arr2.length; i++) {
            if(arr2[i]<500 || arr2[i] >= 600)
                return false;
            if(!existingNumber[arr2[i]-500])
                return false;
        }
        return true;
    }

    static int subArray(int[] arr1, int[] arr2){
        if(arr2.length == 0)
            return 0;
        for (int i = 0; i < arr1.length - arr2.length + 1; i++) {
            if(arr1[i] == arr2[0]){
                int j = 1;
                for (; j < arr2.length; j++) {
                    if(arr1[i+j] != arr2[j]){
                        break;
                    }

                }
                if(j == arr2.length){
                    return i;
                }
            }
        }
        return -1;
    }


    static void print(int[] arr){
        System.out.print("{");

        for (int i = 0; i < arr.length - 1; i++) {
            System.out.print(arr[i] + ",");
        }
        if(arr.length > 0)
            System.out.print(arr[arr.length-1]);

        System.out.println("}");
    }


    //12

    static void printPrimeFactors(int n){
        for (int i = 2; i*i <= n; i++) {
            if(n%i==0){
                printPrimeFactors(i);
                printPrimeFactors(n/i);
                return;
            }
        }
        System.out.print(n+" ");
    }






}
