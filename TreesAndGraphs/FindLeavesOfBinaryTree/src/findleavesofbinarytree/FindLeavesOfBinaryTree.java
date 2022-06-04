/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package findleavesofbinarytree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LeetCode : 366. Find Leaves of Binary Tree
 * Problem Link: https://leetcode.com/problems/find-leaves-of-binary-tree/
 * @author souravpalit
 */
public class FindLeavesOfBinaryTree {

    /**
     * Reverse Height assign. Leaf node will be assigned lowest height. So later
     * we will pick those nodes which height is lowest
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    int totalNodes;
    public List<List<Integer>> findLeaves(TreeNode root) {
        totalNodes = 0;
        Map<Integer, List<Integer>> nodes = new HashMap<>(); // Node height, value
        getHeight(root, nodes);
        
        List<List<Integer>> answer = new ArrayList<>();
        
        for (int height = 0; height < totalNodes; height++) {
            if (nodes.containsKey(height)) {
                answer.add(nodes.get(height));
            }
        }
        
        return answer;
    }
    
    public int getHeight(TreeNode root, Map<Integer, List<Integer>> nodes) {
        if (root == null) {
            return 0;
        }
        
        int leftHeight = getHeight(root.left, nodes);
        int rightHeight = getHeight(root.right, nodes);
        int currentHeight = 1 + Math.max(leftHeight, rightHeight);
        nodes.putIfAbsent(currentHeight, new ArrayList<Integer>());
        nodes.get(currentHeight).add(root.val);
        totalNodes++;
        
        return currentHeight;
    }
}
