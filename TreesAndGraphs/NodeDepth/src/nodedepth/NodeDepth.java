/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nodedepth;

import java.util.Stack;

/**
 *
 * @author souravpalit
 */
public class NodeDepth {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
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
        
        int recursiveResult = getDepth(binaryTree);
        int iterativeResult = getDepthUsingIterativeSolution(binaryTree);
        
        System.out.println("Recursive Result: " + recursiveResult + "  "
        + "Iterative Result: " + iterativeResult + "  " +
                "Both results are same: " + (recursiveResult == iterativeResult));
    }
    
    // Recursive Solution. Time Complexity: O(n) Space Complexity: O(h)
    public static int getDepth(BinaryTree root) {
        return getDepth(root, 0);
    }
    
    public static int getDepth(BinaryTree root, int depth) {
        if (root == null) {
            return 0;
        } 
        
        return depth + getDepth(root.left, depth + 1) + 
                getDepth(root.right, depth +1);
    }
    
    
    public static int getDepthUsingIterativeSolution(BinaryTree root) {
        Stack<NodeInfo> stack = new Stack<NodeInfo>();
        stack.add(new NodeInfo(root, 0));
        
        int sumOfNodeDepth = 0;
        
        while (!stack.isEmpty()) {
            NodeInfo nodeInfo = stack.pop();
            if (nodeInfo.node == null) {
                continue;
            } else {
                sumOfNodeDepth += nodeInfo.depth;
                stack.add(new NodeInfo(nodeInfo.node.left, nodeInfo.depth + 1));
                stack.add(new NodeInfo(nodeInfo.node.right, nodeInfo.depth + 1));
            }
        }
        
        return sumOfNodeDepth;
    }
}
