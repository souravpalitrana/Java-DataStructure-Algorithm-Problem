/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package findsuccessor;

import java.util.ArrayList;
import java.util.List;

/**
 * Time Complexity: O(n) and Space Complexity: O(n)
 * @author souravpalit
 */
public class FindSuccessor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree(1);

        binaryTree.left = new BinaryTree(2);
        binaryTree.left.left = new BinaryTree(4);
        binaryTree.left.right = new BinaryTree(5);
        
        binaryTree.left.left.left = new BinaryTree(6);

        binaryTree.right = new BinaryTree(3);
        BinaryTree tree = findSuccessorAlter(binaryTree, binaryTree.left.right).successor;
        
        //BinaryTree binaryTree = new BinaryTree(1);

        /*binaryTree.left = new BinaryTree(2, binaryTree);
        binaryTree.left.left = new BinaryTree(4, binaryTree.left);
        binaryTree.left.right = new BinaryTree(5, binaryTree.left);
        
        binaryTree.left.left.left = new BinaryTree(6, binaryTree.left.left);

        binaryTree.right = new BinaryTree(3, binaryTree);
        
        BinaryTree tree = findSuccessor(binaryTree, binaryTree.left.right);*/
        
        /*binaryTree.left = new BinaryTree(2, binaryTree);
        binaryTree.right = new BinaryTree(3, binaryTree);
        binaryTree.left.left = new BinaryTree(4, binaryTree.left);
        binaryTree.left.right = new BinaryTree(5, binaryTree.left);
        binaryTree.left.right.left = new BinaryTree(6, binaryTree.left.right);
        binaryTree.left.right.right = new BinaryTree(7, binaryTree.left.right);
        binaryTree.left.right.right.left = new BinaryTree(8, binaryTree.left.right.right);
        BinaryTree tree = findSuccessorAlter(binaryTree, binaryTree.left.right).successor;*/
        
        System.out.println(tree.value);
    }
    
    public static BinaryTree findSuccessor(BinaryTree root, BinaryTree node) {
        if (root == null) {
            return null;
        } 
        
        List<BinaryTree> nodeList = new ArrayList<BinaryTree>();
        addNodesUsingInOrder(root, nodeList);
        
        for (int i = 0; i < nodeList.size(); i++) {
            if (nodeList.get(i) == node) {
                if (i + 1 < nodeList.size()) {
                    return nodeList.get(i + 1);
                } else {
                    return null;
                }
            }
        }
        
        return null;
    }
    
    public static void addNodesUsingInOrder(BinaryTree root, List<BinaryTree> successors) {
        if (root != null) {
            addNodesUsingInOrder(root.left, successors);
            successors.add(root);
            addNodesUsingInOrder(root.right, successors);
        }
    }
    
    public static NodeInfo findSuccessorAlter(BinaryTree root, BinaryTree node) {
        if (root == null) {
            return null;
        } 
        
        NodeInfo successor;
        boolean isFound = false;
        
        successor = findSuccessorAlter(root.left, node);
        
        if (successor != null && successor.isFound && successor.successor == null) {
            return new NodeInfo(root, true);
        } else if (root == node) {
            isFound = true;
        }
        
        successor = findSuccessorAlter(root.right, node);
        if (successor != null && !successor.isFound) {
            successor.isFound = isFound;
        } else if (isFound) {
            successor = new NodeInfo(null, isFound);
        }
        
        return successor;
    }
    
    public static class NodeInfo {
        public BinaryTree successor;
        public boolean isFound;
        
        public NodeInfo(BinaryTree successor, boolean isFound) {
            this.successor = successor;
            this.isFound = isFound;
        }
    }
    
}
