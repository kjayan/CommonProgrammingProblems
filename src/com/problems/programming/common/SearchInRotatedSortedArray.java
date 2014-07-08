package com.problems.programming.common;

public class SearchInRotatedSortedArray{

	public static void main(String[] args) {
		
		int[] a = {3,4,5,1,2};
		int num = 4;
		int index = findNum(a,num);
		if(index > -1){
			System.out.println("Number found at :"+(index+1));
		}
		else{
			System.out.println("Number was not found");
		}
	}
	
	private static int findNum(int[] a, int num){
		int left = 0;
		int right = a.length -1;
		while(left <= right){
			int mid = left + (right-left)/2;
			if(a[mid] == num){
				return mid;
			}
			else if(a[left] < a[mid]){
				if(a[left] <= num && num < a[mid]){
					right = mid-1;
				}
				else{
					left = mid+1;
				}
			}
			else{
				if(a[mid] < num && num <= a[right]){
					left = mid+1;
				}
				else{
					right = mid-1;
				}
			}		
		}
		return -1;
	}

}
