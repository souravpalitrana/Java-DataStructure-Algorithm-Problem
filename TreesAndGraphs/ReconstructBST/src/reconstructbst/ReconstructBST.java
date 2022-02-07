/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reconstructbst;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author souravpalit
 */
public class ReconstructBST {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       ArrayList<Integer> preOrderTraversalValues =
        new ArrayList<Integer>(Arrays.asList(10, 4, 2, 1, 3, 17, 19, 18));
       BST root = reconstructBst(preOrderTraversalValues);
    }
    
    public static BST reconstructBst(List<Integer> preOrderTraversalValues) {
        if (preOrderTraversalValues.size() == 0) {
            return null;
        }
        
        int rootValue = preOrderTraversalValues.get(0);
        // if no value found then this value work as out of array position which
        // leads to empty array
        int rightSubTreeIdx = preOrderTraversalValues.size(); 
        
        for (int i = 1; i < preOrderTraversalValues.size(); i++) {
            int value = preOrderTraversalValues.get(i);
            if (value >= rootValue) {
                rightSubTreeIdx = i;
                break;
            }
        }
        // from value inclusive and toValue exclusive
        BST leftSubTree = reconstructBst(preOrderTraversalValues.subList(1, rightSubTreeIdx));
        BST rightSubTree = reconstructBst(preOrderTraversalValues.subList(rightSubTreeIdx, preOrderTraversalValues.size()));
        
        BST bst = new BST(rootValue);
        bst.left = leftSubTree;
        bst.right = rightSubTree;
        
        
        return bst;
    }
    
}
