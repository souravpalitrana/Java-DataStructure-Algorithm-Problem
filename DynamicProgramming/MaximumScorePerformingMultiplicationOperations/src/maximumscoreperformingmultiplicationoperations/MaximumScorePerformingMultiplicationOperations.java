/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maximumscoreperformingmultiplicationoperations;

/**
 * Leetcode daily challenge: 16 September 2022
 * Problem Link: https://leetcode.com/problems/maximum-score-from-performing-multiplication-operations/
 * @author souravpalit
 */
public class MaximumScorePerformingMultiplicationOperations {

    private int nums [];
    private int mul [];
    private int m;
    private int n;
    private Integer [][] cache;
    
    // TC: O(M^2) SC: O(M^2) where M is the length of multipliers
    public int maximumScore(int[] nums, int[] multipliers) {
        n = nums.length;
        m  = multipliers.length;
        this.nums = nums;
        this.mul = multipliers;
        cache = new Integer [m][n];
        int result = maximumScore(0, 0);
        return result;
    }
    
    private int maximumScore(int opIdx, int numIdx) {
        if (opIdx  >= m || numIdx >= n) {
            return 0;
        } if (cache[opIdx][numIdx] != null) {
            return cache[opIdx][numIdx];
        }
        int rightNumIdx  = n - 1  - (opIdx - numIdx);
        int left = nums[numIdx] * mul[opIdx] + maximumScore(opIdx + 1, numIdx + 1);
        int right = nums[rightNumIdx] * mul[opIdx] + maximumScore(opIdx + 1, numIdx);
        
        cache[opIdx][numIdx] = Math.max(left, right);
        return cache[opIdx][numIdx];
    }
    
}
