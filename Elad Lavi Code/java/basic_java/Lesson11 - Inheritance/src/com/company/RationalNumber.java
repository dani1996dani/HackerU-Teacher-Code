package com.company;

import java.security.InvalidParameterException;

public class RationalNumber extends Number {

	private int numerator;//mone
	private int denominator;//mehane


	public RationalNumber(int numerator, int denominator) {
		setNumerator(numerator);
		setDenominator(denominator);
	}

	public RationalNumber(RationalNumber rationalNumber){
		this.numerator = rationalNumber.numerator;
		this.denominator = rationalNumber.denominator;
	}

	public int getNumerator() {
		return numerator;
	}

	public void setNumerator(int numerator) {
		this.numerator = numerator;
	}

	public int getDenominator() {
		return denominator;
	}

	public void setDenominator(int denominator) {
		if(denominator == 0)
			return;
		this.denominator = denominator;
	}

	@Override
	public int intValue() {
		return numerator/denominator;
	}

	@Override
	public long longValue() {
		return intValue();
	}

	@Override
	public float floatValue() {
		return numerator/(float)denominator;
	}

	@Override
	public double doubleValue() {
		return numerator/(double)denominator;
	}

	@Override
	public String toString() {
		return numerator + "/" + denominator;
	}

	//1982   53

	public static int gcd(int a, int b){
		if(b == 0)
			return a;
		return gcd(b,a%b);
	}

	public void reduce(){
		if(numerator == 0)
			return;
		int gcd = gcd(numerator,denominator);
		numerator /= gcd;
		denominator /= gcd;
	}

	public void add(RationalNumber other){
		int a = this.numerator;
		int b = this.denominator;
		int c = other.numerator;
		int d = other.denominator;
		this.numerator = a*d + b*c;
		this.denominator = b*d;
		this.reduce();
	}

	public void subtract(RationalNumber other){
		add(new RationalNumber(-1*other.numerator,other.denominator));
	}
	public int compareTo(RationalNumber other){
		if(other == null)
			throw new InvalidParameterException();
		int a = this.numerator;
		int b = this.denominator;
		if(b<0){
			b *= -1;
			a *= -1;
		}
		int c = other.numerator;
		int d = other.denominator;
		if(d < 0){
			d *= -1;
			c *= -1;
		}
		return a*d - b*c;



	}

}
