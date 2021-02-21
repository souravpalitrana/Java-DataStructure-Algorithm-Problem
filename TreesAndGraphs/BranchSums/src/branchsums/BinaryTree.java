/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package branchsums;

/**
 *
 * @author souravpalit
 */
public class BinaryTree {
    public int value;
    public BinaryTree left;
    public BinaryTree right;
    
    /*public BinaryTree(int value) {
        this.value = value;
    }*/
    
    // Root of the Binary Tree 
    Node root; 
  
    // This function returns overall maximum path sum in 'res' 
    // And returns max path sum going through root. 
    int findMaxUtil(Node node, Res res) 
    { 
  
        // Base Case 
        if (node == null) 
            return 0; 
  
        // l and r store maximum path sum going through left and 
        // right child of root respectively 
        int l = findMaxUtil(node.left, res); 
        int r = findMaxUtil(node.right, res); 
  
        // Max path for parent call of root. This path must 
        // include at-most one child of root 
        int max_single = Math.max(Math.max(l, r) + node.data, 
                                  node.data); 
  
  
        // Max Top represents the sum when the Node under 
        // consideration is the root of the maxsum path and no 
        // ancestors of root are there in max sum path 
        int max_top = Math.max(max_single, l + r + node.data); 
  
        // Store the Maximum Result. 
        res.val = Math.max(res.val, max_top); 
  
        return max_single; 
    } 
  
    int findMaxSum() { 
        return findMaxSum(root); 
    } 
  
    // Returns maximum path sum in tree with given root 
    int findMaxSum(Node node) { 
  
        // Initialize result 
        // int res2 = Integer.MIN_VALUE; 
        Res res = new Res(); 
        res.val = Integer.MIN_VALUE; 
  
        // Compute and return result 
        findMaxUtil(node, res); 
        return res.val; 
    } 
 
}
