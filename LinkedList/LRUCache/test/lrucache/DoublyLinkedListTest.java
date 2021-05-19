/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lrucache;

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
public class DoublyLinkedListTest {
    
    public DoublyLinkedListTest() {
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

    @Test
    public void testHead() {
        // TODO review the generated test code and remove the default call to fail.
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.setHead(getNode("a", 1));
        Assert.assertEquals("a", doublyLinkedList.head.key);
        Assert.assertEquals(1, doublyLinkedList.tail.value);
        doublyLinkedList.removeTail();
        Assert.assertEquals(null, doublyLinkedList.head);
        Assert.assertEquals(null, doublyLinkedList.tail);
        doublyLinkedList.setHead(getNode("b", 2));
        doublyLinkedList.setHead(getNode("c", 3));
        doublyLinkedList.setHead(getNode("d", 4));
        Assert.assertEquals("d", doublyLinkedList.head.key);
        Assert.assertEquals("b", doublyLinkedList.tail.key);
    }
    
    
    private DoublyLinkedListNode getNode(String key, int value) {
        return new DoublyLinkedListNode(key, value);
    }
}
