package removeduplicates;

import java.util.HashMap;
import java.util.HashSet;

public class SinglyLinkedList<E> {
    // Here we need head to traverse the linked list from starting to lastNode
    private SinglyNode<E> head;
    //Last node will help us to add a new value at the last with out moving the 
    private SinglyNode<E> tail;
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
            tail = node;
        } else {
            SinglyNode<E> node = new SinglyNode<>(null, value);
            tail.next = node;
            tail = tail.next;
        }
        nodeCount++;
    }

    /**
     * Add value in a specific position
     * @param index
     * @param value 
     */
    public void add(int index, E value) {
        if(nodeCount == 0) {
            // Node count 0 means no node has been added yet.
            add(value);
        } else {
            if(index == 0) {
                // node count not zero and we want to add a new node at first.
                addFirst(value);
            } else if(index >= nodeCount) {
                // if index is greater than node count we will add the node 
                // at the last position. We are not throwing exception 
                // when the index is greater than the linked list size
                addLast(value);
            } else {
                // For adding a new node we will go before the target node (T-1) 
                // and create a  new node which next node will be the last 
                // iterated node next (T-1 node's next). 
                SinglyNode<E> tempNode = head;
                
                for (int i = 1; i < index; i++) {
                    tempNode = tempNode.next;
                }
                
                SinglyNode<E> newNode = new SinglyNode<E>(tempNode.next, value);
                tempNode.next = newNode;
                
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
        tail.next = node;
        tail = tail.next;
        nodeCount++;
    }

    /**
     * Return the size of the linked list
     * @return 
     */
    public int size() {
        return nodeCount;
    }

    public E get(int index) {

        SinglyNode<E> tempNode = head;
        int counter = 0;

        if (index == 0) {
            return tempNode.getValue();
        } else {
            while (!tempNode.isLastNode()) {
                counter++;
                tempNode = tempNode.getNext();
                if (counter == index) {
                    break;
                }
            }
            return tempNode.getValue();
        }
    }

    /**
     * Remove value from a specific position of the list
     * @param index 
     */
    public void removeAt(int index) {
        if (index < 0 || index >= nodeCount) return;
        
        if (nodeCount == 1) {
            head = null;
            tail = null;
        } else if (index == 0) {
            // That means we are deleting the first node. So need to change 
            // the head position
            head = head.next;
        } else {
            SinglyNode<E> tempNode = head;
            
            for (int i = 1; i < index; i++) {
                tempNode = tempNode.next;
            }
            
            tempNode.next = tempNode.next.next;
            
            if (tempNode.next == null) {
                // That means we removed the last node. So need to change tail
                // position
                tail = tempNode;
            }
        }
        nodeCount--; 
    }
    
    /**
     * Remove a node from the list
     * @param item 
     */
    public void remove(E item) {
        if (nodeCount == 0) return;
        
        SinglyNode<E> tempNode = head;
        SinglyNode<E> prevNode = null;
        
        while (tempNode != null) {
            if (tempNode.value == item) {
                if (nodeCount == 1) {
                    // Only one node present and we want to delete that. 
                    head = null;
                    tail = null;
                } else if (prevNode == null) {
                    // prevNode null means we found the node at the first node of 
                    // the list. so we need to change the head position
                    head = tempNode.next;
                } else {
                    // so our target node may present at the middle or at the end
                    prevNode.next = tempNode.next;
                    // Now if our target node is the last node in that case we need to
                    // change the last node position as it is deleted
                    if (prevNode.next == null) {
                        tail = prevNode;
                    }
                }
                nodeCount--;
                break;
            } else {
               prevNode = tempNode;
               tempNode = tempNode.next;
           }
        }
    }
    
    /**
     * The best way to remove duplicate from the linked list is using a map where
     * you will insert the visited node and while iterating if you found a value 
     * already exists in the map then you need to delete that. But here though
     * time complexity is O(n) but space complexity is O(n)
     */
    public void removeDuplicatesUsingBuffer() {
        HashSet<E> map = new HashSet<>();
        
        SinglyNode<E> current = head;
        SinglyNode<E> prev = null;
        
        while (current != null) {
            
            if (map.contains(current.value)) {
                // Remove this node
                prev.next = current.next;
            } else {
                map.add(current.value);
                prev = current;
            }
            
            current = current.next;
        }
                
    }
    
    /**
     * If you could not use extra memory like map to check where a value is present
     * then you need to use to loop like bubble sort. In that case time complexity
     * will be O(n^2) but space complexity O(1) (Considering data is not sorted)
     */
    public void removeDuplicatesNotUsingBuffer() {
        SinglyNode<E> current = head;
        
        while (current != null) {
            SinglyNode<E> runner = current.next;
            SinglyNode<E> prev = current;
            
            while (runner != null) {
               if (current.value == runner.value) {
                   prev.next = runner.next; 
               } else {
                   prev = runner;
               }
               
               runner = runner.next;
            }
            
            current = current.next;
        }
    }
    
    /**
     * As value is sorted we know that duplicate values are situated one after 
     * another. So we don't need to use extra memory here. Again no extra loop required
     */
    public void removeDuplicatesWhenValueSorted() {
        SinglyNode<E> current = head;
        
        while (current != null) {
            if (current.next != null && current.value == current.next.value) {
                current.next = current.next.next;
            } else {
                if (current.next == null) {
                    // Setting our current tail
                    tail = current;
                }
                current = current.next;
            }
        }
    }
    
    /**
     * Print existing linked list value
     */
     public void printList() {
       if (nodeCount == 0) {
           System.out.println("Empty Linked List");
       } else {
           SinglyNode<E> tempNode = head;
           
           while (tempNode != null) {
               System.out.println(tempNode.value);
               tempNode = tempNode.next;
           }
       }
   }
  
}
