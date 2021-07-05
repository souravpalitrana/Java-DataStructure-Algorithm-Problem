/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package staircasetraversal;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author souravpalit
 */
public class StairCaseTraversal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int numOfSteps = 5;
        int maxSteps = 2;
        
        System.out.println("Number of ways to top : " + findNumberOfWaysToTop(numOfSteps, maxSteps));
        System.out.println("Number of ways to top using memorization: " + findNumberOfWaysToTopUsingMemorization(numOfSteps, maxSteps));
    }
    
    // Time complexity is O(k^n) where k is the step andd n is the number of allowed
    // steps because for each step we need to traverse n  stairs 
    public static int findNumberOfWaysToTop(int numOfSteps, int maxSteps) {
        if (numOfSteps <= 1) {
            return 1;
        }
        
        int numOfWays = 0;
        // MaxStep can be greater than numOfSteps. Thats why we are taking the
        // min value between maxSteps and numOfSteps(height). Suppose numOfSteps
        // is 2 but maxStep is 3. So here we could not go 3 steps as we only have
        // 2 steps.
        for (int step = 1; step <= Math.min(maxSteps, numOfSteps); step++) {
            numOfWays += findNumberOfWaysToTop(numOfSteps - step, maxSteps);
        }
        
        return numOfWays;
    }
    
    // Time complexity is O(kn) and Space complexity is O(n) 
    public static int findNumberOfWaysToTopUsingMemorization(int numOfSteps, int maxSteps) {
        Map<Integer, Integer> memory = new HashMap<Integer, Integer>();
        memory.put(0, 1);
        memory.put(1, 1);
        return findNumberOfWaysToTopUsingMemorization(numOfSteps, maxSteps, memory);
    }
    
    public static int findNumberOfWaysToTopUsingMemorization(int numOfSteps, int maxSteps, 
            Map<Integer, Integer> memory) {
        if (memory.containsKey(numOfSteps)) {
            return memory.get(numOfSteps);
        }
        
        int numOfWays = 0;
        // MaxStep can be greater than numOfSteps. Thats why we are taking the
        // min value between maxSteps and numOfSteps(height). Suppose numOfSteps
        // is 2 but maxStep is 3. So here we could not go 3 steps as we only have
        // 2 steps.
        for (int step = 1; step <= Math.min(maxSteps, numOfSteps); step++) {
            numOfWays += findNumberOfWaysToTop(numOfSteps - step, maxSteps);
        }
        
        memory.put(numOfSteps, numOfWays);
        
        return numOfWays;
    }
    
}
