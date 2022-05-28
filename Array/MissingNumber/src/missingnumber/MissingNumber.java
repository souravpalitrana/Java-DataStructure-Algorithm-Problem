/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package missingnumber;

/**
 * Leetcode '268. Missing Number' problem solution.
 * @author souravpalit
 */
public class MissingNumber {

    // Time Complexity: O(n) Space Complexity: O(1)
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int expectedSum = (n * (n + 1)) / 2; // n sum formula (n * (n+1))/2
        int actualSum = 0;
        
        for (int num : nums) {
            actualSum += num;
        }
        
        return Math.abs(expectedSum - actualSum);
    }
    
}
