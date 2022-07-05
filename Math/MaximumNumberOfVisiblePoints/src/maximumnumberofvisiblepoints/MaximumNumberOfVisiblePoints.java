/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maximumnumberofvisiblepoints;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author souravpalit
 */
public class MaximumNumberOfVisiblePoints {

    // Time Complexity: O(nlogn) Space Complexity: O(n) where n is the points number
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        List<Double> angles = new ArrayList<>();
        int duplicates = 0;
        
        for (List<Integer> point : points) {
            int deltaY = point.get(1) - location.get(1);
            int deltaX = point.get(0) - location.get(0);
            if (deltaY == 0 && deltaX == 0) {
                duplicates++;
            } else {
                angles.add(getAngle(deltaY, deltaX));
            }
        } 
        
        Collections.sort(angles);
        int maxPoints = 0;
        int n = angles.size();
        
        for (int lowerRay = 0, upperRay = 0; lowerRay < n; lowerRay++) {
            while ((upperRay < n &&
                    angles.get(upperRay) - angles.get(lowerRay) <= angle) || 
                    (upperRay >= n && 360 + angles.get(upperRay % n) - angles.get(lowerRay) <= angle)) {
                upperRay++;
            }
            
            maxPoints = Math.max(maxPoints, upperRay - lowerRay);
        }
        
        return maxPoints + duplicates;
    }
    
    private double getAngle(int deltaY, int deltaX) {
        double angle = Math.toDegrees(Math.atan2(deltaY, deltaX));
        return angle < 0 ? angle + 360 : angle;
    }
}
