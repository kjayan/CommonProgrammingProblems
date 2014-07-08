package com.problems.programming.common;

public class SubArrayWithGivenSum{

	public static void main(String[] args) {
		
		int[] a = {1,2,3,4,5};
		int sumToFind = 5;
		findSubarray(a,sumToFind);
		findSubarrayOptimized(a,sumToFind);
	}
	
	private static void findSubarray(int[] a, int sum){
		int curSum = 0;
		for(int i=0;i<a.length;i++){
			curSum = a[i];
			for(int j=i+1;j<a.length;j++){
				if(curSum == sum){
					System.out.println("Subarray from:"+i+" to "+(j-1));
				}
				if(curSum > sum || j== a.length){
					break;
				}
				curSum += a[j];
			}
		}
	}
	
	private static void findSubarrayOptimized(int[] a,int sum){
		int curSum = a[0];
		int start = 0;
		for(int i=1;i<a.length;i++){
			while(curSum > sum && start < i-1){
				curSum -= a[start];
				start++;
			}
			if(curSum == sum){
				System.out.println("Optimized soln:Subarray from:"+start+" to "+(i-1));
				break;
			}
			if(i<a.length){
				curSum += a[i];
			}
		}
	}

}
