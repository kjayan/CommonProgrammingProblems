package com.datastructures.trie;

import java.util.ArrayList;
import java.util.List;

public class Trie {
	
	private TrieNode rootNode;

	public Trie() {
		rootNode = new TrieNode();
	}
	
	public void addWord(String word){
		word = cleanUpWord(word);
		if(word != "" && word.length() > 0){
			rootNode.addWord(word.toLowerCase());
		}
		
	}
	
	public List<String> getWords(String prefix){
		TrieNode lastNode = rootNode;
		for(int i=0;i<prefix.length();i++){
			lastNode = lastNode.getNode(prefix.charAt(i));
			if(lastNode == null){
				return new ArrayList<String>();
			}
		}
		return lastNode.getWords();
		
	}
	
	private String cleanUpWord(String str){
		if(str != null && str.trim() != ""){
			str = str.replaceAll("[^a-zA-Z\\s]","");
		}
		else{
			str = "";
		}
		return str;
	}

}
