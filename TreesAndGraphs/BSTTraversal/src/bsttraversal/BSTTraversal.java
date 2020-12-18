/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bsttraversal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Preorder Inorder PostOrder
 * Time Complexity O(n) 
 * Space Complexity: Average.: O(d) Worst: O(n) // Ignoring array storing
 * @author souravpalit
 */
public class BSTTraversal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //int[] values = {5, 15, 2, 5, 22, 1, 12};
        int [] values = { 2, -1, 100, 45, 12, 8, -1, 8, 10, 15, 8, 12, 94, 81, 2, -34};

        BST bst = new BST(5);

        for (int i = 0; i < values.length; i++) {
            bst.insert(values[i]);
        }
        
        System.out.println("In Order Trversal:");
        List<Integer> inOrderValues = inOrderTraverse(bst, new ArrayList<Integer>());
        for (int i = 0; i < inOrderValues.size(); i++) {
            System.out.print(inOrderValues.get(i) + " ");
        }
        
        System.out.println("\nPre Order Trversal:");
        List<Integer> preOrderValues = preOrderTraverse(bst, new ArrayList<Integer>());
        for (int i = 0; i < preOrderValues.size(); i++) {
            System.out.print(preOrderValues.get(i) + " ");
        }
        
        System.out.println("\nPost Order Trversal:");
        List<Integer> postOrderValues = postOrderTraverse(bst, new ArrayList<Integer>());
        for (int i = 0; i < postOrderValues.size(); i++) {
            System.out.print(postOrderValues.get(i) + " ");
        }
    }

    public static List<Integer> inOrderTraverse(BST tree, List<Integer> array) {
       if (tree != null) {
           inOrderTraverse(tree.left, array);
           array.add(tree.value);
           inOrderTraverse(tree.right, array);
       }
        
        return array;
    }
    
    public static List<Integer> preOrderTraverse(BST tree, List<Integer> array) {
       if (tree != null) {
           array.add(tree.value);
           preOrderTraverse(tree.left, array);
           preOrderTraverse(tree.right, array);
       }
        
        return array;
    }
    
    public static List<Integer> postOrderTraverse(BST tree, List<Integer> array) {
       if (tree != null) {
           postOrderTraverse(tree.left, array);
           postOrderTraverse(tree.right, array);
           array.add(tree.value);
       }
        
        return array;
    }
}
