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
        
       SinglyLinkedList<String> linkedList = new SinglyLinkedList<String>();
       linkedList.add("1");
       linkedList.add("2");
       linkedList.add("3");
       linkedList.add("4");
       linkedList.add("5");
       
       String value = linkedList.get(2);
       System.out.println("The value is = " + value);
       
       linkedList.add(2,"6");
       value = linkedList.get(2);
       System.out.println("The value is = " + value);
       
       linkedList.add(0,"7");
       value = linkedList.get(2);
       System.out.println("The value is = " + value);
       
       linkedList.add(linkedList.size(), "8");
       value = linkedList.get(linkedList.size());
       System.out.println("The value is = " + value);
       
       linkedList.removeLast();
       value = linkedList.get(linkedList.size());
       System.out.println("The value is = " + value);
       
       linkedList.removeFirst();
       value = linkedList.get(0);
       System.out.println("The value is = " + value);
       
       linkedList.remove(2);
       value = linkedList.get(2);
       System.out.println("The value is = " + value);
       
    }
    
}
