/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package reversesinglylinkedlist;

/**
 *
 * @author mac
 */
public class ReverseSinglyLinkedList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        SinglyLinkedList<String> linkedList = new SinglyLinkedList<String>();
        linkedList.add("1");
        linkedList.add("2");
        linkedList.add("3");
        linkedList.add("4");
        linkedList.add("5");
        
        System.out.println("Before Reverse");
        linkedList.display();
        linkedList.reverse();
        System.out.println("After Reverse");
        linkedList.display();
        
         System.out.println("After adding a new value 6 and 7");
        
        linkedList.add("6");
        linkedList.add("7");
        linkedList.display();
    }
    
}
