/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slidingwindowmaximum;

import java.util.ArrayDeque;

/**
 * Leetcode: 239. Sliding Window Maximum
 * Problem Link: https://leetcode.com/problems/sliding-window-maximum/
 * @author souravpalit
 */
public class SlidingWindowMaximum {

    // TC: O(n) SC: O(n)
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayDeque<Integer> deq = new ArrayDeque<>();
        int n = nums.length;
        
        if (n * k == 0) {
            return new int [0];
        }
        
        int [] result = new int [n - k + 1];
        
        for (int i = 0; i < n; i++) {
            // Remove index which is not part of the sliding window
            if (!deq.isEmpty() && deq.getFirst() == i - k) {
                deq.removeFirst();
            }
            
            // Reomove from first those indexes which values less or equal than
            // current value as they could not be the largest value
            while (!deq.isEmpty() && nums[deq.getLast()] <= nums[i]) {
                deq.removeLast();
            }
            
            deq.addLast(i);
            
            if (i >= k - 1) {
                result[i - k + 1] = nums[deq.getFirst()];
            }
        }
        
        return result;
    }
    
}
