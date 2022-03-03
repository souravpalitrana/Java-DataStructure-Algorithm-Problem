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
public class ReconstructBSTOptimized {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       ArrayList<Integer> preOrderTraversalValues =
        new ArrayList<Integer>(Arrays.asList(10, 4, 2, 1, 5, 17, 19, 18));
       TreeInfo treeInfo = new TreeInfo(0);
       BST root = reconstructBst(Integer.MIN_VALUE, Integer.MAX_VALUE, preOrderTraversalValues, treeInfo);
       System.out.println(root.value);
    }
    
    public static BST reconstructBst(int lowerBound, int upperBound, List<Integer> preOrderTraversalValues, TreeInfo treeInfo) {
        if (treeInfo.rootIdx >= preOrderTraversalValues.size()) {
            return null;
        }
        
        int rootValue = preOrderTraversalValues.get(treeInfo.rootIdx);
        // if no value found then this value work as out of array position which
        // leads to empty array
        if (rootValue < lowerBound || rootValue >= upperBound) {
            return null;
        }
        
        treeInfo.rootIdx += 1;
        // from value inclusive and toValue exclusive
        BST leftSubTree = reconstructBst(lowerBound, rootValue, preOrderTraversalValues, treeInfo);
        BST rightSubTree = reconstructBst(rootValue, upperBound, preOrderTraversalValues, treeInfo);
        
        BST bst = new BST(rootValue);
        bst.left = leftSubTree;
        bst.right = rightSubTree;   
        
        return bst;
    }
    
    static class TreeInfo {
        public int rootIdx;
		
        public TreeInfo(int rootIdx) {
            this.rootIdx = rootIdx;
        }
    }
}
