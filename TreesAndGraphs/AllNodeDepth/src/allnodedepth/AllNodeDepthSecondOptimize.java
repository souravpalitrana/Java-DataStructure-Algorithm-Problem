/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allnodedepth;

/**
 * Time Complexity O(n) Space Complexity O(h)
 * @author souravpalit
 */
public class AllNodeDepthSecondOptimize {
    
    public static void main(String args []) {
        BinaryTree binaryTree = new BinaryTree(1);

        binaryTree.left = new BinaryTree(2);
        binaryTree.left.left = new BinaryTree(4);
        binaryTree.left.left.left = new BinaryTree(8);
        binaryTree.left.left.right = new BinaryTree(9);

        binaryTree.left.right = new BinaryTree(5);
        binaryTree.left.right.left = new BinaryTree(10);

        binaryTree.right = new BinaryTree(3);
        binaryTree.right.left = new BinaryTree(6);
        binaryTree.right.right = new BinaryTree(7);
        
        System.out.println("All kinds of node sum is : " + 
                getAllNodeDepths(binaryTree));
    }
    
    public static int getAllNodeDepths(BinaryTree node) {
        return getNodeInfo(node).sumOfAllNodeDepth;
    }
    
    public static NodeInfo getNodeInfo(BinaryTree node) {
        if (node == null) {
            return new NodeInfo(0,0,0);
        }
        
        NodeInfo leftNodeInfo = getNodeInfo(node.left);
        NodeInfo rightNodeInfo = getNodeInfo(node.right);
        
        int nodeCount = 1 + leftNodeInfo.nodeCount + rightNodeInfo.nodeCount;
        int nodeDepth = leftNodeInfo.nodeDepth + leftNodeInfo.nodeCount 
                + rightNodeInfo.nodeDepth + rightNodeInfo.nodeCount;
        int sumOfAllNodeDepth = nodeDepth + leftNodeInfo.sumOfAllNodeDepth + rightNodeInfo.sumOfAllNodeDepth;
        
        return new NodeInfo(nodeCount, nodeDepth, sumOfAllNodeDepth);
    }
}
