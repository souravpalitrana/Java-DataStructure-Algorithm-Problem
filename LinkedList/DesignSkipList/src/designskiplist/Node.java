/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designskiplist;

/**
 *
 * @author souravpalit
 */
public class Node {
    
    public int val;
    public Node next;
    public Node down;
    
    public Node(int val) {
        this.val = val;
    }
    
    public Node(int val, Node next, Node down) {
        this.val = val;
        this.down = down;
        this.next = next;
    }
}
