/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minnumberofjumps;

import java.util.HashMap;
import java.util.Map;

/**
 * Could not use memorization as we are passing value so in each step the
 * result of that step depends on in how many jump we did to reach did steps
 * @author souravpalit
 */
public class MinNumberOfJumps {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int [] array = {3, 4, 2, 1, 2, 3, 7, 1, 1, 1, 3};
        ///int [] array = {3, 4, 2};
        System.out.println(minJumps(array));
    }
    
    public static int minJumps(int [] array) {
        return minJumps(array, 0, 0);
    }
    
    public static int minJumps(int [] array, int currentPosition, int jumpCount) {
        if (currentPosition >= array.length - 1) {
            return jumpCount;
        } else if (array[currentPosition] == 0) {
            return 0;
        }
        
        int minJumps = Integer.MAX_VALUE;
        for (int i = 1; i <= array[currentPosition]; i++) {
            int numOfJumps = minJumps(array, currentPosition + i, jumpCount + 1);
            if (numOfJumps > 0 && numOfJumps < minJumps) {
                minJumps = numOfJumps;
            }
        }
        
        return minJumps;
    }
  
}
