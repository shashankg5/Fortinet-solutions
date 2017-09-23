package com.fortinet;

public class ReverseLinkedList {

	 // Time complexity: O(N)
	 // Space complexity: O(1)
	 public Node reverse(Node head) {
	        if (head == null) 
	        	return null;
	        Node prev = null;
	        Node after = null;
	        
	        while (head != null) {
	            after = head.next;
	            head.next = prev;
	            prev = head;
	            head = after;
	        }
	        return prev;
	    }
}
