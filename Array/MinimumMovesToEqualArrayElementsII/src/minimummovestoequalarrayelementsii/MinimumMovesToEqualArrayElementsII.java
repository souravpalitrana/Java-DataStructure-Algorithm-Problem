/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minimummovestoequalarrayelementsii;

import java.util.Arrays;

/**
 * Leetcode: 462. Minimum Moves to Equal Array Elements II
 * Problem Link: https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/
 * @author souravpalit
 */
public class MinimumMovesToEqualArrayElementsII {

    // TC: O(nlogn) SC: O(1)
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int mid = nums[nums.length / 2];
        int movesCount = 0;
        for (int i = 0; i < nums.length; i++) {
            movesCount += Math.abs(mid - nums[i]);
        }
        
        return movesCount;
    }
}
