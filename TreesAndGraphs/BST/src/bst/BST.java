/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bst;

/**
 *
 * @author souravpalit
 */
public class BST {

    public int value = 0;
    public BST left;
    public BST right;

    public BST(int value) {
        this.value = value;
    }

    public BST insert(int value) {
        BST currentNode = this;

        while (true) {
            if (value < currentNode.value) {
                if (currentNode.left == null) {
                    currentNode.left = new BST(value);
                    break;
                } else {
                    currentNode = currentNode.left;
                }
            } else {
                if (currentNode.right == null) {
                    currentNode.right = new BST(value);
                    break;
                } else {
                    currentNode = currentNode.right;
                }
            }
        }

        return this;
    }

    public boolean contains(int value) {
        BST currentNode = this;

        while (currentNode != null) {
            if (value < currentNode.value) {
                currentNode = currentNode.left;
            } else if (value > currentNode.value) {
                currentNode = currentNode.right;
            } else {
                return true;
            }
        }

        return false;
    }

    public BST remove(int value) {
        remove(value, null); // Starting frrom root so parent node null
        return this;
    }

    private void remove(int value, BST parentNode) {
        BST currentNode = this;

        // If value is not present in the BST then in one case currentNode will 
        // be null. In that case loop will stop.
        while (currentNode != null) {
            if (value < currentNode.value) {
                parentNode = currentNode;
                currentNode = currentNode.left;
            } else if (value > currentNode.value) {
                parentNode = currentNode;
                currentNode = currentNode.right;
            } else { // Matched found
                if (currentNode.left != null && currentNode.right != null) {
                    // Target node has two child so we need to found out right 
                    // mininum value to replace the target value
                    currentNode.value = currentNode.right.getMinValue();
                    // As we replace the target value with right Min value no we
                    // need to delete the rightMin value node as it is already in
                    // target position
                    currentNode.right.remove(currentNode.value, currentNode);
                } else if (parentNode == null) {
                    // Parentnode may be null which means it is root node and as
                    // first condition failed that means it has only one child. 
                    // either left or right child.
                    if (currentNode.left != null) {
                        // So we can set this left node as root node. Which means
                        // this node's left node(if available) will be the left
                        // node of the root node and right node (if available) will
                        // be the right node of the root node
                        currentNode.value = currentNode.left.value;
                        currentNode.left = currentNode.left.left;
                        currentNode.right = currentNode.left.right;
                    } else if (currentNode.right != null) {
                        // Same like above. As it has only right child so we will
                        // set immediate right childe value as root valuee and
                        // right child's left value as root's left child and right
                        // child value will be root's right child value
                        currentNode.value = currentNode.right.value;
                        currentNode.left = currentNode.right.left;
                        currentNode.right = currentNode.right.right;
                    } else {
                        // Root node has no child node. So removing means 
                        // deleting BST. Discuss this edge case with your
                        // interviewer. Currently we are not doing anything
                        // as we are considering in our code it will not happen
                    }

                } else if (parentNode.left == currentNode) {
                    // currentNode may be single node. in that case we will set it
                    // to null so if it is leaf node so its left child or right child
                    // will be null and we can set either or currentNode may have 
                    // only left node or may have
                    // only right node. in that case that left node or right node 
                    // will be the left child node of its parent. So
                    parentNode.left = currentNode.left != null ? currentNode.left : currentNode.right;
                } else if (parentNode.right == currentNode) {
                    // currentNode may be single node. in that case we will set it
                    // to null so if it is leaf node so its left child or right child
                    // will be null and we can set either 
                    //or currentNode may have only left node or may have
                    // only right node. in that case that left node or right node 
                    // will be the right child node of its parent. So 
                    parentNode.right = currentNode.left != null ? currentNode.left : currentNode.right;
                }

                break;
            }
        }
    }

    public int findClosestValueInBst(int target) {
        BST tree = this;
        // Write your code here.
        int closeValue = tree.value;

        while (tree != null) {
            if (Math.abs(tree.value - target) < Math.abs(closeValue - target)) {
                closeValue = tree.value;
            }

            if (tree.left != null && tree.right != null) {
                if (target < tree.value) {
                    tree = tree.left;
                } else {
                    tree = tree.right;
                }
            } else if (target < tree.value && tree.left != null) {
                tree = tree.left;
            } else if (target > tree.value && tree.right != null) {
                tree = tree.right;
            } else {
                break;
            }
        }
        return closeValue;
    }

    private boolean isLeftClose(int left, int right, int target) {
        return Math.abs(left - target) < Math.abs(right - target);
    }

    private int getMinValue() {
        if (left == null) {
            return value;
        } else {
            return left.getMinValue();
        }
    }
}
