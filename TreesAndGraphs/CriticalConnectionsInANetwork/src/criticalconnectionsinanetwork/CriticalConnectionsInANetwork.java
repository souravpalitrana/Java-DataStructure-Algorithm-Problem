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
public class CriticalConnectionsInANetwork {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> connections = new ArrayList<>();
        ///[[0,1],[1,2],[2,0],[1,3]]
        connections.add(Arrays.asList(0, 1));
        connections.add(Arrays.asList(1, 2));
        connections.add(Arrays.asList(2, 0));
        connections.add(Arrays.asList(1, 3));
        
        solution.criticalConnections(4, connections);
    }
    
}
