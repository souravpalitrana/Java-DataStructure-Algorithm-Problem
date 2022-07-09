/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jumpgamevi;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Leetcode: 1696. Jump Game VI
 * Problem Link: https://leetcode.com/problems/jump-game-vi/
 * @author souravpalit
 */
public class JumpGameVI {

    /*
    // TLE
    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        int [] jumps = new int [n];
        Arrays.fill(jumps, Integer.MIN_VALUE);
        jumps[0] = nums[0];
        
        for (int i = 1; i < n; i++) {
            for (int j = Math.max(i - k, 0); j < i; j++) {
                jumps[i] = Math.max(jumps[i], jumps[j] + nums[i]);
            }
        }
        
        return jumps[n - 1];
    }*/
    
    // TC: O(N) SCC: O(N)
    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        int [] jumps = new int [n];
        jumps[0] = nums[0];
        Deque<Integer> dq = new LinkedList<>();
        dq.offerLast(0);
        
        for (int i = 1; i < n; i++) {
            // pop the old index
            while (!dq.isEmpty() && dq.peekFirst() < i - k) {
                dq.pollFirst();
            }
            jumps[i] = jumps[dq.peek()] + nums[i];
            // pop the smaller value
            while (!dq.isEmpty() && jumps[i] >= jumps[dq.peekLast()]) {
                dq.pollLast();
            }
            dq.offerLast(i);
        }
        
        return jumps[n - 1];
    }
    
}
