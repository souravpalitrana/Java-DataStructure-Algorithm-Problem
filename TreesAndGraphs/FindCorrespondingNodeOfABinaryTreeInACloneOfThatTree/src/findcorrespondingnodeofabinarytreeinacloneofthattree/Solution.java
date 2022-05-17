/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package findcorrespondingnodeofabinarytreeinacloneofthattree;

/**
 *
 * @author souravpalit
 */
public class Solution {
    
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (original == null) {
            return original;
        }
        
        if (original == target) {
            return cloned;
        }
        
        TreeNode left = getTargetCopy(original.left, cloned.left, target);
        if (left != null) {
            return left;
        }
        
        TreeNode right = getTargetCopy(original.right, cloned.right, target);
        if (right != null) {
            return right;
        }
        
        return null;
    }
    
}
