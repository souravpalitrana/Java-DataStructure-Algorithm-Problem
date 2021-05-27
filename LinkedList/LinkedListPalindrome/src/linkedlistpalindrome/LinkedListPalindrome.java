/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlistpalindrome;

/**
 * Time: O(n) Space: O(n) because recursive call stack
 * @author souravpalit
 */
public class LinkedListPalindrome {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LinkedList one = new LinkedList(1);
        LinkedList two = new LinkedList(2);
        LinkedList three = new LinkedList(3);
        LinkedList two2 = new LinkedList(2);
        LinkedList one2 = new LinkedList(1);
        
        one.next = two;
        two.next = three;
        three.next = two2;
        two2.next = one2;
        System.out.println("It is palindrome: " + isPalindrome(one));
    }
    
    public static boolean isPalindrome(LinkedList head) {
        return isPalindrome(head, head).isOuterNodesAreEqual;
    }
    
    private static Result isPalindrome(LinkedList leftNode, LinkedList rightNode) {
        if (rightNode == null) {
            return new Result(true, leftNode);
        }
        Result result = isPalindrome(leftNode, rightNode.next); 
        boolean isNodesAreEqual = result.leftNodeToCompare.value == rightNode.value && result.isOuterNodesAreEqual;
        return new Result(isNodesAreEqual, result.leftNodeToCompare.next);
    }
    
    static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
    }
    
    static class Result {
        public boolean isOuterNodesAreEqual;
        public LinkedList leftNodeToCompare;
        
        public Result(boolean isEqual, LinkedList leftNode) {
            this.isOuterNodesAreEqual = isEqual;
            this.leftNodeToCompare = leftNode;
        }
    }
}
