/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package findsuccessor;

/**
 *
 * @author souravpalit
 */
public class BinaryTree {
    
    public int value;
    public BinaryTree left;
    public BinaryTree right;
    public BinaryTree parent;
    
    public BinaryTree(int value) {
        this.value = value;
    }
    
    public BinaryTree(int value, BinaryTree parent) {
        this.value = value;
        this.parent = parent;
    }
}
