package com.company;

import com.sun.org.apache.xerces.internal.xs.datatypes.ObjectList;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListResourceBundle;

import static abc.org.project.A.MYCONST;

class Dog implements Comparable<Dog>{
    @Override
    public int compareTo(Dog o) {
        System.out.println("in compareTo()");
        return 0;
    }
}

public class Main {

    public static void main(String[] args) {


    }

    public static void printList(List<?> list){
        for(Object o : list)
            System.out.println("{" + o + "}");
    }

    public static double sum(List<? extends Number> numbers){
        double sum = 0.0;
        for(Number number : numbers)
            sum += number.doubleValue();
        //numbers.add(new Double(3.4));
        return sum;
    }

    public static void ex1(){
        int i = 012; //octal base
        if(i == 10.0)//implicit casting
            System.out.println("true");
    }

    public static void ex2(){
        Number [] numbers = new Number[4];
        //numbers[0] = new Number(0); //cannot be instantiated
        numbers[1] = new Integer(1);
        numbers[2] = new Float(2.0f);
        numbers[3] = new BigDecimal(3.0);
        for(Number num : numbers){
            System.out.print(num + " ");
        }
    }

    public static void ex3(){
        StringBuffer stringBuffer = new StringBuffer("This, that, etc.!");
        System.out.println(stringBuffer.replace(12,15,"etcetera"));
    }

    public static void ex4(){
        Object nullObject = null;
        StringBuffer stringBuffer = new StringBuffer(10);
        stringBuffer.append("hello ");
        stringBuffer.append("world ");
        stringBuffer.append(nullObject);
        //stringBuffer.append(null); //does not compile because the compiler doesn't know which method to choose
        stringBuffer.insert(11, '!');
        System.out.println(stringBuffer);

    }

    public static void ex5(){
        Boolean b = null;
        System.out.println(b ? true : false);
    }
    public static void ex6() {
        class Base{
            public Base(){
                System.out.println("Base");
            }
        }
        class Derived extends Base{
            public Derived() {
                System.out.println("Derived");
            }
        }
        class DeriDerived extends Derived{
            public DeriDerived(){
                System.out.println("DeriDervied");
            }
        }
        Derived derived = new DeriDerived();


    }


    public static void ex8() {
        class Point{
            private int x = 0, y;

            public Point(int x, int y){
                this.x = x;
                this.y = y;
            }
            public Point(){
                this(0, 0);
            }
        }

    }

    public static void ex10(){
        //A a = new A();
        System.out.println("MYCONST = " + MYCONST);
        //funcInA();
    }

    public static void ex12(){
        System.out.printf(null);
        //System.out.print(null);
        //System.out.println(null);
    }

    public static void ex15(){
        Outer.main(null);
    }
    public static void foo(C<? super DI> arg){

    }

}
class MyGenericClass<T>{
    private T value;


    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
interface BI{ }
interface DI extends BI {}
interface DDI extends DI{}
class C<T>{ }
class X<T extends DI>{


    public void func(T arg){

    }
}