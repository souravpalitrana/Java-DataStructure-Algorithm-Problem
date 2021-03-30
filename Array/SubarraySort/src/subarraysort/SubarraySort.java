/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subarraysort;

import java.util.Arrays;

/**
 * Time Complexity O(nlogn) Space Complexity O(n)
 * @author souravpalit
 */
public class SubarraySort {

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
        int start = -1;
        int end = -1;
        
        int [] sortedArray = array.clone();
        Arrays.sort(sortedArray);
        
        for (int i = 0; i < array.length; i++) {
            if (array[i] != sortedArray[i]) {
                if (start == -1) {
                    start = i;
                } else {
                    end = i;
                }
            }
        }
        
        return new int [] {start, end};
    }
    
}
