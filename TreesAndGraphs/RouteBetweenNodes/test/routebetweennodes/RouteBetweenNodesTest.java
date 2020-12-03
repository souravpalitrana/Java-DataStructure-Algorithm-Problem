/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package routebetweennodes;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static routebetweennodes.NodeState.UNVISITED;

/**
 *
 * @author souravpalit
 */
public class RouteBetweenNodesTest {
    
    public RouteBetweenNodesTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testRoundBetweenNodesByBFS() {
        Graph graph = RouteBetweenNodes.createGraph();
        Node start = graph.getNodes()[2];
        Node end = graph.getNodes()[4];
        assertEquals(false, RouteBetweenNodes.hasRoute(graph, start, end));
        reset(graph);
        
        start = graph.getNodes()[0];
        end = graph.getNodes()[4];
        assertEquals(true, RouteBetweenNodes.hasRoute(graph, start, end));
        reset(graph);
        
        Node nodes[] = graph.getNodes();
        assertEquals(true, RouteBetweenNodes.hasRoute(graph, nodes[0], nodes[1]));
        reset(graph);
        assertEquals(false, RouteBetweenNodes.hasRoute(graph, nodes[1], nodes[0]));
        reset(graph);
        assertEquals(true, RouteBetweenNodes.hasRoute(graph, nodes[0], nodes[2]));
        reset(graph);
        assertEquals(false, RouteBetweenNodes.hasRoute(graph, nodes[2], nodes[0]));
        reset(graph);
        assertEquals(true, RouteBetweenNodes.hasRoute(graph, nodes[0], nodes[3]));
        reset(graph);
        assertEquals(false, RouteBetweenNodes.hasRoute(graph, nodes[3], nodes[0]));
        reset(graph);
        assertEquals(true, RouteBetweenNodes.hasRoute(graph, nodes[3], nodes[4]));
        reset(graph);
        assertEquals(false, RouteBetweenNodes.hasRoute(graph, nodes[4], nodes[3]));
        reset(graph);
        assertEquals(true, RouteBetweenNodes.hasRoute(graph, nodes[4], nodes[5]));
        reset(graph);
        assertEquals(false, RouteBetweenNodes.hasRoute(graph, nodes[5], nodes[4]));
        reset(graph);
        assertEquals(false, RouteBetweenNodes.hasRoute(graph, nodes[1], nodes[5]));
        reset(graph);
        assertEquals(false, RouteBetweenNodes.hasRoute(graph, nodes[2], nodes[5]));
        reset(graph);
        assertEquals(true, RouteBetweenNodes.hasRoute(graph, nodes[3], nodes[5]));
        reset(graph);
        assertEquals(true, RouteBetweenNodes.hasRoute(graph, nodes[0], nodes[5]));
        
    }
    
    @Test
    public void testRoundBetweenNodesByDFS() {
        Graph graph = RouteBetweenNodesAlternate.createGraph();
        Node start = graph.getNodes()[2];
        Node end = graph.getNodes()[4];
        assertEquals(false, RouteBetweenNodesAlternate.hasRoute(graph, start, end));
        
        reset(graph);
        start = graph.getNodes()[0];
        end = graph.getNodes()[4];
        assertEquals(true, RouteBetweenNodesAlternate.hasRoute(graph, start, end));
        
        reset(graph);
        start = graph.getNodes()[2];
        end = graph.getNodes()[5];
        assertEquals(false, RouteBetweenNodesAlternate.hasRoute(graph, start, end));
        
        reset(graph);
        Node nodes[] = graph.getNodes();
        assertEquals(true, RouteBetweenNodesAlternate.hasRoute(graph, nodes[0], nodes[1]));
        reset(graph);
        assertEquals(false, RouteBetweenNodesAlternate.hasRoute(graph, nodes[1], nodes[0]));
        reset(graph);
        assertEquals(true, RouteBetweenNodesAlternate.hasRoute(graph, nodes[0], nodes[2]));
        reset(graph);
        assertEquals(false, RouteBetweenNodesAlternate.hasRoute(graph, nodes[2], nodes[0]));
        reset(graph);
        assertEquals(true, RouteBetweenNodesAlternate.hasRoute(graph, nodes[0], nodes[3]));
        reset(graph);
        assertEquals(false, RouteBetweenNodesAlternate.hasRoute(graph, nodes[3], nodes[0]));
        reset(graph);
        assertEquals(true, RouteBetweenNodesAlternate.hasRoute(graph, nodes[3], nodes[4]));
        reset(graph);
        assertEquals(false, RouteBetweenNodesAlternate.hasRoute(graph, nodes[4], nodes[3]));
        reset(graph);
        assertEquals(true, RouteBetweenNodesAlternate.hasRoute(graph, nodes[4], nodes[5]));
        reset(graph);
        assertEquals(false, RouteBetweenNodesAlternate.hasRoute(graph, nodes[5], nodes[4]));
        reset(graph);
        assertEquals(false, RouteBetweenNodesAlternate.hasRoute(graph, nodes[1], nodes[5]));
        reset(graph);
        assertEquals(false, RouteBetweenNodesAlternate.hasRoute(graph, nodes[2], nodes[5]));
        reset(graph);
        assertEquals(true, RouteBetweenNodesAlternate.hasRoute(graph, nodes[3], nodes[5]));
        reset(graph);
        assertEquals(true, RouteBetweenNodesAlternate.hasRoute(graph, nodes[0], nodes[5]));
    }   
    
    private void reset(Graph g) {
        for (Node node : g.getNodes()) {
            node.setState(UNVISITED);
            
            for (Node adjacent : node.getAdjacent()) {
                adjacent.setState(UNVISITED);
            }
        }
    }
}
