/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minmaxstackconstruction;

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
public class MinMaxStackTest {
    
    public MinMaxStackTest() {
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
     * Test of peek method, of class MinMaxStack.
     */
    @Test
    public void testLogicOfMinMaxStack() {
        MinMaxStack minMaxStack = new MinMaxStack();
        minMaxStack.push(5);
        assertEquals(5, minMaxStack.getMin());
        assertEquals(5, minMaxStack.getMax());
        assertEquals(5, minMaxStack.peek());
        
        minMaxStack.push(7);
        assertEquals(5, minMaxStack.getMin());
        assertEquals(7, minMaxStack.getMax());
        assertEquals(7, minMaxStack.peek());
        
        minMaxStack.push(2);
        assertEquals(2, minMaxStack.getMin());
        assertEquals(7, minMaxStack.getMax());
        assertEquals(2, minMaxStack.peek());
        assertEquals(2, minMaxStack.pop());
        assertEquals(7, minMaxStack.pop());
        assertEquals(5, minMaxStack.getMin());
        assertEquals(5, minMaxStack.getMax());
        assertEquals(5, minMaxStack.peek());
        
    }
    
}
