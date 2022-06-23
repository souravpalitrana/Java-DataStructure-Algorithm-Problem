/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jumpgameii;

import java.util.Arrays;

/**
 *
 * @author souravpalit
 */
public class JumpGameII {

    // Dp Recursion
    public int jump(int[] nums) {
        int[] cache = new int[nums.length];
        Arrays.fill(cache, -1);
        return minJump(nums, 0, cache);
    }

    public int minJump(int[] nums, int position, int[] cache) {
        // nums.length - 1 because when we reach the last position or pass the
        // last position we do not need any other jump. So we can return 0
        if (position >= nums.length - 1) {
            return 0;
        }

        if (cache[position] != -1) {
            return cache[position];
        }
        int minJump = Integer.MAX_VALUE;
        for (int i = 1; i <= nums[position]; i++) {
            int jump = minJump(nums, position + i, cache);
            if (jump != Integer.MAX_VALUE) {
                minJump = Math.min(jump + 1, minJump);
            }
        }

        cache[position] = minJump;
        return minJump;
    }

    // TC: O(n^2) SC: O(n)
    public int jumpFirstAlternate(int[] nums) {
        int[] jumps = new int[nums.length];
        Arrays.fill(jumps, Integer.MAX_VALUE);
        jumps[0] = 0;

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] >= i - j) {
                    jumps[i] = Math.min(jumps[i], 1 + jumps[j]);
                }
            }
        }

        return jumps[jumps.length - 1];
    }

    // Time Complexity: O(n) SC: O(1)
    public int jumpOptimize(int[] array) {
        if (array.length == 1) {
            return 0;
        }

        int jumps = 1;
        int maxReach = array[0];
        int steps = array[0];

        for (int i = 1; i < array.length - 1; i++) {
            maxReach = Math.max(maxReach, array[i] + i);
            steps--;

            if (steps == 0) {
                jumps++;
                steps = maxReach - i;
            }
        }

        return jumps;
    }
}
