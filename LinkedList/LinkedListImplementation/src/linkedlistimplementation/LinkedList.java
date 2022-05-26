/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlistimplementation;

/**
 *
 * @author souravpalit
 */
public class LinkedList {

    public SinglyNode<Integer> head;
    public int size = 0;

    public LinkedList() {
        head = new SinglyNode(null, Integer.MIN_VALUE);
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        
        SinglyNode<Integer> current = head.next;
        
        while (index > 0) {
            current = current.next;
            index--;
        }
        
        return current.value;
    }

    public void addAtHead(int val) {
        add(0, val);
    }

    public void addAtTail(int val) {
        add(size, val);
    }

    public void addAtIndex(int index, int val) {
        add(index, val);
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        
        SinglyNode<Integer> current = head;
        
        while (index > 0) {
            current = current.next;
            index--;
        }
        
        SinglyNode<Integer> tempNode = current.next;
        current.next = current.next.next;
        tempNode = null;
        size--;
    }

    private void add(int index, int val) {
        if (index < 0 || index > size) {
            return;
        }
        SinglyNode<Integer> current = head;

        while (index > 0) {
            current = current.next;
            index--;
        }

        SinglyNode<Integer> newNode = new SinglyNode<>(null, val);
        SinglyNode<Integer> tempNode = current.next;
        current.next = newNode;
        newNode.next = tempNode;
        size++;
    }
    
    /**
     * Print existing linked list value
     */
     public void printList() {
       if (size == 0) {
           System.out.println("Empty Linked List");
       } else {
            System.out.println("Printing Linked List : ");
           SinglyNode<Integer> tempNode = head.next;
           
           while (tempNode != null) {
               System.out.println(tempNode.value);
               tempNode = tempNode.next;
           }
       }
   }
}
