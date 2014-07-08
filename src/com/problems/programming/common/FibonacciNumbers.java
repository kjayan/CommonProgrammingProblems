package com.problems.programming.common;

public class FibonacciNumbers{

	public static void main(String[] args) {
		int n = 10;
		System.out.println("First "+n+" fibonacci numbers");
		printFibonacci(n);
		System.out.println(n+"th fibonacci number is "+ findNthFibonoacciNumber(n));
	}
	
	private static void printFibonacci(int n){
		for(int i=1;i<=n;i++){
			System.out.println(findFibonacci(i));
		}
	}

	private static int findFibonacci(int i){
		if(i<=2){
			return 1;
		}
		else{
			return findFibonacci(i-1)+findFibonacci(i-2);
		}
	}
	
	private static int findNthFibonoacciNumber(int i){
		if(i==1 || i==2){
			return 1;
		}
		int fib1 = 1;
		int fib2 = 1;
		int fib = 1;
		for(int j=3;j<=i;j++){
			fib = fib1 + fib2;
			fib1 = fib2;
			fib2 = fib;
		}
		return fib;
	}
}
