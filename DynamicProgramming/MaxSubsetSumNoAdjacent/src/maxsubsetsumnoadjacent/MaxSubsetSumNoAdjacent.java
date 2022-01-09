/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maxsubsetsumnoadjacent;

/**
 * 
 * @author souravpalit
 */
public class MaxSubsetSumNoAdjacent {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int [] array = {75, 105, 120, 75, 90, 135};
        System.out.println(maxSubsetSumNoAdjacent(array));
        System.out.println(maxSubsetSumNoAdjacentOptimized(array));
    }
    
    // Time Complexity: O(n) Space Complexity: O(n)
    public static int maxSubsetSumNoAdjacent(int [] array) {
        if (array.length == 0) {
            return 0;
        } else if (array.length == 1) {
            return array[0];
        }
        
        int [] maxSums = new int [array.length];
        maxSums[0] = array[0];
        maxSums[1] = Math.max(array[0], array[1]);
        
        for (int i = 2; i < array.length; i++) {
            maxSums[i] = Math.max(maxSums[i - 1], maxSums[i - 2] + array[i]);
        }
               
        return maxSums[array.length - 1];
    }
    
    // Time complexity: O(n) Space Complexity: O(1)
    public static int maxSubsetSumNoAdjacentOptimized(int [] array) {
        if (array.length == 0) {
            return 0;
        } else if (array.length == 1) {
            return array[0];
        }
        
        int [] maxSums = new int [array.length];
        int first = array[0];
        int second = Math.max(array[0], array[1]);
        
        for (int i = 2; i < array.length; i++) {
            int current = Math.max(second, first + array[i]);
            first = second;
            second = current;
        }
               
        return second;
    }
    
}
