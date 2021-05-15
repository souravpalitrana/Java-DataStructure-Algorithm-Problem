/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doublylinkedlistconstruction;

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
    DoublyLinkedList linkedList;
    Node one, two, three, three2, three3, four, five, six, seven;
    
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
        linkedList = new DoublyLinkedList();
        one = new Node(1);
        two = new Node(2);
        three = new Node(3);
        three2 = new Node(3);
        three3 = new Node(3);
        four = new Node(4);
        five = new Node(5);
        six = new Node(6);
        seven = new Node(7);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testCase1() {
        bindNodes(one, two);
        bindNodes(two, three);
        bindNodes(three, four);
        bindNodes(four, five);
        
        linkedList.head = one;
        linkedList.tail = five;
        
        linkedList.setHead(four);
        Assert.assertArrayEquals(new int [] {4,1,2,3,5}, linkedList.getValues());
        linkedList.setTail(six);
        Assert.assertArrayEquals(new int [] {4,1,2,3,5,6}, linkedList.getValues());
        linkedList.insertBefore(six, three);
        Assert.assertArrayEquals(new int [] {4,1,2,5,3,6}, linkedList.getValues());
        linkedList.insertAfter(six, three2);
        Assert.assertArrayEquals(new int [] {4,1,2,5,3,6,3}, linkedList.getValues());
        linkedList.insertAtPosition(1, three3);
        Assert.assertArrayEquals(new int [] {3,4,1,2,5,3,6,3}, linkedList.getValues());
        linkedList.removeNodesWithValue(3);
        Assert.assertArrayEquals(new int [] {4,1,2,5,6}, linkedList.getValues());
        linkedList.remove(two);
        Assert.assertArrayEquals(new int [] {4,1,5,6}, linkedList.getValues());
        Assert.assertEquals(true, linkedList.containsNodeWithValue(5));
    }
    
    @Test
    public void testCase2() {
        linkedList.setHead(one);
        Assert.assertArrayEquals(new int [] {1}, linkedList.getValues());
    }
    
    @Test
    public void testCase3() {
        linkedList.setTail(one);
        Assert.assertArrayEquals(new int [] {1}, linkedList.getValues());
    }
    
    @Test
    public void testCase4() {
        linkedList.insertAtPosition(1, one);
        Assert.assertArrayEquals(new int [] {1}, linkedList.getValues());
    }
    
    @Test
    public void testCase5() {
        linkedList.setHead(one);
        linkedList.setTail(two);
        Assert.assertArrayEquals(new int [] {1, 2}, linkedList.getValues());
        Assert.assertEquals(1, linkedList.head.value);
        Assert.assertEquals(2, linkedList.tail.value);
    }
    
    @Test
    public void testCase6() {
        linkedList.setHead(one);
        linkedList.setHead(two);
        Assert.assertArrayEquals(new int [] {2,1}, linkedList.getValues());
        Assert.assertEquals(1, linkedList.tail.value);
        Assert.assertEquals(2, linkedList.head.value);
    }
    
    @Test
    public void testCase7() {
        linkedList.setHead(one);
        linkedList.insertAfter(one, two);
        Assert.assertArrayEquals(new int [] {1,2}, linkedList.getValues());
        Assert.assertEquals(1, linkedList.head.value);
        Assert.assertEquals(2, linkedList.tail.value);
    }
    
    @Test
    public void testCase8() {
        linkedList.setHead(one);
        linkedList.insertBefore(one, two);
        Assert.assertArrayEquals(new int [] {2,1}, linkedList.getValues());
        Assert.assertEquals(1, linkedList.tail.value);
        Assert.assertEquals(2, linkedList.head.value);
    }
    
    @Test
    public void testCase9() {
        linkedList.setHead(one);
        linkedList.insertAfter(one, two);
        linkedList.insertAfter(two, three);
        linkedList.insertAfter(three, four);
        Assert.assertArrayEquals(new int [] {1,2,3,4}, linkedList.getValues());
        Assert.assertEquals(1, linkedList.head.value);
        Assert.assertEquals(4, linkedList.tail.value);
    }
    
    @Test
    public void testCase10() {
        linkedList.setTail(one);
        linkedList.insertBefore(one, two);
        linkedList.insertBefore(two, three);
        linkedList.insertBefore(three, four);
        Assert.assertArrayEquals(new int [] {4,3,2,1}, linkedList.getValues());
        Assert.assertEquals(4, linkedList.head.value);
        Assert.assertEquals(1, linkedList.tail.value);
    }
    
    @Test
    public void testCase11() {
        linkedList.setHead(one);
        linkedList.insertAfter(one, two);
        linkedList.insertAfter(two, three);
        linkedList.insertAfter(three, four);
        linkedList.setTail(one);
        Assert.assertArrayEquals(new int [] {2,3,4,1}, linkedList.getValues());
        Assert.assertEquals(2, linkedList.head.value);
        Assert.assertEquals(1, linkedList.tail.value);
    }
    
    @Test
    public void testCase12() {
        linkedList.setTail(one);
        linkedList.insertBefore(one, two);
        linkedList.insertBefore(two, three);
        linkedList.insertBefore(three, four);
        linkedList.setHead(one);
        Assert.assertArrayEquals(new int [] {1,4,3,2}, linkedList.getValues());
        Assert.assertEquals(1, linkedList.head.value);
        Assert.assertEquals(2, linkedList.tail.value);
    }
    
    @Test
    public void testCase13() {
        linkedList.setHead(one);
        linkedList.insertAfter(one, two);
        linkedList.insertAfter(two, three);
        linkedList.insertAfter(three, four);
        linkedList.insertAfter(two, one);
        linkedList.insertBefore(three, four);
        Assert.assertArrayEquals(new int [] {2,1,4,3}, linkedList.getValues());
        Assert.assertEquals(2, linkedList.head.value);
        Assert.assertEquals(3, linkedList.tail.value);
    }
    
    @Test
    public void testCase14() {
        linkedList.setHead(one);
        linkedList.insertAfter(one, two);
        linkedList.insertAfter(two, three);
        linkedList.insertAfter(three, four);
        linkedList.insertAfter(four, five);
        linkedList.insertAfter(five, six);
        linkedList.insertAfter(six, seven);
        linkedList.insertAtPosition(7, one);
        Assert.assertArrayEquals(new int [] {2,3,4,5,6,1,7}, linkedList.getValues());
        linkedList.insertAtPosition(1, one);
        linkedList.insertAtPosition(2, one);
        linkedList.insertAtPosition(3, one);
        linkedList.insertAtPosition(4, one);
        linkedList.insertAtPosition(5, one);
        linkedList.insertAtPosition(6, one);
        //2,3,4,5,1,6,7
        Assert.assertArrayEquals(new int [] {2,3,4,5,1,6,7}, linkedList.getValues());
        Assert.assertEquals(2, linkedList.head.value);
        Assert.assertEquals(7, linkedList.tail.value);
    }
    
    @Test
    public void testCase15() {
        linkedList.setHead(one);
        linkedList.remove(one);
        Assert.assertEquals(null, linkedList.head);
        Assert.assertEquals(null, linkedList.tail);
    }
    
    private static void bindNodes(Node node1, Node node2) {
        node1.next = node2;
        node2.prev = node1;
    }
}
