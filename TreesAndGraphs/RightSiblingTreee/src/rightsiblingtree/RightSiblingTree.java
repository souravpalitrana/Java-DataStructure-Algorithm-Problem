/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rightsiblingtree;

/**
 * Right Sibling Tree: Write a function that takes in a Binary Tree, transforms
 * it into a Right Sibling Tree and returns its root. A right sibling tree is
 * obtained by making every node in a Binary Tree have its right property point
 * to its right on the same level or None/Null if there is no node immediately to
 * its right. Note that once that once the transformation is complete, some nodes
 * might no longer have a node pointing to them. The transformation should be 
 * done in place.
 * Time Complexity: O(n) and Space Complexity: O(d)
 * @author souravpalit
 */
public class RightSiblingTree {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    public static BinaryTree transformToRightSibilingTree(BinaryTree root) {
        mutate(root, null, false);
        return root;
    }
    
    public static void mutate(BinaryTree node, BinaryTree parent, 
            boolean isLeftChild) {
        if (node == null) return;
        
        BinaryTree leftChild = node.left;
        BinaryTree rightChild = node.right;
        mutate(leftChild, node, true);
        if (parent == null) {
            // that means this is root node. In that case we can set the right 
            // node null. Again we stored this right child separately in a 
            // variable. So don't worry it will not loose.
            node.right = null;
        } else if (isLeftChild) {
            // now if it is left child than we need to add its paren'ts right 
            node.right = parent.right;
        } else {
            // That means it is right child. So we need to set it's parent'ss 
            // right child's left child as right child. But what if it's parent's
            // right child is null. In that case we could not do that and we need
            // to handle that
            if (parent.right != null) {
                // If we don't check that then program will crash when parent.right
                // is null as we are accessing the left child of a null value.
                node.right = parent.right.left; 
            } else {
                node.right = null;
            }
        }
        
        mutate(rightChild, node, false);
    }
    
}
