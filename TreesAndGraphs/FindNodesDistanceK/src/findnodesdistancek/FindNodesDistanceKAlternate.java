/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package findnodesdistancek;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Time Complexity: O(n) Space Complexity: O(n)
 * @author souravpalit
 */
public class FindNodesDistanceKAlternate {
    
    public static void main(String[] args) {
        // TODO code application logic here
        BinaryTree root = new BinaryTree(1);
        root.left = new BinaryTree(2);
        root.right = new BinaryTree(3);
        
        root.left.left = new BinaryTree(4);
        root.left.right = new BinaryTree(5);
        
        root.right.right = new BinaryTree(6);
        
        root.right.right.left = new BinaryTree(7);
        root.right.right.right = new BinaryTree(8);
        
        /*BinaryTree root = new BinaryTree(1);
        root.left = new BinaryTree(2);
        root.right = new BinaryTree(3);
        root.left.left = new BinaryTree(4);
        root.right.right = new BinaryTree(5);
        
        root.left.left.left = new BinaryTree(6);
        root.right.right.left = new BinaryTree(7);
        root.right.right.right = new BinaryTree(8);*/
        
        
        int target = 3;
        int distance = 2;
        //int target = 6;
        //int distance = 6;
        
        List<Integer> kDistanceNodes = findNodesDistanceK(root, target, distance);
        
        for (Integer value : kDistanceNodes) {
            System.out.println(value + " ");
        }
    }
    
    public static List<Integer> findNodesDistanceK(BinaryTree root, 
            int target, int distance) {
        Map<Integer, BinaryTree> parentMap = new HashMap<Integer, BinaryTree>();
        mapParents(root, null, parentMap);
        BinaryTree targetNode = getNodeFromValue(root, parentMap, target);
        List<Integer> nodesInKDistance = new ArrayList<Integer>();
        depthFirstSearchFromTarget(targetNode, parentMap, distance, nodesInKDistance);
        return nodesInKDistance;
    }
    
    public static void mapParents(BinaryTree root, BinaryTree parent, 
            Map<Integer, BinaryTree> parentMap) {
        if (root == null) {
            return;
        }
        
        parentMap.put(root.value, parent);
        mapParents(root.left, root, parentMap);
        mapParents(root.right, root, parentMap);
    }
    
    public static BinaryTree getNodeFromValue(BinaryTree root, 
            Map<Integer, BinaryTree> parentMap, int value) {
        if (root.value == value) {
            return root;
        }
        
        BinaryTree node = parentMap.get(value);
        
        if (node.left != null && node.left.value == value) {
            return node.left;
        } else {
            return node.right;
        }
    }
    
    public static void depthFirstSearchFromTarget(BinaryTree targetNode, 
            Map<Integer, BinaryTree> parentMap, int distance, 
            List<Integer> nodesInKDistance) {
        Set<Integer> visitedNodes = new HashSet<Integer>();
        Queue<Pair<BinaryTree, Integer>> queue = new LinkedList<Pair<BinaryTree, Integer>>();
        queue.add(new Pair(targetNode, 0));
        visitedNodes.add(targetNode.value);
        
        while (!queue.isEmpty()) {
           Pair<BinaryTree, Integer> currentNode = queue.poll();
           visitedNodes.add(currentNode.first.value);
           if (currentNode.second == distance) {
               nodesInKDistance.add(currentNode.first.value);
           } else {
               if (currentNode.first.left != null && !visitedNodes.contains(currentNode.first.left.value)) {
                   queue.add(new Pair(currentNode.first.left, currentNode.second + 1));
               }
               
               if (currentNode.first.right != null && !visitedNodes.contains(currentNode.first.right.value)) {
                   queue.add(new Pair(currentNode.first.right, currentNode.second + 1));
               }
               
               BinaryTree parent = parentMap.get(currentNode.first.value);
               if (parent != null && !visitedNodes.contains(parent.value)) {
                   queue.add(new Pair(parent, currentNode.second + 1));
               }
           }
        }
    }
    
}
