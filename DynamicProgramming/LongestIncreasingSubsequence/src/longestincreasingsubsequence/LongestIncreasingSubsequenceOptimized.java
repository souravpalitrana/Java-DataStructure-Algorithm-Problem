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
 * Time Complexity: O(nlogn) Space Complexity: O(n)
 * @author souravpalit
 */
public class LongestIncreasingSubsequenceOptimized {

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
        int [] indics = new int [array.length + 1];
        int [] sequences = new int [array.length];
        
        Arrays.fill(indics, Integer.MIN_VALUE);
        
        // This value will help us to track the max lis index of the length array
        int length = 0;
        
        for (int i = 0; i < array.length; i++) {
            int currentNum = array[i];
            int newLength = binarySearch(1, length, array, indics, currentNum);
            sequences[i] = indics[newLength - 1];
            indics[newLength] = i;
            length = Math.max(length, newLength);
        }
        
        return buildSequences(array, sequences, indics[length]);
    }
    
    public static int binarySearch(int startIdx, int endIdx, int [] array, int [] indics, int num) {
        if (startIdx > endIdx) {
            return startIdx;
        }
        
        int midIdx = (startIdx + endIdx) / 2;
        
        if (array[indics[midIdx]] < num) {
            startIdx = midIdx + 1;
        } else {
            endIdx = midIdx - 1;
        }
        
        return binarySearch(startIdx, endIdx, array, indics, num);
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
