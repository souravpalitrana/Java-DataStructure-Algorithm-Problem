/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package findclosestvalueinbst;

/**
 * Time Complexity: Average Case O(logn) Space Complexity: O(1)
 * Worst Case O(n) Space Complexity: O(1) When tree is only left aligned or 
 * only right aligned
 * @author souravpalit
 */
public class FindClosestValueInBSTIteration {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BST tree = generateSampleBST();
        int target = 12;
        
        System.out.println(findClosestValueInBst(tree, target));
    }
    
     public static int findClosestValueInBst(BST tree, int target) {
         int closest = tree.value;
         while (tree != null) {
             if (Math.abs(tree.value - target) < Math.abs(closest - target)) {
                 closest = tree.value;
             }
             
             if (tree.value > target) {
                 tree = tree.left;
             } else if (tree.value < target) {
                 tree = tree.right;
             } else {
                 // In case same value
                 break;
             }
         }
         
         return closest;
     }
     
     public static int findClosestValueInBst(BST tree, int target, int closest) {
        if (Math.abs(tree.value - target) < Math.abs(closest - target)) {
            closest = tree.value;
        }
        
        if (tree.value > target && tree.left != null) {
            closest = findClosestValueInBst(tree.left, target, closest);
        } else if (tree.value < target && tree.right != null){
            closest = findClosestValueInBst(tree.right, target, closest);
        }
        
        return closest;
     }
    
    public static BST generateSampleBST() {
        BST root = new BST(10);
        root.left = new BST(5);
        root.left.left = new BST(2);
        root.left.left.left = new BST(1);
        root.left.right = new BST(5);
        root.right = new BST(15);
        root.right.left = new BST(13);
        root.right.left.right = new BST(14);
        root.right.right = new BST(22);
        
        return root;
    }
}
