/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lowestcommonancestorofabinarytree;

/**
 *
 * @author souravpalit
 */
public class LowestCommonAncestorOfABinaryTree {
    
    public static void main(String args[]) {
        TreeNode root = new TreeNode(3);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        
        root.left = new TreeNode(5); // target
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4); // target
        
        lowestCommonAncestor(root, root.left, root.left.right.right);
        System.out.println(loweestCommonAncestor);
    }

    static TreeNode loweestCommonAncestor = null;

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        findLowestCommonAncestor(root, p, q);
        return loweestCommonAncestor;
    }

    public static boolean findLowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (loweestCommonAncestor != null || root == null) {
            return false;
        } else if (root == p || root == q) {
            return true;
        }

        boolean isInLeft = findLowestCommonAncestor(root.left, p, q);
        boolean isInRight = findLowestCommonAncestor(root.right, p, q);

        if (isInLeft && isInRight) {
            loweestCommonAncestor = root;
        } else if ((isInLeft || isInRight) && (root == p || root == q)) {
            loweestCommonAncestor = root;
        }

        return isInLeft || isInRight;
    }

}
