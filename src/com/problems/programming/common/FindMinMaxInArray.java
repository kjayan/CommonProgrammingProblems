package com.problems.programming.common;

public class FindMinMaxInArray{

	public FindMinMaxInArray(){

	}

	public static void main(String[] args) {
		
		int[] array = {10,3,20,5,100,8,15};
		int min = array[0];
		int max = array[0];
		for(int i=1;i<array.length;i++){
			if(min >= array[i]){
				min = array[i];
			}
			if(max <= array[i]){
				max = array[i];
			}
		}
		System.out.println("Max Element:"+max);
		System.out.println("Min Element:"+min);
	}

}
