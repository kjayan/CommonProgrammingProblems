package com.problems.programming.common;

public class Factorial{

	public static void main(String[] args) {
		System.out.println(findFactorial(10));
	}
	
	private static int findFactorial(int n){
		if(n==1){
			return 1;
		}
		else{
			return n*findFactorial(n-1);
		}
	}

}
