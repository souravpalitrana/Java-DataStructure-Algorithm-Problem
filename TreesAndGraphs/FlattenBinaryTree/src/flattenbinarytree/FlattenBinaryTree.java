/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flattenbinarytree;

import java.util.ArrayList;
import java.util.List;

/**
 *
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
        
        BinaryTree root = flattenBinaryTree(binaryTree);
        
        
        BinaryTree binaryTree2 = new BinaryTree(1);
        
        binaryTree2.left = new BinaryTree(2);
        binaryTree2.left.left = new BinaryTree(4);
        binaryTree2.left.right = new BinaryTree(5);
        
        binaryTree2.left.right.left = new BinaryTree(7);
        binaryTree2.left.right.right = new BinaryTree(8);
        
        
        binaryTree2.right = new BinaryTree(3);
        binaryTree2.right.left = new BinaryTree(6);
        
        BinaryTree anotherRoot = fllattenBinaryTreeOptimiized(binaryTree2);
        System.out.println();
    }
    
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
    
    public static BinaryTree fllattenBinaryTreeOptimiized(BinaryTree root) {
        BinaryTree [] nodes = getLeftAndRightMostValues(root);
        return nodes[0];
    } 
    
    public static BinaryTree [] getLeftAndRightMostValues(BinaryTree root) {
        BinaryTree leftTreeMostRightNode = null;
        BinaryTree rightTreeMostLeftNode = null;
        
        if (root.left == null) {
            leftTreeMostRightNode = root;
        }
        
        if (root.right == null) {
            rightTreeMostLeftNode = root;
        }
        
        if (root.left != null) {
            BinaryTree [] mostValues = getLeftAndRightMostValues(root.left);
            root.left = mostValues[1];
            mostValues[1].right = root;
            leftTreeMostRightNode = mostValues[0];
        }
        
        if (root.right != null) {
            BinaryTree [] mostValues = getLeftAndRightMostValues(root.right);
            root.right = mostValues[0];
            mostValues[0].left = root;
            rightTreeMostLeftNode = mostValues[1];
        }
        
        return new BinaryTree[] {leftTreeMostRightNode, rightTreeMostLeftNode};
    }
    
}
