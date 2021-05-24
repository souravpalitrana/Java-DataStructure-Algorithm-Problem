/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ziplinkedlist;

/**
 * Time Complexity: O(n) Space Complexity: O(1)
 * @author souravpalit
 */
public class ZipLinkedList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LinkedList one = new LinkedList(1);
        LinkedList two = new LinkedList(2);
        LinkedList three = new LinkedList(3);
        LinkedList four = new LinkedList(4);
        LinkedList five = new LinkedList(5);
        LinkedList six = new LinkedList(6);
        
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = six;
        
        LinkedList zippedHead = zipLinkedList(one);
        while (zippedHead != null) {
            System.out.print(zippedHead.value + " ");
            zippedHead = zippedHead.next;
        }
    }
    
    public static LinkedList zipLinkedList(LinkedList head) {
        // If linked list has only one or two value than ziping does not change
        // the list so we are returning it.
        if (head.next == null || head.next.next == null) {
            return head;
        }
        
        LinkedList middleNode = getMiddleOfTheLinkedList(head);
        LinkedList secondHalfHead = middleNode.next;
        middleNode.next = null; 
        LinkedList reversedSecondHalfHead = reverseLinkedList(secondHalfHead);
        return interWeaveLinkedLists(head, reversedSecondHalfHead);
    }
    
    public static LinkedList getMiddleOfTheLinkedList(LinkedList head) {
        LinkedList slow = head;
        LinkedList fast = head;
        
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        return slow;
    }
    
    public static LinkedList reverseLinkedList(LinkedList head) {
        LinkedList prev = null;
        LinkedList current = head;
        
        while (current != null) {
            LinkedList next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        
        return prev;
    }
    
    public static LinkedList interWeaveLinkedLists(LinkedList head1, LinkedList head2) {
        LinkedList head = head1;
        while (head2 != null) {
            LinkedList temp1 = head1.next;
            LinkedList temp2 = head2.next;
            head1.next = head2;
            head2.next = temp1;
            head1 = temp1;
            head2 = temp2;
        }
        
        return head;
    }
    
    static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
    }   
}
