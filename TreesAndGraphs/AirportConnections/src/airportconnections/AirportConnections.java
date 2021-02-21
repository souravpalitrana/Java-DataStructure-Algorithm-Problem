/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airportconnections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * Time: O(a * (a + r) + a + r + aloga)        Space: O(a + r)
 * @author souravpalit
 */
public class AirportConnections {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String [] airports = {"BGI", "CDG", "DEL", "DOH", "DSM", "EWR","EYW", 
            "HND", "ICN", "JFK", "LGA", "LHR", "ORD", "SAN", "SFO","SIN", 
            "TLV", "BUD"};
        
        List<List<String>> routes = new ArrayList<List<String>>();
        routes.add(getRoute("DSM","ORD"));
        routes.add(getRoute("ORD","BGI"));
        routes.add(getRoute("BGI","LGA"));
        routes.add(getRoute("SIN","CDG"));
        routes.add(getRoute("CDG","SIN"));
        routes.add(getRoute("CDG","BUD"));
        routes.add(getRoute("DEL","DOH"));
        routes.add(getRoute("DEL","CDG"));
        routes.add(getRoute("TLV","DEL"));
        routes.add(getRoute("EWR","HND"));
        routes.add(getRoute("HND","ICN"));
        routes.add(getRoute("HND","JFK"));
        routes.add(getRoute("ICN","JFK"));
        routes.add(getRoute("JFK","LGA"));
        routes.add(getRoute("EYW","LHR"));
        routes.add(getRoute("LHR","SFO"));
        routes.add(getRoute("SFO","SAN"));
        routes.add(getRoute("SFO","DSM"));
        routes.add(getRoute("SAN","EYW"));
      
        System.out.println("Minimum routes required : " + requiredAireportConnection(airports, routes, "LGA"));
    }
    
   
    
    public static int requiredAireportConnection(String [] airports, 
            List<List<String>> routes, String startingAirport) {
        Graph graph = createGraph(airports, routes);
        List<Node> unreacheableAirpots = getUnreachableAirports(airports, graph, startingAirport);
        markUnreachableConnections(graph, unreacheableAirpots);
        return getMinNumberOfNewConnections(graph, unreacheableAirpots);
    }
    
    // Time: O( aloga + a + r) Space O(1)
    public static int getMinNumberOfNewConnections(Graph graph, 
            List<Node> unreachableAirportNodes) {
        int numberOfNewConnections = 0;
        
        Collections.sort(unreachableAirportNodes, new Comparator<Node> () {
            
            @Override
            public int compare(Node o1, Node o2) {
                return o2.unreachableConnections.size() - o1.unreachableConnections.size();
            }
        });
        
        for (Node airport : unreachableAirportNodes) {
            if (!airport.isReachableFromStarting) {
                numberOfNewConnections++;
                for (String connection : airport.unreachableConnections) {
                    graph.nodes.get(connection).isReachableFromStarting = true;
                    
                }
            }
        }
        
        return numberOfNewConnections;
    }
    
    // Time: O(a * (a + r)) Space: O(a)
    public static void markUnreachableConnections(Graph graph, List<Node> unreachableAirportNodes) {
        for (Node connection : unreachableAirportNodes) {
            Set<String> visitedAirports = new HashSet<String>();
            List<String> unreachableConnections = new ArrayList<String>();
            depthFirstAddUnreachableConnections(graph, visitedAirports, connection.vertex, unreachableConnections);
            connection.unreachableConnections = unreachableConnections;
        }
    }
    
    //Time: O(a + r) and Space O(a + r)
    public static Graph createGraph(String [] airports, 
            List<List<String>> routes) {
        Graph graph = new Graph();
        for (String airport : airports) {
            graph.addNode(airport);
        }
        
        for (List<String> route : routes) {
            graph.addEdges(route.get(0), route.get(1));
        }
        return graph;
    }
    
    // Time: O(a + r) and Space O(a)
    public static List<Node> getUnreachableAirports(String [] airports, 
            Graph graph, String startingAirport) {
       Set<String> visitedAirports = new HashSet<String>();
       List<Node> unreachableAirports = new ArrayList<Node>();
       depthFirstTraverseAirports(visitedAirports, graph, startingAirport);
       for (String airport : airports) {
           if (!visitedAirports.contains(airport)) {
               Node unreachableAirport = graph.nodes.get(airport);
               unreachableAirport.isReachableFromStarting = false;
               unreachableAirports.add(unreachableAirport);
           }
       }
       
       return unreachableAirports;
    }
    
    public static void depthFirstTraverseAirports(Set<String> visitedAirports, 
            Graph graph, String airport) {
        if (visitedAirports.contains(airport)) {
            return;
        }
        
        visitedAirports.add(airport);
        List<Node> connections = graph.nodes.get(airport).edges;
        for (Node connection : connections) {
            depthFirstTraverseAirports(visitedAirports, graph, connection.vertex);
        }
    }
    
    public static void depthFirstAddUnreachableConnections(Graph graph, 
            Set<String> visited, String airport, 
            List<String> unreachableConnections) {
        if (visited.contains(airport) || graph.nodes.get(airport).isReachableFromStarting) {
            return;
        }
        
        visited.add(airport);
        unreachableConnections.add(airport);
        
        List<Node> connections = graph.nodes.get(airport).edges;
        for (Node connection : connections) {
            depthFirstAddUnreachableConnections(graph, visited, connection.vertex, unreachableConnections);
        }
    }
    
    public static List<String> getRoute(String firstAirport, 
            String secondAirport) {
        List<String> routes = new ArrayList<String>();
        routes.add(firstAirport);
        routes.add(secondAirport);
        return routes;
    }
    
    
}
