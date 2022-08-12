/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package houserobber;

/**
 * 198. House Robber
 * Problem Link: https://leetcode.com/problems/house-robber/
 * @author souravpalit
 */
public class HouseRobber {

    // TC: O(n) SC: O(1)
    public int rob(int[] nums) {
        if (nums.length < 2) {
            return nums.length == 0 ? 0 : nums[0];
        }
        
        int nMinusTwo = nums[0];
        // In case of second day max. profit will be maximum of first and second
        // day as we could not rob 1 and 2 together as they are adjacent so we 
        // need to rob either one
        int nMinusOne = Math.max(nums[0], nums[1]); 
        
        for (int n = 2; n < nums.length; n++) {
            int max = Math.max(nMinusTwo + nums[n], nMinusOne);
            nMinusTwo = nMinusOne;
            nMinusOne = max;
        }
        
        return nMinusOne;
    }
    
}
