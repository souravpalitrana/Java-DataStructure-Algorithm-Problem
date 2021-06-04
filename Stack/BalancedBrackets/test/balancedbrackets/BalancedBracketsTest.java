/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package balancedbrackets;


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
public class BalancedBracketsTest {
    
    public BalancedBracketsTest() {
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
     * Test of main method, of class BalancedBrackets.
     */
    @Test
    public void testMain() {
        assertEquals(true, BalancedBrackets.isBalancedBrackets("([])(){}(())()()"));
        assertEquals(true, BalancedBrackets.isBalancedBrackets("(((({([])}))))"));
        assertEquals(false, BalancedBrackets.isBalancedBrackets("(((({([])})))}"));
        assertEquals(true, BalancedBrackets.isBalancedBrackets("(agwgg)([ghhheah%&@Q])"));
        assertEquals(true, BalancedBrackets.isBalancedBrackets("{}gawgw()"));
    }
    
}
