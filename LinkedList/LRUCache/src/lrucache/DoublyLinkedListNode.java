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
public class DoublyLinkedListNode {
    
    public DoublyLinkedListNode prev = null;
    public DoublyLinkedListNode next = null;
    public int value;
    public String key;
    
    public DoublyLinkedListNode(String key, int value) {
        this.value = value;
        this.key = key;
    }
}
