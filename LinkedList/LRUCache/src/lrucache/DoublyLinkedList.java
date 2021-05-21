/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lrucache;

/**
 *
 * @author souravpalit
 */
public class DoublyLinkedList {
    
    public DoublyLinkedListNode head = null;
    public DoublyLinkedListNode tail = null;
    
    public void setHead(DoublyLinkedListNode node) {
        if (head == node) {
            return;
        } else if (head == null) {
            // When no node
            head = node;
            tail = node;
        } else if (head == tail) {
            // When onnly one node 
            head = node;
            head.next = tail;
            tail.prev = head;
        } else {
            if (tail == node) {
                // So node already presents at the tail. as we are going to make
                // it as our head so we need to remove it;
                removeTail();
            }
            
            node.removeBindings();
            head.prev = node;
            node.next = head;
            head = node;
        }
    }
    
    public void removeTail() {
        if (tail == null) {
            return;
        } else if (head == tail) {
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
    }
    
}
