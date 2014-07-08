package com.problems.programming.common;

public class LongestPalindromeSubstring {

	public LongestPalindromeSubstring() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		String str = "forgeeksskeegfor";
		
		String result = findUsingDP(str);
				
		System.out.println(result);
		
		result = findUsingLessSpace(str);
		System.out.println(result);
	}
	
	private static String findUsingDP(String str){
		int maxLen = 0;
		int strLen = str.length();
		String result = "";
		int[][] dpTable = new int[str.length()][str.length()];
		
		for(int i=0;i<strLen;i++){
			dpTable[i][i]=1;
		}

		for(int i=0;i<=strLen-2;i++){
			if(str.charAt(i)==str.charAt(i+1)){
				dpTable[i][i+1] = 1;
				result = str.substring(i,i+2);
				maxLen = 2;
			}
			
		}
		
		for(int l=3;l<=strLen;l++){
			for(int i=0;i<=strLen-1;i++){
				int j=i+l-1;
				if(j<str.length()){
					if(str.charAt(i)==str.charAt(j)){
						dpTable[i][j] = dpTable[i+1][j-1];
						if(dpTable[i][j]==1 && l > maxLen){
							result = str.substring(i,j+1);
							maxLen = result.length();
						}					
					}
					else{
						dpTable[i][j] = 0;
					}
				}
				
			}
		}
		return result;
	}

	
	private static String findUsingLessSpace(String str){
		int strLen = str.length();
		String result = "";
		for(int i=0;i<strLen;i++){
			String temp = findPalin(str,i,i);
			if(temp.length() > result.length()){
				result = temp;
			}
			temp = findPalin(str,i,i+1);
			if(temp.length() > result.length()){
				result = temp;
			}
		}
		return result;
	}
	
	private static String findPalin(String str,int start,int end){
		while(start >=0 && end <str.length() && str.charAt(start) == str.charAt(end)){
			start--;
			end++;
		}
		return str.substring(start+1,end);
	}
}
