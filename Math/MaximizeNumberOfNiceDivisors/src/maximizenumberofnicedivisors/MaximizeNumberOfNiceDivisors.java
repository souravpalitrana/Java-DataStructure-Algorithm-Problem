/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maximizenumberofnicedivisors;

/**
 * Leetcode: 1808. Maximize Number of Nice Divisors
 * Problem Link: https://leetcode.com/problems/maximize-number-of-nice-divisors/
 * @author souravpalit
 */
public class MaximizeNumberOfNiceDivisors {

    private final int MOD = 1000000007;
    
    // TC: O(logn) as it is modular exponential to calculate pow
    // SC: O(logn) for recursion stack when calculating pow
    public int maxNiceDivisors(int primeFactors) {
        if (primeFactors == 1) return 1;
        if (primeFactors % 3 == 0) return (int) modPower(3, primeFactors / 3);
        if (primeFactors % 3 == 1) return (int) ((4 * modPower(3, (primeFactors - 2) / 3)) % MOD);
        return (int)((2 * modPower(3, primeFactors / 3)) % MOD);
    }
    
    private long modPower(int n, int m) {
        if (m == 0) return 1;
        if (m % 2 == 0) {
            long value = modPower(n, m / 2);
            return (value * value) % MOD;
        }
        
        return (n * modPower(n, m - 1)) % MOD;
    }
    
}
