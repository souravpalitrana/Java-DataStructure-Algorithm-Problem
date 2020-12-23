/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package branchsums;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author souravpalit
 */
public class BranchSums {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
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
            // It is leaf node. We got a branch
            branchSum.add(sum);
        }
    }
}
