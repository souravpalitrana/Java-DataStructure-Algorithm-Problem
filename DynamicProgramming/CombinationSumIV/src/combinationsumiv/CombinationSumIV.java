/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package combinationsumiv;

import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode: 377. Combination Sum IV
 * Problem Link: https://leetcode.com/problems/combination-sum-iv/
 * @author souravpalit
 */
public class CombinationSumIV {

    private Map<Integer, Integer> cache;
    
    // TC: O(TN) where T is the target value and N is the size of nums
    public int combinationSum4(int[] nums, int target) {
        cache = new HashMap<>();
        return getWays(nums, target);
    }
    
    public int getWays(int [] nums, int target) {
        if (cache.containsKey(target)) {
            return cache.get(target);
        }
        if (target == 0) {
            return 1;
        }
        int ways = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= target) {
                int remaining = target - nums[i];
                    ways += getWays(nums, remaining);
            }
        }
        cache.put(target, ways);
        return ways;
    }
    
}
