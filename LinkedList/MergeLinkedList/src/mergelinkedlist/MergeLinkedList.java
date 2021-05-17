/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mergelinkedlist;

/**
 * Time complexity O(m+n) Space Complexity O(1)
 * @author souravpalit
 */
public class MergeLinkedList {

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
        LinkedList ten = new LinkedList(10);
        
        two.next = six;
        six.next = seven;
        seven.next = eight;
        
        one.next = three;
        three.next = four;
        four.next = five;
        five.next = nine;
        nine.next = ten;
        
        LinkedList mergeHead = mergeLinkedLists(two, one);
        
        while (mergeHead != null) {
            System.out.print(mergeHead.value + " ");
            mergeHead = mergeHead.next;
        }
    }
    
    public static LinkedList mergeLinkedLists(LinkedList headOne, LinkedList headTwo) {
        LinkedList prev = null;
        LinkedList first = headOne;
        LinkedList second = headTwo;   
        
        while (first != null || second != null) {
            // When both list has node
            if (first != null && second != null) {
                if (first.value < second.value) {
                    prev = first;
                    first = first.next;
                } else {
                    if (prev != null) {
                        // Previous will be null when it is head and first list 
                        // head is smaller
                        prev.next = second;
                    } 
                    prev = second;
                    second = second.next;
                    prev.next = first;
                }
            } else if (first != null) {
                // When second list is null that means we need to move forward to
                // first list
                prev = first;
                first = first.next;
            } else {
                // When first list null but second list has value. So in that 
                // case we need to add second node to first node
                prev.next = second;
                prev = second;
                second = second.next;
            }
        }
         
        return (headOne.value < headTwo.value) ? headOne : headTwo;
    }
    
    
    public static class LinkedList {

        int value;
        LinkedList next;

        LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }
    
}
