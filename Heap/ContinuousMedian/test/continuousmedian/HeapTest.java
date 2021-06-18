/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package continuousmedian;

import java.util.Arrays;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author souravpalit
 */
public class HeapTest {
    
    public HeapTest() {
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
     * Test of peek method, of class Heap.
     */
    @Test
    public void test() {
        List<Integer> list = Arrays.asList(48, 12, 24, 7, 8, -5, 24, 391, 24, 56, 2, 6, 8, 41);
        Heap minHeap = new Heap(Heap.MIN_HEAP, list);
        List<Integer> expected = Arrays.asList(-5, 2, 6, 7, 8, 8, 24, 391, 24, 56, 12, 24, 48, 41);
        Assert.assertArrayEquals(expected.toArray(), minHeap.heap.toArray());
        Heap maxHeap = new Heap(Heap.MAX_HEAP, list);
        Assert.assertArrayEquals(expected.toArray(), maxHeap.heap.toArray());
    }

  
}
