package com.learn.common.string;

public class StringReverseRecursive {
	private static String reverse ="";

	public static void main(String[] args) {
		String a = "jayan";
		System.out.println(reverse(a));

	}
	
	private static String reverse(String a){
		if(a.length() == 1){
			return a;
		}
		else{
			reverse += a.charAt(a.length()-1)+reverse(a.substring(0,a.length()-1));
			return reverse;
		}
			
	}

}
