package com.problems.programming.common;

public class PermutationsOfString{

	private static char[] sourceString;
	private static int numPermutations = 0;
	public static void main(String[] args) {
		
		String s = "abc";
		sourceString = s.toCharArray();
		System.out.println("Permutation using backtacking");
		backtrackPermute(0,s.length()-1);
		System.out.println("Number of permutations using backtracking:"+numPermutations);
		numPermutations = 0;
		System.out.println("Permutation using recursion");
		recursivePermute("", s);
		System.out.println("Number of permutations using recursion:"+numPermutations);
				
	}
	
	private static void backtrackPermute(int start,int end){
		if(start == end){
			numPermutations++;
			System.out.println("Permutation :"+new String(sourceString));
		}
		for(int j = start;j<=end;j++){
			swap(start,j);
			backtrackPermute(start+1, end);
			swap(start,j);
		}
	}
	
	private static void recursivePermute(String prefix,String originalString){
		int n = originalString.length();
		if(n == 0){
			numPermutations++;
			System.out.println("Permutation:"+prefix);
		}
		for(int i=0;i<n;i++){
			recursivePermute(prefix+originalString.charAt(i), originalString.substring(0,i)+originalString.substring(i+1,n));
		}
	}
	
	
	private static void swap(int pos1,int pos2){
		char temp = sourceString[pos1];
		sourceString[pos1] = sourceString[pos2];
		sourceString[pos2] = temp;
	}

}
