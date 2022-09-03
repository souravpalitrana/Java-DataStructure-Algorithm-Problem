/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numberswithsameconsecutivedifferences;

import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode: 967. Numbers With Same Consecutive Differences
 * Problem Link: https://leetcode.com/problems/numbers-with-same-consecutive-differences/
 * @author souravpalit
 */
public class NumbersWithSameConsecutiveDifferences {

    // TC: O(2^n)
    // SC:: O(2^n) for the recursion call stack
    private List<Integer> result;
    public int[] numsSameConsecDiff(int n, int k) {
        result = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            generate(1, n, k, i);
        }
        
        return result.stream().mapToInt(i->i).toArray();
    }
    
    public void generate(int pos, int n, int k, int num) {
        if (pos >= n) {
            result.add(num);
            return;
        }
    
        int previousNum = num % 10;
        int nextDigitFront = previousNum - k; 
        int nextDigitBack = previousNum + k;
        
        // If k == 0 in that case adding 0 and subtracting 0 is the same number
        if (nextDigitFront >= 0 && k != 0) {
            int currentNum = num * 10  + nextDigitFront;
            generate(pos + 1, n, k, currentNum);
        }
        
        if (nextDigitBack < 10) {
            int currentNum = num * 10  + nextDigitBack;
            generate(pos + 1, n, k, currentNum);
        }
    }
    
}
