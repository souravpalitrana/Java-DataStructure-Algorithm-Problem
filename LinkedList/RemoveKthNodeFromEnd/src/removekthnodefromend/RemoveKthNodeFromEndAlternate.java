/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package removekthnodefromend;

/**
 * Considering at least two nodes in the linked list
 * Time Complexity O(n) and Space Complexity O(1)
 * @author souravpalit
 */
public class RemoveKthNodeFromEndAlternate {

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
        
        int k = 10;
        
        LinkedList node = zero;
        removeKthNodeFromEnd(zero, k);
        LinkedList current = zero;
	while (current != null) {
            System.out.print(current.value +  " ");
            current = current.next;
        }
    }
    
    public static void removeKthNodeFromEnd(LinkedList head, int k) {
        LinkedList first = head;
        LinkedList second = head;
        
        // move the second pointer to k position ahead
        int count = 1;
        while (count <= k) {
            second = second.next;
            count++;
        }
        
        // When k = n then it is head that we need to delete and at that time second
        // will be at null node
        if (second == null) {
            // Considering linked list has at least two nodes. Otherwise if only
            // one node then head.next.value will through error
            head.value = head.next.value;
            head.next = head.next.next;
        } else {
            // Now move both first and second pointer until second pointer reach 
            // to end
            while (second.next != null) {
                first = first.next;
                second = second.next;
            }
            
            first.next = first.next.next;
        }
    }
    
    static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
    }
    
}
