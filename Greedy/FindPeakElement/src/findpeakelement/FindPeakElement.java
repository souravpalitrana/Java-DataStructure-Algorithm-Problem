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
    
    // Time Complexity: O(logn) Space Complexity::O(1)
    public int findPeakElementOptimize(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        
        while (low < high) {
            int mid = (low + high) / 2;
            
            if (nums[mid] > nums[mid + 1]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        
        return low;
    }
}
