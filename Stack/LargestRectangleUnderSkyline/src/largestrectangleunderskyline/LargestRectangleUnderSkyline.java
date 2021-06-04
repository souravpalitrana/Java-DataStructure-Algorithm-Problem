/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package largestrectangleunderskyline;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author souravpalit
 */
public class LargestRectangleUnderSkyline {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int [] buildingHeights = {1, 3, 3, 2, 4, 1, 5, 3, 2};
        System.out.println(countLargestRectangleUnderSkyline(buildingHeights));
    }
    
    // Time complexity: O(n^2) & Space Complexity O(1)
    public static int countLargestRectangleUnderSkyline(int [] buildingHeights) {
        int maxArea = 0;
        
        for (int i = 0; i < buildingHeights.length; i++) {
            int currentHeight = buildingHeights[i];
            int leftIdx = i;
            while (leftIdx > 0 && buildingHeights[leftIdx - 1] >= currentHeight) {
                leftIdx--;
            }
            
            int rightIdx = i;
            while (rightIdx < buildingHeights.length - 1 && buildingHeights[rightIdx + 1] >= currentHeight) {
                rightIdx++;
            }
            
            int width = rightIdx - leftIdx + 1;
            maxArea = Math.max(width * currentHeight, maxArea);
        }
        
        return maxArea;
    }
    
    // Time complexity: O(n) Space Complexity: O(n) 
    // Second while loop will run maximum n time
    public static int countLargestRectangleUnderSkylineOptimized(int [] buildingHeights) {
        List<Integer> extendedBuildingHeights = new ArrayList<Integer>();
        for (int i = 0; i < buildingHeights.length; i++) {
            extendedBuildingHeights.add(buildingHeights[i]);
        }
        
        extendedBuildingHeights.add(0);
        int maxArea = 0;
        Stack<Integer> stack = new Stack<Integer>();
        
        for (int i = 0; i < extendedBuildingHeights.size(); i++) {
            int height = extendedBuildingHeights.get(i);
            
            while (!stack.isEmpty() && extendedBuildingHeights.get(stack.peek()) >= height) {
                int buildingHeight = extendedBuildingHeights.get(stack.pop());
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(width * buildingHeight, maxArea);
            }
            
            stack.push(i);
        }
        
        return maxArea;
    }
    
}
