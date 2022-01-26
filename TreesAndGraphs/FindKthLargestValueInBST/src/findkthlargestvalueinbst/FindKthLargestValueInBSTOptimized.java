/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package findkthlargestvalueinbst;

import java.util.ArrayList;
import java.util.List;

/**
 * Time Complexity: O(h + k) 
 * Space Complexity: O(h) 
 * @author souravpalit
 */
public class FindKthLargestValueInBSTOptimized {

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
        TreeInfo treeInfo = new TreeInfo(0, -1);
        reverseInOrderTraverse(tree, k, treeInfo);
        return treeInfo.lastVisitedNodeValue;
    }
    
    public static void reverseInOrderTraverse(BST tree, int k, TreeInfo treeInfo) {
        if (tree == null || treeInfo.visitedNodeCount >= k) return;
        
        reverseInOrderTraverse(tree.right, k, treeInfo);
        if (treeInfo.visitedNodeCount < k) {
            treeInfo.lastVisitedNodeValue = tree.value;
            treeInfo.visitedNodeCount++;
            reverseInOrderTraverse(tree.left, k, treeInfo);
        }        
    }
    
    public static class TreeInfo {
        int visitedNodeCount;
        int lastVisitedNodeValue;
        
        public TreeInfo(int visitedNodeCount, int lastVisitedNodeValue) {
            this.visitedNodeCount = visitedNodeCount;
            this.lastVisitedNodeValue = lastVisitedNodeValue;
        }
    }
    
}
