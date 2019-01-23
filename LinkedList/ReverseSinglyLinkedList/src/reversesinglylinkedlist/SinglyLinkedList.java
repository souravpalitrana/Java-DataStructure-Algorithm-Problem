package reversesinglylinkedlist;

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

    
    public void reverse() {
        
      SinglyNode<E> prev = null;  
      SinglyNode<E> current = head;
      SinglyNode<E> next = null;
      
      // Current head will be the lastNode
      lastNode = current;
      
      while(current != null) {
          next = current.next;
          current.next = prev;
          prev = current;
          current = next;
      }   
      head = prev;
    }
    
    
  public void display() {
        if(head == null) return;
        SinglyNode<E> tempNode = head;
        
        while(tempNode != null) {
            System.out.println(tempNode.item);
            tempNode = tempNode.getNext();
        } 
    }
  
}
