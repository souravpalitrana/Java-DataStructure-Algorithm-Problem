/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doublylinkedlistconstruction;

/**
 *
 * @author souravpalit
 */
public class DoublyLinkedListConstruction {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DoublyLinkedList linkedList = new DoublyLinkedList();
        Node one, two, three, three2, three3, four, five, six;
        one = new Node(1);
        two = new Node(2);
        three = new Node(3);
        three2 = new Node(3);
        three3 = new Node(3);
        four = new Node(4);
        five = new Node(5);
        six = new Node(6);
        
        bindNodes(one, two);
        bindNodes(two, three);
        bindNodes(three, four);
        bindNodes(four, five);
        
        linkedList.head = one;
        linkedList.tail = five;
        
        linkedList.setHead(four);
        System.out.println("After setting head to 4");
        linkedList.printLinkedList();
        linkedList.setTail(six);
        System.out.println("After setting tail to 6");
        linkedList.printLinkedList();
        linkedList.insertBefore(six, three);
        System.out.println("After inserting 3 before 6");
        linkedList.printLinkedList();
        linkedList.insertAfter(six, three2);
        System.out.println("After inserting 3(new node) after 6");
        linkedList.printLinkedList();
        linkedList.insertAtPosition(1, three3);
        System.out.println("After inserting 3(new node) at position 1");
        linkedList.printLinkedList();
        linkedList.removeNodesWithValue(3);
        System.out.println("After removing nodes with value 3");
        linkedList.printLinkedList();
        linkedList.remove(two);
        System.out.println("After removing node 2 ");
        linkedList.printLinkedList();
    }
    
    private static void bindNodes(Node node1, Node node2) {
        node1.next = node2;
        node2.prev = node1;
    }
    
}
