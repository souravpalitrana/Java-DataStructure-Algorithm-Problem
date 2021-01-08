/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author souravpalit
 */
public class DFS {

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
        
        //nodeA.depthFirstSearch(output);
        
        depthFirstSearch(nodeA, output);
        
        
        for (String name : output) {
            System.out.print(name + " ");
        }
    }
    
    public static void depthFirstSearch(Node node, List<String> list) {
        Stack<Node> stack = new Stack<Node>();
        stack.add(node);
        
        while (!stack.isEmpty()) {
            Node currentNode = stack.pop();
            if (currentNode != null) {
                list.add(currentNode.name);
                Collections.reverse(currentNode.children);
                stack.addAll(currentNode.children);
                /*for (int i = currentNode.children.size() -1; i >= 0; i--) {
                    stack.add(currentNode.children.get(i));
		}*/
            }
        }
    }
    
}
