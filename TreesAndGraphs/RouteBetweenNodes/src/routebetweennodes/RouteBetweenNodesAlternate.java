/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package routebetweennodes;

import java.util.LinkedList;
import java.util.Queue;
import static routebetweennodes.NodeState.UNVISITED;
import static routebetweennodes.NodeState.VISITED;

/**
 * Route Between nodes: Given a directed graph, design an algorithm to find out
 * whether there is a route between nodes.
 * @author souravpalit
 */
public class RouteBetweenNodesAlternate {

    public static void main(String[] args) {
        Graph graph = createGraph();
        Node start = graph.getNodes()[2];
        Node end = graph.getNodes()[4];
        System.out.println("Has route between " + start.getVertex() + " and " 
                + end.getVertex() + " : " +hasRoute(graph, start, end));
        
        start = graph.getNodes()[0];
        end = graph.getNodes()[4];
        System.out.println("Has route between " + start.getVertex() + " and " 
                + end.getVertex() + " : " +hasRoute(graph, start, end));
        
    }
    
    public static Graph createGraph() {
        int nodeCount = 6;
        Graph graph = new Graph(nodeCount);
        Node[] nodes = new Node[nodeCount];
        nodes[0] = new Node("A", 3);
        nodes[1] = new Node("B", 0);
        nodes[2] = new Node("C", 0);
        nodes[3] = new Node("D", 1);
        nodes[4] = new Node("E", 1);
        nodes[5] = new Node("F", 0);
        
        nodes[0].addAdjacent(nodes[1]);
        nodes[0].addAdjacent(nodes[2]);
        nodes[0].addAdjacent(nodes[3]);
        nodes[3].addAdjacent(nodes[4]);
        nodes[4].addAdjacent(nodes[5]);
        
        for (int i = 0; i < nodeCount; i++) {
            graph.addNode(nodes[i]);
        }
        
        return graph;
    }
    
    //DFS
    public static boolean hasRoute(Graph graph, Node start, Node end) {
        if (start == end) {
            return true;
        } else if (start.getState() == UNVISITED) {
          start.setState(VISITED);
          
          for (Node node : start.getAdjacent()) {
              if (node.getState() == UNVISITED) {
                  if (hasRoute(graph, node, end)) {
                      return true;
                  }
              }
          }
        }
        
        return false;
    }
}
