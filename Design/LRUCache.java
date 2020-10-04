package Design;

import java.util.HashMap;
import java.util.Map;

/**
 * Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
 * 
 * Time complexity : O(1) both for put and get.
 * Space complexity : O(capacity) since the space is used only for a hashmap and
 *  				  double linked list with at most capacity + 1 elements.
 *
 */
public class LRUCache {
	private Map<Integer,DLinkedList> cache;
	private int capacity;
	private DLinkedList head, tail;	// dummy head and tail
	
	/**
	 * Initialize the LRU cache with positive size capacity.
	 * 
	 * @param capacity the size of LRU cache
	 */
	public LRUCache(int capacity) {
		cache = new HashMap<>();
		this.capacity = capacity;
		head = new DLinkedList();
		tail = new DLinkedList();
		head.next = tail;
		tail.prev = head;
    }

	/**
	 * Return the value of the key if the key exists, otherwise return -1.
	 * @param key the passed key parameter
	 * @return the value of the key if the key exists, otherwise return -1.
	 */
	public int get(int key) {
    	DLinkedList node = cache.get(key);
    	if(node == null) return -1;
    	removeNode(node);
    	addFront(node);
    	return node.value;
    }
	
	/**
	 * Update the value of the key if the key exists. Otherwise, add the key-value pair 
	 * to the cache. If the number of keys exceeds the capacity from this operation, 
	 * evict the least recently used key.
	 * @param key the passed key parameter
	 * @param value the passed value parameter
	 */
	public void put(int key, int value) {
    	if(cache.containsKey(key)) {	// update value
    		DLinkedList node = cache.get(key);
    		node.value = value;
    		removeNode(node);
    		addFront(node);
    	} else {
    		if(cache.size() == capacity) { // cache is full, remove last node
    			DLinkedList lastNode = tail.prev;
        		removeNode(lastNode);	// remove node from list
        		cache.remove(lastNode.key);	// remove k->v mapping
    		}
			DLinkedList node = new DLinkedList(key,value);
			cache.put(key,node);
			addFront(node);	
    	}
    }
	
    
    /*
     * Add node to the front of a list
     */
    private void addFront(DLinkedList node) {
    	node.prev = head;
    	node.next = head.next;
    	head.next.prev = node;
    	head.next = node;
	}

    /*
     * Remove the current node
     */
	private void removeNode(DLinkedList node) {
		node.next.prev = node.prev;
		node.prev.next = node.next;
	}

	/*
	 * Inner doubly-linked list class
	 */
	private class DLinkedList {
		int key;
		int value;
		DLinkedList prev;
		DLinkedList next;
		public DLinkedList() {
			this(0,0);
		};
		
		public DLinkedList(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}
}
