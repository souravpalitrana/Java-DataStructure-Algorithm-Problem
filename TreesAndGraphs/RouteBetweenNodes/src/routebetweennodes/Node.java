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
public class Node {
    
    private Node adjacent[];
    private int adjacentCount;
    private String vertex;
    private NodeState state = NodeState.UNVISITED;
        
    public Node(String vertex, int adjacentCount) {
        this.vertex = vertex;
        this.adjacent = new Node[adjacentCount];
    }
    
    public void addAdjacent(Node node) {
        if (adjacentCount < adjacent.length) {
            adjacent[adjacentCount] = node;
            adjacentCount++;
        } else {
            System.out.println("No more adjacent can be added");
        }
    }
    
    public Node[] getAdjacent() {
        return adjacent;
    }
    
    public String getVertex() {
        return vertex;
    }
    
    public NodeState getState() {
        return state;
    }
    
    public void setState(NodeState state) {
        this.state = state;
    }   
}
