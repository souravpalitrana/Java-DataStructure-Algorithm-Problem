/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shiftlinkedlist;

/**
 * Time Complexity: O(n) Space Complexity: O(1)
 * @author souravpalit
 */
public class ShiftLinkedList {

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
        
        zero.next = one;
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        int k = -1;
        LinkedList shiftedList = shiftLinkedList(zero, k);
        while (shiftedList != null) {
            System.out.print(shiftedList.value + " ");
            shiftedList = shiftedList.next;
        }
        
    }
    
    public static LinkedList shiftLinkedList(LinkedList head, int k) {
        int count = 0;
        LinkedList node = head;
        LinkedList tail = null;
        while (node != null) {
            count++;
            if (node.next != null) {
                tail = node.next;
            }
            node = node.next;
        }
        
        int offset = Math.abs(k) % count;
        if (offset == 0) return head;
        
        int shiftingPosition = (k > 0) ? count - offset : offset;
        
        LinkedList newTail = head;
        for (int i = 1; i < shiftingPosition; i++) {
            newTail = newTail.next;
        }
        
        LinkedList newHead = newTail.next;
        newTail.next = null;
        tail.next = head;
        
        return newHead;
    }
    
    static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
    }   
}
