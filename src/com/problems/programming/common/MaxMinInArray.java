package com.problems.programming.common;

public class MaxMinInArray {

	public static void main(String[] args) {
		int[] a = {100,75,12,55,99};
		int min = a[0];
		int max = a[0];
		for(int i=1;i<a.length;i++){
			if(min >= a[i]){
				min = a[i];
			}
			if(max <= a[i]){
				max = a[i];
			}
		}
		System.out.println(max + "--"+min);
	}

}
