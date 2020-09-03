package assignment1;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.Timeout;

public class SampleTest {
    @Rule
    public Timeout globalTimeout = Timeout.seconds(2);

    @Test
    public void sampleTest() {
        int[] x = new int[]{-5, -4, -3, -2, -1, 0};
        int[] original = x.clone();
        int n = x.length;

        assertEquals(2, SortTools.find(x, n, -3));
        assertArrayEquals(original, x);
    }

    @Test
    public void sampleTest1() {
        int[] x = new int[]{-5, -4, -3, -2, -1, 0};
        int[] original = x.clone();
        int n = 1;

        assertEquals(-1, SortTools.find(x, n, -3));
        assertArrayEquals(original, x);
    }
    
    @Test
    public void testIsSorted() {
    	//Given Example Tests
    	int[] x = new int[]{1, 3, 3, 7, 2};
    	assertEquals(true, SortTools.isSorted(x, 4));
    	
    	//Test 1
    	int[] x1 = {-999, -700, -350, -350, -101, -50, -20, -10, 0, 11, 20, 33, 45, 87, 70000, 101000};
        assertTrue(SortTools.isSorted(x1, 13));
        
        //Test 2
        int[] x2 = {1, 20, 30, 70, 40, 50};
        assertTrue(SortTools.isSorted(x2, 3));
        assertFalse(SortTools.isSorted(x2, 5));
        
        //Test 3
        int[] x3 = {1};
        assertTrue(SortTools.isSorted(x3, 1));
        assertFalse(SortTools.isSorted(x3, 0));
        
        //Test 4
        int[] x4 = {};
        assertFalse(SortTools.isSorted(x4, 0));   
    }
    
    @Test
    public void testFind() {
    	//Given Example Tests
    	int[] x = new int[]{1, 3, 3, 7, 2};
    	assertEquals(3, SortTools.find(x, 4, 7));
    	System.out.println(SortTools.find(x, 4, 7)); //should be index = 3
    	assertEquals(2, SortTools.find(x, 4, 3));
    	System.out.println(SortTools.find(x, 4, 3)); //should be index = 2
    	assertEquals(0, SortTools.find(x, 3, 1));
    	assertEquals(-1, SortTools.find(x, 4, 5));
    	
    	//Test 2
    	 int[] x2 = {1, 1, 2, 3, 4};
         assertEquals(-1, SortTools.find(x2, 1, 3)); //not found
         assertEquals(0, SortTools.find(x2, 1, 1)); 
         
         //Test 3 
         int[] x3 = {1}; 
         assertEquals(0, SortTools.find(x3, 1, 1));
         
    }
    
    @Test
    public void testCopyAndInsert() {
    	//Given Example Tests
    	int[] x1 = {1, 3, 5, 7};
    	int[] x1Ans = {1, 3, 4, 5};
    	int[] x2 = {1, 3, 3, 7};
    	int[] x2Ans = {1, 3, 3, 7};
    	assertArrayEquals(x1Ans, SortTools.copyAndInsert(x1, 3, 4));
    	assertArrayEquals(x2Ans, SortTools.copyAndInsert(x2, 4, 7));
    	
    	//Test 3: Checks that inserting an already present value does not change array
    	int[] x3 = {1, 1, 2, 3, 4};
    	int[] expected3 = {1, 1, 2, 3};
    	assertArrayEquals(expected3, SortTools.copyAndInsert(x3, 4, 2));
    	
    	//Test 4: General case of inserting a value at the end of the array 
    	int[] x4 = {1, 2, 3, 4};
        int[] expected4 = {1, 2, 3, 4, 5};
        assertArrayEquals(expected4, SortTools.copyAndInsert(x4, 4, 5));
        
        //Test 5: Inserting value at beginning of array 
        int[] x5 = {1, 2, 3, 4, 5};
        int[] expected5 = {0, 1, 2, 3, 4, 5};
        assertArrayEquals(expected5, SortTools.copyAndInsert(x5, 5, 0));
        
        //Test 6: Inserting a negative value 
        int[] x6 = {-1000, -749, -300, -300, -100, -56, -2, -1, 0, 1, 2, 3, 5, 7, 74569, 100000};
        int[] expected6 = {-1000, -749, -300, -300, -200, -100, -56, -2, -1, 0, 1, 2, 3, 5, 7, 74569, 100000};
        assertArrayEquals(expected6, SortTools.copyAndInsert(x6, 16, -200));
        
        //Test 7: the array is of length 1
        int[] x7 = {0};
        int[] expected7 = {-1000, 0};
        assertArrayEquals(expected7, SortTools.copyAndInsert(x7, 1, -1000));   	
        
        //Test 8: the array is of length 1 and n is 0
        int[] x8 = {1};
        int[] expected8 = {7};
        assertArrayEquals(expected8, SortTools.copyAndInsert(x8, 0, 7));
        
        //Test 8: the array is of length 3 and n is 0
        int[] x9 = {1, 5, 7};
        int[] expected9 = {2};
        assertArrayEquals(expected9, SortTools.copyAndInsert(x9, 0, 2));
    }
    
    @Test
    public void testInsertInPlace() {
    	//Given Example Tests
    	int[] x1 = {1, 3, 5, 7};
    	int[] expected1 = {1, 3, 4, 7};
    	SortTools.insertInPlace(x1, 3, 4);
    	assertArrayEquals(expected1, x1);
    	
    	int[] x2 = {1, 3, 3, 7};
    	int[] expected2 = {1, 3, 3, 7};
    	SortTools.insertInPlace(x2, 3, 7);
    	assertArrayEquals(expected2, x2);
    
    	//Test 3: adding 40 
    	int[] x3 = {-1, -1, 2, 3, 5, 8, 13, 900, 901, 902, 903, 904};
        int[] expected3 = {-1, -1, 2, 3, 5, 8, 13, 40, 901, 902, 903, 904};
        SortTools.insertInPlace(x3, 7, 40);
        assertArrayEquals(expected3, x3);
    }
    
    @Test
    public void testInsertSort() {
    	//Given Example Tests
    	int[] x1 = {7, 3, 1, 3};
    	int[] expected1 = {7, 3, 1, 3};
    	SortTools.insertSort(x1, 1);
    	assertArrayEquals(expected1, x1);
    	
    	int[] x2 = {7, 3, 1, 3};
    	int[] expected2 = {1, 3, 7, 3};
    	SortTools.insertSort(x2, 3);
    	assertArrayEquals(expected2, x2);
    	
    	//Test3
    	int[] x3 = {6, 3, 5, 9, -1, 0, 13, 20, 1000, -769, 1};
    	int[] expected3 = {3, 5, 6, 9, -1, 0, 13, 20, 1000, -769, 1};
        SortTools.insertSort(x3, 4);
        assertTrue(SortTools.isSorted(x3, 4));
        assertArrayEquals(expected3, x3);
    }
    
}
