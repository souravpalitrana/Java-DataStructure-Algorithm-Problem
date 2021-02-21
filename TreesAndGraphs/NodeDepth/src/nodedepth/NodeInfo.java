/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nodedepth;

/**
 *
 * @author souravpalit
 */
public class NodeInfo {
    public int depth;
    public BinaryTree node;
    
    public NodeInfo(BinaryTree node, int depth) {
        this.node = node;
        this.depth = depth;
    }
}
