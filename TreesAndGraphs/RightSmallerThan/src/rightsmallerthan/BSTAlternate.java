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
public class BSTAlternate {

    public int value;
    public BSTAlternate left;
    public BSTAlternate right;
    public int leftNodeCount;
    public int numberOfSmallerAtInsertTime;
    public int idx;

    public BSTAlternate(int value, int idx, int numberOfSmallerAtInsertTime) {
        this.value = value;
        this.idx = idx;
        this.numberOfSmallerAtInsertTime = numberOfSmallerAtInsertTime;
    }
    
    public void insert(int value, int idx) {
        insertHelper(value, idx, 0);
    }
    
    private void insertHelper(int value, int idx, int numberOfSmallerAtInsertTime) {
        if (value < this.value) {
            leftNodeCount++;
            if (left == null) {
                left = new BSTAlternate(value, idx, numberOfSmallerAtInsertTime);
            } else {
                left.insertHelper(value, idx, numberOfSmallerAtInsertTime);
            }
        } else {
            numberOfSmallerAtInsertTime += leftNodeCount;
            if (value > this.value) numberOfSmallerAtInsertTime++;
            
            if (right == null) {
                right = new BSTAlternate(value, idx, numberOfSmallerAtInsertTime);
            } else {
                right.insertHelper(value, idx, numberOfSmallerAtInsertTime);
            }
        }
    }
}
