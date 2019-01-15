/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package stackwithsinglylinkedlist;

/**
 *
 * @author mac
 */
public class StackWithSinglyLinkedList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Stack<String> myStack = new Stack<String>();
        
        myStack.push("1");
        myStack.push("2");
        myStack.push("3");
        myStack.push("4");
        myStack.push("5");
        
        myStack.pop();
        
        String value = myStack.peek();
        
        System.out.println("Peek Value is = " + value);
        
        myStack.display();
         
    }
    
}
