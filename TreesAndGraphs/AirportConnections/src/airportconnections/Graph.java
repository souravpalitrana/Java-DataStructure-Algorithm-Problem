/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airportconnections;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author souravpalit
 */
public class Graph {
    Map<String, Node> nodes = new HashMap<String, Node>();
    
    public void addNode(String vertex) {
        nodes.put(vertex, new Node(vertex));
    }
    
    public void addEdges(String vertex1, String vertex2) {
        Node node1 = nodes.get(vertex1);
        Node node2 = nodes.get(vertex2);
        
        node1.add(node2);
    }
    
}
