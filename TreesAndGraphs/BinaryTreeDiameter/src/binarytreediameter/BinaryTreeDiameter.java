/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarytreediameter;

/**
 * Time Complexity O(n), Space Complexity: Average: O(h) and Worst: O(n)
 * @author souravpalit
 */
public class BinaryTreeDiameter {

    /**
     * @param args the command line arguments
     */
    public static void main(String args []) {
        BinaryTree binaryTree = new BinaryTree(1);

        binaryTree.left = new BinaryTree(3);
        binaryTree.left.left = new BinaryTree(7);
        binaryTree.left.right = new BinaryTree(4);
        
        
        binaryTree.left.right.right = new BinaryTree(5);
        binaryTree.left.right.right.right = new BinaryTree(6);
        
        binaryTree.left.left.left = new BinaryTree(8);
        binaryTree.left.left.left.left = new BinaryTree(9);

        binaryTree.right = new BinaryTree(2);
        
        int diameter = getDiameter(binaryTree);
        System.out.println("Diameter : " + diameter);
    }
    
    public static int getDiameter(BinaryTree node) {
        return getDiameterHelper(node).diameter;
    }
    
    public static NodeInfo getDiameterHelper(BinaryTree node) {
        if (node == null) return new NodeInfo(0,0);
        
        NodeInfo leftNodeCounts =  getDiameterHelper(node.left);
        NodeInfo rightNodeCounts = getDiameterHelper(node.right);
        
        int maxDiameter = Math.max(leftNodeCounts.diameter, rightNodeCounts.diameter);
        int currentDiameter =  leftNodeCounts.height + rightNodeCounts.height;
        int longestHeight = 1  + Math.max(leftNodeCounts.height, rightNodeCounts.height);
      
        return new NodeInfo(longestHeight, Math.max(maxDiameter, currentDiameter));
    }
}
