package removeduplicates;

public class SinglyNode<E> {
    public E value;
    public SinglyNode<E> next;

    public SinglyNode(SinglyNode<E> node, E value) {
        this.next = node;
        this.value = value;
    }

    public E getValue() {
        return value;
    }

    public SinglyNode<E> getNext() {
        return next;
    }

    public  boolean isLastNode() {
        return next == null;
    }
}
