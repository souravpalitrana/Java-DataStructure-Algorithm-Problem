/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pathsumii;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author souravpalit
 */
public class PathSumII {

    // TC: O(N^2) N for travers and another N for inserting list
    // SC: O(N)
    private List<List<Integer>> result;
    private int targetSum;
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();
        this.targetSum = targetSum;
        findPath(root, new ArrayList<>(), 0);
        return result;
    }
    
    private void findPath(TreeNode root, List<Integer> path, int currentSum) {
        if (root == null) {
            return;
        } 
        
        currentSum += root.val;
        path.add(root.val);
        
        if (currentSum == targetSum && root.left == null && root.right == null) {
            result.add(new  ArrayList<>(path));
        } else {
            findPath(root.left, path, currentSum);
            findPath(root.right, path, currentSum);
        }
        
        path.remove(path.size() - 1);
    }
    
}
