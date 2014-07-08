package com.problems.programming.common;

public class IsPalindromeNumber{

	public static void main(String[] args) {
		int n1 = 121;
		int n2 = 123;
		
		isPalindrome(n1);
		isPalindrome(n2);
	}	
	private static void isPalindrome(int number){
		int reverse = 0;
		int temp = number;
		while(number != 0){
			reverse = reverse *10 + number%10;
			number = number/10;
		}
		if(temp == reverse){
			System.out.println(temp +" is palindrome");
		}
		else{
			System.out.println(temp +" is not palindrome");
		}
	}

}
