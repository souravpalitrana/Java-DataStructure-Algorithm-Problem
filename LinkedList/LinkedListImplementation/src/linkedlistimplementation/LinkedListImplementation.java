/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package linkedlistimplementation;

import java.util.LinkedList;
import javafx.scene.Node;

/**
 *
 * @author mac
 */
public class LinkedListImplementation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
       SinglyLinkedList<Integer> myLinkedList = new SinglyLinkedList<Integer>();  
       myLinkedList.add(2);
       myLinkedList.add(4);
       myLinkedList.add(5);
       myLinkedList.add(6);
       
       myLinkedList.printList();  
       
       myLinkedList.add(4, 1);
       System.out.println("After Adding new value(1) at index 4");
       myLinkedList.printList();
       
       myLinkedList.add(5, 7);
       System.out.println("After Adding new value(7) at index 5");
       myLinkedList.printList();
       
       myLinkedList.add(2, 3);
       System.out.println("After Adding new value(3) at index 2");
       myLinkedList.printList();
       
       myLinkedList.remove(1);
       System.out.println("After removing value(1)");
       myLinkedList.printList();
       
       myLinkedList.remove(4);
       System.out.println("After removing value(4)");
       myLinkedList.printList();
       
       myLinkedList.remove(7);
       System.out.println("After removing value(7)");    
       myLinkedList.printList();
       
       myLinkedList.add(9);
       System.out.println("After adding value(9)");    
       myLinkedList.printList();
       
       myLinkedList.removeAt(2);
       System.out.println("After removing value at index 2");   
       myLinkedList.printList();
       
       myLinkedList.removeAt(0);
       System.out.println("After removing value from first");   
       myLinkedList.printList();
       
       myLinkedList.removeAt(myLinkedList.size() -1);
       System.out.println("After removing value from last");   
       myLinkedList.printList();
       
       myLinkedList.removeAt(myLinkedList.size() -1);
       System.out.println("After removing value from last");   
       myLinkedList.printList();
       
       myLinkedList.removeAt(myLinkedList.size() -1);
       System.out.println("After removing value from last");   
       myLinkedList.printList();
       
    }
    
}
