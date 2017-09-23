package com.fortinet;

import java.util.List;

public class KGroups {
	
	public boolean separate(List<Integer> list, int k) { 
		// Time complexity: O(N*2^N) 
		// Space complexity: O(N+k)
		if (list == null || k <= 0 ) return false;
	    if (list.size() < k) return false;
	    if (k == 1) return true;
	 
	    // Check if we can divide the array into k parts
	    int sum = 0;
	    for (int i = 0; i < list.size(); i++) {
	    	sum = sum + list.get(i);
	    }
	    if (sum % k != 0){
	    	return false;
	    }
	 
	    int subsum = sum / k;
	    // default value 0
	    int subsumFill[] =  new int[k];
	    // default value false
	    boolean used[] =  new boolean[list.size()];
	 
	    // filling with last element of array and mark that as used
	    subsumFill[0] = list.get(list.size() - 1);
	    used[list.size() - 1] = true;
	    return isSeparationPossible(list, k, subsum, subsumFill, used, list.size(), 0, list.size() - 2);
		
	}
	
	
	
	private boolean isSeparationPossible(List<Integer> list, int k, int subsum, int subsumFill[], 
											boolean used[], int size, int start, int end) {
		if (subsumFill[start] == subsum) {
			if (start == k - 2){
				return true;
			} else {
				return isSeparationPossible(list, k, subsum, subsumFill, used, size, start + 1, size - 1);
			}
		}
		for (int i = end; i >= 0; i--) {
			if (used[i]) continue;
			int checkSum = subsumFill[start] + list.get(i);
			// we can use the element at i
			if (checkSum <= subsum) {
			     used[i] = true;
			     subsumFill[start] = subsumFill[start] + list.get(i);
			     boolean canDivideOthers = isSeparationPossible(list, k, subsum, subsumFill, used, size, start, i - 1);
			
			     // backtracking
			     used[i] = false;
			     subsumFill[start] = subsumFill[start] - list.get(i);
			     if (canDivideOthers) {
			    	 return true;
			     }
			}
		}
		return false;
	}
}
