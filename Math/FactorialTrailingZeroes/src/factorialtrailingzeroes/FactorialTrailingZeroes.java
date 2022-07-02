/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factorialtrailingzeroes;

/**
 * Leetcode: 172. Factorial Trailing Zeroes
 * Problem Link: https://leetcode.com/problems/factorial-trailing-zeroes/
 * @author souravpalit
 */
public class FactorialTrailingZeroes {

    // TC: O(logn) SC: O(1)
    public int trailingZeroes(int n) {
        int countOfFive = 0;
        int d = 5;
        while (n >= d) {
            countOfFive += n / d;
            d *= 5;
        }
        
        return countOfFive;
    }
    
}
