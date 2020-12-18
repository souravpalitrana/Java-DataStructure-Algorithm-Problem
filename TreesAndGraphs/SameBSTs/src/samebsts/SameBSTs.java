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
 * Write a function that takes in two arrays of integers and determines whether
 * these array represent same BST. Note that you are not allowed to construct any
 * BSTs in your code.
 * Time complexity: O(N^2) and Space Complexity: O(N^2)
 * @author souravpalit
 */
public class SameBSTs {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int arrayOne [] = {5, 2, -1, 100, 45, 12, 8, -1, 8, 10, 15, 8, 12, 94, 81, 2, -34};
        int arrayTwo [] = {5, 8, 10, 15, 2, 8, 12, 45, 100, 2, 12, 94, 81, -1, -1, -34, 8};
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
        if (arrayOne.size() != arrayTwo.size()) {
            return false;
        } else if (arrayOne.size() == 0) {
            return true;
        } else if (arrayOne.get(0) != arrayTwo.get(0)) {
            return false;
        } else {
            List<Integer> leftOne = getSmaller(arrayOne);
            List<Integer> rightOne = getBiggerOrEqual(arrayOne);
            List<Integer> leftTwo = getSmaller(arrayTwo);
            List<Integer> rightTwo = getBiggerOrEqual(arrayTwo);
            
            return willConstructSameBST(leftOne, leftTwo) && willConstructSameBST(rightOne, rightTwo);
        }
    }
    
    public static List<Integer> getSmaller(List<Integer> values) { 
        List<Integer> smallers = new ArrayList<Integer>();
        
        for (int i = 1; i < values.size(); i++) {
            if (values.get(i) < values.get(0)) {
                smallers.add(values.get(i));
            }
        }
        
        return smallers;
    }
    
    public static List<Integer> getBiggerOrEqual(List<Integer> values) {
        List<Integer> biggers = new ArrayList<Integer>();
        
        for (int i = 1; i < values.size(); i++) {
            if (values.get(i) >= values.get(0)) {
                biggers.add(values.get(i));
            }
        }
        
        return biggers;
    }
}
