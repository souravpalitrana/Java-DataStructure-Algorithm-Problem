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
 * Time Complexity O(n^2) Space Complexity O(n)
 * @author souravpalit
 */
public class MinRewardsNaiveSolution {

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
        Arrays.fill(rewards, 1);
        
        for (int i = 1; i < array.length; i++) {
            int j = i - 1;
            if (array[i] > array[j]) {
                rewards[i] = rewards[j] + 1;
            } else {
                while (j >= 0 && array[j] > array[j + 1]) {
                    rewards[j] = Math.max(rewards[j], rewards[j + 1] + 1);
                    j--;
                }
            }
        }
     
        
        int minReward = 0;
        for (Integer reward : rewards) {
            minReward += reward;
        }
     
        return minReward;
    }
    
}
