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
    	int n = 4; 
    	assertEquals(true, SortTools.isSorted(x, n));
    	
    	//Test 1
    	int[] x1 = {-1000, -749, -300, -300, -100, -56, -2, -1, 0, 1, 2, 3, 5, 7, 74569, 100000};
        assertTrue(SortTools.isSorted(x1, 13));
        
        //Test 2
        int[] k = {1, 2, 3, 7, 4, 5};
        assertTrue(SortTools.isSorted(k, 3));
        
        //Test 3
        int[] z = {1};
        assertTrue(SortTools.isSorted(z, 1));
        assertFalse(SortTools.isSorted(z, 0));
        
        //Test 4
        int[] j = {};
        assertFalse(SortTools.isSorted(j, 0));   
    }
    
    @Test
    public void testFind() {
    	//Given Example Tests
    	int[] x = new int[]{1, 3, 3, 7, 2};
    	int n = 4;
    	int v = 7;
    	assertEquals(3, SortTools.find(x, n, v));
    	assertEquals(-1, SortTools.find(x, n, 5));
    	
    	//Test 2
    	 int[] x1 = {1, 1, 2, 3, 4};
         assertEquals(-1, SortTools.find(x1, 1, 3));
         assertEquals(0, SortTools.find(x1, 1, 1));
         
         //Test 3 
         int[] z = {1};
         assertEquals(0, SortTools.find(z, 1, 1));
         
    }
    
    @Test
    public void testCopyAndInsert() {
    	int n = 3;
    	int v1 = 3;
    	int v2 = 7;
    	int[] x1 = {1, 3, 5, 7};
    	int[] x1Ans = {1, 3, 5};
    	
    	int[] x2 = new int[]{1, 3, 3, 7};
    	int[] x2Ans = new int[]{1, 3, 3, 7};
    	
    	assertArrayEquals(x1Ans, SortTools.copyAndInsert(x1, n, v1));
    	//assertEquals(x2Ans, SortTools.copyAndInsert(x2, n, v2));
    	
    }
}
