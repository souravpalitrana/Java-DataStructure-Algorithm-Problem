/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bst;

/**
 * Binary search tree construct insert delete, finding closet value and valid BST
 * @author souravpalit
 */
public class BSTOperation {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ///nt [] values = {5, 15};
        //int [] values = {5, 9, 7 , 4, 3, 11, 12, 6};
        //int [] values = {5, 15, 2 , 5, 13, 22, 1, 14, 12};
        /*int [] values = {5, 15, 2 , 5, 13, 22, 1, 14, 12};
        
        BST bst = new BST(10);
        
        for (int i = 0; i < values.length; i++) {
            bst.insert(values[i]);
        }
        
        
        System.out.println("Root node is = " + bst.value);
        
        for (int i = values.length -1; i >=0; i--) {
           System.out.println("Contains (" + values[i] + ") : " + bst.contains(values[i]));
        }
        
        testValidBST();*/
        
        BST bst = new BST(5);
        bst.remove(10);
        System.out.println("Contains : " + bst.contains(15));
    }
    
    public static void testValidBST() {
        BST bst = new BST(10);
        bst.left = new BST(5);
        bst.right = new BST(15);
        bst.right.left = new BST(10);
        System.out.println("Is valid BST = " + isValidBST(bst));
    }
    
    public static boolean isValidBST(BST tree) {
        return isValidBST(tree, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    public static boolean isValidBST(BST tree, int minValue, int maxValue) {
        if (tree == null) {
            return true;
        } else {
            if (tree.value < minValue || tree.value >= maxValue) {
                return false;
            } else {
                if (tree.left != null && tree.right != null) {
                    return isValidBST(tree.left, minValue, tree.value) && isValidBST(tree.right, tree.value, maxValue);
                } else if (tree.left != null) {
                    return isValidBST(tree.left, minValue, tree.value);
                } else {
                    return isValidBST(tree.right, tree.value, maxValue);
                }
            }
        }
    }
}
