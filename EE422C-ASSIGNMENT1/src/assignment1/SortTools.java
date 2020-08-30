// SortTools.java
/*
 * EE422C Project 1 submission by
 * Mina Abbassian
 * mea2947
 * 16170
 * Fall 2020
 * Slip days used:
 */

package assignment1;

public class SortTools {
	
    /**
      * Return whether the first n elements of x are sorted in non-decreasing
      * order.
      * @param x is the array
      * @param n is the size of the input to be checked
      * @return true if array is sorted
      */
    public static boolean isSorted(int[] x, int n) {
        // stub only, you write this!
        // TODO: complete it
    	
    	//O(n) runtime complexity
    	
    	//check that n > 0
    	if(n < 1)
    		return false;
    	
    	//check that x.length > 0
    	else if(x.length < 0)
    		return false;
    	
    	//if the array has one element, or if the rest of the 
    	//elements in the array are already checked 
    	else if(n == 1)
    		return true;
    	
    	else {
    		for(int i = 0; i < n-1; i++) {
    			if(x[i] > x[i+1]) 
    				return false;
    		}
    		
    		return true;
    	}
    	
   }

    
    /**
     * Return an index of value v within the first n elements of x.
     * @param x is the array
     * @param n is the size of the input to be checked
     * @param v is the value to be searched for
     * @return any index k such that k < n and x[k] == v, or -1 if no such k exists
     */
    public static int find(int[] x, int n, int v) {
        // stub only, you write this!
        // TODO: complete it
    	
    	//O(logn) runtime complexity 
    	
    	//Binary Search implementation
    	int l = 0;
    	int r = n-1; 
    	
    	return (binarySearch(x, l, r, v));
    }
    	
    
    //Helper Method for find() method 
    /**
     * Binary Search Implementation
     * @param x is the array
     * @param l is the left index 
     * @param r is the right index
     * @param v is the value to be searched for 
     * @return any index k such that k < n and x[k] == v, or -1 if no such k exists
     */
    private static int binarySearch(int[] x, int l, int r, int v) {
    	
    	if(r >= l) {
    		int middle = l + (r - 1) / 2;
    		
    		//if v is present at the middle index
    		if(x[middle] == v)
    			return middle;
    		
    		//if v is smaller than the middle element, then
    		//check the left sub-array
    		if(v < x[middle])
    			return binarySearch(x, l, middle - 1, v);
    		
    		//if v is larger than the middle element, then
    		//check the right sub-array
    		if(v > x[middle])
    			return binarySearch(x, middle + 1, r, v);
    		
    	}
    	
    	//if v is not present in the array
    	return -1;
    	
    	
    }

    /**
     * Return a sorted, newly created array containing the first n elements of x
     * and ensuring that v is in the new array.
     * @param x is the array
     * @param n is the number of elements to be copied from x
     * @param v is the value to be added to the new array if necessary
     * @return a new array containing the first n elements of x as well as v
     */
    public static int[] copyAndInsert(int[] x, int n, int v) {
        // stub only, you write this!
        // TODO: complete it
    	
    	//O(n) runtime complexity
    	
    	if((find(x, n, v)) != -1) {
    		int y[] = new int[n];
    		//copy elements of x[] to y[]
    		for(int i = 0; i < n; i++)
    			y[i] = x[i];
    		
    		//change y[] to verify that y[] is different from x[]
    		//y[0]++;
    		
    		return y;
    	}
    	
    	else {
    		return x;
    	}
    	
    }

    
    /**
     * Insert the value v in the first n elements of x if it is not already
     * there, ensuring those elements are still sorted.
     * @param x is the array
     * @param n is the number of elements in the array
     * @param v is the value to be added
     * @return n if v is already in x, otherwise returns n+1
     */
    public static int insertInPlace(int[] x, int n, int v) {
        // stub only, you write this!
        // TODO: complete it
        return -1;
    }

    /**
     * Sort the first n elements of x in-place in non-decreasing order using
     * insertion sort.
     * @param x is the array to be sorted
     * @param n is the number of elements of the array to be sorted
     */
    public static void insertSort(int[] x, int n) {
        // stub only, you write this!
        // TODO: complete it
    }
}
