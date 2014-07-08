package com.problems.programming.common;

public class DutchFlagProblem {
	private static int[] a = { 0, 1, 2, 2, 1, 0, 1, 2, 0 }; 
	
	public static void main(String[] args) {
		
		sort();

	}

	private static void sort(){
		int low = 0;
		int high = a.length - 1;
		int mid = 0;
	 
	   while(mid <= high)
	   {
	      switch(a[mid])
	      {
	         case 0:
	           swap(low,mid);
	           low++;
	           mid++;
	           break;
	         case 1:
	           mid++;
	           break;
	         case 2:
	           swap(mid,high);
	           high--;
	           break;
	      }
	   }
	   System.out.println(a);
	}
	
	private static void swap(int pos1,int pos2){
		int temp = a[pos1];
		a[pos1] = a[pos2];
		a[pos2] = temp;
	}
}
