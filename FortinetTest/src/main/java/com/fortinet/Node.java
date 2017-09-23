package com.fortinet;

public class Node{
	 Node next;
	 int value;
	 
	 public Node(int value) {
		 this.value = value;
	 }
	 
	 public void appendToTail(int value) {
		 Node end = new Node(value);
		 Node node = this;
		 while (node.next != null) {
			 node = node.next;
		 }
		 node.next = end;
	 }
	 
	 public int length(Node head) {
		 int length = 0; 
		 Node current = head;
		 while (current != null) { 
			 length ++; 
			 current = current.next; 
		 } 
		 return length; 
	 }
}