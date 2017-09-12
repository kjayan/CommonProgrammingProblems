package com.learn.common.string;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindDuplicateWordsInString{

	public static void main(String[] args) {
		
		String sentence = "this is a sentence is a";
		
		List<String> wordList = Arrays.asList(sentence.split(" "));
		
		Set<String> wordSet = new HashSet<String>(wordList);
		
		for(String s:wordSet){
			if(wordList.contains(s) && Collections.frequency(wordList, s) > 1){
				System.out.println("Duplicate:"+s);
			}
		}
		
		
	}

}
