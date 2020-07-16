/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package triple.step;

import java.util.Arrays;

/**
 *
 * @author souravpalit
 */
public class TripleStepWithMemorization {
    
    public static void main(String [] args) {
        
        int stairCount = 5;
        
        int[] memo = new int[stairCount + 1];
        Arrays.fill(memo, -1);
        
        System.out.println("Number of ways the child can run up the stairs is : " + countWays(stairCount, memo));
    }
    
    public static int countWays(int n, int [] memo) {
        
        if (n < 0) {
            return 0;
        } else if (n == 0) {
            return 1;
        } else if(memo[n] > -1) {
            return memo[n];
        } else {
            memo[n] = countWays(n-1, memo) + countWays(n-2, memo) + countWays(n-3, memo);
            return memo[n];
        }
    }
}
