/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rearrangelinkedlist;

/**
 * Time Complexity O(n) Space Complexity: O(1)
 * @author souravpalit
 */
public class RearrangeLinkedList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LinkedList zero = new LinkedList(0);
        LinkedList one = new LinkedList(1);
        LinkedList two = new LinkedList(2);
        LinkedList three = new LinkedList(3);
        LinkedList five = new LinkedList(5);
        LinkedList four = new LinkedList(4);
        
        three.next = zero;
        zero.next = five;
        five.next = two;
        two.next = one;
        one.next = four;
        
        int k = 3;
        
        LinkedList head = rearrangeLinkedList(three, k);
        
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
    }
    
    public static LinkedList rearrangeLinkedList(LinkedList head, int k) {
        LinkedList smallerListHead = null;
        LinkedList smallerListTail = null;
        
        LinkedList equalListHead = null;
        LinkedList equalListTail = null;
        
        LinkedList greaterListHead = null;
        LinkedList greaterListTail = null;
        
        LinkedList current = head;
        while (current != null) {
            if (current.value < k) {
                LinkedListPair pair = separateNodes(smallerListHead, smallerListTail, current);
                smallerListHead = pair.head;
                smallerListTail = pair.tail;
            } else if (current.value > k) {
                LinkedListPair pair = separateNodes(greaterListHead, greaterListTail, current);
                greaterListHead = pair.head;
                greaterListTail = pair.tail;
            } else {
                LinkedListPair pair = separateNodes(equalListHead, equalListTail, current);
                equalListHead = pair.head;
                equalListTail = pair.tail;
            }
            
            LinkedList prev = current;
            current = current.next;
            prev.next = null;
        }
        
        LinkedListPair firstPair = connectLists(smallerListHead, smallerListTail, equalListHead, equalListTail);
        LinkedListPair finalPair = connectLists(firstPair.head, firstPair.tail, greaterListHead, greaterListTail);
        return finalPair.head;
    }
    
    
    public static LinkedListPair separateNodes(LinkedList head, LinkedList tail, LinkedList node) {
        LinkedList newHead = head;
        LinkedList newTail = node;
        
        if (head == null) {
            newHead = node;
        } 
        
        if (tail != null) {
            tail.next = node;
        }
        
        return new LinkedListPair(newHead, newTail);
    }
    
    public static LinkedListPair connectLists(LinkedList headOne, LinkedList tailOne,
            LinkedList headTwo, LinkedList tailTwo) {
        LinkedList newHead =  (headOne == null) ? headTwo : headOne;
        LinkedList newTail = (tailTwo == null) ? tailOne : tailTwo;
        
        if (tailOne != null) {
            tailOne.next = headTwo;
        }
        
        return new LinkedListPair(newHead, newTail);
    }
    
    
    static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
    }
    
    static class LinkedListPair {
        
        public LinkedList head;
        public LinkedList tail;
        
        public LinkedListPair(LinkedList head, LinkedList tail) {
            this.head = head;
            this.tail = tail;
        }
    }
}
