/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarytreecameras;

import java.util.HashSet;
import java.util.Set;

/**
 * Leetcode: Binary Tree Cameras
 * Problem Link: https://leetcode.com/problems/binary-tree-cameras/
 * Daily Challenge 17 June 2022
 * @author souravpalit
 */
public class BinaryTreeCameras {

    private Set<TreeNode> covered;
    private int cameraCount;
    
    // Greedy Approach
    // TC: O(n) SC: O(h) where h is the height
    public int minCameraCover(TreeNode root) {
        covered = new HashSet<TreeNode>();
        covered.add(null);
        cameraCount = 0;
        placeCamera(root, null);
        return cameraCount;
    }
    
    public void placeCamera(TreeNode node, TreeNode parent) {
        if (node == null) {
            return;
        }
        
        placeCamera(node.left, node);
        placeCamera(node.right, node);
        
        if (parent == null && !covered.contains(node) ||
                !covered.contains(node.left) || 
                !covered.contains(node.right)) {
            cameraCount++;
            covered.add(node);
            covered.add(parent);
            covered.add(node.left);
            covered.add(node.right);
        }
    }
    
}
