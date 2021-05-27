/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doublylinkedlistconstruction;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author souravpalit
 */
public class DoublyLinkedList {
    
    public Node head;
    public Node tail;

    // Time: O(1) Space: O(1)
    public void setHead(Node node) {
      if (head == null) {
          head = node;
          tail = node;
      } else {
          insertBefore(head, node);
      }
    }

    // Time: O(1) Space: O(1)
    public void setTail(Node node) {
      if (tail == null) {
          setHead(node);
      } else {
          insertAfter(tail, node);
      }
    }

    // Time: O(1) Space: O(1)
    public void insertBefore(Node node, Node nodeToInsert) {
      if (nodeToInsert == head && nodeToInsert == tail) return;
      // If it is already present remove it;
      remove(nodeToInsert);
      nodeToInsert.prev = node.prev;
      nodeToInsert.next = node;
      
      if (node.prev == null) {
          // That means we are adding the new node before head so need to point
          // to head
          head = nodeToInsert;
      } else {
          // As our new node is not head not so we need to add previous next 
          // to current node
          node.prev.next = nodeToInsert;
      }
      
      // now old current's previous node must set to new node
      node.prev = nodeToInsert;
    }

    // Time: O(1) Space: O(1)
    public void insertAfter(Node node, Node nodeToInsert) {
      if (nodeToInsert == head && nodeToInsert == tail) return;
      // If it is already present remove it;
      remove(nodeToInsert);
      nodeToInsert.prev = node;
      nodeToInsert.next = node.next;
      
      if (node.next == null) {
          // That means we are adding after tail. SO tail must updated
          tail = nodeToInsert;
      } else {
          node.next.prev = nodeToInsert;
      }
      
      // Now need to connect current node next to new node next
      node.next = nodeToInsert;
    }

    // Time: O(p) where p is the positionn | Space: O(1)
    public void insertAtPosition(int position, Node nodeToInsert) {
      if (position == 1) {
          setHead(nodeToInsert);
      } else {
          Node node = head;
          int currentPosition = 1;
          while (node != null && currentPosition++ != position) node = node.next;
          
          if (node == null) {
              /// That means need to set as tail
              setTail(nodeToInsert);
          } else {
              insertBefore(node, nodeToInsert);
          }
      }
    }

    // Time: O(n) | Space: O(1)
    public void removeNodesWithValue(int value) {
      Node node = head;
      while (node != null) {
          Node nodeToRemove = node;
          node = node.next;
          if (nodeToRemove.value == value) remove(nodeToRemove);
      }
    }

    // Time: O(1) | Space: O(1)
    public void remove(Node node) {
      // The node can be head node, tail node or both (when there is one node)
      if (node == head && node == tail) {
          head = null;
          tail = null;
      } else if (node == head) {
          head = head.next;
          head.prev = null;
      } else if (node == tail) {
          tail = tail.prev;
          tail.next = null;
      } else {
          if (node.prev != null) {
              node.prev.next = node.next;
          }
          
          if (node.next != null) {
              node.next.prev = node.prev;
          }
      }
    }

    public boolean containsNodeWithValue(int value) {
      Node node = head;
      while (node != null) {
          if (node.value == value) {
              return true;
          }
          node = node.next;
      }
      return false;
    }
    
    public void printLinkedList() {
        Node current = head;
        
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        
        System.out.println();
    }
    
    public int [] getValues() {
        ArrayList<Integer> values = new ArrayList<Integer>();
        Node node = head;
        while (node != null) {
            values.add(node.value);
            node = node.next;
                    
        }
        int [] result = new int [values.size()];
        for (int i = 0; i < values.size(); i++) {
            result[i] = values.get(i);
        }
        
        return result;
    }
}
