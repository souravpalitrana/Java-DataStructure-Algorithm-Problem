package linkedlistimplementation;

public class SinglyLinkedList<E> {
    // Here we need head to traverse the linked list from starting to lastNode
    private SinglyNode<E> head;
    //Last node will help us to add a new value at the last with out moving the 
    private SinglyNode<E> lastNode;
    //Node count will track the length of the linked list
    private int nodeCount = 0;


    /**
     * Initializing head. First time both head and lastNode will be the same
     * @param value 
     */
    public void add(E value) {
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

    public void add(int index, E value) {
        if(nodeCount == 0) {
            // Node count 0 means no node has been added yet.
            add(value);
        } else {
            if(index == 0) {
                // node count not zero and we want to add a new node at first.
                addFirst(value);
            } else if(index > nodeCount) {
                // if index is greater than node count we will add the node 
                // at the last position. We are not throwing exception 
                // when the index is greater than the linked list size
                addLast(value);
            } else {
                // For adding a new node we will go before the target node and
                // will set this node's next to new node and set the index node
                // to new node's next
                SinglyNode<E> tempNode = head;
                int counter = 1;
                int LIMIT = index - 1;
                while (counter <= LIMIT) {
                    if(counter == LIMIT) {
                        SinglyNode<E> nextNode = tempNode.next;
                        SinglyNode<E> newNode = new SinglyNode<>(nextNode, value);
                        tempNode.next = newNode;
                    } else {
                        tempNode = tempNode.next;
                    }

                    counter++;

                }
                nodeCount++;
            }


        }
    }

    public void addFirst(E value) {
        if(nodeCount == 0) {
            add(value);
        } else {
            SinglyNode<E> node = new SinglyNode<>(null, value);
            SinglyNode<E> tempNodeFirst = head;
            head = node;
            head.next = tempNodeFirst;
            nodeCount++;
        }
    }

    public void addLast(E value) {
        SinglyNode<E> node = new SinglyNode<>(null, value);
        lastNode.next = node;
        lastNode = lastNode.next;
        nodeCount++;
    }

    public int size() {
        return nodeCount;
    }

    public E get(int index) {

        SinglyNode<E> tempNode = head;
        int counter = 1;

        if(index == 0) {
            return tempNode.getItem();
        } else {
            while (!tempNode.isLastNode()) {
                counter++;
                if(counter == index) {
                    tempNode = tempNode.getNext();
                    break;
                } else {
                    tempNode = tempNode.getNext();
                }
            }
            return tempNode.getItem();
        }
    }

    public void removeFirst() {
        head = head.next;
        nodeCount--;
    }

    public void removeLast() {
        SinglyNode<E> tempNode = head;
        int counter = 1;
        while (counter < nodeCount) {
            if(counter == nodeCount - 1) {
                tempNode.next = null;
                break;

            } else {
                tempNode = tempNode.next;
            }
            counter++;

        }
        nodeCount--;
    }

    public void remove(int index) {
        if(nodeCount == 1 && index == 0) {
            removeFirst();
        } else if(nodeCount == index) {
            removeLast();
        } else {
            SinglyNode<E> tempNode = head;
            int counter = 1;
            while (counter < index) {
                if(counter == index - 1) {
                    SinglyNode<E> deleteNode = tempNode.next;

                    tempNode.next = deleteNode.next;
                    break;

                } else {
                    tempNode = tempNode.next;
                }

                counter++;
            }
            nodeCount--;

        }
    }


}
