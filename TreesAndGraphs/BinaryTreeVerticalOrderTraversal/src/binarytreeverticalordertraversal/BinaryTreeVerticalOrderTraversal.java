/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarytreeverticalordertraversal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;
import javax.swing.tree.TreeNode;

/**
 *
 * @author souravpalit
 */
public class BinaryTreeVerticalOrderTraversal {

    // TC: O(HlogH + H WlogW) SC: O(N) where H is the height and W is the width
    // and N is the W * H which is number of nodes
    int rank;
    TreeMap<Integer, List<NodeInfo>> orderMap;
    
    public List<List<Integer>> verticalOrder(TreeNode root) {
        rank = 0;
        orderMap = new TreeMap<>();
        traverse(root, 0, 0);
        List<List<Integer>> result = new ArrayList<>();
        for (List<NodeInfo> nodes : orderMap.values()) {
            Collections.sort(nodes, new NodeInfoComparator());
            List<Integer> newList = new ArrayList<>();
            for (NodeInfo nodeInfo : nodes) {
                newList.add(nodeInfo.val);
            }
            result.add(newList);
        }
        return result;
    }
    
    private void traverse(TreeNode node, int depth, int level) {
        if (node == null) {
            return;
        }
        
        orderMap.putIfAbsent(depth, new ArrayList<NodeInfo>());
        orderMap.get(depth).add(new NodeInfo(level, rank, node.val));
        traverse(node.left, depth - 1, level + 1);
        traverse(node.right, depth + 1, level + 1);
    }
    
    
    class NodeInfo {
        
        int level;
        int rank;
        int val;
        
        public NodeInfo(int level, int rank, int val) {
            this.level = level;
            this.rank = rank;
            this.val = val;
        }
    }
    
    public class NodeInfoComparator implements Comparator< NodeInfo> {

        @Override
        public int compare(NodeInfo info1, NodeInfo info2) {
            if (info1.level == info2.level) {
                return Integer.compare(info1.rank, info2.rank);
            } else {
                return Integer.compare(info1.level, info2.level);
            }
        }
    
    }
    
}
