package com.problems.programming.common;

public class MaxSumInArrayWithNoAdjacentElements {

	public MaxSumInArrayWithNoAdjacentElements() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		int[] a = {3,2,5,10,7};
		System.out.println(findMaxSum(a));

	}

	private static int findMaxSum(int[] a){
		int incl = a[0];
		int excl = 0;
		int temp = 0;
		for(int i=1;i<a.length;i++){
			temp = incl>excl?incl:excl;
			incl = excl+a[i];
			excl = temp;
		}
		if(incl>excl){
			return incl;
		}
		return excl;
	}
}
