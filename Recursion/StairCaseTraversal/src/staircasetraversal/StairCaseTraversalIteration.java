/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package staircasetraversal;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author souravpalit
 */
public class StairCaseTraversalIteration {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int numOfSteps = 5;
        int maxSteps = 3;
        
        System.out.println("Number of ways to top : " + findNumberOfWaysToTop(numOfSteps, maxSteps));
        System.out.println("Number of ways to top : " + findNumberOfWaysToTopUsingSlidingWindowTechnique(numOfSteps, maxSteps));
    }
    
    // Time complexity is O(n*k) where k is the step andd n is the height
    public static int findNumberOfWaysToTop(int numOfSteps, int maxSteps) {
        int [] ways = new int [numOfSteps + 1];
        ways[0] = 1;
        ways[1] = 1;
        
        
        for (int current = 2; current <= numOfSteps; current++) {
            int step = 1;
            while (step <= current && step <= maxSteps) {
                ways[current] = ways[current] + ways[current - step];
                step++;
            }
        }
        
        return ways[numOfSteps];
    }
    
    // Sliding Window Technnique
    // Time complexity O(n) and Space Complexity O(n)
    public static int findNumberOfWaysToTopUsingSlidingWindowTechnique(int numOfSteps, int maxSteps) {
        int [] ways = new int [numOfSteps + 1];
        ways[0] = 1;
        
        int currentNumberOfWays = 0;
        
        for (int current = 1; current <= numOfSteps; current++) {
            int start = current - maxSteps - 1;
            int end = current - 1;
            
            if (start >= 0) {
                currentNumberOfWays -= ways[start];
            }
            
            currentNumberOfWays += ways[end];
            ways[current] = currentNumberOfWays;
        }
        
        return ways[numOfSteps];
    }
    
}
