/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bsttraversal;

/**
 *
 * @author souravpalit
 */
public class BST {
    
    public int value;
    public BST left;
    public BST right;
    
    public BST(int value) {
        this.value = value;
    }
    
     public BST insert(int value) {
        BST currentNode = this;

        while (true) {
            if (value < currentNode.value) {
                if (currentNode.left == null) {
                    currentNode.left = new BST(value);
                    break;
                } else {
                    currentNode = currentNode.left;
                }
            } else {
                if (currentNode.right == null) {
                    currentNode.right = new BST(value);
                    break;
                } else {
                    currentNode = currentNode.right;
                }
            }
        }

        return this;
    }
    
}
