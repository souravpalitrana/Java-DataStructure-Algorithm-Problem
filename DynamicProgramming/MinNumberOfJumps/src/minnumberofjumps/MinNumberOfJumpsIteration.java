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
 * Time Complexity: O(n^2) Space Complexity: O(n)
 * @author souravpalit
 */
public class MinNumberOfJumpsIteration {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int [] array = {3, 4, 2, 1, 2, 3, 7, 1, 1, 1, 3};
        //int [] array = {3, 4, 2};
        System.out.println(minJumps(array));
    }
    
    public static int minJumps(int [] array) {
        int [] jumps = new int [array.length];
        Arrays.fill(jumps, Integer.MAX_VALUE);
        jumps[0] = 0;
        
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                if (array[j] + j >= i) {
                    // We can jump
                    jumps[i] = Math.min(jumps[i], jumps[j] + 1);
                }
            }
        }
        
        return jumps[array.length - 1];
    }
}
