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
 * Time Complexity O(n) Space Complexity O(n)
 * @author souravpalit
 */
public class MinRewardsOptimized {

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
        
        List<Integer> localMinsIndx = getLocalMins(array);
     
        
        for (Integer minIndx : localMinsIndx) {
            // Left expand
            int left = minIndx - 1;
            
            while (left >=0 && array[left] > array[left + 1]) {
                rewards[left] = Math.max(rewards[left], rewards[left + 1] + 1);
                left--;
            }
            
            int right = minIndx + 1;
            
            while (right < array.length && array[right] > array[right - 1]) {
                rewards[right] = rewards[right - 1] + 1;
                right++;
            }
        }
        
        
        for (Integer reward : rewards) {
            minReward += reward;
        }
     
        return minReward;
    }
    
    public static List<Integer> getLocalMins(int [] array) {
        List<Integer> localMinsIndx = new ArrayList<Integer>();
        for (int i = 0; i < array.length; i++) {
            if ((i == 0 && array[i] < array[i + 1]) || 
                    (i == array.length - 1 &&  array[i] < array[i - 1])) {
                localMinsIndx.add(i);
            } else if (i == 0 || i == array.length - 1) {
                continue;
            } else if (array[i] < array[i - 1] && array[i] < array[i+ 1]) {
                localMinsIndx.add(i);
            }
        }
        
        return localMinsIndx;
    }
    
}
