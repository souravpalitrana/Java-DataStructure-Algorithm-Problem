/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maximumpointsyoucanobtainfromcards;

/**
 *
 * @author souravpalit
 */
public class MaximumPointsYouCanObtainFromCards {

    // Sliding window technique
    // TC: O(n) SC: O(1)
    public int maxScore(int[] cardPoints, int k) {
        int totalPoints = 0;
    
        for (int point : cardPoints) {
            totalPoints += point;
        }
        
        int maxPoints = Integer.MIN_VALUE;
        int windowSize = cardPoints.length - k - 1;
        int window = 0;
        
        for (int i = 0; i < cardPoints.length; i++) {
            window += cardPoints[i];
            
            if (i < windowSize) {
                continue;
            }
            
            if (i > windowSize) {
               window = window - cardPoints[i - windowSize - 1];
            } 
            
            maxPoints = Math.max(maxPoints, totalPoints - window);
        }
        
        return maxPoints;
    }
    
}
