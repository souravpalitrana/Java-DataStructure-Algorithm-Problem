/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maxpathsum;

import java.util.Collections;
import java.util.Stack;

/**
 * Max Path Sum: Time Complexity O(n) Space Complexity: Average O(log(n) 
 * Worst O(n)
 * @author souravpalit
 */
public class MaxPathSum {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree(1);
        
        /*binaryTree.left = new BinaryTree(2);
        binaryTree.right = new BinaryTree(-1);*/
        
        binaryTree.left = new BinaryTree(2);
        binaryTree.left.left = new BinaryTree(4);
        binaryTree.left.right = new BinaryTree(5);
        
        binaryTree.right = new BinaryTree(3);
        binaryTree.right.left = new BinaryTree(6);
        binaryTree.right.right = new BinaryTree(7);
        
        System.out.println(findMaxPathSum(binaryTree));
    }
    
    public static int findMaxPathSum(BinaryTree tree) {
        if (tree == null) {
            return 0;
        } 
        
        return findMaxPathSumHelper(tree).maxPathSum;
    }
    
    public static NodeInfo findMaxPathSumHelper(BinaryTree node) {
        if (node == null) {
            return new NodeInfo(Integer.MIN_VALUE, Integer.MIN_VALUE);
        } 
        
        NodeInfo leftNodeInfo = findMaxPathSumHelper(node.left);
        NodeInfo rightNodeInfo = findMaxPathSumHelper(node.right);
        int leftMaxPathAsBranch = Math.max(leftNodeInfo.maxPathAsBranch + node.value, node.value);
        int maxPathAsBranch = Math.max(rightNodeInfo.maxPathAsBranch + node.value, leftMaxPathAsBranch);
        int pathSum = Math.max(maxPathAsBranch, leftNodeInfo.maxPathAsBranch + node.value + rightNodeInfo.maxPathAsBranch);
        int maxPathSum = Math.max(pathSum, Math.max(leftNodeInfo.maxPathSum, rightNodeInfo.maxPathSum));
        
        return new NodeInfo(maxPathAsBranch, maxPathSum);
    }
    
    public static class NodeInfo {
        
        public int maxPathAsBranch;
        public int maxPathSum;
        
        public NodeInfo(int leftMaxPathSumAsBranch, int leftNodePathSum) {
            this.maxPathAsBranch = leftMaxPathSumAsBranch;
            this.maxPathSum = leftNodePathSum;
        }
    }
}
