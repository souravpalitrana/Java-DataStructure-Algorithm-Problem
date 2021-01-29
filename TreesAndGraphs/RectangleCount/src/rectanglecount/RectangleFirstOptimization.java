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
 * We are storing all coordinates based on x and y so total 2N coordinates. Hence
 * the time complexity is O(N) and space complexity is O(N).
 * Now considering each point as bottom left point and rotating clockwise is 
 * also takes O(n^2) time because for each point we need to deal with n-1 points
 * So we can say time Complexity is O(n^2) and space complexity is O(n^2).
 * We can ignore recursion call stack as it will be maximum 4 call frame because
 * of 4 direction.
 * @author souravpalit
 */
public class RectangleFirstOptimization {
    
    static String X = "x";
    static String Y = "y";
    static String UP = "up";
    static String DOWN = "down";
    static String LEFT = "left";
    static String RIGHT = "right";
    
    public static void main(String[] args) {
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
        Map<String, Map<Integer, List<Point>>> coordinatesTable = getCoordinatesTable(coordinates);
        int rectangleCount = 0;
        for (Point point : coordinates) {
            rectangleCount += clockwiseCountRectangle(point, UP, coordinatesTable, point);
        }
        
        return rectangleCount;
    }
    
    public static int clockwiseCountRectangle(Point point, String direction, 
            Map<String, Map<Integer, List<Point>>> coordinatesTable, Point origin) {
        if (direction == LEFT) {
            List<Point> leftCoordinates = coordinatesTable.get(Y).get(point.y);
            if (leftCoordinates.contains(origin)) {
                return 1;
            } else {
                return 0;
            }
        } else {
          int rectangleCount = 0;
          String nextDirection = getNextDirection(direction);
          List<Point> nextPoints = new ArrayList<Point>();
          
          if (direction == UP || direction == DOWN) {
              nextPoints.addAll(coordinatesTable.get(X).get(point.x));
          } else if (direction == RIGHT || direction == LEFT) {
              nextPoints.addAll(coordinatesTable.get(Y).get(point.y));
          }
        
          for (int i = 0; i < nextPoints.size(); i++) {
              Point nextPoint = nextPoints.get(i);
              if (!isValidPoint(point, nextPoint, direction)) {
                  continue;
              }
              rectangleCount += clockwiseCountRectangle(nextPoint, nextDirection, coordinatesTable, origin);
          }
          
          return rectangleCount;
        }
    }
    
    public static boolean isValidPoint(Point point1, Point point2, String direction) {
        if (point1 == point2) {
            return false;
        } else {
            if (direction == RIGHT) {
                return (point2.x > point1.x);
            } else if (direction == LEFT) {
                return (point2.x < point1.x);    
            } else if (direction == UP) {
                return (point2.y > point1.y);
            } else if (direction == DOWN) {
                return (point2.y < point1.y);
            }
        }
        
        return true;
    }
    
    
    public static Map<String,  Map<Integer, List<Point>>> getCoordinatesTable(List<Point> coordinates) {
        Map<String,  Map<Integer, List<Point>>> coordinatesTable = new HashMap<String, Map<Integer, List<Point>>>();
        
        Map<Integer, List<Point>> xValues = new HashMap<Integer, List<Point>>();
        Map<Integer, List<Point>> yValues = new HashMap<Integer, List<Point>>();
        for (Point point : coordinates) {
            
            if (!xValues.containsKey(point.x)) {
                xValues.put(point.x, new ArrayList<Point>());
            }
            
            if (!yValues.containsKey(point.y)) {
                yValues.put(point.y, new ArrayList<Point>());
            }
            
            xValues.get(point.x).add(point);
            yValues.get(point.y).add(point);
        }
        
        coordinatesTable.put(X, xValues);
        coordinatesTable.put(Y, yValues);
        
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
