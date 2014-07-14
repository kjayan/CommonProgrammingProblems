package com.datastructures.trie;

import java.util.ArrayList;
import java.util.List;

public class TrieNode {
	
	private TrieNode parent;
	private TrieNode[] children;
	private boolean isLeaf;
	private boolean isWord;
	private char character;

	public TrieNode() {
		children = new TrieNode[26];
		isLeaf = true;
		isWord = false;
	}
	
	public TrieNode(char charcter){
		this();
		this.character = charcter;
	}
	
	protected void addWord(String word){
		isLeaf = false;
		int charPos = word.charAt(0) - 'a';
		if(children[charPos] == null){
			children[charPos] = new TrieNode(word.charAt(0));
			children[charPos].parent = this;
		}
		if(word.length() > 1){
			children[charPos].addWord(word.substring(1));
		}
		else{
			children[charPos].isWord = true;
		}
	}
	
	protected TrieNode getNode(char c){
		return children[c-'a'];
	}
	
	protected List<String> getWords(){
		List<String> nodeList = new ArrayList<String>();
		if(isWord){
			nodeList.add(this.toString());
		}
		if(!isLeaf){
			for(int i=0;i<children.length;i++){
				if(children[i] != null){
					nodeList.addAll(children[i].getWords());
				}
			}
		}
		return nodeList;
	}
	
	@Override
	public String toString(){
		if(parent == null){
			return "";
		}
		else{
			return parent.toString()+ new String(new char[] {character});
		}
	}

}
