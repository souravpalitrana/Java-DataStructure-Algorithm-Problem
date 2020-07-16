package reversesinglylinkedlist;

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
