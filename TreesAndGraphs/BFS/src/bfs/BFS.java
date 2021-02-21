/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author souravpalit
 */
public class BFS {

    /**
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
        breadthFirstSearch(nodeA, output);
        for (String name : output) {
            System.out.print(name + " ");
        }
    }
    
    public static void breadthFirstSearch(Node root, List<String> list) {
        Queue<Node> q = new LinkedList();
        q.add(root);
        
        while (!q.isEmpty()) {
            Node node = q.poll();
            if (node != null) {
                list.add(node.name);
                q.addAll(node.children);
            }
        }
    }
    
}
