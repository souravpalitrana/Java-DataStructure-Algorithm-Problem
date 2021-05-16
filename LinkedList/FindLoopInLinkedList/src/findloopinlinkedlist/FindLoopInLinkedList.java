/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package findloopinlinkedlist;

/**
 * Time: O(n) and Space: O(1)
 * @author souravpalit
 */
public class FindLoopInLinkedList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LinkedList zero = new LinkedList(0);
        LinkedList one = new LinkedList(1);
        LinkedList two = new LinkedList(2);
        LinkedList three = new LinkedList(3);
        LinkedList four = new LinkedList(4);
        LinkedList five = new LinkedList(5);
        LinkedList six = new LinkedList(6);
        LinkedList seven = new LinkedList(7);
        LinkedList eight = new LinkedList(8);
        LinkedList nine = new LinkedList(9);
        
        zero.next = one;
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = six;
        six.next = seven;
        seven.next = eight;
        eight.next = nine;
        nine.next = four;
        
        LinkedList loopedNode = findLoop(zero);
        System.out.println(loopedNode.value);
    }
    
    public static LinkedList findLoop(LinkedList head) {
        LinkedList fastPointer = head.next.next;
        LinkedList slowPointer = head.next;
        
        while (fastPointer != slowPointer) {
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;
        }
        
        slowPointer = head;
        
        while (fastPointer != slowPointer) {
            fastPointer = fastPointer.next;
            slowPointer = slowPointer.next;
        }
        
        return fastPointer;
    }
    
    static class LinkedList {

        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
    }
    
}
