package com.fortinet;

public class MultiDimensionArraySum {
	class MultiDimensionArray {
	    // This is a provided function, Assume it works
	    public Long getValue(int... indexOfDimension) {
	        //... 
	        return 1L;
	    }
	}
	
	
	    // lengthOfDimension: each dimension's length, assume it is valid: lengthOfDimension[i]>0.
	    public static Long sum(MultiDimensionArray mArray, int[] lengthOfDimension) { 
	    	Long sum = null;
	    	
	    	int numDimensions = lengthOfDimension.length;
	    	int[] indexArray = new int[numDimensions];
			int currentDim = numDimensions - 1;
	 
			while (true)
			{
				for (int i = 0; i < lengthOfDimension[currentDim]; i++) {
					indexArray[currentDim] = i;
					sum = sum + mArray.getValue(indexArray);
				}
				while (currentDim >= 0 && indexArray[currentDim] == lengthOfDimension[currentDim] - 1) {
					currentDim = currentDim-1; 
				}
				if (currentDim < 0) break;
				indexArray[currentDim] = indexArray[currentDim] + 1;
				currentDim = currentDim + 1;
				
				while (currentDim < numDimensions - 1) {
					indexArray[currentDim] = 0;
					currentDim = currentDim + 1;
				}
			}
	    	
	    	return sum;
	    }
}
