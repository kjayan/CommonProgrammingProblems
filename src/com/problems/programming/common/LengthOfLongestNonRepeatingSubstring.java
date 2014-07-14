package com.problems.programming.common;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestNonRepeatingSubstring {

	public LengthOfLongestNonRepeatingSubstring() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		String str = "abcabcbb";
		String str2 = "bbbbb";
		int len = findLength(str);
		System.out.println(len);

	}
	
	private static int findLength(String str){
		
		int pre = 0;
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		
		for(int i=0;i<str.length();i++){
			if(!map.containsKey(str.charAt(i))){
				map.put(str.charAt(i), i);
			}
			else{
				pre = pre > map.size()?pre:map.size();
				i = map.get(str.charAt(i));
				map.clear();
			}
		}
		return Math.max(pre, map.size());
	}

}
