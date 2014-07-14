package com.cache.lru;

public class DLLCacheNode {

	private int key;
	private int value;
	private DLLCacheNode previous;
	private DLLCacheNode next;
	
	public DLLCacheNode(int key, int value) {
		this.value = value;
		this.key = key;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public DLLCacheNode getPrevious() {
		return previous;
	}

	public void setPrevious(DLLCacheNode previous) {
		this.previous = previous;
	}

	public DLLCacheNode getNext() {
		return next;
	}

	public void setNext(DLLCacheNode next) {
		this.next = next;
	}
	
	

}
