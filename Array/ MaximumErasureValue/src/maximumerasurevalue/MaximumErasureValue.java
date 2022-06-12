/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maximumerasurevalue;

import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode: 1695. Maximum Erasure Value
 * Problem Link: https://leetcode.com/problems/maximum-erasure-value/
 * @author souravpalit
 */
public class MaximumErasureValue {

    // Time Complexity: O(n) Space Complexity: O(n)
    public int maximumUniqueSubarray(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> lastIndexMap = new HashMap<>();
        int[] prefixSum = new int[n + 1];

        int result = 0, start = 0;
        for (int end = 0; end < n; end++) {
            int currentElement = nums[end];
            prefixSum[end + 1] = prefixSum[end] + currentElement;
            if (lastIndexMap.containsKey(currentElement)) {
                start = Math.max(start, lastIndexMap.get(currentElement) + 1);
            }
            // update result with maximum sum found so far
            result = Math.max(result, prefixSum[end + 1] - prefixSum[start]);
            lastIndexMap.put(currentElement, end);
        }
        return result;
    }
    
}
