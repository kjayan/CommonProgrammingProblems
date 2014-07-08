package com.problems.programming.common;

public class PairHavingSumInSortedArray{

	public static void main(String[] args) {
		
		int[] a = {1,2,3,4,5};
		int sumToFind = 9;
		String[] resultPairs  = findPair(a, sumToFind);
		if(resultPairs == null){
			System.out.println("No such pairs found");
		}
		else{
			for(String s:resultPairs){
				if(s != null){
					System.out.println(s);
				}
			}
		}
		
	}
	
	private static String[] findPair(int[] a, int sumToFind){
		String[] pairsFound = new String[a.length];
		int k = 0;
		int i =0;
		int j = a.length -1;
		int tempSum = 0;
		while(i<j){
			tempSum = a[i]+a[j]; 
			if(tempSum == sumToFind){
				//System.out.println("Pair found at "+(i+1)+" and "+(j+1));
				pairsFound[k++] = "Pair found at "+(i+1)+" and "+(j+1);
				i++;
				j--;
			}
			else if(i<j && tempSum < sumToFind){
				i++;
			}
			else if(i<j && tempSum > sumToFind){
				j--;
			}
		}
		if(k == 0){
			return null;
		}
		return pairsFound;
	}

}
