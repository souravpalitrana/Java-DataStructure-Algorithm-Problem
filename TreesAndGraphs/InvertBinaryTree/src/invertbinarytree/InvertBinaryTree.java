/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package invertbinarytree;

/**
 * Time Complexity O(n) time and O(d) space 
 * We are using recursive solution. You can use iterative solution but in 
 * that case stack will cause O(n) space
 * @author souravpalit
 */
public class InvertBinaryTree {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree(1);
        
        binaryTree.left = new BinaryTree(2);
        binaryTree.left.left = new BinaryTree(4);
        binaryTree.left.left.left = new BinaryTree(8);
        binaryTree.left.left.right = new BinaryTree(9);
        
        binaryTree.left.right = new BinaryTree(5);
        binaryTree.left.right.left = new BinaryTree(10);
        
        binaryTree.right = new BinaryTree(3);
        binaryTree.right.left = new BinaryTree(6);
        binaryTree.right.right = new BinaryTree(7);
        
        invert(binaryTree);
        System.out.print(binaryTree.value);
    }
    
    public static void invert(BinaryTree bt) {
        if (bt == null) {
            return;
        }
        BinaryTree temp = bt.left;
        bt.left = bt.right;
        bt.right = temp;
        
        invert(bt.left);
        invert(bt.right);
    }
    
}
