/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allnodedepth;

import java.util.Stack;

/**
 *
 * @author souravpalit
 */
public class AllNodeDepth {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
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

        System.out.println("Usinge Recursion Solutiion : " + getAllDepth(binaryTree));
        System.out.println("Usinge Iterative Solutiion : " + getDepthUsingIterativeSolution(binaryTree));
    }

    public static int getAllDepth(BinaryTree root) {
        if (root == null) return 0;
        
        return getDepth(root, 0) + getAllDepth(root.left) 
                + getAllDepth(root.right);
    }

    public static int getDepth(BinaryTree root, int depth) {
        if (root == null) return 0;
        
        return depth + getDepth(root.left, depth + 1)
                + getDepth(root.right, depth + 1);
    }
    
    public static int getAllDepthUsingIterativeSolution(BinaryTree root) {
        if (root == null) return 0;
        
        return getDepth(root, 0) + getAllDepth(root.left) 
                + getAllDepth(root.right);
    }
    
    // Iterative Solutiion
    public static int getDepthUsingIterativeSolution(BinaryTree root) {
        if (root == null) return 0;
        
        Stack<BinaryTree> stack = new Stack<BinaryTree>();
        stack.add(root);
        
        int sumOfNodeDepth = 0;
        
        while (!stack.isEmpty()) {
            BinaryTree node = stack.pop();
            if (node == null) {
                continue;
            } else {
                sumOfNodeDepth += getDepth(node, 0);
                stack.add(node.left);
                stack.add(node.right);
            }
        }
        
        return sumOfNodeDepth;
    } 
}
