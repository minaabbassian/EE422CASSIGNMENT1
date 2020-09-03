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

import java.util.Arrays;

public class SortTools {
	
    /**
      * Return whether the first n elements of x are sorted in non-decreasing
      * order.
      * @param x is the array
      * @param n is the size of the input to be checked
      * @return true if array is sorted
      */
    public static boolean isSorted(int[] x, int n) {
    	//O(n) runtime complexity
    	
    	//check that n > 0, because n could be 0
    	if(n < 1)
    		return false;
    	
    	//check that x.length > 0, because it could be 0
    	else if(x.length < 1)
    		return false;
    	
    	//if the array has one element, or if the rest of the 
    	//elements in the array are already checked 
    	else if(n == 1)
    		return true;
    	
    	else {
    		for(int i = 0; i < n-1; i++) { //O(N) runtime 
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
    	
    	//O(logn) runtime complexity 
    	
    	//Binary Search implementation
    	int l = 0;
    	int r = n; 
    	
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
    	
    	if(l < r) { //right has to be greater than 0
    		int middle = (l + r) / 2;
    		
    		//if v is smaller than the middle element, then
    		//check the left sub-array
    		if(v < x[middle])
    			return binarySearch(x, l, middle, v);
    		
    		//if v is larger than the middle element, then
    		//check the right sub-array
    		else if(v > x[middle])
    			return binarySearch(x, middle + 1, r, v);
    		
    		//if v is present at the middle index
    		else
    			return middle;
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
    	//O(n) runtime complexity
    	
    	//if n = 0, create a new array with just one element, which is v
    	if(n == 0) { //not sure if n can be 0!!!!! CHECK THIS!!!!
    		int[] y = new int[1];
    		y[0] = v;
    		return y; 
    	}
    	
    	//check whether the first n elements of x contain v
    	else if((find(x, n, v)) != -1) 
    		return (Arrays.copyOf(x, n));
    	else { 
    		int[] y = new int[n+1];
    		
    		int i;
    		
    		//place all of the numbers less than v first 
    		for(i = 0; i < n; i++) {
    			if(v > x[i])
    				y[i] = x[i];
    			else 
    				break;
    		}
    		
    		//place v in correct location in the array 
    		y[i] = v;
    		i++;
    		
    		//place all of the numbers greater than v after
    		for(int j = i; j < n+1; j++) {
    			y[j] = x[j-1];
    		}
    		
    		return y; 
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
    	//O(n) runtime complexity 
    	
    	//check whether x contains v within the first n elements 
    	if(find(x, n, v) != -1)
    		return n;
    	
    	else { //x does not contain v within the first n elements 
    		int i;
    		for(i = 0; i < n; i++) {
    			if(v < x[i])
    				break;
    		}
    		
    		//place v in the correct location in the x array
    		x[i] = v;
    		
    		return (n+1);
    	}
    }
    
    
    /**
     * Sort the first n elements of x in-place in non-decreasing order using
     * insertion sort.
     * @param x is the array to be sorted
     * @param n is the number of elements of the array to be sorted
     */
    public static void insertSort(int[] x, int n) {
    	//O(n^2) runtime complexity 
    	
    	//one element, already sorted, so return
    	if(n == 1)
    		return;
    	
    	else {
    		for(int i = 1; i < n; i++) {
    			int current = x[i]; 
    			//comparable values are all values before the current element
    			int j = i - 1; //initially j = 0
    			
    			while((j >= 0) && (x[j] > current)) {
    				//move the larger elements one position up
    				//making space for the swapped element 
    				x[j + 1] = x[j]; 
    				j = j - 1;
    			}
    			//put the smaller current value in its correct location
    			x[j + 1] = current; 
    		}	
    	}	
    }
    
}
