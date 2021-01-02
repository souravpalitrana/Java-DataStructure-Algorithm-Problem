/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allnodedepth;

/**
 *
 * @author souravpalit
 */
public class AllNodeDepthFourthOptimize {
    
    public static void main(String args []) {
        BinaryTree binaryTree = new BinaryTree(1);

        binaryTree.left = new BinaryTree(2);
        binaryTree.left.left = new BinaryTree(4);
        binaryTree.left.left.left = new BinaryTree(8);
        binaryTree.left.left.right = new BinaryTree(9);

        binaryTree.left.right = new BinaryTree(5);
        //binaryTree.left.right.left = new BinaryTree(10);

        binaryTree.right = new BinaryTree(3);
        binaryTree.right.left = new BinaryTree(6);
        binaryTree.right.right = new BinaryTree(7);
        
        System.out.println("All kinds of node sum is : " + 
                getAllNodeDepths(binaryTree));
    }
    
    public static int getAllNodeDepths(BinaryTree node) {
        return getAllNodeDepthSum(node, 0); 
    }
    
    public static int getAllNodeDepthSum(BinaryTree node, int depth) {
        if (node == null) {
            return 0;
        }
        
        int depthSum = (depth * (depth + 1)) / 2;
        System.out.println("Node: " + node.value + " Depth = " + depth + " Before DepthSum: " + depthSum);
        
        int leftNodeSum = getAllNodeDepthSum(node.left, depth + 1);
        int rightNodeSum = getAllNodeDepthSum(node.right, depth + 1);
        
        return depthSum + leftNodeSum +
                rightNodeSum;
    }
}
