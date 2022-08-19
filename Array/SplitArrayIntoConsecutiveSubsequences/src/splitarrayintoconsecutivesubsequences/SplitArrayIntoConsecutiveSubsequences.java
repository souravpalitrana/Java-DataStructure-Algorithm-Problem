/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package splitarrayintoconsecutivesubsequences;

import java.util.HashMap;
import java.util.Map;
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
    
    
    // TC: O(n) SC: O(n)
    public boolean isPossibleAlternate(int[] nums) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        Map<Integer, Integer> subsequences = new HashMap<>();
        
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        
        for (int num : nums) {
            if (frequencyMap.get(num) == 0) {
                continue;
            }
            
            if (subsequences.getOrDefault(num - 1, 0) > 0) {
                // num - 1 presents so we can add to existing sequence
                // After adding num num - 1 count will be reduced by 1 as we placed num in
                // this sequence theoritically. Again num sequence will increased as another sequence with last number num added. 
                subsequences.put(num - 1, subsequences.getOrDefault(num - 1, 0) - 1);
                subsequences.put(num, subsequences.getOrDefault(num, 0) + 1);
            } else if (frequencyMap.getOrDefault(num + 1, 0) > 0 && frequencyMap.getOrDefault(num + 2, 0) > 0) {
                // We have more value which can create a valid sequence of at least 3 length starting vaue num. So update subsequence with the last value and reduce frequency
                subsequences.put(num + 2, subsequences.getOrDefault(num + 2, 0) + 1);
                frequencyMap.put(num + 1, frequencyMap.getOrDefault(num + 1, 0) - 1);
                frequencyMap.put(num + 2, frequencyMap.getOrDefault(num + 2, 0) - 1);
            } else {
                // No valid subsequence is possible
                return false;
            }
            
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) - 1);
        }
        
        return true;
    }
}
