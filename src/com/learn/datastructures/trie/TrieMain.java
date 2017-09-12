package com.learn.datastructures.trie;

import java.util.List;

public class TrieMain {

	public static void main(String[] args) {

		Trie trie = new Trie();	

		trie.addWord("can");
		trie.addWord("cant");
		trie.addWord("ban");
		trie.addWord("banner");
		
		trie.addWord("a");
		trie.addWord("an");
		trie.addWord("and");
		trie.addWord("ant");
		trie.addWord("aunty");
		
		List<String> result = trie.getWords("a");
		for(String str:result){
			System.out.println(str);
		}

	}

}
