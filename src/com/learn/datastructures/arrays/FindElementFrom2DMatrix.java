package com.learn.datastructures.arrays;

public class FindElementFrom2DMatrix{

	public static void main(String[] args) {
		
		int[][] a = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15}};
		search(a,21);
	}
	
	private static void search(int[][] a,int num){
		int temp = a[0][a.length-1];
		int i = 0,j=a[0].length-1;
		while(i<a.length && j<a[0].length){
			temp = a[i][j];
			if(temp == num){
				System.out.println("Found at:\nRow:"+(i+1)+"\nColumn:"+(j+1));
				return;
			}
			if(temp > num){
				j--;
			}
			else if(temp < num){
				i++;
			}
		}		
		System.out.println("Element not found");
	}

}
