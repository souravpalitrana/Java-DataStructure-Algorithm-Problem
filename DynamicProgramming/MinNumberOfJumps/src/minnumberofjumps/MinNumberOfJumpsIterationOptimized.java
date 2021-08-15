/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minnumberofjumps;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Time Complexity: O(n) Space Complexity: O(1)
 * @author souravpalit
 */
public class MinNumberOfJumpsIterationOptimized {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int [] array = {3, 4, 2, 1, 2, 3, 7, 1, 1, 1, 3};
        //int [] array = {3, 4, 2};
        System.out.println(minJumps(array));
    }
    
    public static int minJumps(int [] array) {
        if (array.length == 1) {
            return 0;
        }
        
        // Initiall jump from first position. If you sets it to 0 then
        // before return the result you must add + 1
        int jumps = 1; 
        
        int maxReach = array[0];
        int steps = array[0];
        
        for (int i = 1; i < array.length - 1; i++) {
            maxReach = Math.max(maxReach, array[i] + i);
            steps--;
            
            if (steps == 0) {
                jumps++;
                steps = maxReach - i;
            }
        }
        
        return jumps;
    }
}
