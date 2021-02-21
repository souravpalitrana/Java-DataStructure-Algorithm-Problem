/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dfs;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author souravpalit
 */
public class Node {
    
    public String name;
    public List<Node> children = new ArrayList(); 
    
    public Node(String name) {
        this.name = name;
    }
    
    public Node(String name, List<Node> children) {
        this.name = name;
        this.children = children;
    }
    
    public void addChild(Node node) {
        children.add(node);
    }
    
    public List<String> depthFirstSearch(List<String> list){
        list.add(name);
        
        for (Node node : children) {
            node.depthFirstSearch(list);
        }
        
        return list;
    }
}
