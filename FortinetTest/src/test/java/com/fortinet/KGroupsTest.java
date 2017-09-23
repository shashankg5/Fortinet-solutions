package com.fortinet;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class KGroupsTest {
	
	private KGroups kGroups;
	private List<Integer> list;
	private int k;
	
	@Before
	public void setup() {
		kGroups = new KGroups();
		list =  new ArrayList();
	}
	
	@Test
	public void testGroupsExists() {
		list.add(2);
		list.add(5);
		list.add(0);
		list.add(3);
		k = 2;
		Assert.assertTrue(kGroups.separate(list, k));
	}
	
	@Test
	public void testGroupsDoesNotExists() {
		list.add(2);
		list.add(5);
		list.add(0);
		list.add(3);
		list.add(1);
		k = 2;
		Assert.assertFalse(kGroups.separate(list, k));
	}
	
	@Test
	public void testWithEmptyList() {
		Assert.assertFalse(kGroups.separate(list, k));
	}
	
	@Test
	public void testNull() {
		Assert.assertFalse(kGroups.separate(null, k));
	}
	
	@Test
	public void testZeroGroups() {
		list.add(2);
		list.add(5);
		list.add(0);
		list.add(3);
		Assert.assertFalse(kGroups.separate(list, 0));
	}
	
	@Test
	public void testOneGroup() {
		list.add(2);
		list.add(5);
		list.add(0);
		list.add(3);
		Assert.assertTrue(kGroups.separate(list, 1));
	}
	
	@Test
	public void testGroupsMoreThanListELements() {
		list.add(2);
		list.add(5);
		list.add(0);
		list.add(3);
		k = 5;
		Assert.assertFalse(kGroups.separate(list, k));
	}
	
	@Test
	public void testNegativeNumberOfGroups() {
		list.add(2);
		list.add(5);
		list.add(0);
		list.add(3);
		k = -2;
		Assert.assertFalse(kGroups.separate(list, k));
	}
}
