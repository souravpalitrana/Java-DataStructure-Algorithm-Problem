/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flattenbinarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * Flatten Binary Tree: Write a function that takes in a Binary Tree, flattens it 
 * and returns its leftmost node. A flattened binary tree is structure that's 
 * nearly identical to a Doubly Linked List(except that nodes have left and right
 * pointers instead of prev and next pointers), where nodes follow the orginal 
 * tree's left to right order.
 * 
 * The flattening should be done in place, meaning that the orginal data structure
 * should be mutated(no new structure should be created)
 * @author souravpalit
 */
public class FlattenBinaryTree {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree(1);
        
        binaryTree.left = new BinaryTree(2);
        binaryTree.left.left = new BinaryTree(4);
        binaryTree.left.right = new BinaryTree(5);
        
        binaryTree.left.right.left = new BinaryTree(7);
        binaryTree.left.right.right = new BinaryTree(8);
        
        
        binaryTree.right = new BinaryTree(3);
        binaryTree.right.left = new BinaryTree(6);
        binaryTree.right.right= new BinaryTree(9);
        
        BinaryTree root = flattenBinaryTree(binaryTree);
        
        
        BinaryTree binaryTree2 = new BinaryTree(1);
        
        binaryTree2.left = new BinaryTree(2);
        binaryTree2.left.left = new BinaryTree(4);
        binaryTree2.left.right = new BinaryTree(5);
        
        binaryTree2.left.right.left = new BinaryTree(7);
        binaryTree2.left.right.right = new BinaryTree(8);
        
        
        binaryTree2.right = new BinaryTree(3);
        binaryTree2.right.left = new BinaryTree(6);
        binaryTree2.right.right= new BinaryTree(9);
        
        BinaryTree anotherRoot = fllattenBinaryTreeOptimiized(binaryTree2);
        System.out.println();
    }
    
    // Time Complexity: O(N) and Space Complexity: O(N)
    public static BinaryTree flattenBinaryTree(BinaryTree root) {
    
        List<BinaryTree> inOrderList = new ArrayList<BinaryTree>();
        inorderTraverse(root, inOrderList);
        
        for (int i = 0; i < inOrderList.size() - 1; i++) {
            BinaryTree leftNode = inOrderList.get(i);
            BinaryTree rightNode = inOrderList.get(i + 1);
            
            leftNode.right = rightNode;
            rightNode.left = leftNode;
        }
        
        return inOrderList.get(0);
    } 
    
    public static void inorderTraverse(BinaryTree startNode, List<BinaryTree> nodeList) {
        if (startNode != null) {
            inorderTraverse(startNode.left, nodeList);
            nodeList.add(startNode);
            inorderTraverse(startNode.right, nodeList);
        }
    }
    
    // Time complexity: O(N) Splace Complexity: O(D) where D is depth of BT
    public static BinaryTree fllattenBinaryTreeOptimiized(BinaryTree root) {
        BinaryTree [] nodes = getLeftAndRightMostValues(root);
        return nodes[0];
    } 
    
    public static BinaryTree [] getLeftAndRightMostValues(BinaryTree root) {
        BinaryTree leftMost = null;
        BinaryTree rightMost = null;
        
        if (root.left == null) {
            leftMost = root;
        }
        
        if (root.right == null) {
            rightMost = root;
        }
        
        if (root.left != null) {
            BinaryTree [] mostValues = getLeftAndRightMostValues(root.left);
            root.left = mostValues[1];
            mostValues[1].right = root;
            leftMost = mostValues[0];
        }
        
        if (root.right != null) {
            BinaryTree [] mostValues = getLeftAndRightMostValues(root.right);
            root.right = mostValues[0];
            mostValues[0].left = root;
            rightMost = mostValues[1];
        }
        
        return new BinaryTree[] {leftMost, rightMost};
    }
    
}
