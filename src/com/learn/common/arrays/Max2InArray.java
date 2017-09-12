package com.learn.common.arrays;

public class Max2InArray {

	public static void main(String[] args) {
		int[] a = {50,25,75,40,55};
		int max1 = 0;
		int max2 = 0;
		for(int n:a){
			if(max1 < n){
				max2 = max1;
				max1 = n;
			}
			else if(max2 < n){
				max2 = n;
			}
		}
		System.out.println(max1+"--"+max2);

	}

}
