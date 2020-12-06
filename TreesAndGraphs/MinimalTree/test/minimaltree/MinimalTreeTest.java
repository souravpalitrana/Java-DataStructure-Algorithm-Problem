/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minimaltree;

import static minimaltree.MinimalTree.getMinimalBST;
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
public class MinimalTreeTest {
    
    public MinimalTreeTest() {
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
     * Test of main method, of class MinimalTree.
     */
    @Test
    public void testMain() {
        int [] sortedValues  = {1,2,3,4,5,6,7,8,9,10};
        BST bst = getMinimalBST(sortedValues, 0, sortedValues.length -1);
        assertEquals(5, bst.getValue());
        assertEquals(2, bst.getLeftNode().getValue());
        assertEquals(1, bst.getLeftNode().getLeftNode().getValue());
        assertEquals(null, bst.getLeftNode().getLeftNode().getLeftNode());
    }
    
}
