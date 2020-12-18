/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package samebsts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author souravpalit
 */
public class SameBSTsOptimized {

    /**
     * Write a function that takes in two arrays of integers and determines whether
     * these array represent same BST. Note that you are not allowed to construct any
     * BSTs in your code.
     * Time complexity: O(N^2) and Average Space Complexity: O(D) Worst : O(N)
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //int arrayOne [] = {5, 2, -1, 100, 45, 12, 8, -1, 8, 10, 15, 8, 12, 94, 81, 2, -34};
        //int arrayTwo [] = {5, 8, 10, 15, 2, 8, 12, 45, 100, 2, 12, 94, 81, -1, -1, -34, 8};
        
        int arrayOne [] = {10, 15, 8, 12, 94, 81, 5, 2, 11};
        int arrayTwo [] = {10, 8, 5, 15, 2, 12, 11, 94, 81};
        
        List<Integer> firstList = new ArrayList();
        List<Integer> secondList = new ArrayList();
        
        for (int i = 0; i < arrayOne.length; i++) {
            firstList.add(arrayOne[i]);
        }
        
        for (int i = 0; i < arrayTwo.length; i++) {
            secondList.add(arrayTwo[i]);
        }
        
        System.out.println("Will construct same BST : " + willConstructSameBST(firstList, secondList));
    }
    
    public static boolean willConstructSameBST(List<Integer> arrayOne, List<Integer> arrayTwo) {
        return willConstructSameBST(arrayOne, arrayTwo, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    public static boolean willConstructSameBST(List<Integer> arrayOne, List<Integer> arrayTwo,
            int rootIdxOne, int rootIdxTwo, int minValue, int maxValue) {
        if (arrayOne.size() != arrayTwo.size()) {
            return false;
        } else if (rootIdxOne == -1 || rootIdxTwo == -1) {
            return (rootIdxOne == rootIdxTwo);
        } else if (arrayOne.get(rootIdxOne) != arrayTwo.get(rootIdxTwo)) {
            return false;
        } else {
            // both array's current value should be same as we are in else
            int currentValue = arrayOne.get(rootIdxOne); 
            
            int leftRootIdxOne = getSmaller(arrayOne, rootIdxOne, minValue);
            int rightRootIdxOne = getBiggerOrEqual(arrayOne, rootIdxOne, maxValue);
            int leftRootIdxTwo = getSmaller(arrayTwo, rootIdxTwo, minValue);
            int rightRootIdxTwo = getBiggerOrEqual(arrayTwo, rootIdxTwo, maxValue);
            
            boolean isLeftSame = willConstructSameBST(arrayOne, arrayTwo, leftRootIdxOne, leftRootIdxTwo, minValue, currentValue);
            boolean isRightSame = willConstructSameBST(arrayOne, arrayTwo, rightRootIdxOne, rightRootIdxTwo, currentValue, maxValue);
            
            return isLeftSame && isRightSame;
        }
    }
    
    public static int getSmaller(List<Integer> values, int startingIdx, int minValue) { 
        for (int i = startingIdx + 1; i < values.size(); i++) {
            if (values.get(i) < values.get(startingIdx) && values.get(i) >= minValue) {
                return i;
            }
        }
        
        return -1;
    }
    
    public static int getBiggerOrEqual(List<Integer> values, int startingIdx, int maxValue) {
        for (int i = startingIdx + 1; i < values.size(); i++) {
            if (values.get(i) >= values.get(startingIdx) && values.get(i) <= maxValue) {
                return i;
            }
        }
        
        return -1;
    }
}
