/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numberofbinarytreetopologies;

import java.util.ArrayList;
import java.util.List;

/**
 * Time Complexity: O(n^2) Space Complexity: O(n)
 * @author souravpalit
 */
public class NumberOfBinaryTreeTopologiesIterative {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int nodeCount = 3;
        System.out.println(numberOfBinaryTreeTopologies(nodeCount));
    }
    
    public static int numberOfBinaryTreeTopologies(int n) {
        List<Integer> cache = new ArrayList<Integer>();
        cache.add(1);
        
        
        for (int i = 1; i < n + 1; i++) {
            int numberOfTrees = 0;
            for (int leftTreeSize = 0; leftTreeSize < i; leftTreeSize++) {
                int rightTreeSize = i - 1 - leftTreeSize;
                int numberOfLeftTrees = cache.get(leftTreeSize);
                int numberOfRightTrees = cache.get(rightTreeSize);
                numberOfTrees += numberOfLeftTrees * numberOfRightTrees;
            }
            
            cache.add(numberOfTrees);
        }
        
       return cache.get(n);
    }
}
    
    
     

