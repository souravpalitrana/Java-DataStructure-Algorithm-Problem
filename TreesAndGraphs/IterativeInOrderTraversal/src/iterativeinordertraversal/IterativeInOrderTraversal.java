/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iterativeinordertraversal;

import java.util.function.Function;

/**
 *
 * @author souravpalit
 */
public class IterativeInOrderTraversal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree(1);
        
        binaryTree.left = new BinaryTree(2, binaryTree);
        binaryTree.left.left = new BinaryTree(4, binaryTree.left);
        binaryTree.left.left.right = new BinaryTree(9, binaryTree.left.left);
        
    
        
        binaryTree.right = new BinaryTree(3, binaryTree);
        binaryTree.right.left = new BinaryTree(6, binaryTree.right);
        binaryTree.right.right = new BinaryTree(7, binaryTree.right);
        
        Program.iterativeInOrderTraversalAlternate(binaryTree);
    }
    
    public static void testCallback(BinaryTree tree) {
        System.out.println(tree.value);
    }
}
