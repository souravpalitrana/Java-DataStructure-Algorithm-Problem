/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package detectarbitrage;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Time Complexity: O(n^3) because n^2 edges and n loop for bellman ford algo
 * Space Complexity: O(n^2) because of new input array. If we are allow to 
 * modify the input array then space complexity will be O(n) because of 
 * distance array
 * @author souravpalit
 */
public class DetectArbitrage {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<ArrayList<Double>> input = new ArrayList<ArrayList<Double>>();
        input.add(new ArrayList<Double>(Arrays.asList(1.0, 0.8631, 0.5903)));
        input.add(new ArrayList<Double>(Arrays.asList(1.1586, 1.0, 0.6849)));
        input.add(new ArrayList<Double>(Arrays.asList(1.6939, 1.46, 1.0)));
        
        System.out.println("Has Arbitrag : " + detectArbitrage(input));
    }
    
    public static boolean detectArbitrage(ArrayList<ArrayList<Double>> exchangeRates) {
        ArrayList<ArrayList<Double>> logExchangeRates = 
                convertToLogExchangeRates(exchangeRates);
        return hasNegativeWeightCycle(logExchangeRates);
    }
    
    public static boolean hasNegativeWeightCycle(ArrayList<ArrayList<Double>> graph) {
        double [] distancesFromStart = new double [graph.size()];
        Arrays.fill(distancesFromStart, Double.MAX_VALUE);
        distancesFromStart[0] = 0; // As starting node to starting node 0 distance
        
        for (int i = 0; i < graph.size(); i++) {
            if (!relaxAndUpdateDistance(graph, distancesFromStart)) {
                // No changes that means no negative cycle and we could stop
                // as no negative cycle means no aribrage possiblee
                return false;
            }
        }
        
        return relaxAndUpdateDistance(graph, distancesFromStart);
    }
    
    public static ArrayList<ArrayList<Double>> convertToLogExchangeRates(
            ArrayList<ArrayList<Double>> exchangeRates
    ) {
        ArrayList<ArrayList<Double>> logExchangeRates = 
                new ArrayList<ArrayList<Double>>();
        
        for (int i = 0; i < exchangeRates.size(); i++) {
            ArrayList<Double> rates = new ArrayList<Double>();
            for (int j = 0; j < exchangeRates.get(i).size(); j++) {
                rates.add(-Math.log10(exchangeRates.get(i).get(j)));
            }
            logExchangeRates.add(rates);
        }
        
        return logExchangeRates;
    }
    
    public static boolean relaxAndUpdateDistance(
            ArrayList<ArrayList<Double>> graph, 
            double [] distancesFromStart
    ) {
        boolean isUpdated = false;
        
        for (int sourceIdx = 0; sourceIdx < graph.size(); sourceIdx++) {
            ArrayList<Double> edges = graph.get(sourceIdx);
            for (int destinationIdx = 0; destinationIdx < edges.size(); destinationIdx++) {
                double newDistance = distancesFromStart[sourceIdx] + edges.get(destinationIdx);
                if (newDistance < distancesFromStart[destinationIdx]) {
                    isUpdated = true;
                    distancesFromStart[destinationIdx] = newDistance;
                }
            }
        }
        
        return isUpdated;
    }
    
}
