package com.problems.programming.common;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidateParenthesis {

	public ValidateParenthesis() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		String str = "[{()}()]";
		Map<Character, Character> parenthesis = new HashMap<Character, Character>();
		parenthesis.put('[',']');
		parenthesis.put('(',')');
		parenthesis.put('{','}');
		
		boolean isValid = checkIfValid(str,parenthesis);
		System.out.println("Is Valid:"+isValid);
		
		

	}
	
	private static boolean checkIfValid(String str,Map<Character, Character> parenthesis){
		Stack<Character> stack = new Stack<Character>();
		char c;
		for(int i=0;i<str.length();i++){
			c = str.charAt(i);
			if(parenthesis.keySet().contains(c)){
				stack.push(c);
			}
			else if(parenthesis.values().contains(c)){
				if(!stack.isEmpty() && parenthesis.get(stack.peek()) == c){
					stack.pop();
				}
				else{
					return false;
				}
			}
		}
		return stack.isEmpty();
	}

}
