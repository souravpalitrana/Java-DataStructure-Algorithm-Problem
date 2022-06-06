/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intersectionoftwolinked.lists;

/**
 * Leetcode: 160. Intersection of Two Linked Lists
 * Problem LLink: https://leetcode.com/problems/intersection-of-two-linked-lists/
 * @author souravpalit
 */
public class IntersectionOfTwoLinkedLists {

    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthOfA = getLength(headA);
        int lengthOfB = getLength(headB);
        int diff = Math.abs(lengthOfA - lengthOfB);
        
        if (lengthOfA > lengthOfB) {
            while (diff > 0) {
                headA = headA.next;
                diff--;
            }
        } else if (lengthOfA < lengthOfB) {
            while (diff > 0) {
                headB = headB.next;
                diff--;
            }
        }
        
        while (headA != null) {
            if (headA == headB) {
                return headA;
            }
            
            headA = headA.next;
            headB = headB.next;
        }
        
        return null;
        
    }
    
    public int getLength(ListNode node) {
        ListNode currentNode = node;
        int length = 0;
        while (currentNode != null) {
            currentNode = currentNode.next;
            length++;
        }
        
        return length;
    }
    
}
