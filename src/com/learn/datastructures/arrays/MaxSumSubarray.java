package com.learn.datastructures.arrays;

public class MaxSumSubarray {

	public MaxSumSubarray() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		int[] a = {-2, -5, 6, -2, -3, 1, 5, -6};
		
		
		int max = findMaxUsingDP(a);
		System.out.println("Maximum Sum:"+max);
		
		max = findMaxUsingKadane(a);
		System.out.println("Maximum Sum:"+max);
		

	}

	
	private static int findMaxUsingDP(int[] a){
		int max = a[0];
		int[] sum = new int[a.length];
		sum[0] = a[0];
		
		for(int i=1;i<a.length;i++){
			sum[i] = Math.max(a[i],sum[i-1]+a[i]);
			max = Math.max(max, sum[i]);
					
		}
		return max;
	}
	
	private static int findMaxUsingKadane(int[] a){
		int curMax = a[0];
		int max = a[0];
		for(int i=1;i<a.length;i++){
			curMax = Math.max(a[i], curMax+a[i]);
			max = Math.max(max, curMax);
		}
		return max;
	}
}
