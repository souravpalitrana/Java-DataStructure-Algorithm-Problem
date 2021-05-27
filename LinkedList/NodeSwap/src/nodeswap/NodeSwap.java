/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nodeswap;

/**
 *
 * @author souravpalit
 */
public class NodeSwap {

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
        /*two.next = three;
        three.next = four;
        four.next = five;*/
        
        LinkedList swapedHead = nodeSwap(zero);
        
        while (swapedHead != null) {
            System.out.println(swapedHead.value + " ");
            swapedHead = swapedHead.next;
        }
        
    }
    
    public static LinkedList nodeSwap(LinkedList head) {
        LinkedList newHead = head;
        LinkedList current = head;
        LinkedList prev = null;
        
        while (current != null && current.next != null) {
            LinkedList nextTarget = current.next.next;
            LinkedList next = current.next;
            next.next = current;
            current.next = nextTarget;
            
            if (prev == null) {
                newHead = next;
            } else {
                prev.next = next;
            }
            
            prev = current;
            current = nextTarget;
        }
        
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
