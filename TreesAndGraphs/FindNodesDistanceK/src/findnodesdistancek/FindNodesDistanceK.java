/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package findnodesdistancek;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author souravpalit
 */
public class FindNodesDistanceK {

    /**
     * @param args the command line arguments
     */
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
        root.left.left = new BinaryTree(3);
        root.left.left.left = new BinaryTree(4);
        root.left.left.left.left = new BinaryTree(5);*/
        
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
        
        List<Integer> kDistanceNodes = findNodeDistanceK(root, target, distance);
        
        for (Integer value : kDistanceNodes) {
            System.out.println(value + " ");
        }
        
    }
    
    public static List<Integer> findNodeDistanceK(BinaryTree root, int target, int k) {
        List<Integer> nodesInKDistance = new ArrayList<Integer>();
        findDistanceFromNodeToTarget(root, target, k, nodesInKDistance);
        return nodesInKDistance;
    }
    
    public static int findDistanceFromNodeToTarget(BinaryTree node, int target, 
            int k, List<Integer> nodesInKDistance) {
        if (node == null) {
            return -1;
        }
        
        if (node.value == target) {
            findNodesInKDistance(node, 0, k, nodesInKDistance);
            return 1;
        }
        
        int leftDistance = findDistanceFromNodeToTarget(node.left, target, k, nodesInKDistance);
        int rightDistance = findDistanceFromNodeToTarget(node.right, target, k, nodesInKDistance);
        
        if (leftDistance == k || rightDistance == k) nodesInKDistance.add(node.value);
        
        if (leftDistance != -1) {
            findNodesInKDistance(node.right, leftDistance + 1, k, nodesInKDistance);
            return leftDistance + 1;
        } else if (rightDistance != -1) {
            findNodesInKDistance(node.left, rightDistance + 1, k, nodesInKDistance);
            return rightDistance + 1;
        }
        
        return -1;
    }
    
    public static void findNodesInKDistance(BinaryTree node, int distance, int k,
            List<Integer> nodesInKDistance) {
        
        if (node == null) return;
        
        if (distance == k) {
            nodesInKDistance.add(node.value);
        }
        
        findNodesInKDistance(node.left, distance + 1, k, nodesInKDistance);
        findNodesInKDistance(node.right, distance + 1, k, nodesInKDistance);
    }
    
}
