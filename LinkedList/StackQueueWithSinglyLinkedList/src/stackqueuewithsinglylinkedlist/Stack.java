/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package stackqueuewithsinglylinkedlist;

import java.util.EmptyStackException;

/**
 *
 * @author SouravPalit
 */
public class Stack<E> {
    
    private SinglyNode<E> head;
    //Node count will track the length of the stack
    private int nodeCount = 0;

   
    /**
     * Initializing head. First time both head and lastNode will be the same
     * @param value 
     */
    private void add(E value) {
        if(head == null) {
            SinglyNode<E> node = new SinglyNode<>(null, value);
            head = node;
        } else {
            SinglyNode<E> newNode = new SinglyNode<>(null, value);
            SinglyNode<E> tempNode = head;
            newNode.next = head;
            head = newNode;
        }
        nodeCount++;
    }
    
    public void removeFirst() {
        head = head.next;
        nodeCount--;
    }
    
    public void push(E value) {
        add(value);
    }
    
    public void pop() {
        if(nodeCount != 0) {
            removeFirst();
        }
    }
    
    public E peek() throws EmptyStackException {
        if(nodeCount > 0) {
            return head.getItem();
        } else {
           
            throw new EmptyStackException();
        }
    }
    
    public void display() {
        if(head == null) return;
        SinglyNode<E> tempNode = head;
        
        while(!tempNode.isLastNode()) {
            System.out.println(tempNode.item);
            tempNode = tempNode.getNext();
        } 
        // Printing the last item
        System.out.println(tempNode.item);
    }
    
}
