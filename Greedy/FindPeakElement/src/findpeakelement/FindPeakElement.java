/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package findpeakelement;

/**
 * Leetcode : 162. Find Peak Element
 * Problem Link: https://leetcode.com/problems/find-peak-element/
 * @author souravpalit
 */
public class FindPeakElement {

    // Time Complexity: O(n) Space Complexity::O(1)
    public int findPeakElement(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (i == nums.length - 1) {
                if (nums[i] > nums[i - 1] ) {
                    return i;
                }
            } else {
               if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1] ) {
                    return i;
                } 
            }
        }
        return 0;
    }
}
