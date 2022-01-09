/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maxsumincreasingsubsequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Time complexity: O(n^2) Space Complexity: O(n)
 * @author souravpalit
 */
public class MaxSumIncreasingSubsequence {

    
    public static void main(String[] args) {
        int [] array  =  {10, 70, 20, 30, 50, 11, 30};
        List<List<Integer>> result = maxSumIncreasingSubsequence(array);
        
        for (List<Integer> list : result) {
            for (Integer value : list) {
                System.out.print(value + "  ");
            }
            System.out.println();
        }
        
    }
    
    public static List<List<Integer>> maxSumIncreasingSubsequence(int [] array) {
        int [] idxList = new int [array.length];
        
        // We are cloning because when no greater value found in that case 
        // that positions it's own value will be the maximuu. For example- at
        // first position there is no value previous that. So maxSum will be the
        /// value.
        int [] sums = array.clone();
        
        Arrays.fill(idxList, Integer.MAX_VALUE);
        
        int maxSumIdx = 0;
        
        for (int i = 0; i < array.length; i++) {
            int current = array[i];
            for (int j = 0; j < i; j++) {
                if (current > array[j] && sums[j] + current >= sums[i]) {
                    sums[i] = sums[j] + current;
                    idxList[i] = j;
                }
            }
            
            if (sums[i] >= sums[maxSumIdx]) {
                maxSumIdx = i;
            }
        }
        
        return buildSequence(array, idxList, maxSumIdx, sums[maxSumIdx]);
    }
    
    public static List<List<Integer>> buildSequence(int [] array, int [] idxList, int maxSumIdx, int maxSum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        List<Integer> maxSumList = new ArrayList<Integer>();
        maxSumList.add(maxSum);
        
        result.add(maxSumList);
        
        List<Integer> maxIdxList = new ArrayList<Integer>();
        int idx = maxSumIdx;
        while (idx != Integer.MAX_VALUE) {
            maxIdxList.add(0, array[idx]);
            idx = idxList[idx];
        }
        
        result.add(maxIdxList);
        
        return result;
    }
}
