/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package randompickwithweight;

import java.util.ArrayList;
import java.util.List;

/**
 * TC: 
 * @author souravpalit
 */
public class RandomPickWithWeight {

    // Prefix sum with linear seach
    private int [] prefixSum;
    
    public RandomPickWithWeight(int[] w) {
        prefixSum = new int [w.length];
        prefixSum[0] = w[0];
        for (int i = 1; i < w.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + w[i];
        }
    }
    
    // Linear search
    // O(n)
    /*public int pickIndex() {
        int target = (int) (prefixSum[prefixSum.length - 1] * Math.random());
        
        for (int i = 0; i < prefixSum.length; i++) {
            if (target < prefixSum[i]) {
                return i;
            }
        }
        return 0;
    }*/
    
    // BinarySearch
    public int pickIndex() {
        // Without double it gives wong answer. Need to look further
        double target = prefixSum[prefixSum.length - 1] * Math.random();
        
        int low = 0;
        int high = prefixSum.length - 1;
        
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (target > prefixSum[mid]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        
        return low;
    }

}
