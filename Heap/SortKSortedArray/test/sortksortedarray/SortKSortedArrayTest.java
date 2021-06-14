/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortksortedarray;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author souravpalit
 */
public class SortKSortedArrayTest {
    
    public SortKSortedArrayTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of main method, of class SortKSortedArray.
     */
    @Test
    public void testSortKSortedArray() {
        int [] kSortedArray = {3, 2, 1, 5, 4, 7, 6, 5};
        int k = 3;
        int [] expectedArray = {1, 2, 3, 4, 5, 5, 6, 7};
        int [] actualArray = SortKSortedArrayProgram.sortKSortedArray(kSortedArray, k);
        assertArrayEquals(expectedArray, actualArray);
    }
    
}
