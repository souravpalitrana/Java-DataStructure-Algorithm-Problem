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
 * Time Complexity: O(m^n) where n is the number of elements and m is the highest 
 * number
 * Space Complexity: O(max(n,m))
 * @author souravpalit
 */
public class MinNumberOfJumpsOptimize {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int [] array = {3, 4, 2, 1, 2, 3, 7, 1, 1, 1, 3};
        //int [] array = {3, 4, 2};
        System.out.println(minJumps(array));
    }
    
    public static int minJumps(int [] array) {
        int [] cache = new int [array.length];
        Arrays.fill(cache, -1);
        return minJumps(array, 0, cache);
    }
    
    public static int minJumps(int [] array, int currentPosition, int [] cache) {
        if (currentPosition >= array.length - 1) {
            return 0;
        } else if (cache[currentPosition] != -1) {
            return cache[currentPosition];
        }
        
        int minJumps = Integer.MAX_VALUE;
        
        for (int i = 1; i <= array[currentPosition]; i++) {
            int numOfJumps =  1 + minJumps(array, currentPosition + i, cache);
            if (numOfJumps > 0 && numOfJumps < minJumps) {
                minJumps = numOfJumps;
            }
        }
        
        cache[currentPosition] = minJumps;
        
        return minJumps;
    }
  
}
