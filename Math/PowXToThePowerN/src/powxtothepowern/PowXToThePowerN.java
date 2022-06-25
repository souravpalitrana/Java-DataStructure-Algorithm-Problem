/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package powxtothepowern;

/**
 * Leetcode: 50. Pow(x, n)
 * Problem Link: https://leetcode.com/problems/powx-n/
 * @author souravpalit
 */
public class PowXToThePowerN {

    // TC: O(logn) where n is the power as each time n devides by 2 so logn
    public double myPow(double x, int n) {
        long pow = Math.abs((long) n);
        double result = modularExpo(x, pow);
        return n < 0 ? 1.0 / result : result;
    }

    public double modularExpo(double x, long pow) {
        if (pow == 0) {
            return 1.0;
        }

        if (pow % 2 == 0) {
            double value = modularExpo(x, pow / 2);
            return value * value;
        }

        return x * modularExpo(x, pow - 1);
    }

}
