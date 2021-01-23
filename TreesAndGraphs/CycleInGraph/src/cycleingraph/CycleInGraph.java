/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cycleingraph;

/**
 *
 * @author souravpalit
 */
public class CycleInGraph {

    /**
     * @param args the command line arguments
     */
    
    public static final int VISITED = 2;
    public static final int UNVISITED = 0;
    public static final int VISITING = 1;
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        int edges [][] = {{1, 3}, {2, 3, 4}, {}, {}, {2,5}, {}};
        
        System.out.println("This graph has cycle: " + hasCycle(edges));
    }
    
    public static boolean hasCycle(int [][] edges) {
        int nodesCount = edges.length;
        
        int nodeStates [] = new int [nodesCount];
        
        for (int i = 0; i < nodesCount; i++) {
            if (nodeStates[i] == VISITED) {
                continue;
            }
            
            boolean hasCycle = hasCycle(edges, i, nodeStates);
            
            if (hasCycle) {
                return true;
            }
        }
        
        return false;
    }
    
    public static boolean hasCycle(int [][] edges, int nodeIdx, int [] nodeStates) {
        nodeStates[nodeIdx] = VISITING;
        
        int [] adjacentNodes = edges[nodeIdx];
        
        for (int i = 0; i < adjacentNodes.length; i++) {
            int adjacentIdx = adjacentNodes[i];
            
            if (nodeStates[adjacentIdx] == VISITING) {
                return true;
            } else if (nodeStates[adjacentIdx] == UNVISITED) {
                boolean hasCycle = hasCycle(edges, adjacentIdx, nodeStates);
                
                if (hasCycle) {
                    return true;
                }
            }
        }
        
        nodeStates[nodeIdx] = VISITED;
        return false;
    }
    
}
