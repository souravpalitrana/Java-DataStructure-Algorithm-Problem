/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minimumwaitingtime;

import java.util.Arrays;

/**
 * Time Complexity: O(nlogn) Space Complexity O(1)
 * @author souravpalit
 */
public class MinimumWaitingTime {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int [] waitingTimes = {3, 2, 1, 2, 6};
        System.out.println("Minimum waiting time to execute all queries is: " 
                + calculateMinimumWaitingTime(waitingTimes));
    }
    
    public static int calculateMinimumWaitingTime(int [] waitingTimes) {
        Arrays.sort(waitingTimes);
        int totalWaitingTime = 0;
        
        for (int i = 0; i < waitingTimes.length; i++) {
            totalWaitingTime += waitingTimes[i] * (waitingTimes.length - (i+ 1));
        }
        
        return totalWaitingTime;
    }
    
}
