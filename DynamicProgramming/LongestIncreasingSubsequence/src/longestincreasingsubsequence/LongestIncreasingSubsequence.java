/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longestincreasingsubsequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Time complexity: O(n^2) Space Complexity: O(n)
 * @author souravpalit
 */
public class LongestIncreasingSubsequence {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int array [] = {5, 7, -24, 12, 10, 2, 3, 12, 5, 6, 35};
        
        List<Integer> lis = longestIncreasingSubsequence(array);
        
        for (Integer value : lis) {
            System.out.print(value + "  ");
        }
    }
    
    public static List<Integer> longestIncreasingSubsequence(int [] array) {
        int [] length = new int [array.length];
        int [] sequences = new int [array.length];
        
        // Filling all value with 1 as each value can create 1 length liis
        Arrays.fill(length, 1);
        // Filling all value with an aribitary value to detect the end of the
        // sequence
        Arrays.fill(sequences, Integer.MIN_VALUE);
        
        // This value will help us to track the max lis index of the length array
        int maxLengthIdx = 0;
        
        for (int i = 0; i < array.length; i++) {
            int currentNum = array[i];
            
            for (int j = 0; j < i; j++) {
                int otherNum = array[j];
                
                if (otherNum < currentNum && length[j] + 1 > length[i]) {
                    length[i] = length[j] + 1;
                    sequences[i] = j;
                }
            }
            
            // Update the maxLengthIdx value if latest calculated lis is greater
            if (length[i] > length[maxLengthIdx]) {
                maxLengthIdx = i;
            }
            
        }
        
        return buildSequences(array, sequences, maxLengthIdx);
    }
    
    public static List<Integer> buildSequences(int [] array, int [] sequences, int currentIdx) {
        List<Integer> lis = new ArrayList<Integer>();
        
        while (currentIdx != Integer.MIN_VALUE) {
            lis.add(array[currentIdx]);
            currentIdx = sequences[currentIdx];
        }
        
        Collections.reverse(lis);
        return lis;
    }
    
}
