/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maximumsubarray;

/**
 * Leetcode: 53. Maximum Subarray
 * Problem Link: https://leetcode.com/problems/maximum-subarray/
 * @author souravpalit
 */
public class MaximumSubarray {

    // Kadanes Algorithm
    // TC: O(N) SC: O(1)
    public int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int runningSum = nums[0];
        int maxSum = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            //  Either we will add the value if it creates the high value than previous
            //  or will take the new value
            runningSum = Math.max(num, runningSum + num);
            maxSum = Math.max(maxSum, runningSum);
        }
        
        return maxSum;
    }
    
}
