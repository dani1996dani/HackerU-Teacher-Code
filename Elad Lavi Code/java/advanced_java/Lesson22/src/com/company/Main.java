package com.company;

public class Main {

    public static void main(String[] args) {
	    int[] coins = {1,2,5,10};
	    int howMuchToPay = 5;
        long[][] table = new long[howMuchToPay+1][coins.length+1];
        for (int i = 0; i <= howMuchToPay; i++) {
            for (int j = 0; j <= coins.length; j++) {
                table[i][j] = -1;
            }
        }

        long count = countWaysToPay(coins, coins.length, howMuchToPay, table);


        System.out.println("count: " + count);
    }

    public static long countWaysToPay(int[] coins, int numberOfCoins, int howMuchToPay,long[][] table){

        long result;
        if(howMuchToPay == 0)
            return  1;
        else if(howMuchToPay<0)
            return  0;
        else if(numberOfCoins <= 0)// && howMuchToPay > 0
            return 0;
        else {
            if(table[howMuchToPay][numberOfCoins] != -1)
                return table[howMuchToPay][numberOfCoins];
            else {
                result = countWaysToPay(coins, numberOfCoins, howMuchToPay - coins[numberOfCoins - 1],
                            table) + countWaysToPay(coins, numberOfCoins - 1,
                            howMuchToPay, table);
                table[howMuchToPay][numberOfCoins] = result;
                return result;
            }
        }


    }

    public static long countWaysToPay(int[] coins, int numberOfCoins, int howMuchToPay){
        long[] table = new long[howMuchToPay+1];
        table[0] = 1;
        for (int i = 0; i < numberOfCoins; i++) {
            for (int j = coins[i]; j <= howMuchToPay ; j++) {
                table[j] += table[j-coins[i]];
            }
        }
        return table[howMuchToPay];
    }
}
