/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package waterarea;

/**
 * Time Complexity: O(n) Space Complexity: O(n)
 * @author souravpalit
 */
public class WaterArea {

    public static void main(String[] args) {
        int [] pillarHeights = {0, 8, 0, 0, 5, 0, 0, 10, 0, 0, 1, 1, 0, 3};
        System.out.println("Trapped water area = " + calculateTrappedWaterArea(pillarHeights));
        System.out.println("Trapped water area Optimized = " + calculateTrappedWaterAreaOptimized(pillarHeights));
    }
    
    public static int calculateTrappedWaterArea(int [] heights) {
        int leftMaxHeights [] = new int [heights.length];
        int rightMaxHeights [] = new int [heights.length];
        int trappedWaterAreas [] = new int [heights.length];
        
        int leftMaxHeight = 0; // As non negative integer mentioned
        for (int i = 0; i < heights.length; i++) {
            leftMaxHeights[i] = leftMaxHeight;
            if (heights[i] > leftMaxHeight) {
                leftMaxHeight = heights[i];
            }
        }
        
        int rightMaxHeight = 0;
        for (int i = heights.length - 1; i >= 0; i--) {
            rightMaxHeights[i] = rightMaxHeight;
            if (heights[i] > rightMaxHeight) {
                rightMaxHeight = heights[i];
            }
        }
        
        for (int i = 0; i < heights.length; i++) {
            int currentPillarHeight = heights[i];
            int trappedHeight = Math.min(leftMaxHeights[i], rightMaxHeights[i]);
            
            if (currentPillarHeight > trappedHeight) {
                trappedWaterAreas[i] = 0;
            } else {
                trappedWaterAreas[i] = trappedHeight - currentPillarHeight;
            }
        }
        
        return sumTheTrappedAreas(trappedWaterAreas);
    }
    
    
    // Will not change the time and space complexity value but it will
    // run faster because of less loop and less array use
    public static int calculateTrappedWaterAreaOptimized(int [] heights) {
        int maxHeights [] = new int [heights.length];
        int leftMaxHeight = 0; // As non negative integer mentioned
        for (int i = 0; i < heights.length; i++) {
            maxHeights[i] = leftMaxHeight;
            if (heights[i] > leftMaxHeight) {
                leftMaxHeight = heights[i];
            }
        }
        
        int rightMaxHeight = 0;
        for (int i = heights.length - 1; i >= 0; i--) {
            // We already have the leftMaxHeight and rightMaxHeight 
            // of the current position. So before moving forward
            // we can calculate the trappeed area
            
            int currentPillarHeight = heights[i];
            int trappedHeight = Math.min(maxHeights[i], rightMaxHeight);
            if (currentPillarHeight > trappedHeight) {
                maxHeights[i] = 0;
            } else {
                maxHeights[i] = trappedHeight - currentPillarHeight;
            }
            
            if (heights[i] > rightMaxHeight) {
                rightMaxHeight = heights[i];
            }
        }
        
        return sumTheTrappedAreas(maxHeights);
        
    }
    
    public static int sumTheTrappedAreas(int [] heights) {
        int totalHeight = 0;
        
        for (Integer height : heights) {
            totalHeight += height;
        }
        
        return totalHeight;
    }
}
