/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bst;

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
public class BSTOperationTest {
    
    public BSTOperationTest() {
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
     * Test of main method, of class BSTOperation.
     */
    @Test
    public void testMain() {
        int [] values =  {5,15,2,5,13,22,1,14,12};
        
        BST bst = new BST(10);
        
        for (int i = 0; i < values.length; i++) {
            bst.insert(values[i]);
        }
        
        for (int i = values.length - 1; i >= 0; i--) {
            assertEquals(true, bst.contains(values[i]));
        }
        
        bst.remove(10);
        
        assertEquals(12, bst.value);
        bst.remove(12);
        assertEquals(false, bst.contains(12));
        
    }
    
}
