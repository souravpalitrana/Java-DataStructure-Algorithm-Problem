/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rightsmallerthan;

/**
 *
 * @author souravpalit
 */
public class BST {

    public int value = 0;
    public BST left;
    public BST right;
    public int leftNodeCount = 0;

    public BST(int value) {
        this.value = value;
    }
    
    public int insert(int value) {
        BST currentNode = this;      
        int count = 0;

        while (true) {
            if (value < currentNode.value) {
                // Our value is small than current value so it will go left
                currentNode.leftNodeCount++;
                if (currentNode.left == null) {
                    // So if left child is null we can add this new value to left
                    currentNode.left = new BST(value);
                    return count;
                } else {
                    // Left node is not null. So need to move to this node
                    currentNode = currentNode.left;
                }
            } else {
                // So our value is either greater or equal the current value. But
                // in both case we will move to right because if the target value is
                // equal to the current value that means all the value of its left
                // is smaller and if the target value is greater in that case also
                // all the left value are smallers. So we need to add the leftNodeCount
                // If no leftNode then it is 0.
                count = count + currentNode.leftNodeCount;
                // However, if the target value is greater than current that means
                // we just passed a smaller value so we are increasing the count value
                if (value > currentNode.value) {
                    count++;
                }
                // If right node is null we can add our target value as right node
                if (currentNode.right == null) {
                    currentNode.right = new BST(value);
                    return count;
                } else {
                    // So it has right node. Moving to that node
                    currentNode = currentNode.right;
                }
            }
        }
    }
}
