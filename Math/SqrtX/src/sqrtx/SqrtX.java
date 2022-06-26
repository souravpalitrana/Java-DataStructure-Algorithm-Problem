/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqrtx;

/**
 *
 * @author souravpalit
 */
public class SqrtX {

    // TC:: O(logn) SC: O(1)
    public int mySqrt(int x) {
        long low = 0;
        long high = x;
        
        while (low < high) {
            long mid = low + (high - low + 1) / 2;
            if (mid * mid > x) {
                high = mid - 1;
            } else {
                low = mid;
            }
        }
        
        return (int) high;
    }
    
}
