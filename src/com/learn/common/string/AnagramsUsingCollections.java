package com.learn.common.string;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AnagramsUsingCollections{

	public static void main(String[] args) {
		
		String[] strings = {"cat","act","god","dog","dgo","tac"};
		
		Map<String, Integer> stringMap = new HashMap<String,Integer>();
		for(String s:strings){
			stringMap.put(s, findHashCode(s.toCharArray()));
		}
		Collection<Integer> valueSet = stringMap.values();
		Set<Integer> distinctHashSet = new HashSet<Integer>(valueSet);
		for(int hashCode : distinctHashSet){
			System.out.println("Set");
			for(String key: stringMap.keySet()){
				if(stringMap.get(key).equals(hashCode)){
					System.out.println("Same HashCode:"+key);
				}
			}
		}
	}
	
	private static int findHashCode(char[] s){
		int hashCode = 0;
		for(int i=0;i<s.length;i++){
			hashCode += (int)s[i];
		}
		return hashCode;
	}

}
