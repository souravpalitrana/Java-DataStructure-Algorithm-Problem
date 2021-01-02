/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allnodedepth;

/**
 *
 * @author souravpalit
 */
public class NodeInfo {
    public int nodeCount;
    public int nodeDepth;
    public int sumOfAllNodeDepth;
    
    public NodeInfo(int nodeCount, int nodeDepth, int sumOfAllNodeDepth) {
        this.nodeCount = nodeCount;
        this.nodeDepth = nodeDepth;
        this.sumOfAllNodeDepth = sumOfAllNodeDepth;
    }
}
