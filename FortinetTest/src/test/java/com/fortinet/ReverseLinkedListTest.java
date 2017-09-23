package com.fortinet;

import org.junit.Before;
import org.junit.Test;
import junit.framework.Assert;

public class ReverseLinkedListTest {

	private ReverseLinkedList reverseLinkedList;
	private Node node;
	private int[] inputSequence = {1, 2, 3, 4, 5};
	
	@Before
	public void setup() {
		reverseLinkedList = new ReverseLinkedList();
	}
	
	@Test
	public void testReverse() {
		// setup input linked list
		if (inputSequence.length > 0) {
			node = new Node(inputSequence[0]);
		}
		for (int i = 1; i < inputSequence.length; i++) {
			node.appendToTail(inputSequence[i]);
		}
		
		// call
		Node result = reverseLinkedList.reverse(node);
		
		// verify result
		Assert.assertNotNull(result);
		int inputSequenceLength = inputSequence.length;
		Assert.assertEquals(inputSequence[inputSequenceLength - 1], result.value);
		Assert.assertEquals(inputSequenceLength, result.length(result));
		
		Node resultNode = result;
		for (int i = inputSequence.length - 1; i >= 0; i--) {
			Assert.assertEquals(inputSequence[i], resultNode.value);
			resultNode = resultNode.next;
		} 
		Assert.assertNull(resultNode);
	}
	
	@Test
	public void testForNull() {
		Node result = reverseLinkedList.reverse(null);
		Assert.assertNull(result);		
	}
	
	@Test
	public void testSingleElementList() {
		// setup input linked list
		Node input = new Node(1);
		
		// call
		Node result = reverseLinkedList.reverse(input);
		
		// verify result
		Assert.assertEquals(input, result);	
		Assert.assertNull(result.next);
	}
}
