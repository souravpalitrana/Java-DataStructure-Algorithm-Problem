/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package criticalconnectionsinanetwork;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author souravpalit
 */
public class Solution {

    // Bridge Detection Approach
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> bridges = new ArrayList<>();
        List<List<Integer>> edges = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            edges.add(new ArrayList<Integer>());
        }

        for (List<Integer> connection : connections) {
            edges.get(connection.get(0)).add(connection.get(1));
            edges.get(connection.get(1)).add(connection.get(0));
        }

        int[] arrivalTimes = new int[n];
        Arrays.fill(arrivalTimes, -1);

        getMinimumArrivalTimeOfAncestor(0, -1, 0, arrivalTimes, edges, bridges);
        return bridges;
    }

    public int getMinimumArrivalTimeOfAncestor(
            int currentVertex,
            int parentVertex,
            int currentTime,
            int[] arrivalTimes,
            List<List<Integer>> edges,
            List<List<Integer>> bridges
    ) {

        arrivalTimes[currentVertex] = currentTime;
        int minimumArrivalTime = currentTime;

        for (Integer destination : edges.get(currentVertex)) {
            if (arrivalTimes[destination] == -1) {
                int currentMin = getMinimumArrivalTimeOfAncestor(
                        destination,
                        currentVertex,
                        currentTime + 1,
                        arrivalTimes,
                        edges,
                        bridges
                );
                // -1 is the minimum which means there is a bridge.
                // so we don't need that
                if (currentMin != -1) {
                    minimumArrivalTime = Math.min(minimumArrivalTime, currentMin);
                }
            } else if (destination != parentVertex) {
                // thats meann it is not parent but already visited so its minimumArrivalTime
                // is in the arrivalTimes
                minimumArrivalTime = Math.min(minimumArrivalTime, arrivalTimes[destination]);
            }
        }

        if (minimumArrivalTime == currentTime && parentVertex != -1) {
            // second part is for starting vertext where it has no parent
            // as did not get backedge so return -1 and add the edge as it is a
            // bridge
            bridges.add(Arrays.asList(parentVertex, currentVertex));
            return -1;
        }

        return minimumArrivalTime;
    }
}
