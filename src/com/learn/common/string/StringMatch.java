package com.learn.common.string;

public class StringMatch{

	public static void main(String[] args) {

		String a = "test";
		String stringToFind = "st";
		
		findSubstring(a.toCharArray(),stringToFind.toCharArray());
		
	}
	
	private static void findSubstring(char[] a,char[] find){
		int matches = 0;
		for(int i=0;i<a.length;i++){
			for(int j=0;j<find.length;j++){
				if(a[i+j] == find[j]){
					if(j==find.length-1){
						matches++;
						break;
					}
				}
				else{
					break;
				}
			}			
		}
		if(matches > 0){
			System.out.println("match found");
			return;
		}
		System.out.println("Match not found");
	}

}
