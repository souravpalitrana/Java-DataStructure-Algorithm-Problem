/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minimaltree;

/**
 *
 * @author souravpalit
 */
public class BST {
    private int value;
    private BST left;
    private BST right;
    
    public BST(int value) {
        this.value = value;
    }
    
    public void addToLeft(BST leftNode) {
        this.left = leftNode;
    }
    
    public void addToRight(BST rightNodee) {
        this.right = rightNodee;
    }
    
    public BST getLeftNode() {
        return left;
    }
    
    public BST getRightNode() {
        return right;
    }
    
    public int getValue() {
        return value;
    }
}
