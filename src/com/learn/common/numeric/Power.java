package com.learn.common.numeric;

public class Power{

	public static void main(String[] args) {
		int n = 2;
		int k = 4;
		System.out.println(findPower(n,k));
	}
	
	private static int findPower(int n, int k){
		int temp;
		if(k==0){
			return 1;
		}
		temp = findPower(n,k/2);
		if(k%2 == 0){
			return temp*temp;
		}
		else{
			if(k> 0){
				return n*temp*temp;
			}
			else{
				return (temp*temp)/n;
			}
		}
	}

}
