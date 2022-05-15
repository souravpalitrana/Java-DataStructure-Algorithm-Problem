/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deepestleavessum;

/**
 *
 * @author souravpalit
 */
public class DeepestLeavesSum {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        
        root.left.left.left = new TreeNode(7);
        
        root.right.right = new TreeNode(6);
        root.right.right.right = new TreeNode(8);*/
        
        //6,7,8,2,7,1,3,9,null,1,4,null,null,null,5
        
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(7);
        root.right = new TreeNode(8);
        
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(7);
        
        root.left.left.left = new TreeNode(9);
        
        root.left.right.left = new TreeNode(1);
        root.left.right.right = new TreeNode(4);
        
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(3);
        
        root.right.right.right = new TreeNode(5);
        
        DeepestLeavesSumSolution solution = new DeepestLeavesSumSolution();
        System.out.println(solution.deepestLeavesSum(root));
    }
    
    
    
}
