/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rectanglecount;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author souravpalit
 */
public class RectangleCount {

    static String UP = "up";
    static String DOWN = "down";
    static String LEFT = "left";
    static String RIGHT = "right";
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        List<Point> coordinates = new ArrayList<Point>();
        coordinates.add(new Point(0, 0));
        coordinates.add(new Point(1, 0));
        coordinates.add(new Point(2, 0));
        coordinates.add(new Point(0, 1));
        coordinates.add(new Point(1, 1));
        coordinates.add(new Point(2, 1));
        
        System.out.println("Number of rectangles : " + countRectangles(coordinates));
    }
    
    public static int countRectangles(List<Point> coordinates) {
        Map<String, Map<String, List<Point>>> coordinatesTable = getCoordinatesTable(coordinates);
        int rectangleCount = 0;
        for (Point point : coordinates) {
            rectangleCount += clockwiseCountRectangle(point, UP, coordinatesTable, point);
        }
        
        return rectangleCount;
    }
    
    public static int clockwiseCountRectangle(Point point, String direction, 
            Map<String, Map<String, List<Point>>> coordinatesTable, Point origin) {
        if (direction == LEFT) {
            List<Point> leftCoordinates = coordinatesTable.get(point.toString()).get(LEFT);
            if (leftCoordinates.contains(origin)) {
                return 1;
            } else {
                return 0;
            }
        } else {
          int rectangleCount = 0;
          String nextDirection = getNextDirection(direction);
          List<Point> upperPoints = coordinatesTable.get(point.toString()).get(direction);
          for (Point nextPoint : upperPoints) {
              rectangleCount += clockwiseCountRectangle(nextPoint, nextDirection, coordinatesTable, origin);
          }
          
          return rectangleCount;
        }
    }
    
    
    public static Map<String,  Map<String, List<Point>>> getCoordinatesTable(List<Point> coordinates) {
        Map<String,  Map<String, List<Point>>> coordinatesTable = new HashMap<String, Map<String, List<Point>>>();
        
        for (Point point1 : coordinates) {
            Map<String, List<Point>> relativeDirections = new HashMap<String, List<Point>>();
            relativeDirections.put(UP, new ArrayList<Point>());
            relativeDirections.put(DOWN, new ArrayList<Point>());
            relativeDirections.put(LEFT, new ArrayList<Point>());
            relativeDirections.put(RIGHT, new ArrayList<Point>());
            
            for (Point point2 : coordinates) {
                String direction = getRelativeDirection(point1, point2);
                if (relativeDirections.containsKey(direction)) {
                    relativeDirections.get(direction).add(point2);
                }
            }
            
            coordinatesTable.put(point1.toString(), relativeDirections);
        }
        
        return coordinatesTable;
    }
    
    public static String getRelativeDirection(Point firstPoint, Point secondPoint) {
        if (firstPoint.x == secondPoint.x) {
            if (secondPoint.y > firstPoint.y) {
                return UP;
            } else if (secondPoint.y < firstPoint.y){
                return DOWN;
            }
        } else if (firstPoint.y == secondPoint.y) {
            if (secondPoint.x > firstPoint.x) {
                return RIGHT;
            } else if (secondPoint.x < firstPoint.x) {
                return LEFT;
            }
        } 
        
        return "";
    }
    
    public static String getNextDirection(String direction) {
        if (direction == UP) {
            return RIGHT;
        } else if (direction == RIGHT) {
            return DOWN;
        } else if (direction == DOWN) {
            return LEFT;
        } else {
            return "";
        }
    }
}
