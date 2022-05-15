/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deepestleavessum;

/**
 *
 * @author souravpalit
 */
public class DeepestLeavesSumSolution {

    public int deepestLeavesSum(TreeNode root) {
        Pair pair = getDeepestSum(root, 0);
        return pair.sum;
    }
    
    public Pair getDeepestSum(TreeNode node, int level) {
        if (node == null) {
            return new Pair(0, 0);
        }
        
        if (node.left == null && node.right == null) {
            // this is leaf node so return current node value
            return new Pair(node.val, level);
        }
        
        Pair leftInfo = getDeepestSum(node.left, level + 1);
        Pair rightInfo = getDeepestSum(node.right, level + 1);
        
        if (leftInfo.sum != 0 && rightInfo.sum != 0) {
            if (leftInfo.level == rightInfo.level) {
                int sum = leftInfo.sum + rightInfo.sum;
                return new Pair(sum, leftInfo.level);
            } else if (leftInfo.level > rightInfo.level) {
                return leftInfo;
            } else {
                return rightInfo;
            }
        } else if (leftInfo.sum != 0) {
            return leftInfo;
        } else {
            return rightInfo;
        }
    }
    
    class Pair {
        int sum;
        int level;
        
        public Pair(int first, int second) {
            this.sum = first;
            this.level = second;
        }
    }
    
}
