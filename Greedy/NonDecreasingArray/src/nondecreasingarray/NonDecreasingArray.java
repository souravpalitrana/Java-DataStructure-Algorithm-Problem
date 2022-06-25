/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nondecreasingarray;

/**
 * LeetCode: 665. Non-decreasing Array 
 * Problem Link: https://leetcode.com/problems/non-decreasing-array/
 * @author souravpalit
 */
public class NonDecreasingArray {

    // TC: O(N) SC: O(1)
    public boolean checkPossibility(int[] nums) {
        boolean isViolated = false;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) {
                if (isViolated) {
                    return false;
                }

                isViolated = true;
                if (i < 2 || nums[i - 2] <= nums[i]) {
                    nums[i - 1] = nums[i];
                } else {
                    nums[i] = nums[i - 1];
                }

            }
        }

        return true;
    }
}
