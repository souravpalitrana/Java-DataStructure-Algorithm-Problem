/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package countprimes;

/**
 * Leetcode: 204. Count Primes
 * Problem Link: https://leetcode.com/problems/count-primes/
 * @author souravpalit
 */
public class CountPrimes {

    // TC: O(rootn log logn) SC: O(n)
    public int countPrimes(int n) {
        int numOfPrimes = 0;
        boolean [] primeCuts = new boolean [n + 1];
        
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (primeCuts[i]) {
                continue;
            }
            for (int j = i * i; j < n; j += i) {
                primeCuts[j] = true;
            }
        }
        
        for (int i = 2; i < n; i++) {
            if (!primeCuts[i]) {
                numOfPrimes++;
            }
        }
        
        return numOfPrimes;
    }
    
}
