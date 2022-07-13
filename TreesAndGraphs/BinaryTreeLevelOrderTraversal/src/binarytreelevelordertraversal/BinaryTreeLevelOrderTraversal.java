/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarytreelevelordertraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Leetcode: 102. Binary Tree Level Order Traversal
 * Problem Link: https://leetcode.com/problems/binary-tree-level-order-traversal/
 * @author souravpalit
 */
public class BinaryTreeLevelOrderTraversal {

    // TC: O(n) SC: O(n)
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levelOrderTraversal = new ArrayList<>();
        if (root == null) {
            return levelOrderTraversal;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        Queue<TreeNode> chidQueue = new LinkedList<>();
        List<Integer> level = new ArrayList<>();
      
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            level.add(node.val);
            
            if (node.left != null) {
                chidQueue.add(node.left);
            }
                
            if (node.right != null) {
                chidQueue.add(node.right);
            }
            
            if (queue.isEmpty()) {
                levelOrderTraversal.add(level);
                level = new ArrayList<>(); 
                queue = chidQueue;
                chidQueue = new LinkedList<>();
            }
        }
        
        return levelOrderTraversal;
    }
    
    // Slight Improvement : How can we use queue size to remove using extra queue
    public List<List<Integer>> levelOrder(TreeNode root) { 
        List<List<Integer>> levelOrderTraversal = new ArrayList<>();
        if (root == null) {
            return levelOrderTraversal;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int nodesPerLevel = 0;
        
        while (!queue.isEmpty()) {
            List<Integer> levelWiseNodes = new ArrayList<>();
            nodesPerLevel = queue.size();
            
            for (int i = 0; i < nodesPerLevel; i++) {
                TreeNode node = queue.remove();
                levelWiseNodes.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            levelOrderTraversal.add(levelWiseNodes);
        }
        
        return levelOrderTraversal;
    }
    
}
