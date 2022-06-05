/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serializeanddeserializebinarytree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 
 * @author souravpalit
 */
public class Codec {
    
    private final String nullNodeIndicator = "null";
    private final String separator = ",";
    
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public String serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        preorderTraversal(root, builder);
        builder.deleteCharAt(builder.length() - 1);
        return builder.toString();
    }

    // Decodes your encoded data to tree.
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public TreeNode deserialize(String data) {
        Queue<String> nodeQueue = new LinkedList<>();
        String [] splits = data.split(separator);
        nodeQueue.addAll(Arrays.asList(splits));
        return buildTree(nodeQueue);
    }
    
    private void preorderTraversal(TreeNode node, StringBuilder builder) {
        if (node == null) {
            builder.append(nullNodeIndicator);
            builder.append(separator);
            return;
        }
        
        builder.append(node.val);
        builder.append(separator);
        preorderTraversal(node.left, builder);
        preorderTraversal(node.right, builder);
    }
    
    private TreeNode buildTree(Queue<String>nodeQueue) {
        if (nodeQueue.isEmpty()) {
            return null;
        } else if (nodeQueue.peek().equals(nullNodeIndicator)) {
            nodeQueue.remove();
            return null;
        }
        
        TreeNode node = new TreeNode(Integer.valueOf(nodeQueue.remove()));
        node.left = buildTree(nodeQueue);
        node.right = buildTree(nodeQueue);
        
        return node;
    }
}
