/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minrewards;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Time Complexity O(nlogn) Space Complexity O(n)
 * @author souravpalit
 */
public class MinRewards {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int [] input = {8, 4, 2, 1, 3, 6, 7, 9, 5};
        
        //int [] input = {0, 4, 2, 1, 3};
        System.out.println("Min Reward :" + calculateMinReward(input));
    }
    
    public static int calculateMinReward(int array[]) {
        if (array.length == 1) {
            return 1;
        }
        
        int minReward = 0;
     
        Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
        
        for (int i = 0; i < array.length; i++) {
            map.put(array[i], i);
        }
        
        int [] rewardArray = new int [array.length];
      
        for (Integer value : map.keySet()) {
            int valuePosition = map.get(value);
            
            if (valuePosition == 0) {
                if (value > array[valuePosition + 1]) {
                    rewardArray[valuePosition] = rewardArray[valuePosition + 1] + 1;
                } else {
                    rewardArray[valuePosition] = 1;
                }
            } else if (valuePosition == array.length - 1) {
                if (value > array[valuePosition - 1]) {
                    rewardArray[valuePosition] = rewardArray[valuePosition - 1] + 1;
                } else {
                    rewardArray[valuePosition] = 1;
                }
            } else {
                if (value < array[valuePosition - 1] && value < array[valuePosition + 1]) {
                    rewardArray[valuePosition] = 1;
                } else if (value > array[valuePosition - 1] && value > array[valuePosition + 1]) {
                    rewardArray[valuePosition] = Math.max(rewardArray[valuePosition - 1], rewardArray[valuePosition + 1]) + 1;
                } else if (value > array[valuePosition - 1]) {
                    rewardArray[valuePosition] = rewardArray[valuePosition - 1] + 1;
                } else {
                    rewardArray[valuePosition] = rewardArray[valuePosition + 1] + 1;
                }
            }  
        }
        
        for (Integer reward : rewardArray) {
            minReward += reward;
        }
     
        return minReward;
    }
    
}
