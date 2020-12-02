/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package routebetweennodes;

/**
 *
 * @author souravpalit
 */
public class Graph {
    
    private int nodeCount;
    private Node nodes [];
    
    public Graph(int nodeCount) {
        this.nodes = new Node[nodeCount];
    }
    
    public void addNode(Node node) {
        if (nodeCount < nodes.length) {
            nodes[nodeCount] = node;
            nodeCount++;
        } else {
            System.out.println("Graph Full");
        }
    }
    
    public Node[] getNodes() {
        return nodes;
    }
}
