/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airportconnections;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author souravpalit
 */
public class Node {
    String vertex;
    List<Node> edges = new ArrayList<Node>();
    boolean isReachableFromStarting = true;
    // This nodes are reachable from the vertex but not reachable from starting
    // point. Which means if we add a connection from starting to this vertex
    // than we can reach all the airports of unreachableConnections
    List<String> unreachableConnections = new ArrayList<String>(); 
    
    
    public Node(String vertex) {
        this.vertex = vertex;
    }
    
    public void add(Node node) {
        edges.add(node);
    }
}
