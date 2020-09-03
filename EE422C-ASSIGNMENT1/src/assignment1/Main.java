/*
 * This file is how you might test out your code.  Don't submit this, and don't
 * have a main method in SortTools.java.
 */

package assignment1;

public class Main {
    public static void main(String [] args) {
        // call your test methods here
        // SortTools.isSorted() etc.
    	
    	int[] x1 = {1, 3, 5, 7};
    	System.out.println(SortTools.insertInPlace(x1, 3, 4));
    	System.out.println(SortTools.insertInPlace(x1, 3, 3));
    	
    	int[] x3 = {-1, -1, 2, 3, 5, 8, 13, 900, 901, 902, 903, 904};
    	System.out.println(SortTools.insertInPlace(x3, 7, 40));
    }
}
