/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package branchsums;

import java.util.ArrayList;
import java.util.List;

/**
 * Write a function that takes in a Binary Tree and returns a list of its branch
 * sums ordered from leftmost branch sum to rightmost branch sum.
 * A branch sum is the sum of all values in a Binary Tree branch. A Binary Tree
 * branch is a path of nodes in a tree that starts at the root node and ends at 
 * any leaf node. That means number of leaf = number of branches.
 * Time complexity: O(N) and Space Complexity O(N)
 * @author souravpalit
 */
public class BranchSums {

    /**
     * @param args the command line arguments
     */
    /*public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree(1);
        
        binaryTree.left = new BinaryTree(2);
        binaryTree.left.left = new BinaryTree(4);
        binaryTree.left.left.left = new BinaryTree(8);
        binaryTree.left.left.right = new BinaryTree(9);
        
        binaryTree.left.right = new BinaryTree(5);
        binaryTree.left.right.left = new BinaryTree(10);
        
        binaryTree.right = new BinaryTree(3);
        binaryTree.right.left = new BinaryTree(6);
        binaryTree.right.right = new BinaryTree(7);
        
        List<Integer> branchSum = findBranchSum(binaryTree);
        
        for (Integer sum : branchSum) {
            System.out.println(sum);
        }
    }*/
    
    public static void main(String args[]) { 
        BinaryTree tree = new BinaryTree(); 
        /*tree.root = new Node(1); 
        tree.root.left = new Node(2); 
        tree.root.right = new Node(10); 
        tree.root.left.left = new Node(4); 
        tree.root.left.right = new Node(1); 
        tree.root.right.right = new Node(-25); 
        tree.root.right.right.left = new Node(3); 
        tree.root.right.right.right = new Node(4); 
        System.out.println("maximum path sum is : " + 
                            tree.findMaxSum()); */
        tree.root = new Node(1);
        addNodes(tree.root, -10, -5);
        addNodes(tree.root.left, 30, 75);
        addNodes(tree.root.left.left, 5, 1);
        addLeftNodes(tree.root.left.left.left, 100);
        addNodes(tree.root.left.right, 3, -3);
        addNodes(tree.root.right, -20, -21);
        addNodes(tree.root.right.left, 100, 2);
        addNodes(tree.root.right.right, -100, 1);
        System.out.println("maximum path sum is : " + 
                            tree.findMaxSum()); 
    }
    
    public static void addNodes(Node tree, int left, int right) {
        tree.left = new Node(left);
        tree.right = new Node(right);
    }
    
    public static void addLeftNodes(Node tree, int left) {
        tree.left = new Node(left);
    }
    
    public static void addRightNodes(Node tree, int right) {
        tree.right = new Node(right);
    }
    
    
    
    public static List<Integer> findBranchSum(BinaryTree startNode) {
        List<Integer> branchSum = new ArrayList<Integer>();
        findBranchSum(startNode, 0, branchSum);
        return branchSum;
    }
           
    public static void findBranchSum(BinaryTree startNode, int sum, List<Integer> branchSum) {
        sum = sum + startNode.value;
        
        if (startNode.left != null) {
            findBranchSum(startNode.left, sum, branchSum);
        }
        
        if (startNode.right != null) {
            findBranchSum(startNode.right, sum, branchSum);
        }
        
        if (startNode.left == null && startNode.right == null) {
            // It is leaf node. So we got a branch
            branchSum.add(sum);
        }
    }
}
