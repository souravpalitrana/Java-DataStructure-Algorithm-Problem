/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package removeduplicates;

/**
 *
 * @author souravpalit
 */
public class RemoveDuplicateIfSorted {
    
    public static void main(String[] args) {
       SinglyLinkedList<Integer> myLinkedList = new SinglyLinkedList<Integer>();  
       // Considered all values are sorted
       myLinkedList.add(1);
       myLinkedList.add(1);
       myLinkedList.add(1);
       myLinkedList.add(3);
       myLinkedList.add(4);
       myLinkedList.add(4);
       myLinkedList.add(5);
       myLinkedList.add(6);
       myLinkedList.add(6);
       
       myLinkedList.printList();
       
       myLinkedList.removeDuplicatesWhenValueSorted();
       System.out.println("After removing duplicates");
       myLinkedList.printList();
       
       myLinkedList.add(7);
       myLinkedList.add(8);
       myLinkedList.add(8);
       myLinkedList.add(9);
       
       myLinkedList.removeDuplicatesWhenValueSorted();
       System.out.println("After removing duplicates again");
       myLinkedList.printList();
       
    }
    
    
}
