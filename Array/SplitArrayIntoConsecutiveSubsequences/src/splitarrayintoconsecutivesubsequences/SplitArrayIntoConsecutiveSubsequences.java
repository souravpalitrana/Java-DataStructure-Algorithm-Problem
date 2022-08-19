/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package splitarrayintoconsecutivesubsequences;

import java.util.PriorityQueue;

/**
 * Leetcode: 659. Split Array into Consecutive Subsequences Problem Link:
 * https://leetcode.com/problems/split-array-into-consecutive-subsequences/
 *
 * @author souravpalit
 */
public class SplitArrayIntoConsecutiveSubsequences {

    // TC: O(nlogn) SC: O(n)
    public boolean isPossible(int[] nums) {
        PriorityQueue<int[]> subsequences = new PriorityQueue<>(
                (int[] seq1, int[] seq2) -> {
                    // If last two value is same then sort based on their length
                    // increasing order otherwise based on the last value
                    return (seq1[1] == seq2[1]) ? getLength(seq1) - getLength(seq2) : seq1[1] - seq2[1];
                }
        );

        for (int num : nums) {

            // Remove those sequences which last value and num difference is 
            // more than 1 as we could not place any value after that by 
            // satisfying the both condition
            while (!subsequences.isEmpty() && subsequences.peek()[1] + 1 < num) {
                if (getLength(subsequences.poll()) < 3) {
                    // We found a sub sequence which length is less than 3 that
                    // means don't need to check further. We can end here.
                    return false;
                }
            }
            
            // We need to insert this value either in a new sequence or in a
            // existing sequence
            if (subsequences.isEmpty() || subsequences.peek()[1] == num) {
                // If empty or last value same so we need to create a new 
                // sequence
                subsequences.add(new int [] {num, num});
            } else {
                int [] subsequence = subsequences.poll();
                subsequences.add(new int [] {subsequence[0], num});
            }
        }
        
        // Now check all the sub sequences. If we found any subsequence which
        // length is smaller than 3 then we will return false
        while (!subsequences.isEmpty()) {
            if (getLength(subsequences.poll()) < 3) {
                return false;
            }
        }

        return true;
    }

    private int getLength(int[] seq) {
        return seq[1] - seq[0] + 1;
    }
}
