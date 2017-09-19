package com.learn.cache.lru;

import java.util.HashMap;
import java.util.Map;

public class LRUCacheDLL {

	private Map<Integer,DLLCacheNode> cacheMap = new HashMap<Integer, DLLCacheNode>();
	private DLLCacheNode head;
	private DLLCacheNode tail;
	private int maximumCapacity;
	private int currentCapacity;
	
	public LRUCacheDLL(int capacity) {
		this.maximumCapacity = capacity;
		this.currentCapacity = 0;
	}
	
	public void set(int key,int value){
		if(cacheMap.containsKey(key)){
			DLLCacheNode oldNode = cacheMap.get(key);
			oldNode.setValue(value);
			removeNode(oldNode);
			setHead(oldNode);
		}
		else{
			DLLCacheNode newNode = new DLLCacheNode(key, value);
			if(currentCapacity < maximumCapacity){
				setHead(newNode);
				cacheMap.put(key, newNode);
				currentCapacity++;
			}
			else{
				cacheMap.remove(tail);
				tail = tail.getPrevious();
				if(tail != null){
					tail.setNext(null);
				}
				setHead(newNode);
				cacheMap.put(key,newNode);
			}
		}
	}
	
	public int get(int key){
		if(cacheMap.containsKey(key)){
			DLLCacheNode latest = cacheMap.get(key);
			removeNode(latest);
			setHead(latest);
			return latest.getValue();
		}
		else {
			return -1;
		}
	}
	
	private void removeNode(DLLCacheNode node){
		DLLCacheNode current = node;
		DLLCacheNode previous = current.getPrevious();
		DLLCacheNode next = current.getNext();
		
		if(previous != null){
			previous.setNext(next);
		}
		else{
			head = next;
		}
		
		if(next != null){
			next.setPrevious(previous);
		}
		else{
			tail = previous;
		}
		
	}
	
	private void setHead(DLLCacheNode node){
		node.setNext(head);
		node.setPrevious(null);
		
		if(head != null){
			head.setPrevious(node);
		}
		
		head = node;
		
		if(tail == null){
			tail = node;
		}
	}

}
