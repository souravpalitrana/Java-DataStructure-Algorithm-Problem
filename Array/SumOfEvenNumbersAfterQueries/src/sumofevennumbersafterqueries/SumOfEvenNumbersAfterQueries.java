/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sumofevennumbersafterqueries;

/**
 * Leetcode: 985. Sum of Even Numbers After Queries
 * Problem Link: https://leetcode.com/problems/sum-of-even-numbers-after-queries/
 * @author souravpalit
 */
public class SumOfEvenNumbersAfterQueries {

    // TC: O(N + Q) where N is the length of the nums and Q is the length of queries
    // SC: O(Q) as we need to return the answer and for each query we have an answer
    
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        nums[queries[0][1]] +=  queries[0][0];
        int [] answer = new int [queries.length];
        int sum = 0;
        
        for (int num : nums) {
            if (num % 2 == 0) {
                sum += num;
            }
        }
        
        answer[0] = sum;
        
        for (int i = 1; i < queries.length; i++) {
            int idx = queries[i][1];
            int value = queries[i][0];
            //  If the previous value is positive that means it is added in the last sum. So for the next sum we need to subtract it because it will change after adding value of queries. If the new value is even we will add this
            if (nums[idx] % 2 == 0) {
                sum -= nums[idx];
            }
            
            nums[idx] = nums[idx] + value;
            if (nums[idx] % 2  == 0) {
                sum += nums[idx];
            }
            answer[i] = sum;
        }
        
        return answer;
    }
    
}
