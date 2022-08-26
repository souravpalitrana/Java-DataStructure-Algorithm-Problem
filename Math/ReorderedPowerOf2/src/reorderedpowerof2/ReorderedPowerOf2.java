/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reorderedpowerof2;

import java.util.Arrays;

/**
 * Leetcode: 869. Reordered Power of 2
 * Problem Link: https://leetcode.com/problems/reordered-power-of-2/
 * @author souravpalit
 */
public class ReorderedPowerOf2 {

    // O(logn) for generating all the number power of 2  and O(logn) comparing two array
    // so TC: O(logn * logn) SC: O(n)
    public boolean reorderedPowerOf2(int n) {
        int  [] frequencyOfDigitsInN = coutFrequencyOfDigits(n);
        for (int i =  0; i < 31; i++) {
            int value = 1 << i;
            if (Arrays.equals(frequencyOfDigitsInN, coutFrequencyOfDigits(1 << i))) {
                return true;
            }
            
        }
        
        return false;
    }
    

    public int [] coutFrequencyOfDigits(int n) {
        int [] digits = new int [10];
        while (n > 0) {
            digits[n %  10]++;
            n  /= 10;
        }
        return digits;
    }
    
}
