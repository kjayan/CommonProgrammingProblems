package com.learn.common.string;

public class SwapWithoutTemp {

	public static void main(String[] args) {
		int a = 1;
		int b = 2;
		
		a = a+b;
		b = a-b;
		a = a-b;
		
		System.out.println(a+"--"+b);
		
		a=1;b=2;
		
		a = a*b;
		b = a/b;
		a = a/b;
		
		System.out.println(a+"--"+b);
		
		a=1;b=2;
		
		a = a^b;
		b = a^b;
		a = a^b;
		
		System.out.println(a+"--"+b);
		

	}

}
