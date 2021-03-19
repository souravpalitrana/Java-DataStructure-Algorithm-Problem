/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fournumbersum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Time Complexity: Average Case: O(n^2) Worst Case: O(n^3)
 * Space Complexity: O(n^2)
 *
 * @author souravpalit
 */
public class FourNumberSum {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int [] input = {7, 6, 4, -1, 1, 2};
        int targetSum = 16;
        
        List<Integer[]> fourNumberSums = findFourNumberSum(input, targetSum);
        
        for (Integer [] sum : fourNumberSums) {
            System.out.println("[" + sum[0] + "," + sum[1]+ "," + sum[2] + "," + sum[3] + "]");
        }
        
    }
    
    public static List<Integer[]> findFourNumberSum(int [] array, int targetSum) {
        List<Integer[]> fourNumberPairs = new ArrayList<Integer[]>();
        Map<Integer, List<Integer[]>> allPairSums = new HashMap<Integer, List<Integer[]>>();
        
        for (int i = 1; i < array.length - 1; i++) {
            
            for (int j = i + 1; j < array.length; j++) {
                int sum = array[i] + array[j];
                int diff = targetSum - sum;
                
                if (allPairSums.containsKey(diff)) {
                    List<Integer []> numPairs = allPairSums.get(diff);
                    for (Integer [] pair : numPairs) {
                        Integer [] fourPairs = new Integer[4];
                        fourPairs[0] = array[i];
                        fourPairs[1] = array[j];
                        fourPairs[2] = pair[0];
                        fourPairs[3] = pair[1];
                        
                        fourNumberPairs.add(fourPairs);
                    }
                }
            }
            
            for (int k = 0; k < i; k++) {
                int sum = array[k] + array[i];
                Integer [] pair = {array[k], array[i]};
                if (allPairSums.containsKey(sum)) {
                    allPairSums.get(sum).add(pair);
                } else {
                    List<Integer[]> pairList = new ArrayList<Integer[]>();
                    pairList.add(pair);
                    allPairSums.put(sum, pairList);
                }
            }
        }
        
        return fourNumberPairs;
    }
    
}
