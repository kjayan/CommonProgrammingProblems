package com.problems.programming.common;

public class RepeatingElementsInArray{

	public RepeatingElementsInArray(){

	}

	public static void main(String[] args) {
		int[] a = {1,2,1,3,4,1,2,3,6,5,4,3};
		
		for(int i=0;i<a.length;i++){
			if(a[Math.abs(a[i])] >=0){
				a[Math.abs(a[i])] = -a[Math.abs(a[i])];
			}
			else{
				System.out.println(Math.abs(a[i]));
			}
		}
		System.out.println(a);
	}

}
