/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package stackqueuewithsinglylinkedlist;

import java.util.EmptyStackException;

/**
 *
 * @author mac
 */
public class Queue <E> {
     // Here we need head to traverse the linked list from starting to lastNode
    private SinglyNode<E> head;
    //Last node will help us to add a new value at the last with out moving the 
    private SinglyNode<E> lastNode;
    //Node count will track the length of the Queue
    private int nodeCount = 0;

   
    /**
     * Initializing head. First time both head and lastNode will be the same
     * @param value 
     */
    private void add(E value) {
        if(head == null) {
            SinglyNode<E> node = new SinglyNode<>(null, value);
            head = node;
            lastNode = node;
        } else {
            SinglyNode<E> node = new SinglyNode<>(null, value);
            lastNode.next = node;
            lastNode = lastNode.next;
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

