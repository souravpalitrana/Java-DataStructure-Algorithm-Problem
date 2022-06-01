/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package constructbinarytreefrompreorderandinordertraversal;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author souravpalit
 */
public class ConstructBinaryTreefromPreorderAndInorderTraversal {

    
    int preOrderIdx;
    Map<Integer, Integer> inorderIdxMap;
    
    // Time Complexity: O(n) where n is the number of elements
    // Space Complexity: O(n) where n is the number of elements
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        inorderIdxMap = new HashMap<>();
        preOrderIdx = 0;
        for (int i = 0; i < inorder.length; i++) {
            inorderIdxMap.put(inorder[i], i);
        }
        
        return generateTree(preorder, inorder, 0, inorder.length - 1);
    }
    
    public TreeNode generateTree(
            int[] preorder, 
            int[] inorder,
            int low,
            int high
                    
    ) {
        if (low > high) {
            return null;
        }
        
        TreeNode currentNode = new TreeNode(preorder[preOrderIdx++]);
        int mid = inorderIdxMap.get(currentNode.val);
        currentNode.left = generateTree(preorder, inorder, low, mid - 1);
        currentNode.right = generateTree(preorder, inorder, mid + 1, high);
        return currentNode;
    }

}
