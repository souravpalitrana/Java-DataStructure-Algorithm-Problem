/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rightsmallerthan;

import java.util.ArrayList;
import java.util.List;
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
public class RightSmallerThanTest {
    
    public RightSmallerThanTest() {
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
     * Test of main method, of class RightSmallerThan.
     */
    @Test
    public void testMain() {
        int arrayOne [] = {8,5,11,-1,3,4,2};
        
        List<Integer> input = new ArrayList();
        
        for (int i = 0; i < arrayOne.length; i++) {
            input.add(arrayOne[i]);
        }
        
        Integer expected [] = {5,4,4,0,1,1,0};
        
        List<Integer> actual = RightSmallerThan.rightSmallerThan(input);
        
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], actual.get(i));
        }
    }
    
}
