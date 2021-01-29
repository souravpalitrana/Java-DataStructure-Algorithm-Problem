/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rectanglecount;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Storing only n values of coordinates string so Space Complexity O(N) and time
 * for this is O(n). 
 * Now considering each point as bottom left point and finding top right point
 * we need to use double for loop which is O(N^2). So final time complexity
 * is O(N^2) and space complexity is O(N)
 * @author souravpalit
 */
public class RectangleCountSecondOptimization {
    
    public static void main(String[] args) {
        List<Point> coordinates = new ArrayList<Point>();
        coordinates.add(new Point(0, 0));
        coordinates.add(new Point(0, 1));
        coordinates.add(new Point(1, 1));
        coordinates.add(new Point(1, 0));
        coordinates.add(new Point(2, 1));
        coordinates.add(new Point(2, 0));
        coordinates.add(new Point(3, 1));
        coordinates.add(new Point(3, 0));
        
        System.out.println("Number of rectangles : " + countRectangles(coordinates));
    }
    
    public static int countRectangles(List<Point> coordinates) {
        Set<String> coordinatesTable = getCoordinatesTable(coordinates);
        int rectangleCount = 0;
        for (Point point1 : coordinates) {
            for (Point point2 : coordinates) {
                if (point2.x > point1.x && point2.y > point1.y) {
                    // it is topRightPoint
                    String topLeft = new Point(point1.x, point2.y).toString();
                    String bottomRight = new Point(point2.x, point1.y).toString();
                    
                    if (coordinatesTable.contains(topLeft) && coordinatesTable.contains(bottomRight)) {
                        rectangleCount++;
                    }
                }
            }
        }
        
        return rectangleCount;
    }
      
    public static Set<String> getCoordinatesTable(List<Point> coordinates) {
        Set<String> coordinatesTable = new HashSet<String>();
        
        for (Point point : coordinates) {
            coordinatesTable.add(point.toString());
        }
         
        return coordinatesTable;
    }
}
