/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlistpalindrome;

/**
 * Time: O(n) Space: O(1)
 * @author souravpalit
 */
public class LinkedListPalindromeOptimized {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LinkedList one = new LinkedList(1);
        LinkedList two = new LinkedList(2);
        LinkedList three = new LinkedList(3);
        LinkedList two2 = new LinkedList(2);
        LinkedList one2 = new LinkedList(1);
        
        one.next = two;
        two.next = three;
        three.next = two2;
        two2.next = one2;
        System.out.println("It is palindrome: " + isPalindrome(one));
    }
    
    public static boolean isPalindrome(LinkedList head) {
        LinkedList slow = head;
        LinkedList fast = head;
        
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        LinkedList reversedHead = reverseLinkedList(slow);
        
        while (reversedHead != null) {
            if (head.value != reversedHead.value) {
                return false;
            }
            
            head = head.next;
            reversedHead = reversedHead.next;
        }
        
        return true;
    }
    
    private static LinkedList reverseLinkedList(LinkedList head) {
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
    
    static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
    }
}
