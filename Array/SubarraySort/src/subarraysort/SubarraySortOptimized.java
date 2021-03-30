/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subarraysort;

import java.util.Arrays;

/**
 * Time Complexity O(n) Space Complexity O(1)
 * @author souravpalit
 */
public class SubarraySortOptimized {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int [] input = {1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19};
        
        int [] output = getSubArrayNeedToSort(input);
        System.out.println("[" + output[0] + "," + output[1] + "]");
        
    }
    
    public static int [] getSubArrayNeedToSort(int [] array) {
       // int [] sortedArray = new int [array.length];
        int minOutOfOrder = Integer.MAX_VALUE;
        int maxOutOfOrder = Integer.MIN_VALUE;
        
        for (int i = 0; i < array.length; i++) {
            if (isOutOfOrder(i, array)) {
                minOutOfOrder = Math.min(minOutOfOrder, array[i]);
                maxOutOfOrder = Math.max(maxOutOfOrder, array[i]);
            }
        }
        
        // In case if the array is already sorted then we will not get any value
        // for minOutOfOrder and maxOutOfOrder
        if (minOutOfOrder == Integer.MAX_VALUE && maxOutOfOrder == Integer.MIN_VALUE) {
            return new int [] {-1, -1};
        }
        
        int startIndx = 0;
        int endIndx = array.length - 1;
        
        while (minOutOfOrder >= array[startIndx]) {
            startIndx++;
        }
        
        while (maxOutOfOrder <= array[endIndx]) {
            endIndx--;
        }
        
        return new int [] {startIndx, endIndx};
    }
    
    public static boolean isOutOfOrder(int i, int [] array) {
       
        if (i == 0) {
            return array[i] > array[i + 1];
        } else if (i == array.length - 1) {
            return array[i] < array[i - 1];
        } else {
            return array[i] < array[i - 1] || array[i] > array[i + 1];
        }
    }
    
}
