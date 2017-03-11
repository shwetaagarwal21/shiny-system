package org.shweta.arrays;

public class Fibonacci {

	public static void main(String[] args) {
		System.out.println("Fibonacci of 6 using recursion is " + getFibonacci(6));
		System.out.println("Fibonacci of 6 using iteration is " + getFibonacciIter(6));

	}
	
	static int getFibonacci(int n){
		if(n<0)
			throw new IllegalArgumentException("n cannot be negative!");
		if(n==0 || n == 1)
			return n;
		return getFibonacci(n-1) + getFibonacci(n-2);
	}
	
	static int getFibonacciIter(int n){
		if(n<0)
			throw new IllegalArgumentException("n cannot be negative!");
		if(n==0 || n == 1)
			return n;
		int a = 0;
		int b = 1;
		int c = a + b;
		for(int i=2;i<=n;i++){
			c = a+b;
			a=b;
			b=c;
		}
		return c;
	}
}
