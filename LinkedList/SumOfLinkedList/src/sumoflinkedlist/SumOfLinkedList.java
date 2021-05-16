/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sumoflinkedlist;

/**
 * 
 * Time Complexity O(max(m,n)) and Space Complexity O(max(m,n)) where m and n are
 * the length of first and second linked list respectively. 
 * @author souravpalit
 */
public class SumOfLinkedList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LinkedList two = new LinkedList(2);
        LinkedList four = new LinkedList(4);
        LinkedList seven = new LinkedList(7);
        LinkedList one = new LinkedList(1);
        
        two.next = four;
        four.next = seven;
        seven.next = one;
        
        LinkedList nine = new LinkedList(9);
        LinkedList four2 = new LinkedList(4);
        LinkedList five = new LinkedList(5);
        
        nine.next = four2;
        four2.next = five;
    
        LinkedList sum = sumOfLinkedLists(two, nine);
        
        while (sum != null) {
            System.out.print(sum.value +  " ");
            sum = sum.next;
        }
    }
    
    public static LinkedList sumOfLinkedLists(LinkedList linkedListOne, LinkedList linkedListTwo) {
        int sum = getIntegerNumber(linkedListOne) + getIntegerNumber(linkedListTwo);
        String sumInString = String.valueOf(sum);
        char [] digits = sumInString.toCharArray();
        int index = digits.length - 1;
        
        LinkedList head = new LinkedList(Integer.valueOf(digits[index]+ ""));
        LinkedList current = head;
        for (int i = index - 1; i >= 0; i--) {
            current.next = new LinkedList(Integer.valueOf(digits[i]+ ""));
            current = current.next;
        }
                
        return head;
    }
    
    public static int getIntegerNumber(LinkedList linkedList) {
        StringBuilder builder = new StringBuilder();
        while (linkedList != null) {
            builder.append(String.valueOf(linkedList.value));
            linkedList = linkedList.next;
        }     
        
        return Integer.valueOf(builder.reverse().toString());
    }
    
    public static class LinkedList {

        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }
    
}
