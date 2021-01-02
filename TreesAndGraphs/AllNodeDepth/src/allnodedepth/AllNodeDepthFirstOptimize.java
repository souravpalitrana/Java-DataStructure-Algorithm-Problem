/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allnodedepth;

import java.util.HashMap;
import java.util.Map;

/**
 * Time Complexity O(n) and Space Complexity O(n)
 * @author souravpalit
 */
public class AllNodeDepthFirstOptimize {
    
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
                getAllNodesDepth(binaryTree));
    }
    
    public static int getAllNodesDepth(BinaryTree node) {
        if (node == null) {
            return 0;
        }
        Map<BinaryTree, Integer> nodeCounts = new HashMap<>();
        addNodeCounts(node, nodeCounts);
        Map<BinaryTree, Integer> nodeDepths = new HashMap();
        addNodeDepths(node, nodeDepths, nodeCounts);
        
        /* This or that
        int sumOfAllNode = 0;
        for (Map.Entry element : nodeDepths.entrySet()) {
            sumOfAllNode += (Integer) element.getValue();
        }
        
        return sumOfAllNode;*/
        
        return sumAllNodeDepths(node, nodeDepths);
    }
    
    public static void addNodeCounts(BinaryTree node, 
            Map<BinaryTree, Integer> nodeCounts) {
        nodeCounts.put(node, 1);
        
        if (node.left != null) {
            addNodeCounts(node.left, nodeCounts);
            nodeCounts.put(node, nodeCounts.get(node) + nodeCounts.get(node.left));
        } 
        
        if (node.right != null) {
            addNodeCounts(node.right, nodeCounts);
            nodeCounts.put(node, nodeCounts.get(node) + nodeCounts.get(node.right));
        }
        
    }
    
    public static void addNodeDepths(BinaryTree node,  
            Map<BinaryTree, Integer> nodeDepths,
            Map<BinaryTree, Integer> nodeCounts) {
        nodeDepths.put(node, 0);
        
        if (node.left != null) {
            addNodeDepths(node.left, nodeDepths, nodeCounts);
            nodeDepths.put(node, nodeDepths.get(node.left)  + nodeCounts.get(node.left));
        }
        
        if (node.right != null) {
            addNodeDepths(node.right, nodeDepths, nodeCounts);
            nodeDepths.put(node, nodeDepths.get(node) + nodeDepths.get(node.right)  + nodeCounts.get(node.right));
        }
    }
    
    public static int sumAllNodeDepths(BinaryTree node, 
            Map<BinaryTree, Integer> nodeDepths) {
        if (node == null) {
            return 0;
        }
        
        return sumAllNodeDepths(node.left, nodeDepths) + 
                sumAllNodeDepths(node.right, nodeDepths) 
                + nodeDepths.get(node);
    }
}
