/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package stackwithsinglylinkedlist;

/**
 *
 * @author SouravPalit
 */
public class SinglyNode<E> {
    public E item;
    public SinglyNode<E> next;

    public SinglyNode(SinglyNode<E> node, E value) {
        this.next = node;
        this.item = value;
    }

    public E getItem() {
        return item;
    }

    public SinglyNode<E> getNext() {
        return next;
    }

    public  boolean isLastNode() {
        return next == null;
    }
}
