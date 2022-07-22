/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package partitionlist;

/**
 * Leetcode: 86. Partition List
 * Problem Link: https://leetcode.com/problems/partition-list/
 * @author souravpalit
 */
public class PartitionList {

    // TC: O(N) SC: O(1)
    public ListNode partition(ListNode head, int x) {
        ListNode beforeHead = new ListNode(0);
        ListNode before = beforeHead;
        ListNode afterHead = new ListNode(0);
        ListNode after = afterHead;
        ListNode current = head;
        
        while (current != null) {
            if (current.val < x) {
                before.next = current;
                before = before.next;
            } else {
                after.next = current;
                after = after.next;
            }
            current = current.next;
        }
        
        after.next = null;
        before.next = afterHead.next;
        return beforeHead.next;
    }
    
}
