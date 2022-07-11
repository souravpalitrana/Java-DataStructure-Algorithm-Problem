/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarytreerightsideview;

/**
 *
 * @author souravpalit
 */
public class BinaryTreeRightSideView {

    // TC: O(N) SC: O(N)
    /*public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        traverse(root, result, 0);
        return result;
    }
    
    private void traverse(TreeNode node, List<Integer> result, int depth) {
        if (node == null) {
            return;
        }
        
        if (result.size() <= depth) {
            result.add(node.val);
        } else {
            result.set(depth, node.val);
        }
        
        traverse(node.left, result, depth + 1);
        traverse(node.right, result, depth + 1);
    }*/
    
    
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        traverse(root, result, 0);
        return result;
    }
    
    private void traverse(TreeNode node, List<Integer> result, int depth) {
        if (node == null) {
            return;
        }
        
        if (result.size() == depth) {
            result.add(node.val);
        } 
        
        traverse(node.right, result, depth + 1);
        traverse(node.left, result, depth + 1);
        
    }
    
}
