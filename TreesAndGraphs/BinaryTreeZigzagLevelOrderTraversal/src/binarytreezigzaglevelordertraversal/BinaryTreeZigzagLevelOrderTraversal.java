/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarytreezigzaglevelordertraversal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Binary Tree Zigzag Level Order Traversal
 * Leetcode: https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 * @author souravpalit
 */
public class BinaryTreeZigzagLevelOrderTraversal {

    // Time Complexity: O(n) Space Complexity: O(n)
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Stack<TreeNode> nodes = new Stack<TreeNode>();
        nodes.push(root);
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        boolean isRightToLeft = true;
        int childCount = nodes.size();
        result.add(Arrays.asList(root.val));
        
        while (!nodes.isEmpty()) {
            List<Integer> subResult = new ArrayList<Integer>();
            Stack<TreeNode> newNodes = new Stack<TreeNode>();
            for (int i = 0; i < childCount; i++) {
                TreeNode node = nodes.pop();
                
                if (isRightToLeft) {
                    if (node.right != null) {
                        newNodes.push(node.right);
                        subResult.add(node.right.val);
                    }
                    
                    if (node.left != null) {
                        newNodes.push(node.left);
                        subResult.add(node.left.val);
                    }
                } else {
                    if (node.left != null) {
                        newNodes.push(node.left);
                        subResult.add(node.left.val);
                    }
                    
                    if (node.right != null) {
                        newNodes.push(node.right);
                        subResult.add(node.right.val);
                    }
                }
            }
            nodes = newNodes;
            childCount = newNodes.size();
            isRightToLeft = !isRightToLeft;
            if (subResult.size() != 0) {
                result.add(subResult);
            }
        }
        
        return result;
    }
    
}
