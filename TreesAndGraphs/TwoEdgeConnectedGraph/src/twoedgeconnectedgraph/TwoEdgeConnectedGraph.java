/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twoedgeconnectedgraph;

import java.util.Arrays;

/**
 * Time Complexity: O(v + e) 
 * Space Complexity: O(v)
 * @author souravpalit
 */
public class TwoEdgeConnectedGraph {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[][] input = new int[][]{{1, 2, 5}, {0, 2}, {0, 1, 3}, {2, 4, 5}, {3, 5}, {0, 3, 4}};
        
        System.out.println("twoEdgeConnectedGraph " + twoEdgeConnectedGraph(input));
    }

    public static boolean twoEdgeConnectedGraph(int[][] edges) {
        if (edges.length == 0) {
            return true;
        }
        
        int arrivalTimes [] = new int[edges.length];
        
        Arrays.fill(arrivalTimes, -1);
        int startingVertex = 0;
        
        if (getMinimumArrivalTimeOfAncestor(startingVertex, -1, 0, arrivalTimes, edges) == -1) {
            return false;
        }
        
        return areAllVertecVisited(arrivalTimes);
    }
    
    public static int getMinimumArrivalTimeOfAncestor(
            int currentVertex, 
            int parentVertex,
            int currentTime,
            int [] arrivalTimes,
            int [][] edges
    ) {
        
        arrivalTimes[currentVertex] = currentTime;
        int minimumArrivalTime = currentTime;
        
        for (Integer destination : edges[currentVertex]) {
            if (arrivalTimes[destination] == -1) {
                // that means it is not visited
                minimumArrivalTime = Math.min(minimumArrivalTime, getMinimumArrivalTimeOfAncestor(
                        destination,
                        currentVertex,
                        currentTime + 1,
                        arrivalTimes,
                        edges
                ));
            } else if (destination != parentVertex) {
                // thats meann it is not parent but already visited so its minimumArrivalTime
                // is in the arrivalTimes
                minimumArrivalTime = Math.min(minimumArrivalTime, arrivalTimes[destination]);
            }
        }
        
        if (minimumArrivalTime == currentTime && parentVertex != -1) {
            // second part is for starting vertext where it has no parent
            // as did not get backedge so return -1
            return -1;
        }
        
        return minimumArrivalTime;
       
    }
    
    
    public static boolean areAllVertecVisited(int [] arrivalTimes) {
        for (Integer value : arrivalTimes) {
            if (value == -1) {
                return false;
            }
        } 
        
        return true;
    }

}
