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
public class Program {
    
    public static void iterativeInOrderTraversal(
      BinaryTree tree, Function<BinaryTree, Void> callback) {
    
        while (tree != null) {
            if (!tree.isVisited && tree.left != null && !tree.left.isVisited) {
                // Node is not printed and left not null and left not visited
                // so we need to move to left
                tree = tree.left;
            } else if (!tree.isVisited) {
                // That means left to root. We need to print
                callback.apply(tree);
               //callback(tree);
                tree.isVisited = true;
                // Now if right not visited and has right then move to right
                if (tree.right != null && !tree.right.isVisited) {
                    tree = tree.right;
                } else {
                    // Either it is visited or null so this node work is completed
                    // moving to parent node
                    tree = tree.parent;
                }
            } else {
                tree = tree.parent;
            }
             
        }
    } 
    
    public static void iterativeInOrderTraversal(BinaryTree tree) {
        while (tree!= null) {
            if (!tree.isVisited && tree.left != null && !tree.left.isVisited) {
                // Node is not printed and left not null and left not visited
                // so we need to move to left
                tree = tree.left;
            } else if (!tree.isVisited) {
                // That means left to root. We need to print
                System.out.println(tree.value);
               //callback(tree);
                tree.isVisited = true;
                // Now if right not visited and has right then move to right
                if (tree.right != null && !tree.right.isVisited) {
                    tree = tree.right;
                } else {
                    // Either it is visited or null so this node work is completed
                    // moving to parent node
                    tree = tree.parent;
                }
            } else {
                tree = tree.parent;
            }  
        }
    } 
    
    public static void iterativeInOrderTraversalAlternate(BinaryTree tree) {
        BinaryTree previousNode = null;
        BinaryTree currentNode = tree;
        
        while (currentNode != null) {
            if (previousNode == null || currentNode.parent == previousNode) {
                if (currentNode.left != null) {
                    previousNode = currentNode;
                    currentNode = currentNode.left;
                } else {
                    System.out.println(currentNode.value);
                    previousNode = currentNode;
                    currentNode = (currentNode.right != null) ? currentNode.right : currentNode.parent;
                }
            } else if (previousNode == currentNode.left) {
                System.out.println(currentNode.value);
                previousNode = currentNode;
                currentNode = (currentNode.right != null) ? currentNode.right : currentNode.parent;
            } else {
                previousNode = currentNode;
                currentNode = currentNode.parent;
            }
        }
    }
}
