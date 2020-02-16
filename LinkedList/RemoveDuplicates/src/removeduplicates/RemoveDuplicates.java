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
public class RemoveDuplicates {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       SinglyLinkedList<Integer> myLinkedList = new SinglyLinkedList<Integer>();  
       myLinkedList.add(1);
       myLinkedList.add(2);
       myLinkedList.add(3);
       myLinkedList.add(3);
       myLinkedList.add(4);
       myLinkedList.add(5);
       myLinkedList.add(6);
       myLinkedList.add(4);
       myLinkedList.add(2);
       myLinkedList.add(6);
       myLinkedList.add(7);
       myLinkedList.add(7);
       myLinkedList.add(1);
       
       myLinkedList.printList();
       
       myLinkedList.removeDuplicatesNotUsingBuffer();
       System.out.println("After removing duplicates");
       myLinkedList.printList();
       
    }
    
}
