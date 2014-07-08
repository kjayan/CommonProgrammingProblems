package com.problems.programming.common;

import java.math.BigInteger;
import java.util.Scanner;

public class IsFibonacci {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int numTestCases = in.nextInt();
		BigInteger[] numbersToCheck = new BigInteger[numTestCases];
		for(int i=0;i<numTestCases;i++){
			numbersToCheck[i] = BigInteger.valueOf(in.nextInt());
		}
		checkIfFibonacci(numbersToCheck);

	}
	
	private static void checkIfFibonacci(BigInteger[] numbersToCheck){
		BigInteger sum1;
		BigInteger sum2;
		for(BigInteger n:numbersToCheck){
			sum1 = (n.multiply(n).multiply(BigInteger.valueOf(5))).add(BigInteger.valueOf(4));
			sum2 = (n.multiply(n).multiply(BigInteger.valueOf(5))).subtract(BigInteger.valueOf(4));
			if(findIfPerfectSquare(sum1,sum2)){
				System.out.println("IsFibo");
			}
			else{
				System.out.println("IsNotFibo");
			}
			
		}
	}
	
	private static boolean findIfPerfectSquare(BigInteger sum1,BigInteger sum2){
		boolean isPerfectSquare = false;
		return true;
	}

}
