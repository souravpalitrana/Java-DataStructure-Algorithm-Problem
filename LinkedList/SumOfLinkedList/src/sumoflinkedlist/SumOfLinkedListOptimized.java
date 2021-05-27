/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sumoflinkedlist;

/**
 * Time Complexity O(max(m,n)) and Space Complexity O(max(m,n)) where m and n are
 * the length of first and second linked list respectively. 
 * @author souravpalit
 */
public class SumOfLinkedListOptimized {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LinkedList two = new LinkedList(2);
        LinkedList four = new LinkedList(4);
        LinkedList seven = new LinkedList(7);
        LinkedList one = new LinkedList(1);
        
        two.next = four;
        four.next = seven;
        seven.next = one;
        
        LinkedList nine = new LinkedList(9);
        LinkedList four2 = new LinkedList(4);
        LinkedList five = new LinkedList(5);
        
        nine.next = four2;
        four2.next = five;
    
        LinkedList sum = sumOfLinkedLists(two, nine);
        
        while (sum != null) {
            System.out.print(sum.value +  " ");
            sum = sum.next;
        }
    }
    
    public static LinkedList sumOfLinkedLists(LinkedList linkedListOne, LinkedList linkedListTwo) {
        int carry = 0;
        LinkedList node = null;
        LinkedList head = null;
        
        // When right most value is grater than 10 but loop will not execute next
        // because both the linkedlist ended so the carry will remain.
        // For example 1999 and 1111 thats why carry != 0 condition for extra loop
        while(linkedListOne != null || linkedListTwo != null || carry != 0) {
            int value = 0;
            int firstNumber = (linkedListOne != null) ? linkedListOne.value : 0;
            int secondNumber = (linkedListTwo != null) ? linkedListTwo.value : 0;
            value = firstNumber + secondNumber + carry;
            carry = value / 10;
            value = value % 10;
            
            linkedListOne = (linkedListOne != null) ? linkedListOne.next : null;
            linkedListTwo = (linkedListTwo != null) ? linkedListTwo.next : null;
            
            // Initially our new linkedList needs to initialize. So we are checking
            // if it is null. As we set initial value null so it will initialize 
            // the first as linkedlist head;
            if (head == null) {
                head = new LinkedList(value);
                node = head;
            } else {
                node.next = new LinkedList(value);
                node = node.next;
            }
        }
            
        return head;
    }
    
    public static class LinkedList {

        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }
    
}
