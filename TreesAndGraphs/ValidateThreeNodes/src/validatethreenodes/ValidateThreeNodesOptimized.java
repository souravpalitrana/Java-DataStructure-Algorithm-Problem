/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validatethreenodes;

/**
 * Time Complexity: O(d) where d is th distance between nodeOne to nodeThree or
 * nodeThree to nodeOne
 * Space Complexity: O(1) 
 * @author souravpalit
 */
public class ValidateThreeNodesOptimized {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    

    public static boolean validateThreeNodes(BST nodeOne, BST nodeTwo, BST nodeThree) {
        BST searchOne = nodeOne;
        BST searchTwo = nodeThree;
        
        // Finding nodeTwo one nodeOne and nodeThree
        while (true) {
            boolean isNodeOneFoundFromNodeThree = searchTwo == nodeOne;
            boolean isNodeThreeFoundFromNodeOne = searchOne == nodeThree;
            boolean isNodeTwoFound = searchOne == nodeTwo || searchTwo == nodeTwo;
            boolean isSearchFinished = searchOne == null && searchTwo == null;
            
            if (isNodeOneFoundFromNodeThree || isNodeThreeFoundFromNodeOne || isNodeTwoFound || isSearchFinished) {
                break;
            }
            
            if (searchOne != null) {
                searchOne = (nodeTwo.value < searchOne.value) ? searchOne.left : searchOne.right;
            }
            
            if (searchTwo != null) {
                searchTwo = (nodeTwo.value < searchTwo.value) ? searchTwo.left : searchTwo.right;
            }
        }
        
        boolean isNodeTwoFound = searchOne == nodeTwo || searchTwo == nodeTwo;
        boolean foundNodeFromOneAnother = searchOne == nodeThree || searchTwo == nodeOne;
        
        if (!isNodeTwoFound || foundNodeFromOneAnother) {
            return false; 
        }
        
        return isDescendant(nodeTwo, (searchOne == nodeTwo) ? nodeThree : nodeOne);
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
