/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minrewards;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Time Complexity O(nlogn) Space Complexity O(n)
 * @author souravpalit
 */
public class MinRewardsOptimizedFinal {

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
        
        int [] rewards = new int [array.length];
        int minReward = 0;
        Arrays.fill(rewards, 1);
        
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[i - 1]) {
                rewards[i] = rewards[i - 1] + 1;
            }
        }
        
        for (int i = array.length - 2; i >= 0; i--) {
            if (array[i] > array[i + 1]) {
                rewards[i] = Math.max(rewards[i], rewards[i + 1] + 1);
            }
        }
        
        
        for (Integer reward : rewards) {
            minReward += reward;
        }
     
        return minReward;
    }
    
   
}
