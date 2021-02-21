/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package findsuccessor;


/**
 * Time Complexity: O(h) Space Complexity O(1)
 * @author souravpalit
 */
public class FindSuccessorOptimize {
    
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree(1);

        binaryTree.left = new BinaryTree(2, binaryTree);
        binaryTree.right = new BinaryTree(3, binaryTree);
        binaryTree.left.left = new BinaryTree(4, binaryTree.left);
        binaryTree.left.right = new BinaryTree(5, binaryTree.left);
        binaryTree.left.right.left = new BinaryTree(6, binaryTree.left.right);
        binaryTree.left.right.right = new BinaryTree(7, binaryTree.left.right);
        binaryTree.left.right.right.left = new BinaryTree(8, binaryTree.left.right.right);
        BinaryTree tree = findSucceessor(binaryTree, binaryTree.left.right);
        
        System.out.println(tree.value);
    }
    
    public static BinaryTree findSucceessor(BinaryTree tree, BinaryTree node) {
        if (node.right != null) {
            return getLeftMostChild(tree.right);
        } else {
            return getRightMostParent(tree);
        }
    }
    
    public static BinaryTree getLeftMostChild(BinaryTree tree) {
        while(tree.left != null) {
            tree = tree.left;
        }
        return tree;
    }
    
    public static BinaryTree getRightMostParent(BinaryTree tree) {
        /*while (tree.parent != null && tree.parent.right == tree ) {
            tree = tree.parent;
        }*/
        if (tree.parent != null && tree.parent.right == tree) {
            return tree.parent.parent;
        } else {
            return tree.parent;
        }
    }
}
