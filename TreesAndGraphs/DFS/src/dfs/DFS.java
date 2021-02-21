/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author souravpalit
 */
public class DFS {

    /**
     * Considering no cycle. If it has cycle then we need to track which node 
     * we visited and need extra memory.
     * Time Complexity O(v + e) Space Complexity O(v)
     * One important thing is when we use DFS in binary tree then O (v + e) can 
     * say O(v) because edge is less than v in case of Binary tree so v+e always
     * less than 2v we can say it is O(v)s
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");
        Node nodeF = new Node("F");
        Node nodeG = new Node("G");
        Node nodeH = new Node("H");
        Node nodeI = new Node("I");
        Node nodeJ = new Node("J");
        Node nodeK = new Node("K");
        
        nodeA.addChild(nodeB);
        nodeA.addChild(nodeC);
        nodeA.addChild(nodeD);
        
        nodeB.addChild(nodeE);
        nodeB.addChild(nodeF);
        
        nodeF.addChild(nodeI);
        nodeF.addChild(nodeJ);
        
        nodeD.addChild(nodeG);
        nodeD.addChild(nodeH);
        
        nodeG.addChild(nodeK);
        
        List<String> output = new ArrayList();
        
        //nodeA.depthFirstSearch(output);
        depthFirstSearch(nodeA, output);
        //depthFirstSearchAlternate(nodeA, output);
        
        for (String name : output) {
            System.out.print(name + " ");
        }
    }
    
    // Iterative approacch
    public static void depthFirstSearch(Node node, List<String> list) {
        Stack<Node> stack = new Stack<Node>();
        stack.add(node);
        while (!stack.isEmpty()) {
            Node currentNode = stack.pop();
            if (currentNode != null) {
                list.add(currentNode.name);
                Collections.reverse(currentNode.children);
                stack.addAll(currentNode.children);
            }
        }
    }
    
    // Recursive approach
    public static void depthFirstSearchAlternate(Node node, List<String> list) {
        if (node != null) {
            list.add(node.name);
            for (Node child : node.children) {
                depthFirstSearchAlternate(child, list);
            }
        }
    }
    
}
