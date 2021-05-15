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
public class RemoveKthNodeFromEnd {

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
    
        removeKthNodeFromEnd(zero, k);
        LinkedList current = zero;
        
	while (current != null) {
            System.out.print(current.value +  " ");
            current = current.next;
        }
    }
    
    public static void removeKthNodeFromEnd(LinkedList head, int k) {
        LinkedList node = head;
        int totalNode = getNodeCount(head);
        int nodeToRemove = totalNode - k;

        if (nodeToRemove == 0) {
            // Head node
            node.value = node.next.value;
            node.next = node.next.next;
        } else {
            int currentPosition = 1;
            while (node != null && currentPosition++ != nodeToRemove) {
                node = node.next;
            }

            node.next = node.next.next;
        }
    }
    
    public static int getNodeCount(LinkedList node) {
        int count = 0;
        while (node != null) {
            count++;
            node = node.next;
        }

        return count;
    }
    
    static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
    }  
}
