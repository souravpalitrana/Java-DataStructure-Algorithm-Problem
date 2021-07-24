/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numberofbinarytreetopologies;

/**
 * Time Complexity: Upper Bound: O((n* (2n+1)!)/(n!(n+1)!)) Space Complexity: O(n)
 * @author souravpalit
 */
public class NumberOfBinaryTreeTopologies {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int nodeCount = 3;
        System.out.println(numberOfBinaryTreeTopologies(nodeCount));
    }
    
    public static int numberOfBinaryTreeTopologies(int n) {

        if (n == 0) {
            return 1;
        }

        int numberOfTrees = 0;
        for (int leftTreeSize = 0; leftTreeSize < n; leftTreeSize++) {
            int rightTreeSize = n - 1 - leftTreeSize;
            int numberOfLeftTrees = numberOfBinaryTreeTopologies(leftTreeSize);
            int numberOfRightTrees = numberOfBinaryTreeTopologies(rightTreeSize);
            numberOfTrees = numberOfTrees + numberOfLeftTrees * numberOfRightTrees;
        }

        return numberOfTrees;
    }
}
    
    
     

