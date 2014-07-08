package com.problems.programming.common;

public class GenerateMatchingParenthesisPairs{

	public static void main(String[] args) {
		
		int numberOfPairs = 1000;
		printParenthesis("",numberOfPairs,0);
	}
	
	private static void printParenthesis(String pair,int openStack,int closedStack){
		if(openStack == 0 && closedStack ==0){
			System.out.println(pair);
		}
		if(openStack > 0){
			printParenthesis(pair+"(",openStack-1,closedStack+1);
		}
		if(closedStack > 0){
			printParenthesis(pair+")",openStack,closedStack-1);
		}
	}

}
