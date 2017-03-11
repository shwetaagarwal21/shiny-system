package org.shweta.dynamic_programming;

public class FibonacciNumber {

	public static void main(String[] args) {
		System.out.println("Recursive");
		System.out.println(getFibonacciRec(10));
		
		System.out.println("Iterative");
		System.out.println(getFibonacci(10));
	}
	
	public static int getFibonacciRec(int n){
		if(n < 0)
			throw new IllegalArgumentException("n cannot be negative");
		if(n == 0 || n == 1)
			return n;
		return (getFibonacciRec(n-1) + getFibonacciRec(n - 2));
	}
	
	public static int getFibonacci(int n){
		if(n < 0)
			throw new IllegalArgumentException("n cannot be negative");
		if(n == 0 || n == 1)
			return n;
		int a = 0, b = 1;
		int c = a + b;
		for(int i = 2; i<=n ; i++){
			c = a + b;
			a = b;
			b = c;
		}
		return c;
	}

}