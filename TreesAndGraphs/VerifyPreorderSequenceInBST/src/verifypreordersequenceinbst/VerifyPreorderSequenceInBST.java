/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package verifypreordersequenceinbst;

/**
 * Leetcode: 255. Verify Preorder Sequence in Binary Search Tree
 * Problem Link: https://leetcode.com/problems/verify-preorder-sequence-in-binary-search-tree/
 * @author souravpalit
 */
public class VerifyPreorderSequenceInBST {

    int currentIdx;
    
    /**
     * Approach 1: 
     * TC: O(n) SC: O(n) 
     * @param preorder
     */
    
    public boolean verifyPreorder(int[] preorder) {
        currentIdx = 0;
        verifyPreorder(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return currentIdx == preorder.length;
    }
    
    private void verifyPreorder(
            int [] preorder, 
            int minValue, 
            int maxValue
    ) {
        if (currentIdx == preorder.length) {
            return;
        }
        
        int currentValue = preorder[currentIdx];
        
        if (currentValue < minValue || currentValue > maxValue) {
            return;
        }
        
        currentIdx++;
        
        verifyPreorder(preorder, minValue, currentValue);
        verifyPreorder(preorder, currentValue, maxValue);
    }
    
    
    /**
     * Approach 2: 
     * TC: O(n) SC: O(n) 
     * @param preorder
     * @return 
     */
    public boolean verifyPreorderAlternate(int[] preorder) {
        currentIdx = 0;
        return verifyPreorderAlternatee(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    private boolean verifyPreorderAlternatee(
            int [] preorder, 
            int minValue, 
            int maxValue
    ) {
        if (currentIdx == preorder.length) {
            return true;
        }
        
        int currentValue = preorder[currentIdx];
        
        if (currentValue < minValue || currentValue > maxValue) {
            return false;
        }
        
        currentIdx++;
        
        return verifyPreorderAlternatee(preorder, minValue, currentValue) || 
               verifyPreorderAlternatee(preorder, currentValue, maxValue);
    }
}
