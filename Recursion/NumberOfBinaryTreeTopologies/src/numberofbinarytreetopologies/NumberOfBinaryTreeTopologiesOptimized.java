/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numberofbinarytreetopologies;

import java.util.HashMap;

/**
 * Time Complexity: O(n^2) Space Complexity: O(n)
 * @author souravpalit
 */
public class NumberOfBinaryTreeTopologiesOptimized {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int nodeCount = 3;
        System.out.println(numberOfBinaryTreeTopologies(nodeCount));
    }
    
    public static int numberOfBinaryTreeTopologies(int n) {
        HashMap<Integer, Integer> cache = new HashMap<Integer, Integer>();
        cache.put(0, 1);
        return numberOfBinaryTreeTopologies(n, cache);
    }
    
    public static int numberOfBinaryTreeTopologies(int n, HashMap<Integer, Integer> cache) {
        if (cache.containsKey(n)) {
            return cache.get(n);
        }
        
        int numberOfTrees = 0;
        for (int leftNode = 0; leftNode < n ; leftNode++) {
            int rightNode = n - 1 - leftNode;
            int leftCount = numberOfBinaryTreeTopologies(leftNode);
            int rightCount = numberOfBinaryTreeTopologies(rightNode);
            numberOfTrees += leftCount * rightCount;
        }

        cache.put(n, numberOfTrees);
        return numberOfTrees;
    }
}
    
    
     

