package com.company;

public class Main {

    public static void main(String[] args) {






	    boolean f = true;

	    f = false;
	    f = 5 < 7;
	    f = 5 <= 8;
	    f = 5 == 8;
	    f = 5 != 8;
	    f = 5 > 7 && 3 < 12;
        f = 5 < 7 || 3 < 12;
        f = !(5<7);
        f = 5 != 7;
        f = !(5 == 7);
        f = 5 < 7;
        f = !(5 >= 7);
        f = 5 > 7 && 5%2 == 0 && 2 < 10;
        boolean a=false,b=false,c=false;









        int x=0,y=0,z=0,w;
        w = z*(x+y);
        w = 2*(3+4);
        w = 2*3+2*4;
        w = z*x+z*y;



        f = !(a && b);
        f = !a && !b;
        f = !a || !b;


        f = (a || b) && c;


		if(5<7){
			System.out.println("5 is less than 7");
		}else{
			System.out.println("5 is NOT less than 7");
		}

		x = 17;
		if(x < 10){
			System.out.println("x is less than 10");
		}else if(x < 20){
			System.out.println("x is between 10 and 20");
		}else if(x < 100){
			System.out.println("x is less than 100");
		} else{
			System.out.println("x is 20 or more");
		}

		if(x < 100)
			System.out.println("x is less than 100");

		System.out.println("another line");

		x = 17;
		if(x < 100)
			y = 20;
		else {
			if (x % 2 == 0)
				y = 30;
			else
				y = 40;
		}

		y = x < 100 ? 20 : (x%2==0 ? 30 : 40);


		if(x < 100 && x % 2 == 0){
			System.out.println("x is both even and less than 100");
		}

		if(x < 100){
			if(x % 2 == 0)
				System.out.println("x is both even and less than 100");
		}

		int j = 0;
		while(j < 10){
			System.out.println("hello");
			j++;
		}




		j = 0;
		while(j < 10){
			int k = 0;
			System.out.println("hello");
			j++;
		}

		int k = 5;

		for(int i=0; i<10; i++){
			System.out.println(i);
		}

		for(int i=0; i<10; i++){
			System.out.println(i);
			for (int l = 0; l < 10; l++) {
				System.out.println("hi");
			}
		}



		x = 10;

		if(x == 1){

		}else if(x == 2){

		}else if(x == 5){

		}else if(x == 19){

		}else{

		}

		switch (x){
			case 1:

				break;
			case 2:

				break;
			case 5:

				break;
			case 19:

				break;
			default:

		}

		x = myFunc(6,1);
		System.out.println(x);
		System.out.println(distance(3,8));

    }


    static int myFunc(int x, int y){
		System.out.println("in myFunc()");
		return (19 + x) * y;
	}

	static int distance(int x, int y){
    	int small = x;
    	int large = y;
    	if(x > y){
    		small = y;
    		large = x;
		}
		int result = 0;
    	while (small + result < large)
			result++;
    	return result;
	}

	static int product(int x, int y){
		int small = x;
		int large = y;
		if(x > y){
			small = y;
			large = x;
		}
    	int result = 0;
		for (int i = 0; i < small; i++) {
			result += large;
		}
		return result;
	}

	static int quotient(int x, int y){
		if(y==0){
			return -1;
		}
    	int result = 0;
		int sum = y;
		while(sum <= x){
			result++;
			sum += y;
		}
		return result;
	}

	static int remainder(int x, int y){
		if(y==0){
			return -1;
		}
		return distance(x, product(quotient(x,y), y));

	}





}
