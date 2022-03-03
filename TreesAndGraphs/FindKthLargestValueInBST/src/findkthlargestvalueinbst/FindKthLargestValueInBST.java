/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package findkthlargestvalueinbst;

import java.util.ArrayList;
import java.util.List;

/**
 * Time Complexity: O(n) as we need to traverse all node
 * Space Complexity: O(n) because of storing all the sorted value
 * @author souravpalit
 */
public class FindKthLargestValueInBST {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BST root = new BST(10);
        root.left = new BST(5);
        root.left.left = new BST(2);
        root.left.left.left = new BST(1);
        root.left.right = new BST(5);
        root.right = new BST(15);
        root.right.left = new BST(13);
        root.right.left.right = new BST(14);
        root.right.right = new BST(22);
        
        int k = 3;
        
        System.out.println("Thee Kth Largest value is : " + findKthLargestValueInBst(root, k));
    }
    
    public static int findKthLargestValueInBst(BST tree, int k) {
        List<Integer> sortedList = new ArrayList<Integer>();
        inOrderTraverse(tree, sortedList);
        return sortedList.get(sortedList.size() - k);
    }
    
    public static void inOrderTraverse(BST tree, List<Integer> list) {
        if (tree == null) return;
        
        inOrderTraverse(tree.left, list);
        list.add(tree.value);
        inOrderTraverse(tree.right, list);
    }
    
}
