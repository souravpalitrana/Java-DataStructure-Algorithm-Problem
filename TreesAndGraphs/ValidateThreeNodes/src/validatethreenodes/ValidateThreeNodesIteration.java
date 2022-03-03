/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validatethreenodes;

/**
 * Time Complexity: O(h) as maximum h node need to visit 
 * Space Complexity: O(1)
 * @author souravpalit
 */
public class ValidateThreeNodesIteration {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    

    public static boolean validateThreeNodes(BST nodeOne, BST nodeTwo, BST nodeThree) {
        // Write your code here.
        if (isDescendant(nodeOne, nodeTwo)) {
            return isDescendant(nodeTwo, nodeThree);
        }
        
        if (isDescendant(nodeThree, nodeTwo)) {
            return isDescendant(nodeTwo, nodeOne);
        }
        
        return false;
    }
    
    public static boolean isDescendant(BST node, BST target) {
        while (node != null && node != target) {
            if (target.value < node.value) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        
        return node == target;
    }
    
  
    static class BST {
        public int value;
        public BST left = null;
        public BST right = null;

        public BST(int value) {
        this.value = value;
        }
     }
}
