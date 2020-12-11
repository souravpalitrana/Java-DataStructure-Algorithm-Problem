/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minimaltree;

import apple.laf.JRSUIUtils.Tree;

/**
 * Minimal Tree: Given a sorted(increasing order) array with unique integer 
 * elements, write an algorithm to create a binary search tree with minimal 
 * height
 * @author souravpalit
 */
public class MinimalTree {

    /** Given a sorted (increasing order) array with unique integer elements.Write
     *  an algorithm to create a binary search tree with minimal height. 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int [] sortedValues  = {1,2,3,4,5,6,7,8,9,10};
        BST bst = getMinimalBST(sortedValues, 0, sortedValues.length -1);
        System.out.println(bst.getValue());
    }
    
    public static BST getMinimalBST(int [] values, int start, int end) {
        if (end < start) {
            return null;
        }
        
        int mid = (start + end) / 2;
        BST bst = new BST(values[mid]);
        bst.addToLeft(getMinimalBST(values, start, mid - 1));
        bst.addToRight(getMinimalBST(values, mid + 1, end));
        return bst;
    }
    
}
