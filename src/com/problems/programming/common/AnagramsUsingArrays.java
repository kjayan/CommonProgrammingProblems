package com.problems.programming.common;

import java.util.Arrays;

public class AnagramsUsingArrays{

	public static void main(String[] args) {
		String[] strings = {"cat","act","god","dog","dgo","tac"};
		
		String[] words = new String[strings.length];
		int[] index = new int[strings.length];
		
		int i =0;
		for(String s:strings){
			words[i] = s;
			index[i] = i;
			i++;
		}
		words = sortEachWord(words);
		words = sortWordArray(words,index);
		
		
		
	}
	
	private static String[] sortWordArray(String[] stringArray,int[] indexArray){
		String[] result = new String[stringArray.length];
		return result;
	}
	
	private static String[] sortEachWord(String[] source){
		String[] result = new String[source.length];
		int i=0;
		for(String s:source){
			result[i] = sortWord(s);
		}
		return result;
	}
	
	private static String sortWord(String s){
		char[] temp = s.toCharArray();
		Arrays.sort(temp);
		return new String(temp);
	}
	
	private static int getHashCode(char[] s){
		int hashCode = 0;
		for(int i=0;i<s.length;i++){
			hashCode += (int)s[i];
		}
		return hashCode;
	}

}
