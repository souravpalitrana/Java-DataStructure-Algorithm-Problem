/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convertsortedarraytobinarysearchtree;

/**
 *
 * @author souravpalit
 */
public class ConvertSortedArrayToBinarySearchTree {

    // Time Complexity: O(n)
    // Space Complexity: O(logn) where n is the number of element
    public TreeNode sortedArrayToBST(int[] nums) {
        return constructBST(nums, 0, nums.length - 1);
    }
    
    public TreeNode constructBST(int [] nums, int low, int high) {
        if (low > high) {
            return null;
        }
        
        int mid = (low + high) / 2;
        
        TreeNode currentNode = new TreeNode(nums[mid]);
        currentNode.left = constructBST(nums, low, mid - 1);
        currentNode.right = constructBST(nums, mid + 1, high);
        
        return currentNode;
    }
    
}
